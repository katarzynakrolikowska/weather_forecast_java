package  main.weatherapp.model;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;

public class CurrentWeatherControls {

    private VBox contentVbox;
    private Label date;
    private Label cityName;
    private Label citySunriseTime;
    private Label citySunsetTime;
    private Label cityWeatherDescription;
    private WeatherIconView cityWeatherIcon;
    private Label cityMainTempreture;
    private Label cityWindSpeed;
    private Label cityHumidity;
    private Label cityPressure;

    public CurrentWeatherControls(VBox contentVbox, Label date, Label cityName, Label citySunriseTime,
                                  Label citySunsetTime,
                                  Label cityWeatherDescription
            , WeatherIconView cityWeatherIcon, Label cityMainTempreture, Label cityWindSpeed, Label cityHumidity,
                                  Label cityPressure) {
        this.contentVbox = contentVbox;
        this.date = date;
        this.cityName = cityName;
        this.citySunriseTime = citySunriseTime;
        this.citySunsetTime = citySunsetTime;
        this.cityWeatherDescription = cityWeatherDescription;
        this.cityWeatherIcon = cityWeatherIcon;
        this.cityMainTempreture = cityMainTempreture;
        this.cityWindSpeed = cityWindSpeed;
        this.cityHumidity = cityHumidity;
        this.cityPressure = cityPressure;
    }

    public void setCurrentWeatherControlsForCity(Integer cityId) throws APIException {

        CurrentWeatherData currentWeatherData = new CurrentWeatherData(cityId);
        contentVbox.getStyleClass().clear();
        contentVbox.getStyleClass().add(currentWeatherData.getBackgroundClass());
        date.setText(currentWeatherData.getDate() + currentWeatherData.getTimeOffsetText());
        cityName.setText(currentWeatherData.getCityName());
        citySunriseTime.setText(currentWeatherData.getSunriseTime());
        citySunsetTime.setText(currentWeatherData.getSunsetTime());
        cityWeatherDescription.setText(currentWeatherData.getWeatherDescription());
        cityWeatherIcon.setGlyphName(currentWeatherData.getCurrentWeatherGlyphName());
        cityMainTempreture.setText(currentWeatherData.getMainTempreture());
        cityWindSpeed.setText(currentWeatherData.getWindSpeed());
        cityHumidity.setText(currentWeatherData.getHumidity());
        cityPressure.setText(currentWeatherData.getPressure());
    }
}
