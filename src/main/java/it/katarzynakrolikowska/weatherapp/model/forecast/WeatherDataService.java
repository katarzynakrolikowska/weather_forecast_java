package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.model.formatter.DataFormatter;
import it.katarzynakrolikowska.weatherapp.model.formatter.DateTimeFormatter;
import net.aksingh.owmjapis.model.param.WeatherData;

import java.util.Date;
import java.util.TimeZone;

public class WeatherDataService {

    private WeatherData data;
    private TimeZone timeZone;

    public WeatherDataService(WeatherData data, TimeZone timeZone) {
        this.data = data;
        this.timeZone = timeZone;
    }

    public String getTime() {

        Date date = data.getDateTime();
        return DateTimeFormatter.getHourMinute(data.getDateTime(), timeZone) + "\n" +  DateTimeFormatter.getShortDayName(date
                , timeZone);
    }

    public Integer getMainTempreture() {

        return  DataFormatter.getRoundedNumberToInteger(data.getMainData().getTemp());
    }

    public String getIconCode() {

        return data.getWeatherList().get(0).getIconCode();
    }

    public String getDayName() {

        Date date = data.getDateTime();
        return DateTimeFormatter.getDayName(date, timeZone);
    }
}
