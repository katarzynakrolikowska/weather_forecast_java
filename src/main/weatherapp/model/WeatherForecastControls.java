package main.weatherapp.model;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;

public class WeatherForecastControls {

    private CurrentWeatherControls currentWeatherControls;
    private VBox chartVbox;
    private Label warningLabel;
    private ScrollPane scrollPane;

    public WeatherForecastControls(CurrentWeatherControls currentWeatherControls, VBox chartVbox, Label warningLabel, ScrollPane scrollPane) {

        this.currentWeatherControls = currentWeatherControls;
        this.chartVbox = chartVbox;
        this.warningLabel = warningLabel;
        this.scrollPane = scrollPane;
    }

    public void setControlsOfWeatherForecastForCity(Integer cityId) throws APIException {

        currentWeatherControls.setCurrentWeatherControlsForCity(cityId);

        FiveDaysForecastData userFiveDaysForecast = new FiveDaysForecastData(cityId);
        userFiveDaysForecast.setFiveDaysForecast(chartVbox);
        warningLabel.setText("");
        scrollPane.setVvalue(0.0);
    }
}
