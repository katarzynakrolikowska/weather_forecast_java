package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.mock.MockRepository;
import it.katarzynakrolikowska.weatherapp.model.owm.OWMRepository;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class FiveDaysForecastControlsTest extends TestHeadlessMode {

    private VBox vBox;
    private Label label;
    private ScrollPane scrollPane;
    private FiveDaysForecastControls fiveDaysForecastControls;
    private OWMRepository owmRepository;

    @BeforeEach
    void setUp() {

        vBox = new VBox();
        label = new Label();
        scrollPane = new ScrollPane();
        fiveDaysForecastControls = new FiveDaysForecastControls(vBox, label, scrollPane);
        owmRepository = mock(OWMRepository.class);
    }

    @Test
    void shouldBeAbleToThrowExceptionIfCurrentWeatherIsNotAvailable() throws APIException {

        //given
        given(owmRepository.getHourlyWeatherForecast(10)).willThrow(APIException.class);

        //when
        //then
        assertThrows(APIException.class, () -> fiveDaysForecastControls.setControlsOfFiveDaysForecastForCity(owmRepository, 10));
    }

    @Test
    void warningLabelShouldBeRemovedAfterSettingForecastWeather() throws APIException {

        //given
        given(owmRepository.getHourlyWeatherForecast(10)).willReturn(MockRepository.getHourlyWeatherForecast());

        //when
        fiveDaysForecastControls.setControlsOfFiveDaysForecastForCity(owmRepository, 10);

        //then
        assertThat(label.getText(), equalTo(""));
    }

    @Test
    void scrollPaneShouldBeMovedAtBeginningdAfterSettingForecastWeather() throws APIException {

        //given
        given(owmRepository.getHourlyWeatherForecast(10)).willReturn(MockRepository.getHourlyWeatherForecast());

        //when
        fiveDaysForecastControls.setControlsOfFiveDaysForecastForCity(owmRepository, 10);

        //then
        assertThat(scrollPane.getVvalue(), equalTo(0.0));
    }
}