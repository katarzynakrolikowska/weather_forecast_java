package weatherapp.model;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;

public class ForecastControls {

    private VBox contentVbox;
    private Label cityName;
    private Label citySunriseTime;
    private Label citySunsetTime;
    private Label cityWeatherDescription;
    private WeatherIconView cityWeatherIcon;
    private Label cityMainTempreture;
    private Label cityWindSpeed;
    private Label cityHumidity;
    private Label cityPressure;

    public ForecastControls(VBox contentVbox, Label cityName, Label citySunriseTime, Label citySunsetTime,
                            Label cityWeatherDescription
            , WeatherIconView cityWeatherIcon, Label cityMainTempreture, Label cityWindSpeed, Label cityHumidity,
                            Label cityPressure) {
        this.contentVbox = contentVbox;
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

    public void setForecastControls(String city) throws APIException {

        CurrentForecastData currentForecastData = new CurrentForecastData(city);
        contentVbox.getStyleClass().clear();
        contentVbox.getStyleClass().add(currentForecastData.getBackgroundClass());
        cityName.setText(currentForecastData.getCityName());
        citySunriseTime.setText(currentForecastData.getSunriseTime());
        citySunsetTime.setText(currentForecastData.getSunsetTime());
        cityWeatherDescription.setText(currentForecastData.getWeatherDescription());
        cityWeatherIcon.setGlyphName(currentForecastData.getCurrentWeatherGlyphName());
        cityMainTempreture.setText(currentForecastData.getMainTempreture());
        cityWindSpeed.setText(currentForecastData.getWindSpeed());
        cityHumidity.setText(currentForecastData.getHumidity());
        cityPressure.setText(currentForecastData.getPressure());
    }


}
