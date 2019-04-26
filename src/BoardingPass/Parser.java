
package BoardingPass;

import dto.Passenger;
import utils.DateUtils;

/**
 *
 * @author uakgul
 */
public class Parser {
    
    /** 
    * 
    * eg. : M1AKGUL.UBEYDE        E5K8YY4 SAWADAPC 2092 047Y020B0078 100
    * eg. : M1AKGUL.UBEYDE        ERTD5A7 SAWDLMTK 2992 276Y025A0025 150Ç10B2OO7276BTK 29235232530081801TK                    020K(30600000K0902       X
    * eg. : M2AKGUL.UBEYDE        EDWRJU7 OSLSAWPC 1274 199Y002F0141 35D5180O 0199BSK              2A62421652899800 PC                         (30600000K09         DWRJU7 SAWESBPC 2674 199Y002B0061 3372A62421652899800 PC
    * 
    * M1 normal passenger
    * M2 transfer passenger
    * 
    */


   // M1DONMEZ.MUSTAFAISMAILEX89CCB SAWTZXPC 2822 312Y026F0058 100
   // M1ATES.MEHMET HAKAN   E4F9AAD SAWECNPC 1912 032Y004D0007 100

   /** pieces for notTransferPassenger : M1
    **
    ** piece1 :  0 - 2  : (  2  ) : formatAndNumberOfLegEncoded : M1                    / M1
    ** piece2 :  2 - 22 : (  20 ) : PassengerNameSurname        : DONMEZ.MUSTAFAISMAIL  / ATES.MEHMET HAKAN___
    ** piece3 : 22 - 23 : (  1  ) : ElectronicTicketIndicator   : E                     / E
    ** piece4 : 23 - 30 : (  7  ) : OperatingCarrier PNRCode    : X89CCB_               / 4F9AAD_
    ** piece5 : 30 - 33 : (  3  ) : FromCityAirportCode         : SAW                   / SAW
    ** piece6 : 33 - 36 : (  3  ) : ToCityAirportCode           : TZX                   / ECN
    ** piece7 : 36 - 39 : (  3  ) : OperatingCarrierDesignator  : PC_                   / PC
    ** piece8 : 39 - 44 : (  5  ) : FlightNumber                : 2822_                 / 1912_
    ** piece9 : 44 - 47 : (  3  ) : DayOfFlight (DayOfYear)     : 312                   / 032
    ** piece10: 47 - 48 : (  1  ) : CompartmentClassCode        : Y                     / Y
    ** piece11: 48 - 52 : (  4  ) : SeatNumber                  : 026F                  / 004D
    // not using
    // piece12: 52 - 57 : (  5  ) : Check-InSequenceNumber      : 0058_                 / 0007_
    // piece12: 57 - 58 : (  1  ) : PassengerStatus             : 1                     / 1
    **
    *
    */


   // if 152 < lenght !<182 : multiple flight = transfer passenger flight boarding
   // M2KAYACAN.FATMA       EDWRJU7 OSLSAWPC 1274 199Y002F0141 35D>5180O 0199BSK              2A62421652899800 PC                         (30600000K09         DWRJU7 SAWESBPC 2674 199Y002B0061 3372A62421652899800 PC                         09
   // M2JALALIAN.DAVOUD     ED46ISH OSLSAWPC 1274 230Y006B0043 35D>5180O 0230BSK              2A62449177524440 PC                         (30600000K09         D46ISH SAWIKAPC 0512 230Y024D0051 3372A62449177524440 PC                         09

