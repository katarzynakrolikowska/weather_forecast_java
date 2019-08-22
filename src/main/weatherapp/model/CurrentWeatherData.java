package  main.weatherapp.model;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import java.util.Date;
import java.util.TimeZone;


public class CurrentWeatherData extends WeatherData {

    private CurrentWeather currentWeather;

    public CurrentWeatherData(Integer cityId) throws APIException {

        super();
        this.currentWeather = owmApp.getCurrentWeather(cityId);
        this.timeZone = getTimeZoneOfTheCity();
    }

    public String getBackgroundClass() {

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

        return MyDate.getDayMonthYear(date, getTimeZoneOfTheCity());
    }

    public String getTimeOffsetText() {

        int offset = getTimeOffset();
        String offsetStr = String.format("%02d:", Math.abs(offset));

        if(offset > 0) {
            return " (UTC +" + offsetStr + "00)";
        } else {
            return " (UTC -" + offsetStr + "00)";
        }
    }

    private int getTimeOffset() {

        TimeZone timeZone = getTimeZoneOfTheCity();

        int offset =  timeZone.getOffset(MyDate.getCurrentDate()) / WeatherAppConst.MILLISECONDS_IN_ONE_HOUR;
        return offset;
    }

    public String getCityName() {

        return currentWeather.getCityName();
    }

    public String getSunriseTime() {

        Date date = currentWeather.getSystemData().getSunriseDateTime();
        return MyDate.getHourMinute(date, getTimeZoneOfTheCity());
    }

    public String getSunsetTime() {

        Date date = currentWeather.getSystemData().getSunsetDateTime();
        return MyDate.getHourMinute(date, getTimeZoneOfTheCity());
    }

    public String getWeatherDescription() {

        String desc = currentWeather.getWeatherList().get(0).getMoreInfo();
        return DataFormatter.getUppercaseFirstLetter(desc);
    }

    public String getCurrentWeatherGlyphName() {

        return getWeatherGlyphName(getCurrentWeatherIconCode());
    }

    private String getCurrentWeatherIconCode() {

        return currentWeather.getWeatherList().get(0).getIconCode();
    }

    public String getMainTempreture() {

        double temp = currentWeather.getMainData().getTemp();
        return DataFormatter.getRoundedNumber(temp) + "°C";
    }

    public String getWindSpeed() {

        double wind = currentWeather.getWindData().getSpeed();
        return DataFormatter.getKmPerHour(wind) + " km/h";
    }

    public String getHumidity() {

        double humidity = currentWeather.getMainData().getHumidity();
        return DataFormatter.getRoundedNumber(humidity) + "%";
    }

    public String getPressure() {

        double pressure = currentWeather.getMainData().getPressure();
        return DataFormatter.getRoundedNumber(pressure) + " hPa";
    }

    private TimeZone getTimeZoneOfTheCity() {

        return CityTimeZone.getTimeZoneOfTheCity(getLatitude(), getLongitude());
    }

    private double getLatitude() {

        return currentWeather.getCoordData().getLatitude();
    }

    private double getLongitude() {

        return currentWeather.getCoordData().getLongitude();
    }
}
