package it.katarzynakrolikowska.weatherapp.model.forecast;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import it.katarzynakrolikowska.weatherapp.model.owm.OWMService;
import it.katarzynakrolikowska.weatherapp.settings.SystemProperties;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CurrentWeatherControlsTest {

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

    @BeforeAll
    public static void setUpProperties() throws Exception {
        SystemProperties.setUpHeadlessProperties();
    }

    @BeforeEach
    void setUp() {
        contentVbox = new VBox();
        dateLabel = new Label();
        cityNameLabel = new Label();
        citySunriseTimeLabel = new Label();
        citySunsetTimeLabel = new Label();
        cityWeatherDescriptionLabel = new Label();
        cityWeatherIcon = new WeatherIconView();
        cityMainTempretureLabel = new Label();
        cityWindSpeedLabel = new Label();
        cityHumidityLabel = new Label();
        cityPressureLabel = new Label();
    }

    @Test
    void shouldBeAbleToThrowExceptionIfCurrentWeatherIsNotAvailable() throws APIException {

        //given
        CurrentWeatherControls currentWeatherControls = new CurrentWeatherControls(contentVbox, dateLabel, cityNameLabel, citySunriseTimeLabel,
                citySunsetTimeLabel, cityWeatherDescriptionLabel, cityWeatherIcon, cityMainTempretureLabel, cityWindSpeedLabel,
                cityHumidityLabel, cityPressureLabel);
        OWMService owmService = mock(OWMService.class);
        given(owmService.getCurrentWeather(10)).willThrow(APIException.class);

        //when
        //then
        assertThrows(APIException.class, () -> currentWeatherControls.setControlsOfCurrentWeatherForCity(10));
    }

}