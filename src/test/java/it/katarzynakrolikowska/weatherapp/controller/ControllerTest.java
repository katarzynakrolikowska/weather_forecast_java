package it.katarzynakrolikowska.weatherapp.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

class ControllerTest extends ApplicationTest {

    private TextField searchFieldUser;
    private  TextField searchFieldTravel;

    @Override
    public void start( Stage primaryStage) {
        try {
            Parent grid = FXMLLoader.load(getClass().getResource("/mainView.fxml"));

            primaryStage.setTitle("DoubleWeatherApp");
            Image icon = new Image(getClass().getResourceAsStream("/icon/circle_cloud.png"));
            primaryStage.getIcons().add(icon);
            Scene scene = new Scene(grid, 900, 575);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    @BeforeEach
    void cleanUpTextFields() {

        searchFieldUser = lookup("#userTextFieldSearch").query();
        searchFieldTravel = lookup("#travelTextFieldSearch").query();
        searchFieldUser.clear();
        searchFieldTravel.clear();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Kraków,PL"})
    void shouldBeAbleToShowErrorMessageForUserCityIfCityNameIsEmpty(String cityName) {

        //given
        Button button = lookup("#userContentVbox").lookup(".button").query();

        //when
        searchFieldUser.setText(cityName);
        clickOn(button);

        //then
        verifyThat("#userWarningLabel", hasText("Wybierz miejscowość z listy!"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Kraków,PL"})
    void shouldBeAbleToShowErrorMessageForTravelCityIfCityNameIsEmpty(String cityName) {

        //given
        Button button = lookup("#travelContentVbox").lookup(".button").query();

        //when
        searchFieldTravel.setText(cityName);
        clickOn(button);

        //then
        verifyThat("#travelWarningLabel", hasText("Wybierz miejscowość z listy!"));
    }
}