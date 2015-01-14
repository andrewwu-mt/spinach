package com.spinach.bean;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtil {
	private static SimpleDateFormat df;
	static protected SimpleDateFormat _IDNdateTimeFormat = new SimpleDateFormat("dd MMM yyyyHH:mm:ss", Locale.ENGLISH);
	static protected SimpleDateFormat _IDNdateTimeFormat2 = new SimpleDateFormat("dd MMM yyyyHH:mm", Locale.ENGLISH);
	static protected TimeZone _gmt = TimeZone.getTimeZone("GMT");
	static protected SimpleDateFormat _timeFormat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);

	
	public static int getFrequency(int number , String unit){
		int frequency = 0;
		if(unit.equals("s")){
			frequency = number * 1000;
		} else if(unit.equals("m")){
			frequency = number * 60 * 1000;
		} else if(unit.equals("h")){
			frequency = number * 60 * 60 * 1000;
		} else if(unit.equals("d")){
			frequency = number * 24 * 60 * 60 * 1000;
		} else if(unit.equals("w")){
			frequency = number * 7 * 24 * 60 * 60 * 1000;
		} else if(unit.equals("M")){
			frequency = number * 4 * 7 * 24 * 60 * 60 * 1000;
		}
		return frequency;
	}
	
	public static Timestamp getTimeOMM(String time){
		_IDNdateTimeFormat.setTimeZone(_gmt);
		_IDNdateTimeFormat2.setTimeZone(_gmt);
		Date _storyDateTime = null;
    	try {
    		_storyDateTime = _IDNdateTimeFormat.parse(time);
		} catch (ParseException e) {
			try {
				_storyDateTime = _IDNdateTimeFormat2.parse(time);
			} catch (ParseException e2) {
				System.err.println("err");
			}
		}
    	Timestamp ts = TimeUtil.getTimeStamp(_storyDateTime);
    	return ts;
	}
	
	public static Timestamp getTimeStamp(Date date) {
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(date);
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}
	
	public static Timestamp getTimeStamp(String time) {
		df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}
	
	public static String getYear(Date date) {
		df = new SimpleDateFormat("yyyy");
		return df.format(date);
	}
	
	public static String getMonth(Date date) {
		df = new SimpleDateFormat("MMM", Locale.ENGLISH);
		return df.format(date);
	}
	
	public static String getDay(Date date) {
		df = new SimpleDateFormat("dd");
		return df.format(date);
	}
	
	public static String getStringTime(Date date) {
		df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		return df.format(date);
	}
	
	public static Date getDate(String time) {
		df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = df.parse(time);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String getDateStringForExcel(Date date) {
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	public static String getDateString(Date date) {
		df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	public static String getTimeString(Date date) {
		df = new SimpleDateFormat("HH:mm:ss");
		return df.format(date);
	}
	
	public static String getValidTime(int month, String time) {
		df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = getDate(time);
		Calendar cr = Calendar.getInstance();
		cr.setTime(date);
		cr.add(Calendar.MONTH, month);
		return getDateString(cr.getTime());
	}
	
	public static String mathOneDay(String time, int day) {
		Date date = getDate(time);
		Calendar cr = Calendar.getInstance();
		cr.setTime(date);
		cr.add(Calendar.DAY_OF_MONTH, day);
		return getDateString(cr.getTime());
	}
	
	public static int compareTime(String time1, String time2) {
		df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(df.parse(time1));
			c2.setTime(df.parse(time2));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return c1.compareTo(c2);
	}
	
	public static String dateFileName(Date date) {
		df = new SimpleDateFormat("yyyyMMdd");
		return df.format(date);
	}
	
	public static boolean checkValidTime(Date date) {
		long nowTime = getDateTimeInMillis(new Date());
		long endTime = getDateTimeInMillis(date)+86399000;
		if(endTime > nowTime) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Date getEndTime() {
		df = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = mathOneDay(df.format(new Date()), -1);
		return getDate(nowTime);
	}
	
	public static Long getDateTimeInMillis(Date date){
		Calendar gCal = new GregorianCalendar();
        gCal.setTime(date);
        return gCal.getTimeInMillis();
	}
	
	public static Date getDateByMillis(long timeInMillis) {
		Calendar gCal = new GregorianCalendar();
		gCal.setTimeInMillis(timeInMillis);
		return gCal.getTime();
	}
	
	public static String getStringTimeFifteenMin(Date date){
		Calendar gCal = new GregorianCalendar();
		gCal.setTime(date);
		long now = gCal.getTimeInMillis();
		gCal.setTimeInMillis(now - 900000L);
		return getDateStringForExcel(gCal.getTime());
	}
	
	public static String getInterval(Timestamp time){
		Timestamp now = getTimeStamp(new Date());
		long interval = now.getTime() - time.getTime();
		long second = interval/1000L;
		long minute = interval/60000L;
		
		long result = 0;
		
		if(minute < 1){
			result = second;
			return (result + " seconds");
		} else if(minute < 60){
			result = minute;
			return (result + " minutes");
		} else if (minute < 1440){ 
			result = minute / 60; //hours interval
			return (result + " hours");
		} else {
			result = (minute / 60) / 24;//days interval
			return (result + " days");
		}
	}
}
