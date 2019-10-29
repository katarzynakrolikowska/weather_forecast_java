package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.model.constant.WeatherAppConst;
import it.katarzynakrolikowska.weatherapp.model.formatter.DataFormatter;
import it.katarzynakrolikowska.weatherapp.model.formatter.DateTimeFormatter;
import it.katarzynakrolikowska.weatherapp.model.owm.OWMRepository;
import it.katarzynakrolikowska.weatherapp.model.time.CityTimeZone;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

import java.util.Date;
import java.util.TimeZone;


public class CurrentWeatherData extends WeatherForecastData {

    private CurrentWeather currentWeather;

    public CurrentWeatherData(OWMRepository owmRepository, Integer cityId) throws APIException {

        this.currentWeather = owmRepository.getCurrentWeather(cityId);
        this.timeZone = getTimeZoneOfTheCity();
    }

    public String getBackgroundCSSClass() {

        switch (getCurrentWeatherIconCode()) {
            case "01d":
                return "bg-sunny";
            case "01n":
            case "02n":
            case "03n":
            case "04n":
            case "09n":
            case "10n":
            case "13n":
            case "50n":
                return "bg-night";
            case "03d":
            case "04d":
                return "bg-cloudy";
            case "09d":
                return "bg-rain";
            case "11d":
            case "11n":
                return "bg-thunderstorm";
            case "13d":
                return "bg-snow";
            case "50d":
                return "bg-mist";
            case "02d":
            case "10d":
            default:
                return "bg-clear";
        }
    }

    public String getDate() {

        Date date = currentWeather.getDateTime();

        return DateTimeFormatter.getDayMonthYear(date, getTimeZoneOfTheCity());
    }

    public String getStrTimeOffset() {

        int offset = getTimeOffset();
        String offsetStr = String.format("%02d:", Math.abs(offset));

        if(offset > 0) {
            return " (UTC +" + offsetStr + "00)";
        } else if (offset < 0){
            return " (UTC -" + offsetStr + "00)";
        } else {
            return " (UTC " + offsetStr + "00)";
        }
    }

    private int getTimeOffset() {

        TimeZone timeZone = getTimeZoneOfTheCity();

        int offset =  timeZone.getOffset(DateTimeFormatter.getCurrentDate()) / WeatherAppConst.MILLISECONDS_IN_ONE_HOUR;
        return offset;
    }

    public String getCityName() {

        return currentWeather.getCityName();
    }

    public String getSunriseTime() {

        Date date = currentWeather.getSystemData().getSunriseDateTime();
        return DateTimeFormatter.getHourMinute(date, getTimeZoneOfTheCity());
    }

    public String getSunsetTime() {

        Date date = currentWeather.getSystemData().getSunsetDateTime();
        return DateTimeFormatter.getHourMinute(date, getTimeZoneOfTheCity());
    }

    public String getWeatherDescription() {

        String desc = currentWeather.getWeatherList().get(0).getMoreInfo();
        return DataFormatter.getWordUppercaseFirstLetter(desc);
    }

    public String getCurrentWeatherGlyphName() {

        return getWeatherGlyphName(getCurrentWeatherIconCode());
    }

    private String getCurrentWeatherIconCode() {

        return currentWeather.getWeatherList().get(0).getIconCode();
    }

    public String getMainTempreture() {

        double temp = currentWeather.getMainData().getTemp();
        return DataFormatter.getRoundedNumberToInteger(temp) + "°C";
    }

    public String getWindSpeed() {

        double wind = currentWeather.getWindData().getSpeed();
        return DataFormatter.getKmPerHour(wind) + " km/h";
    }

    public String getHumidity() {

        double humidity = currentWeather.getMainData().getHumidity();
        return DataFormatter.getRoundedNumberToInteger(humidity) + "%";
    }

    public String getPressure() {

        double pressure = currentWeather.getMainData().getPressure();
        return DataFormatter.getRoundedNumberToInteger(pressure) + " hPa";
    }

    private TimeZone getTimeZoneOfTheCity() {

        CityTimeZone cityTimeZone = new CityTimeZone();
        return cityTimeZone.getTimeZoneOfTheCity(getLatitude(), getLongitude());
    }

    private double getLatitude() {

        return currentWeather.getCoordData().getLatitude();
    }

    private double getLongitude() {

        return currentWeather.getCoordData().getLongitude();
    }
}
