package it.katarzynakrolikowska.weatherapp.model.forecast;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import it.katarzynakrolikowska.weatherapp.mock.MockRepository;
import it.katarzynakrolikowska.weatherapp.model.owm.OWMRepository;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CurrentWeatherControlsTest extends TestHeadlessMode {

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
    private CurrentWeatherControls currentWeatherControls;
    private OWMRepository owmRepository;

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
        currentWeatherControls = new CurrentWeatherControls(contentVbox, dateLabel, cityNameLabel, citySunriseTimeLabel,
                citySunsetTimeLabel, cityWeatherDescriptionLabel, cityWeatherIcon, cityMainTempretureLabel, cityWindSpeedLabel,
                cityHumidityLabel, cityPressureLabel);
        owmRepository = mock(OWMRepository.class);
    }

    @Test
    void shouldBeAbleToThrowExceptionIfCurrentWeatherIsNotAvailable() throws APIException {

        //given
        given(owmRepository.getCurrentWeather(10)).willThrow(APIException.class);

        //when
        //then
        assertThrows(APIException.class, () -> currentWeatherControls.setControlsOfCurrentWeatherForCity(owmRepository, 10));
    }

    @Test
    void cityNameLabelShouldBeSet() throws APIException {

        //given
        given(owmRepository.getCurrentWeather(10)).willReturn(MockRepository.getCurrentWeather());

        //when
        currentWeatherControls.setControlsOfCurrentWeatherForCity(owmRepository, 10);
        String result = cityNameLabel.getText();

        //then
        assertThat(result, equalTo("Mountain Vieew"));
    }

}