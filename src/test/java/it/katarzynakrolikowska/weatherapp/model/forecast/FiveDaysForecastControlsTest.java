package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.model.owm.OWMService;
import it.katarzynakrolikowska.weatherapp.settings.SystemProperties;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class FiveDaysForecastControlsTest {

    @BeforeAll
    public static void setUpProperties() throws Exception {
        SystemProperties.setUpHeadlessProperties();
    }

    @Test
    void shouldBeAbleToThrowExceptionIfCurrentWeatherIsNotAvailable() throws APIException {

        //given
        FiveDaysForecastControls fiveDaysForecastControls = new FiveDaysForecastControls(new VBox(), new Label(), new ScrollPane());
        OWMService owmService = mock(OWMService.class);
        given(owmService.getHourlyWeatherForecast(10)).willThrow(APIException.class);

        //when
        //then
        assertThrows(APIException.class, () -> fiveDaysForecastControls.setControlsOfFiveDaysForecastForCity(10));
    }

}