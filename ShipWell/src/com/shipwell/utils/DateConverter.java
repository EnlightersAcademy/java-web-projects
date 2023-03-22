package com.shipwell.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConverter {

	public static String formatDateToString(Date date) {
		// null check
		if (date == null) return null;
		String format = "yyyy-MM-dd";
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String timeZone = "IST";
		
		// set timezone to SimpleDateFormat
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		// return Date in required format with timezone as String
		return sdf.format(date);
	}
	
	public static long formatStringToDate(String dateString)  {
		
		 long dateInLong = 0l;
		 try {
		    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = formatter.parse(dateString);
		    dateInLong = date.getTime();
		    
		 } catch(Exception exe) {
			 System.out.println("Error in coverting String value to Date");
			 exe.printStackTrace();
		 }
		 return dateInLong;

	}
	
	public static long formatStringToDateTime(String dateString) {
		String today = "yyyy-MM-dd HH:mm";
		 long dateInLong = 0l;
		 try {
		    DateFormat formatter = new SimpleDateFormat(today);
		    Date date = formatter.parse(dateString);
		    dateInLong = date.getTime();
		    
		 } catch(Exception exe) {
			 System.out.println("Error in coverting String value to Date");
			 exe.printStackTrace();
		 }
		 return dateInLong;
		
	}
	
	public static String formatDateTimeToString(long time) {
		// null check
		
		String format = "yyyy-MM-dd HH:mm";
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// convert long to Date object
		Date myDate = new Date(time);
		
		System.out.println("===>" + sdf.format(myDate));
		//return DateTime string
		return sdf.format(myDate);
	}
	
}
