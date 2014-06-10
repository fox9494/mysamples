package com.soarsky.octopus.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;


public class DateUtil {
	
     Logger logger =  Logger.getLogger(DateUtil.class);
	/**
	 * 默认的格式:yyyy-MM-dd
	 */
	public static final String PATTERN_DEFAULT = "yyyy-MM-dd";

	/**
	 * 将时间转换成数字，根据时间计算分钟
	 * 
	 * @param time
	 *            需要计算的时间字符表示
	 * @return 分钟总数
	 * @throws Exception
	 */
	public static int parseInt(String time) throws Exception {
		if (time.indexOf(":") != -1) {
			int hour = Integer.parseInt(time.substring(0, time.indexOf(":")));
			int minute = Integer.parseInt(time.substring(time.indexOf(":") + 1,
					time.length()));
			return hour * 60 + minute;
		} else {
			throw new Exception("输入的时间格式不对");
		}
	}
	
	/**
	 * 转换日期格式
	 * @param dateStr    日期字符串
	 * @param src        日期源格式
	 * @param dest       日期转后后的目标格式
	 * @return
	 *      转换格式后的日期字符串
	 * @throws ParseException 如果格式转换失败，则抛出异常
	 */
	public static String changeDateStrFormate(String dateStr, String src,
			String dest) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(src);
		Date date = sdf.parse(dateStr);
		sdf = new SimpleDateFormat(dest);
		return sdf.format(date);
	}


	/**
	 * 获取指定格式的当前时间字符串
	 * @param pattern
	 * @return
	 */
	public static String getCurDateStr(String pattern)
	{
		String dateStr = null;
		try
		{
			if (StringUtils.isNotBlank(pattern))
			{
				dateStr = DateFormatUtils.format(new Date(), pattern);
			}
			else
			{
				dateStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dateStr;
	}
	
	/**
	 * 将字符串转换为Date类型
	 * @param dateStr    日期字符串
	 * @param pattern    格式
	 * @return     Date对象
	 * @throws ParseException    当进行格式化的时候失败，抛出该异常。
	 */
	public static Date getDateByString(String dateStr, String pattern) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}
	
	/**
	 * 将Date类型转换为String类型
	 * @param date       日期
	 * @param pattern    格式
	 * @return    日期对应格式的字符串
	 * @throws ParseException
	 * 当格式转换出现异常，抛出
	 */
	public static String getStringByDate(Date date, String pattern) throws ParseException{
		if (StringUtils.isBlank(pattern))
		{
			return getDefaultDateFormat().format(date);
		}
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		}
	}
	
	/**
	 * 获取默认格式对象
	 * @return    简单的时间格式化对象
	 */
	private static SimpleDateFormat getDefaultDateFormat(){
		return new SimpleDateFormat(PATTERN_DEFAULT);
	}
	
	
	 /**
     * 获取两个 Date 相差的 天数
     * @param dateBeg 开始日期
     * @param dateEnd 结束日期
     * @return 两个 Date 相差的 天数
     */
    public static long getDays(Date dateBeg, Date dateEnd) {
    	if (dateEnd != null && dateEnd != null) {
        	return (Math.abs(dateEnd.getTime() - dateBeg.getTime()) / 24 / 3600 / 1000 );
    	}
    	else {
    		return 0;
    	}
    }
    
    /**
     * 日期 加 天 数
     * @param currentDate 当前时间
     * @param days 日数量
     * @return 加后的日期
     */
    public static Date addDays(Date currentDate, int days) {
    	return addDateTime(currentDate, Calendar.DATE, days);
    }
    
    public static Date addDateTime(Date currentDate, int AddType, int dateTimeCount) {
    	Date addedDate = currentDate;
    	if (currentDate != null && dateTimeCount != 0) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);    			
			calendar.add(AddType, dateTimeCount);
			addedDate = calendar.getTime();
    	}
    	return addedDate;
    }
    
    public String dateDiff(String startTime, String endTime, String format) {
    	SimpleDateFormat sd = new SimpleDateFormat(format);
    	long nd = 1000*24*60*60;//一天的毫秒数
    	long nh = 1000*60*60;//一小时的毫秒数
    	long nm = 1000*60;//一分钟的毫秒数
    	//long ns = 1000;//一秒钟的毫秒数
    	long diff;
    	try {
	    	diff = sd.parse(startTime).getTime() - sd.parse(endTime).getTime();
	    	long day = diff/nd;//计算差多少天
	    	long hour = diff%nd/nh;//计算差多少小时
	    	long min = diff%nd%nh/nm;//计算差多少分钟
	    	//long sec = diff%nd%nh%nm/ns;//计算差多少秒
    	    return "剩余时间:"+day+"天"+hour+"小时"+min+"分";
    	} catch (ParseException e) {
    		logger.error(e.getMessage());
    	}
    	return null;
    }
    
    
    /** 
     * 根据出生日期计算年龄 
     *  
     * @param strBirthDay 
     *            字符串型日期 
     * @param format 
     *            日期格式 
     * @return 未来日期返回0 
     * @throws Exception 
     */  
    public static int getAge(String strBirthDay, String format)  
            throws Exception {  
      
        DateFormat df = new SimpleDateFormat(format);  
        Date birthDay = df.parse(strBirthDay);  
        return getAge(birthDay);  
    }  
    
    /** 
     * 根据出生日期计算年龄 
     *  
     * @param birthDay 
     * @return 未来日期返回0 
     * @throws Exception 
     */  
    private static int getAge(Date birthDay) throws Exception {  
      
        Calendar cal = Calendar.getInstance();  
      
        if (cal.before(birthDay)) {  
            return 0;  
        }  
      
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
      
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
      
        int age = yearNow - yearBirth;  
      
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) {  
                    age--;  
                }  
            } else {  
                age--;  
            }  
        }  
      
        return age;  
    }  
	    
    public static void main(String[] args) throws Exception {
		System.out.println(getAge("1980-4-02", "yyyy-MM-dd"));
		
	}
}
