/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardingPass;

import dto.Passenger;

/**
 *
 * @author uakgul
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        * example tickets
//        String barcode = "M1CEYLAN.BERCE        EXQK7L1 SAWCRLPC 0801 032Y003B0003 100";
//        String barcode = "M1KANBEROGLU/POLATMR   63M5ES SAWDXBFZ 0754 049Y022C0074 337>1081OO9049B29 ";
//        String barcode = "M1USTAOSMANOGLU.SULEYMEURF5WA SAWAYTTK 7522 032Y025F0085 151Ç50B1OO8032BTK 2A235233721242101TK                    020KN(30600000K0A02       X";
//        String barcode = "M1ALDEMIR.ABDULKADIR  EB7KESS SAWASRPC 2744 122Y025C0024 100";
//        String barcode = "M1SAYAN.AHMET         EBSRFXF SAWASRPC 2744 122Y011E0040 100";
//        String barcode = "M1SEVILIR.EMINFERHATMRE       SAWASRPC 2744 122Y028F0121 36CÇ5321  8122BXH                                        2A624218281084400PC PC 136279920            0652886896";
        String barcode = "M1DEMIRHISARLI.HAMZA  EB7KESS SAWASRPC 2744 122Y025D0025 100";
//        String barcode = "M1ISIK/CEMAL          ES5MKY7 SAWAJITK 7306 067Y007C0113 151>50B1KK9067BTK 2A235237546038401TK                    020KN*30600000K0A00";
//        String barcode2 = "M2KAYA.FATMA          EDWRJU7 OSLSAWPC 2274 199Y002F0141 35D5180O 0199BSK              2A62421652899800 PC                         (30600000K09         DWRJU7 SAWESBPC 2674 199Y002B0061 3372A62421652899800 PC";
        
        Passenger passenger = Parser.parse( barcode );
        
    }
    
}
