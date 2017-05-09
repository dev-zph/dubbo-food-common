package dubbo.out.food.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";
	
	public static final String DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 格式化标准日�?
	 * @param date
	 * @return
	 */
	public static String formatStandard(Date date){
		if (date == null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DATE);
		return sdf.format(date);
	}
	
	/**
	 * 格式化标准日期和时间
	 * @param date
	 * @return
	 */
	public static String formatStandardTime(Date date){
		if (date == null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TIME);
		return sdf.format(date);
	}
	
	/**
	 * 格式化标准日期和时间
	 * @param date
	 * @return
	 */
	public static String formatStandardTime(Date date,String pattern){
		if (date == null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

}
