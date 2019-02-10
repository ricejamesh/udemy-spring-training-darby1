package com.ttgsolutions.springdemo.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class DateUtils {

    // The date formatter
    // - dd:   day in month (number)
    // - MM:   month in year (number)
    // - yyyy: year
    //
    // See this link for details: https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
    //
    //
    private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    private static SimpleDateFormat utfFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    private static SimpleTimeZone utcTimeZone = new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC");

    static {
        utfFormatter.setTimeZone(utcTimeZone);
    }

    public static String getUTCDate() {
        Date theDate = new Date();
        return formatUTCDate(theDate);
    }

    public static String formatUTCDate(Date theDate) {
        if (theDate == null)
            return "NULL";

        String yourUtcDate = utfFormatter.format(theDate);
        return yourUtcDate;
    }

    // read a date string and parse/convert to a date
    public static Date parseUTCDate(String dateStr) throws ParseException {
        Date theDate = utfFormatter.parse(dateStr);
        return theDate;
    }

    // read a date string and parse/convert to a date
    public static Date parseDate(String dateStr) throws ParseException {
        Date theDate = formatter.parse(dateStr);

        return theDate;
    }

    // read a date and format/convert to a string
    public static String formatDate(Date theDate) {

        String result = null;

        if (theDate != null) {
            result = formatter.format(theDate);
        }

        return result;
    }
}