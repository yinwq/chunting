package com.yinwq.chunting.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BT {
    private static final Logger     LOGGER             = LoggerFactory.getLogger(BT.class);

    private final static Properties SUPER_PROPERTIES = new Properties();

    /**
     * 判断字符串是否为空
     * 
     * @param ()str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 返回格式化后的时间字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String dateFormat(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        String time = df.format(date);
        return time;
    }

    /**
     * 返回转换后的时间类型
     * 
     * @param date
     * @param format
     * @return
     */
    public static Date Str2Date(String dateStr, String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * 返回格式化后的时间字符串,时间由第一个时间参数再加上第二个参数得到
     * 
     * @param date
     * @param format
     * @return
     */
    public static String dateFormat(Date date, long val, String format) {
        Date newDate = new Date(date.getTime() + val);
        DateFormat df = new SimpleDateFormat(format);
        String time = df.format(newDate);
        return time;
    }

    /**
     * 从一个日期对象中提取时间字符串
     * 
     * @param date
     * @return
     */
    public static String pickUpTime(Date date) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        String time = df.format(date);
        return time;
    }

    /**
     * 根据指定格式，获取当前日期时间字符串，默认格式yyyy-MM-dd HH:mm:ss
     * 
     * @param format
     * @return
     */
    public static String getCurrentDateTime(String format) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(isEmpty(format) ? "yyyy-MM-dd HH:mm:ss" : format);
        String dateTime = df.format(date);
        return dateTime;
    }

    /**
     * 获取当前日期时间字符串，默认格式yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String getCurrentDateTime() {
        return getCurrentDateTime(null);
    }

    /**
     * 获取当前日期，格式yyyyMMdd
     * 
     * @return
     */
    public static String getCurrentDate() {
        GregorianCalendar tGCalendar = new GregorianCalendar();
        StringBuffer tStringBuffer = new StringBuffer(10);
        int sYears = tGCalendar.get(Calendar.YEAR);
        tStringBuffer.append(sYears);
        int sMonths = tGCalendar.get(Calendar.MONTH) + 1;
        if (sMonths < 10) {
            tStringBuffer.append('0');
        }
        tStringBuffer.append(sMonths);
        int sDays = tGCalendar.get(Calendar.DAY_OF_MONTH);
        if (sDays < 10) {
            tStringBuffer.append('0');
        }
        tStringBuffer.append(sDays);
        String tString = tStringBuffer.toString();
        return tString;
    }

    /**
     * 获取当前时间，格式HHmmss
     * 
     * @return
     */
    public static String getCurrentTime() {
        GregorianCalendar tGCalendar = new GregorianCalendar();
        StringBuffer tStringBuffer = new StringBuffer(6);
        int sHOUR = tGCalendar.get(Calendar.HOUR_OF_DAY);
        if (sHOUR < 10) {
            tStringBuffer.append('0');
        }
        tStringBuffer.append(sHOUR);
        int sMINUTE = tGCalendar.get(Calendar.MINUTE);
        if (sMINUTE < 10) {
            tStringBuffer.append('0');
        }
        tStringBuffer.append(sMINUTE);
        int sSECOND = tGCalendar.get(Calendar.SECOND);
        if (sSECOND < 10) {
            tStringBuffer.append('0');
        }
        tStringBuffer.append(sSECOND);
        String tString = tStringBuffer.toString();
        return tString;
    }

    /**
     * 将参数填充到模板中，合成字符串。一般用在短信、微信中。参数形式如：“您收到来自%phone%的信息”
     * 
     * @param template
     * @param parameters
     * @return
     */
    public static String buildString(String template, Map<String, String> parameters) {
        Set<String> keys = parameters.keySet();
        for (String key : keys) {
            template = template.replaceAll("%" + key + "%", parameters.get(key));
        }
        return template;
    }

    /**
     * 根据出生日期计算周岁 参数 birthDay 格式为YYYYMMDD
     * 
     * @param birthDay
     * @return
     */
    public static int calAgeByBirthDay(String birthDay) {
        int bYear = Integer.parseInt(birthDay.substring(0, 4));
        String bMonthday = birthDay.substring(4);

        Calendar tGCalendar = Calendar.getInstance();
        int sYear = tGCalendar.get(Calendar.YEAR);

        StringBuffer nMonthday = new StringBuffer(6);
        int nMonth = tGCalendar.get(Calendar.MONTH) + 1;
        if (nMonth < 10) {
            nMonthday.append('0');
        }
        nMonthday.append(nMonth);
        int nDay = tGCalendar.get(Calendar.DAY_OF_MONTH);
        if (nDay < 10) {
            nMonthday.append('0');
        }
        nMonthday.append(nDay);
        return sYear - bYear - 1 + (nMonthday.toString().compareTo(bMonthday) >= 0 ? 1 : 0);
    }

}
