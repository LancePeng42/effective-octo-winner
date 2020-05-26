package com.citic.payment.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static int getCurrentMonth() {
        Date date = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH + 1);
        return month;
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH + 1);
        return month;
    }

}
