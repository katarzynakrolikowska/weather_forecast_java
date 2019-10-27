package it.katarzynakrolikowska.weatherapp.model.owm;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

public class OWMService {

    String apiKey;
    OWM owm;

    public OWMService(String apiKey) {

        this.apiKey = apiKey;
        owm = new OWM(apiKey);
        owm.setLanguage(OWM.Language.POLISH);
        owm.setUnit(OWM.Unit.METRIC);
    }

    public CurrentWeather getCurrentWeather(Integer cityId) throws APIException {

        return owm.currentWeatherByCityId(cityId);
    }

    public HourlyWeatherForecast getHourlyWeatherForecast(Integer cityId) throws APIException {

        return owm.hourlyWeatherForecastByCityId(cityId);
    }
}
