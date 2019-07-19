package com.oneself.blog.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Describe 时间工具类
 * @Author: liangjiayao
 * @Date: 2019/6/12 15:53
 * @Version 1.0
 */
public class DateUtils {

    /**
     * 获取本机现在时间<传入自己想要的时间格式>
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getLocalTime(String format) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 两个时间相差秒数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差秒数
     */
    public static int secondOfDate(Date fromDate, Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        long v = to - from;
        return (int) (v / 1000L);
    }

    /**
     * 两个时间相差分钟数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差分钟数
     */
    public static int minuteOfDate(Date fromDate, Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        long v = to - from;
        return (int) (v / 1000L / 60L);
    }

    /**
     * 两个时间相差小时数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差小时数
     */
    public static int hourOfDate(Date fromDate, Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        long v = to - from;
        return (int) (v / 1000L / 60L / 60L);
    }

    /**
     * 两个时间相差天数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差天数
     */
    public static int yearOfDate(Date fromDate, Date toDate) {
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.setTime(fromDate);
        to.setTime(toDate);
        return to.get(1) - from.get(1);
    }


    /**
     * 两个时间相差月数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差月数
     */
    public static int monthOfDate(Date fromDate, Date toDate) {
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.setTime(fromDate);
        to.setTime(toDate);
        int year = to.get(1) - from.get(1);
        return (year * 12 + to.get(2)) - from.get(2);
    }

    /**
     * 两个时间相差年数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差年数
     */
    public static int dayOfDate(Date fromDate, Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        long v = to - from;
        return (int) (v / 1000L / 3600L / 24L);
    }

    /**
     * 在一个时间基础上增加秒数
     *
     * @param date   原时间
     * @param second 秒
     * @return 增加后的时间
     */
    public static Date addSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(13, calendar.get(13) + second);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加分钟
     *
     * @param date   原时间
     * @param minute 分钟
     * @return 增加后的时间
     */
    public static Date addMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(12, calendar.get(12) + minute);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加小时
     *
     * @param date 原时间
     * @param hour 小时
     * @return 增加后的时间
     */
    public static Date addHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, calendar.get(11) + hour);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加天数
     *
     * @param date 原时间
     * @param day  天数
     * @return 增加后的时间
     */
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(6, calendar.get(6) + day);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加月数
     *
     * @param date  原时间
     * @param month 月
     * @return 增加后的时间
     */
    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(2, calendar.get(2) + month);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加年数
     *
     * @param date 原时间
     * @param year 年
     * @return 增加后的时间
     */
    public static Date addYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(1, calendar.get(2) + year);
        return calendar.getTime();
    }

    /**
     * @param dateStr 日期字符串
     * @return 将String日期转换成 java.util.Date
     * @throws ParseException .
     */
    public static Date strToDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        return dateFormat.parse(dateStr);
    }

    /**
     * @param dateStr 日期字符串
     * @return 将String日期转换成 java.util.Date
     * @throws ParseException .
     */
    public static Date strToDate(String dateStr ,String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.parse(dateStr);
    }

    /**
     * @param date 日期
     * @return 将日期转换成 String ， 格式是 yyyy-MM-dd     *
     */
    public static String dateToStr(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }

    /**
     * @param date 日期
     * @return 将日期转换成 String ， 格式是自定义
     */
    public static String dateToStr(Date date,String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }

    /**
     *  比较日期
     * @param date
     * @param comDate
     * @return
     */
    public static int dateCompareTo(String date,String comDate){
        int compareTo = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateTime = dateFormat.parse(date);
            Date comDateTime = dateFormat.parse(comDate);
            compareTo = dateTime.compareTo(comDateTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return compareTo;
    }

    /**
     * 通过某个日期来计算所需要的前后多少天的日期
     *
     * @param time
     * @param i
     * @return
     */
    public static String getCalendarTime(String time, int i) throws Exception {
        String times = "";
        // 创建日历类
        Calendar calendar = Calendar.getInstance();
        // 设置一个时间进日历类
        calendar.setTime(strToDate(time,"yyyy-MM-dd"));
        // 设置指定的日期
        calendar.add(calendar.DATE, i);
        // 通过日历类拿到想要的日期
        Date t = calendar.getTime();
        // 日期转换字符串
        times = dateToStr(t, "yyyy-MM-dd");
        return times;
    }


    public static void main(String[] args) throws  Exception{

    }



}
