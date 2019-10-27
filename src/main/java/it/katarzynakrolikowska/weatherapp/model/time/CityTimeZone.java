package it.katarzynakrolikowska.weatherapp.model.time;

import com.github.bfsmith.geotimezone.TimeZoneLookup;
import com.github.bfsmith.geotimezone.TimeZoneResult;
import it.katarzynakrolikowska.weatherapp.model.formatter.DataFormatter;
import it.katarzynakrolikowska.weatherapp.model.math.MathFunctions;

import java.util.TimeZone;

public class CityTimeZone {

    public TimeZone getTimeZoneOfTheCity(double latitude, double longitude) {

        if (isValidCoordinates(latitude, longitude)) {
            String timeZoneName = getStrTimeZoneOfTheCity(latitude, longitude);
            return TimeZone.getTimeZone(timeZoneName);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String getStrTimeZoneOfTheCity(double latitude, double longitude) {

        TimeZoneLookup timeZoneLookup = new TimeZoneLookup();
        TimeZoneResult timeZoneResult = timeZoneLookup.getTimeZone(latitude, longitude);
        return timeZoneResult.getResult();
    }

    private boolean isValidCoordinates(double latitude, double longitude) {

        if (MathFunctions.isBetween(latitude, -90.00, 90.00) && MathFunctions.isBetween(longitude, -180.00, 180.00)) {
            return true;
        } else {
            return false;
        }
    }
}
