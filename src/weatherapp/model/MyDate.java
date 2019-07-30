package weatherapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    public static String getStringDate() {

        SimpleDateFormat df = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String dateStr = df.format(new Date());

        return dateStr;
    }

}
