package com.atguigu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat();
	public static String dateFormatYYYYMMDD(Date date){
		if(date == null){
			return "";
		}
		sdf.applyPattern("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String dateFormatyyyyMMddHHmm(Date date){
		if(date == null){
			return "";
		}
		sdf.applyPattern("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
}
