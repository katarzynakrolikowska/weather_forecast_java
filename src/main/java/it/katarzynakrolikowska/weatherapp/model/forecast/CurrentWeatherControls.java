package it.katarzynakrolikowska.weatherapp.model.forecast;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import it.katarzynakrolikowska.weatherapp.model.owm.OWMService;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;

import static it.katarzynakrolikowska.weatherapp.model.constant.WeatherAppConst.API_KEY;

public class CurrentWeatherControls {

    private VBox contentVbox;
    private Label dateLabel;
    private Label cityNameLabel;
    private Label citySunriseTimeLabel;
    private Label citySunsetTimeLabel;
    private Label cityWeatherDescriptionLabel;
    private WeatherIconView cityWeatherIcon;
    private Label cityMainTempretureLabel;
    private Label cityWindSpeedLabel;
    private Label cityHumidityLabel;
    private Label cityPressureLabel;


    public CurrentWeatherControls(VBox contentVbox, Label date, Label cityName, Label citySunriseTime,
                                  Label citySunsetTime,
                                  Label cityWeatherDescription
            , WeatherIconView cityWeatherIcon, Label cityMainTempreture, Label cityWindSpeed, Label cityHumidity,
                                  Label cityPressure) {
        this.contentVbox = contentVbox;
        this.dateLabel = date;
        this.cityNameLabel = cityName;
        this.citySunriseTimeLabel = citySunriseTime;
        this.citySunsetTimeLabel = citySunsetTime;
        this.cityWeatherDescriptionLabel = cityWeatherDescription;
        this.cityWeatherIcon = cityWeatherIcon;
        this.cityMainTempretureLabel = cityMainTempreture;
        this.cityWindSpeedLabel = cityWindSpeed;
        this.cityHumidityLabel = cityHumidity;
        this.cityPressureLabel = cityPressure;
    }

    public void setControlsOfCurrentWeatherForCity(Integer cityId) throws APIException {

        OWMService owmService = new OWMService(API_KEY);
        CurrentWeatherData currentWeatherData = new CurrentWeatherData(owmService.getCurrentWeather(cityId));
        contentVbox.getStyleClass().clear();
        contentVbox.getStyleClass().add(currentWeatherData.getBackgroundCSSClass());
        dateLabel.setText(currentWeatherData.getDate() + currentWeatherData.getStrTimeOffset());
        cityNameLabel.setText(currentWeatherData.getCityName());
        citySunriseTimeLabel.setText(currentWeatherData.getSunriseTime());
        citySunsetTimeLabel.setText(currentWeatherData.getSunsetTime());
        cityWeatherDescriptionLabel.setText(currentWeatherData.getWeatherDescription());
        cityWeatherIcon.setGlyphName(currentWeatherData.getCurrentWeatherGlyphName());
        cityMainTempretureLabel.setText(currentWeatherData.getMainTempreture());
        cityWindSpeedLabel.setText(currentWeatherData.getWindSpeed());
        cityHumidityLabel.setText(currentWeatherData.getHumidity());
        cityPressureLabel.setText(currentWeatherData.getPressure());
    }
}
