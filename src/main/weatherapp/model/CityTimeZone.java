package  main.weatherapp.model;

import com.github.bfsmith.geotimezone.TimeZoneLookup;
import com.github.bfsmith.geotimezone.TimeZoneResult;

import java.util.TimeZone;

public class CityTimeZone {

    public static TimeZone getTimeZoneOfTheCity(double latitude, double longitude) {

        String timeZoneName = getStrTimeZoneOfTheCity(latitude, longitude);
        return TimeZone.getTimeZone(timeZoneName);
    }

    private static String getStrTimeZoneOfTheCity(double latitude, double longitude) {

        TimeZoneLookup timeZoneLookup = new TimeZoneLookup();
        TimeZoneResult timeZoneResult = timeZoneLookup.getTimeZone(latitude, longitude);
        return timeZoneResult.getResult();
    }
}
