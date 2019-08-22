package  main.weatherapp.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MyDate {

    public static String getHourMinute(Date date, TimeZone timeZone) {

        DateFormat formatter = new SimpleDateFormat("HH:mm");
        formatter.setTimeZone(timeZone);
        return formatter.format(date);
    }

    public static String getDayMonthYear(Date date, TimeZone timeZone) {

        DateFormat formatter = new SimpleDateFormat("EEEE, d MMMM yyyy");

        formatter.setTimeZone(timeZone);
        return formatter.format(date);
    }

    public static String getShortDayName(Date date, TimeZone timeZone) {

        DateFormat formatter = new SimpleDateFormat("EE");
        formatter.setTimeZone(timeZone);

        return formatter.format(date);
    }

    public static String getDayName(Date date, TimeZone timeZone) {

        DateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(timeZone);

        return formatter.format(date);
    }

    public static Long getCurrentDate() {

        return new Date().getTime();
    }
}
