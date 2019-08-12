package weatherapp;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import weatherapp.model.ForecastControls;
import weatherapp.model.FiveDaysForecastData;
import weatherapp.model.MyDate;
import weatherapp.model.WeatherChart;

public class Controller {

    @FXML
    private VBox userContentVbox;
    @FXML
    private Label userCurrentDateLabel;

    @FXML
    private Label userCityName;
    @FXML
    private Label userCitySunriseTime;
    @FXML
    private Label userCitySunsetTime;
    @FXML
    private Label userCityWeatherDescription;
    @FXML
    private WeatherIconView userCityWeatherIcon;
    @FXML
    private Label userCityMainTempreture;
    @FXML
    private Label userCityWindSpeed;
    @FXML
    private Label userCityHumidity;
    @FXML
    private Label userCityPressure;

    @FXML
    private VBox travelContentVbox;
    @FXML
    private Label travelCurrentDateLabel;
    
    @FXML
    private Label travelCityName;
    @FXML
    private Label travelCitySunriseTime;
    @FXML
    private Label travelCitySunsetTime;
    @FXML
    private Label travelCityWeatherDescription;
    @FXML
    private WeatherIconView travelCityWeatherIcon;
    @FXML
    private Label travelCityMainTempreture;
    @FXML
    private Label travelCityWindSpeed;
    @FXML
    private Label travelCityHumidity;
    @FXML
    private Label travelCityPressure;

    @FXML
    private VBox userWeatherDataVbox;

    @FXML
    private VBox travelWeatherDataVbox;


    @FXML
    public void initialize() {

        try {
            
            initializeMainDataOfForecast();
            initializeFiveDaysForecast();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    private void initializeMainDataOfForecast() throws APIException {
        
        userCurrentDateLabel.setText(MyDate.getCurrentStrDate());
        
        ForecastControls userCityForecastControls= new ForecastControls(userContentVbox, userCityName,
                userCitySunriseTime,
                userCitySunsetTime, userCityWeatherDescription, userCityWeatherIcon, userCityMainTempreture,
                userCityWindSpeed, userCityHumidity, userCityPressure);
        userCityForecastControls.setForecastControls("Warszawa");

        travelCurrentDateLabel.setText(MyDate.getCurrentStrDate());

        ForecastControls travelCityForecastControls= new ForecastControls(travelContentVbox, travelCityName,
                travelCitySunriseTime,
                travelCitySunsetTime, travelCityWeatherDescription, travelCityWeatherIcon, travelCityMainTempreture,
                travelCityWindSpeed, travelCityHumidity, travelCityPressure);
        travelCityForecastControls.setForecastControls("London");

    }

    private void initializeFiveDaysForecast() throws APIException {

        FiveDaysForecastData userFiveDaysForecast = new FiveDaysForecastData("Skierbieszów");
        userFiveDaysForecast.setFiveDaysForecast(userWeatherDataVbox);

        FiveDaysForecastData travelFiveDaysForecast = new FiveDaysForecastData("London");
        travelFiveDaysForecast.setFiveDaysForecast(travelWeatherDataVbox);

    }


}
