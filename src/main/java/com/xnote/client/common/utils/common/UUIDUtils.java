package com.xnote.client.common.utils.common;

import java.util.UUID;

public class UUIDUtils
{

    public static String getUUID()
    {
        String uuidString = UUID.randomUUID().toString();
        String uuidStr = uuidString.substring(0, 8) + uuidString.substring(9, 13) + uuidString.substring(14, 18) + uuidString.substring(19, 23) + uuidString.substring(24);
        return uuidStr;
    };
}
