package com.xnote.client.common.utils.common;

import java.util.Date;

public class DateUtils {

    public static Date getNewDate()
    {
        return new Date();
    }

    public static Long getTimeStamp(){
        return getNewDate().getTime();
    }
}
