package it.katarzynakrolikowska.weatherapp.model.forecast;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;

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

        FiveDaysForecastData fiveDaysForecasData = new FiveDaysForecastData(cityId);
        fiveDaysForecasData.setFiveDaysForecast(chartVbox);
        warningLabel.setText("");
        scrollPane.setVvalue(0.0);
    }
}
