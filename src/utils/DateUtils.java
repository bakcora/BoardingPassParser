 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
 
    public static final String DATE         = "yyyyMMdd";
    public static final String TIME         = "HHmmss";
    public static final String DATETIME     = "yyyy-MM-dd HH:mm:ss";
    public static final String DATEFORMAT   = "yyyy-MM-dd";
    
    public static final String DATEpoint    = "yyyy.MM.dd";
    public static final String TIMEpoint    = "HH.mm.ss";

    /**
     * 
     * @return timeStamp : yyyyMMdd
     */
    public static String getSystemDate() {
        Calendar cal         = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        return sdf.format(cal.getTime());
    }

    /**
     * 
     * @return timeStamp : yyyy-MM-dd
     */
    public static String getDefaultTodayStd() {
        Calendar cal         = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        return sdf.format(cal.getTime());
    }

    /**
     * 
     * @return timeStamp : HHmmss
     */
    public static String getSystemTime() {
        Calendar cal         = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(TIME);
        return sdf.format(cal.getTime());
    }

    /**
     * 
     * @return timeStamp : yyyy-MM-dd HH:mm:ss
     */
    public static String getTimeStamp() {
        Calendar cal         = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
        return sdf.format(cal.getTime());
    }
    
    
    
    
    /**
     * 
     * @return timeStamp : yyyy.MM.dd
     */
    public static String getSystemDatePoint() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATEpoint);
        return sdf.format(cal.getTime());
    }

    /**
     * 
     * @return timeStamp : HH.mm.ss
     */
    public static String getSystemTimePoint() {
        Calendar cal         = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(TIMEpoint);
        return sdf.format(cal.getTime());
    }
    
    
    
     
    
    
    
    /**
     * 
     * @param diff
     * @return timeStamp + diff Hour : yyyy-MM-dd HH:mm:ss
     */
    public static String getTimeStampAddHour(int diff) {
        Calendar cal         = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY , diff ); // adds diff hour 
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
        return sdf.format(cal.getTime());
    }
     
    
    
    
    
    /**
     * 
     * @param time
     * @return timeStamp with string : yyyy-MM-dd HH:mm:ss --> yyyyMMdd
     */
    public static String getClassicFormatedDate( String time ) { 
        
        SimpleDateFormat format1 = new SimpleDateFormat( DATETIME );
        SimpleDateFormat format2 = new SimpleDateFormat( DATE ); 
//        Date date = new Date(); 
        String reformattedStr = ""; 
        try {
            
            reformattedStr = format2.format( format1.parse( time ) );
            
//            System.out.println( "format2.format( format1.parse( time ) ) => format1 --> format2 ( "+time+" ) : " + reformattedStr ); 
//            date = format1.parse( time );
//            System.out.println( "format1 --> formeat2 ( "+time+" ) : " + format2.format( date ) );
            
        } catch (ParseException ex) {
            System.out.println(DateUtils.getTimeStamp() + " CipLoungeGates.Config.getClassicFormatedDate() : ParseException : " + ex.getMessage()); 
        } 
//        return format2.format( date );   
        return reformattedStr;  
        
    }
    
    
    
    /**
     * 
     * @param longTime
     * @return string timeStamp with Long milisecondUnixTime : yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTimeFromLongMilisecond(Long longTime){ 
        String dateTime = "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
        Date date = new Date(longTime); 
        dateTime = sdf.format(date); 
        return dateTime;
    }// end of getDateTimeFromLongMilisecond
    
    
    
    /**
     * 
     * @param dateTime
     * @return Long milisecondUnixTime with string timeStamp : 1518107116247
     */
    public static Long getMilisecondFromDate( String dateTime ) { 
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME); 
        Date date = new Date(); 
        try { 
            date = sdf.parse(dateTime); 
            System.out.println(DateUtils.getTimeStamp() + " CipLoungeGates.Config.getMilisecondFromDate() : getMilisecondFromDate ( "+dateTime+" ) --> : " + date.getTime() );
        } catch (ParseException ex) {
            System.out.println(DateUtils.getTimeStamp() + " CipLoungeGates.Config.getMilisecondFromDate() : ParseException : " + ex.getMessage());
        } 
        return date.getTime();
    
    }
    
    
    
    /**
     * 
     * @return String GregorianCalendar.DAY_OF_YEAR  : 066 / 151
     */
    public static String getJulianDate() { 
         
        GregorianCalendar gc = new GregorianCalendar(); 
        
        gc.setTime( Calendar.getInstance().getTime() );
         
        int julianDate = gc.get( GregorianCalendar.DAY_OF_YEAR );
          
        String result = "001";
        
        if( julianDate <100 ){
            result = "0" + julianDate;
        }else{
            result = ""  + julianDate;
        }
        
        return result;
    }
    
    
    /**
     * 
     * @param dayOfYear
     * @return String GregorianCalendar.DAY_OF_YEAR  : 066 / 151
     * @throws java.lang.Exception
     */
    public static String getDateFromJulianDate(String dayOfYear) throws Exception{ 
         
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(Calendar.DAY_OF_YEAR , Integer.parseInt( dayOfYear ) ); 
        
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        String result =  sdf.format( calendar.getTime());
                 
        return result;
    }
    
		
		/**
     * 
     * @return String GregorianCalendar.DAY_OF_YEAR  : 066 / 151
     */
    public static String getDateFromJulianDate(){ 
         
        Calendar calendar = Calendar.getInstance(); 
        
        calendar.set( Calendar.DAY_OF_YEAR , Integer.parseInt( getJulianDate() ) ); 
        
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        String result =  sdf.format( calendar.getTime());
                 
        return result;
    }
	
	

    
    
    
}
