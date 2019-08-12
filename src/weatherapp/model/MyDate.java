package weatherapp.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {

    public static String getCurrentStrDate() {

        SimpleDateFormat df = new SimpleDateFormat("EEEE, d MMMM yyyy");
        String dateStr = df.format(new Date());

        return dateStr;
    }

    public static String getHourMinute(Date date) {

        DateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(date);
    }

    public static String getDayMonthYear(Date date) {

        DateFormat formatter = new SimpleDateFormat("EEEE, d MMMM yyyy");
        return formatter.format(date);
    }

    public static String getDayName(Date date) {

        DateFormat formatter = new SimpleDateFormat("EE");
        return formatter.format(date);
    }

}