   /** pieces for transferPassenger : M2
    **
    ** piece1 :  0  - 2   : (  2  ) : formatAndNumberOfLegEncoded : M2                  / M2
    ** piece2 :  2  - 22  : (  20 ) : PassengerNameSurname        : KAYACAN.FATMA_______/ JALALIAN.DAVOUD_____
    ** piece3 : 22  - 23  : (  1  ) : ElectronicTicketIndicator   : E                   / E
    ** piece4 : 152 - 159 : (  7  ) : OperatingCarrier PNRCode    : DWRJU7_             / 2UY97R_
    ** piece5 : 160 - 163 : (  3  ) : FromCityAirportCode         : SAW                 / SAW
    ** piece6 : 163 - 166 : (  3  ) : ToCityAirportCode           : ESB                 / IKA
    ** piece7 : 166 - 169 : (  3  ) : OperatingCarrierDesignator  : PC_                 / PC
    ** piece8 : 169 - 174 : (  5  ) : FlightNumber                : 2674_               / 0512_
    ** piece9 : 174 - 177 : (  3  ) : DayOfFlight (DayOfYear)     : 199                 / 230
    ** piece10: 177 - 178 : (  1  ) : CompartmentClassCode        : Y                   / Y
    ** piece11: 178 - 182 : (  4  ) : SeatNumber                  : 002B                / 024D
    // not using
    ** piece12: 52  - 57  : (  5  ) : Check-InSequenceNumber      : 0061_               / 0051_
    ** piece12: 57  - 58  : (  1  ) : PassengerStatus             : 3                   / 3
    **
    *
    */
    
    
    /**
     * @param barcodeContent  
     * @return Passenger object getting from barcodeContent
     */
    public static Passenger parse(String barcodeContent){
        
        Passenger passenger;
        
        barcodeContent = barcodeContent.toUpperCase();  // just in case

        if (barcodeContent.length() > 51) {
            
            if( barcodeContent.contains( "." ) || barcodeContent.contains( "/" )  ){
                                
                // replace for eng-tr keypboard
                if( barcodeContent.contains( "/" ) ) barcodeContent = barcodeContent.replace( "/" , ".");

                // replace for tall baording content or multiple flight = transfer flight boarding content
                if( barcodeContent.startsWith( "Ç" ) ) barcodeContent = barcodeContent.replace( "Ç" , ">" );

                // replace for aztex-datamatrix auto prefix sometimes
                if( barcodeContent.startsWith( "\\000010" ) ) barcodeContent = barcodeContent.replace( "\\000010" , "" );
                
                if( barcodeContent.startsWith( ",000010" ) ) barcodeContent = barcodeContent.replace( ",000010" , "" );
                      
                passenger = new Passenger();

                try {
                    
                    String piece1 = barcodeContent.substring( 0,2 );
                    
//                    if( barcodeContent.length() <152 && piece1.equals( "M1" ) ) // normalTicket
//                    if( barcodeContent.length() >152 && piece1.equals( "M2" ) ) // transferTicket
                    
                    String piece2 = barcodeContent.substring( 2,22 );

                    piece2 = piece2.toUpperCase().trim();
                    
                    if (piece2.contains(".")) { piece2 = piece2.replace(".", " "); }

                    if (piece2.contains("/")) { piece2 = piece2.replace("/", " "); }
                    
                    piece2 = piece2.substring( piece2.indexOf(" ") + 1 , piece2.length()) + " " + piece2.substring( 0, piece2.indexOf(" ") );
                    passenger.name = piece2.substring( piece2.indexOf(" ") + 1 , piece2.length());
                    passenger.surname = piece2.substring( 0, piece2.indexOf(" ") );
                    
                    String piece3 = barcodeContent.substring( 22,23 );

                    String piece4 = barcodeContent.substring( 23,30 ).trim();
                    passenger.pnrNo = piece4;
                    
                    String piece5 = barcodeContent.substring( 30,33 );
                    passenger.flightFr = piece5;
                    
                    String piece6 = barcodeContent.substring( 33,36 );
                    passenger.flightTo = piece6;

                    String piece7 = barcodeContent.substring( 36,39 ).trim();
                    passenger.iataCode = piece7;
 
                    String piece8 = barcodeContent.substring( 39,44 ).trim();
                    passenger.flightNo = piece8;
  
                    String piece9 = barcodeContent.substring( 44,47 ).trim();
                    String dayOfFlight = DateUtils.getDateFromJulianDate( piece9 );
                    passenger.flightDate = dayOfFlight;
                    
                    String piece10 = barcodeContent.substring( 47,48 ).trim();
                    passenger.compartment = piece10;

                    String piece11 = barcodeContent.substring( 48,52 ).trim();
                    passenger.seatNo = piece11;
                    
                    System.out.println( DateUtils.getTimeStamp() + " BoardingPassParser.BoardingPass.Parser.parse() : passenger : " + passenger.toString() );  

                    } catch (Exception ex) {
                        System.out.println( DateUtils.getTimeStamp() + " BoardingPassParser.BoardingPass.Parser.parse() : Passenger information was not received..!! An error occurred while parsing the barcode... : " + ex.getMessage());
                        passenger = null;
                    }
                
                
             // Barcode reader scan fail , getting different content
             }else if( barcodeContent.contains( "!" ) || barcodeContent.contains( "?" ) || barcodeContent.contains( ":" )  ){
                System.out.println( DateUtils.getTimeStamp() + " BoardingPassParser.BoardingPass.Parser.parse() : corrupted barcodeContent fail : " + barcodeContent + "\n"); 
                passenger = null;
             }else{
                System.out.println( DateUtils.getTimeStamp() + " BoardingPassParser.BoardingPass.Parser.parse() : barcodeContent is fail : " + barcodeContent + "\n"); 
                passenger = null;
            }
      
        } else {
            //System.out.println( DateUtils.getTimeStamp() + " BoardingPassParser.BoardingPass.Parser.parse() : HERHANGİ BİR TARAMA VERİSİ ALINAMADI <51 ....");
            passenger = null;
        }
        
        return passenger;
        
    }//end of parse
    
    
 
    
}