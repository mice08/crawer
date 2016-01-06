package com.mk.crawer.biz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    static String DATE_NULL = "0000-00-00";

    public static String format_yMd(Date date) {
        if (date == null) {
            return DATE_NULL;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String format_yMdHms(Date date) {
        if (date == null) {
            return DATE_NULL;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static Date parse(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(strDate);
        } catch (Exception e) {
            //log
        }
        return null;
    }
}
