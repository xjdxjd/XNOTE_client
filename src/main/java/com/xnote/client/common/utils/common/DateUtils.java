package com.xnote.client.common.utils.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getNowDate()
    {
        return new Date();
    }

    public static Long getTimeStamp(){
        return getNowDate().getTime();
    }

    public static Long getTimeStamp(Date date){
        return date.getTime();
    }

    /**
     * 格式化时间
     */
    public static String format(Date date)
    {
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return dateString;
    };

    /**
     * 格式化当前时间
     * @return
     */
    public static String getFormatNowDate(){
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getNowDate());
        return dateString;
    }

    /**
     *  获取指定日期的指定时间量之后的日期
     * @param timeBase   时间基数
     * @param quantum   时间量
     * @return
     */
    public static Date getSpecifiedDate(Date timeBase, Integer quantum)
    {
        //  获取日历示例
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeBase);
        calendar.add(Calendar.MONTH, quantum);
        Date time = calendar.getTime();

        return time;
    }
}
