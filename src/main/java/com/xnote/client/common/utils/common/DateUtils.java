package com.xnote.client.common.utils.common;

import java.text.SimpleDateFormat;
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
}
