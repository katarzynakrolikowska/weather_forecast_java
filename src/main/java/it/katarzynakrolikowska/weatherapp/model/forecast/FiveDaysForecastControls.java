package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.model.owm.OWMService;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;

import static it.katarzynakrolikowska.weatherapp.model.constant.WeatherAppConst.API_KEY;

public class FiveDaysForecastControls {

    private VBox chartVbox;
    private Label warningLabel;
    private ScrollPane scrollPane;

    public FiveDaysForecastControls(VBox chartVbox, Label warningLabel, ScrollPane scrollPane) {

        this.chartVbox = chartVbox;
        this.warningLabel = warningLabel;
        this.scrollPane = scrollPane;
    }

    public void setControlsOfFiveDaysForecastForCity(Integer cityId) throws APIException {

        OWMService owmService = new OWMService(API_KEY);
        FiveDaysForecastData fiveDaysForecastData = new FiveDaysForecastData(owmService.getHourlyWeatherForecast(cityId));
        fiveDaysForecastData.setFiveDaysForecast(chartVbox);
        warningLabel.setText("");
        scrollPane.setVvalue(0.0);
    }
}
