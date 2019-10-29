package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.model.owm.OWMRepository;
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

    public void setControlsOfFiveDaysForecastForCity(OWMRepository owmRepository, Integer cityId) throws APIException {

        FiveDaysForecastData fiveDaysForecastData = new FiveDaysForecastData(owmRepository, cityId);
        fiveDaysForecastData.setFiveDaysForecast(chartVbox);
        warningLabel.setText("");
        scrollPane.setVvalue(0.0);
    }
}
