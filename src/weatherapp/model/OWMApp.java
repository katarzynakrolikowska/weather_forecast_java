package weatherapp.model;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

public class OWMApp {

    String apiKey;
    OWM owm;

    public OWMApp(String apiKey) {

        this.apiKey = apiKey;
        owm = new OWM(apiKey);
        owm.setLanguage(OWM.Language.POLISH);
        owm.setUnit(OWM.Unit.METRIC);
    }

    public CurrentWeather getCurrentWeather(String city) throws APIException {

        return owm.currentWeatherByCityName(city);
    }

    public HourlyWeatherForecast getHourlyWeatherForecast(String city) throws APIException {

        return owm.hourlyWeatherForecastByCityName(city);
    }
}
