package it.katarzynakrolikowska.weatherapp.model.forecast;

import net.aksingh.owmjapis.api.APIException;

public class WeatherForecastControls {

    private CurrentWeatherControls currentWeatherControls;
    private FiveDaysForecastControls fiveDaysForecastControls;


    public WeatherForecastControls(CurrentWeatherControls currentWeatherControls, FiveDaysForecastControls fiveDaysForecastControls) {

        this.currentWeatherControls = currentWeatherControls;
        this.fiveDaysForecastControls = fiveDaysForecastControls;
    }

    public void setControlsOfWeatherForecastForCity(Integer cityId) throws APIException {

        currentWeatherControls.setControlsOfCurrentWeatherForCity(cityId);
        fiveDaysForecastControls.setControlsOfFiveDaysForecastForCity(cityId);
    }
}
