package cn.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String dateToString(Date date){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String s = sd.format(date);
		return s;
	}
	
	public static Date stringToDate(String s){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = sd.parse(s);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return d;
	}
}
