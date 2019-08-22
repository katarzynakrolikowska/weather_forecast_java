package main.weatherapp.controller;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.weatherapp.model.exception.InvalidCityNameException;
import net.aksingh.owmjapis.api.APIException;
import main.weatherapp.model.*;


import java.util.*;

public class Controller {

    @FXML
    private GridPane mainGridPane;

    @FXML
    private TextField userTextFieldSearch;
    @FXML
    private VBox userContentVbox;
    @FXML
    private Label userWarningLabel;

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
    private VBox userChartVbox;

    @FXML
    private TextField travelTextFieldSearch;
    @FXML
    private VBox travelContentVbox;
    @FXML
    private Label travelWarningLabel;

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
    private VBox travelChartVbox;

    @FXML
    private ScrollPane userScrollPane;

    @FXML
    private ScrollPane travelScrollPane;

    private CurrentWeatherControls userCityCurrentWeatherControls;
    private CurrentWeatherControls travelCityCurrentWeatherControls;
    private Map<String, Integer> citiesMap;


    @FXML
    public void initialize() {

        try {
            citiesMap = JSONConverter.getCitiesMapFromJSON(WeatherAppConst.PATH_OF_CITIES_LIST_FILE);

            final Integer initialUserCityId = CitiesCollection.getCityId(WeatherAppConst.INITIAL_USER_CITY, citiesMap);
            final Integer initialTravelCityId = CitiesCollection.getCityId(WeatherAppConst.INITIAL_TRAVEL_CITY, citiesMap);

            setCurrentWeatherControls();
            initializeForecastData(initialUserCityId, initialTravelCityId);
            setAutoCompleteTextFields();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            showErrorMessage();
        }
    }

    private void showErrorMessage() {

        Label label = new Label("Przepraszamy, serwis chwilowo nieczynny. Proszę spróbować później.");
        label.getStyleClass().addAll("text-black", "text-20");
        mainGridPane.getChildren().clear();
        mainGridPane.getChildren().add(label);
    }

    private void setCurrentWeatherControls() {

        userCityCurrentWeatherControls = new CurrentWeatherControls(userContentVbox, userCurrentDateLabel,
                userCityName, userCitySunriseTime,
                userCitySunsetTime, userCityWeatherDescription, userCityWeatherIcon, userCityMainTempreture,
                userCityWindSpeed, userCityHumidity, userCityPressure);

        travelCityCurrentWeatherControls = new CurrentWeatherControls(travelContentVbox, travelCurrentDateLabel,
                travelCityName, travelCitySunriseTime, travelCitySunsetTime, travelCityWeatherDescription, travelCityWeatherIcon, travelCityMainTempreture,
                travelCityWindSpeed, travelCityHumidity, travelCityPressure);
    }

    private void initializeForecastData(Integer userCityId, Integer travelCityId) throws APIException {

        setControlsOfWeatherForecastForUserCity(userCityId);
        setControlsOfWeatherForecastForTravelCity(travelCityId);
    }

    private void setControlsOfWeatherForecastForUserCity(Integer cityId) throws APIException {

       WeatherForecastControls controls = new WeatherForecastControls(userCityCurrentWeatherControls, userChartVbox,
               userWarningLabel, userScrollPane);
       controls.setControlsOfWeatherForecastForCity(cityId);
    }

    private void setControlsOfWeatherForecastForTravelCity(Integer cityId) throws APIException {

        WeatherForecastControls controls = new WeatherForecastControls(travelCityCurrentWeatherControls, travelChartVbox,
                travelWarningLabel, travelScrollPane);
        controls.setControlsOfWeatherForecastForCity(cityId);
    }

    private void setAutoCompleteTextFields() {

        CustomTextField.setAutoCompleteTextField(userTextFieldSearch, citiesMap);
        CustomTextField.setAutoCompleteTextField(travelTextFieldSearch, citiesMap);
    }

    @FXML
    private void changeUserCity() {
        try {
            String city = userTextFieldSearch.getText();
            setControlsOfWeatherForecastForUserCity(CitiesCollection.getCityId(city, citiesMap));
        } catch (APIException | InvalidCityNameException e) {
            userWarningLabel.setText("Wybierz miejscowość z listy!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            showErrorMessage();
        }
    }

    @FXML
    private void changeTravelCity() {

        try {
            String city = travelTextFieldSearch.getText();
            setControlsOfWeatherForecastForTravelCity(CitiesCollection.getCityId(city, citiesMap));
        } catch (APIException | InvalidCityNameException e) {
           travelWarningLabel.setText("Wybierz miejscowość z listy!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            showErrorMessage();
        }
    }
}
