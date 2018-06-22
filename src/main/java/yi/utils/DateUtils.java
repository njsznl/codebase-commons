package yi.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author xiao
 * @create 2018/6/22
 */
@Slf4j
public class DateUtils {

    private static final String DATE_STRING = "yyyy-MM-dd";
    private static final String TIME_STRING = "HH:mm:ss";
    private static final String DATE_TIME_STRING = "yyyy-MM-dd HH:mm:ss";
    public static final char ONE_SPACE = ' ';

    /**
     * 由开始日期转换为开始时间，一般在以时间为条件的查询中使用
     *
     * @param startDate start date
     * @return start date  00:00:00
     */
    public static Date date2StartTime(Date startDate) {
        if (startDate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING);
        String dateStr = sdf.format(startDate);
        sdf = new SimpleDateFormat(DATE_TIME_STRING);
        Date startTime = null;
        try {
            startTime = sdf.parse(dateStr + " 00:00:00");
        } catch (ParseException e) {
            log.error("开始日期转换为开始时间失败", e);
        }
        return startTime;
    }

    /**
     * 由结束日期转换为结束时间，一般在以时间为条件的查询中使用
     *
     * @param endDate end date str
     * @return end date time
     */
    public static Date date2EndTime(Date endDate) {
        if (endDate == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING);
        String dateStr = sdf.format(endDate);
        sdf = new SimpleDateFormat(DATE_TIME_STRING);
        Date endTime = null;
        try {
            endTime = sdf.parse(dateStr + " 23:59:59");
        } catch (ParseException e) {
            log.error("结束时间转换失败", e);
        }
        return endTime;
    }

    /**
     * 获得当前SQL日期
     *
     * @return sql date
     */
    public static java.sql.Date curSqlDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }

    /**
     * 获得当前日期字符串: yyyy-MM-dd
     *
     * @return current date str
     */
    public static String curDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING);
        return sdf.format(new Date());
    }

    /**
     * 获得当前日期字符串：yyyy-MM-dd HH:mm:ss
     *
     * @return current datetime str
     */
    public static String curDateTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_STRING);
        return sdf.format(new Date());
    }

    /**
     * 格式化日期
     *
     * @param date date
     * @return date String
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING);
        return sdf.format(date);
    }

    /**
     * 格式化时间
     *
     * @param date date
     * @return time str
     */
    public static String formatTime(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_STRING);
        return sdf.format(date);
    }

    /**
     * 格式化日期时间
     *
     * @param date date
     * @return date time str
     */
    public static String formatDateTime(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_STRING);
        return sdf.format(date);
    }

    /**
     * 字符串转换为日期
     *
     * @param dateStr date str
     * @return date
     */
    private static Date parseDate(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取当前周的第一天
     *
     * @return The first day of the current week
     */
    public static String getCurrentWeekFirst() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -(c.get(Calendar.DAY_OF_WEEK) - 2));
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING);
        return sdf.format(c.getTime());
    }

    /**
     * 获取当前周的最后一天
     *
     * @return The last day of the previous week
     */
    public static String getCurrentWeekLast() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -(c.get(Calendar.DAY_OF_WEEK) - 2));
        c.add(Calendar.DATE, 6);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING);
        return sdf.format(c.getTime());
    }

    /**
     * 字符串转换为SQL日期对象，如果出错，则返回null
     *
     * @param dateStr date str
     * @return sql date
     */
    public static java.sql.Date parseSqlDate(String dateStr) {
        Date d = parseDate(dateStr);
        if (d != null) {
            return new java.sql.Date(d.getTime());
        }
        return null;
    }

    /**
     * 字符串date转ate
     *
     * @param datetimeStr date str
     * @return Date
     */
    private static Date parseDateTime(String datetimeStr) {
        if (StringUtils.isEmpty(datetimeStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_STRING);
            return sdf.parse(datetimeStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 字符串时间转sql时间戳
     *
     * @param datetimeStr date time str
     * @return timestamp sql
     */
    public static java.sql.Timestamp parseSqlDateTime(String datetimeStr) {
        Date d = parseDateTime(datetimeStr);
        if (d != null) {
            return new java.sql.Timestamp(d.getTime());
        }
        return null;
    }

    /**
     * 计算生日
     *
     * @param sDate String 指定日期[YYYY-MM-DD]或时间
     * @return int age
     */
    public static int getAge(String sDate) {
        // 提取字符串中的年、月、日
        int i1stMin = sDate.indexOf("-", 0);
        int i2stMin = sDate.indexOf("-", i1stMin + 1);
        int i3stMin = i2stMin + 3;
        if (i2stMin + 3 < sDate.length()) {
            i3stMin = i2stMin + 2;
        } else {
            if (sDate.charAt(i2stMin + 2) == ONE_SPACE) {
                i3stMin = i2stMin + 2;
            }
        }
        int iYear = Integer.parseInt(sDate.substring(0, i1stMin));
        int iMonth = Integer.parseInt(sDate.substring(i1stMin + 1, i2stMin));
        int iDay = Integer.parseInt(sDate.substring(i2stMin + 1, i3stMin));

        // 取得当前年份，和当天是年内第N天
        Calendar calendar = Calendar.getInstance();
        int iSysYear = calendar.get(Calendar.YEAR);
        int iSysMonth = calendar.get(Calendar.MONTH) + 1;
        int iSysDay = calendar.get(Calendar.DATE);

        // 计算年龄
        int iAge = iSysYear - iYear;
        if (iSysDay - iDay < 0) {
            // 月份数借位
            iSysMonth--;
        }
        if (iSysMonth - iMonth < 0) {
            iAge--;
        }
        return iAge;
    }

    /**
     * 计算生日
     *
     * @param sDate   String 指定日期[YYYY-MM-DD]或时间
     * @param pattern String 指定日期格式
     * @return int 年龄
     */
    public static int getAge(String sDate, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d = sdf.parse(sDate);
        return getAge(d);
    }

    /**
     * 计算生日
     *
     * @param date date 指定日期或时间
     * @return int 年龄
     */
    private static int getAge(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int iYear = cal.get(Calendar.YEAR);
        int iMonth = cal.get(Calendar.MONTH) + 1;
        int iDay = cal.get(Calendar.DATE);

        // 取得当前年份，和当天是年内第N天
        Calendar calendar = Calendar.getInstance();
        int iSysYear = calendar.get(Calendar.YEAR);
        int iSysMonth = calendar.get(Calendar.MONTH) + 1;
        int iSysDay = calendar.get(Calendar.DATE);

        // 计算年龄
        int iAge = iSysYear - iYear;
        if (iSysDay - iDay < 0) {
            // 月份数借位
            iSysMonth--;
        }
        if (iSysMonth - iMonth < 0) {
            iAge--;
        }
        return iAge;
    }

    /**
     * 按照[yyyy-MM-dd]格式转换日期字符串到Date对象（例如：2001年1月12日为“2001-01-12”）
     *
     * @param sDate date
     * @return date
     * @throws ParseException 日期转换异常
     */
    public static Date getDateFromString(String sDate) throws ParseException {
        SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd");
        return formatDateTime.parse(sDate);
    }

    /**
     * 按照[yyyy年MM月dd日]格式转换日期字符串到Date对象（例如：2001年1月12日为“2001年01月12日”）
     *
     * @param sDate date
     * @return Date 日期对象,如果日期字符创不合法，返回当前日期
     * @throws ParseException 日期转换异常
     */
    public static Date getDateFromCHString(String sDate) throws ParseException {
        SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy年MM月dd日");
        return formatDateTime.parse(sDate);
    }

}
