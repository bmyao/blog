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
     * 根据给定的数据创建一个时间
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return 时间
     */
    public static Date newDate(int year, int month, int day) {
        return newDate(year, month, day, 0, 0, 0);
    }

    /**
     * 根据给定的数据创建一个时间
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   时
     * @param minute 分
     * @param second 秒
     * @return 时间
     */
    public static Date newDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.set(1, year);
        c.set(2, month - 1);
        c.set(5, day);
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, second);
        c.set(14, 999);
        return c.getTime();
    }


    /**
     * @param dateStr 日期字符串
     * @return 将String日期转换成 java.util.Date
     * @throws ParseException .
     */
    public static Date StringToDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        return dateFormat.parse(dateStr);
    }

    /**
     * 截取日期数据的时、分、秒
     *
     * @param date 时间
     * @return 分割后的日期
     */
    public static String dateSplit(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH时mm分");
        return format.format(date);
    }



    /**
     * @param date 日期
     * @return 将日期转换成 String ， 格式是 yyyy-MM-dd HH:mm:ss
     */
    public static String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }

    /**
     * @param date 日期
     * @return 将日期转换成 String ， 格式是 yyyy-MM-dd     *
     */
    public static String dateToShortDateString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }

    /**
     * 将日期转换成 String
     * @param date 日期
     * @param  dateFormatType 指定格式  如 yyyy-MM-dd HH:mm:ss
     * @return  返回指定格式的String
     */
    private static String getDateFormat(Date date, String dateFormatType) {
        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
        return simformat.format(date);
    }

    /**
     * 将日期转换成 String
     * @param dateStr 日期  Thu Mar 14 11:46:18 CST 2019
     * @param  format 指定格式  如 yyyy-MM-dd HH:mm:ss
     * @return  返回指定格式的String
     *例如  Thu Mar 14 11:46:03 CST 2019 -> 2019-03-14 11:46:03
     */
    public static String formatCSTTime(String dateStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date d = sdf.parse(dateStr);
        return DateUtils.getDateFormat(d, format);
    }


    public static void main(String[] args) throws  Exception{
        System.out.println(formatCSTTime("Thu Mar 14 11:46:03 CST 2019","yyyy-MM-dd HH:mm:ss"));

    }



}
