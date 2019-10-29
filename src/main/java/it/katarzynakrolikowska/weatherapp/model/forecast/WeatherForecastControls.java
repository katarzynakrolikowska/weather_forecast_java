package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.model.owm.OWMRepository;
import net.aksingh.owmjapis.api.APIException;

public class WeatherForecastControls {

    private CurrentWeatherControls currentWeatherControls;
    private FiveDaysForecastControls fiveDaysForecastControls;


    public WeatherForecastControls(CurrentWeatherControls currentWeatherControls, FiveDaysForecastControls fiveDaysForecastControls) {

        this.currentWeatherControls = currentWeatherControls;
        this.fiveDaysForecastControls = fiveDaysForecastControls;
    }

    public void setControlsOfWeatherForecastForCity(OWMRepository owmRepository, Integer cityId) throws APIException {

        currentWeatherControls.setControlsOfCurrentWeatherForCity(owmRepository, cityId);
        fiveDaysForecastControls.setControlsOfFiveDaysForecastForCity(owmRepository, cityId);
    }
}
