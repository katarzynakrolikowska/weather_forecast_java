package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.mock.MockRepository;
import it.katarzynakrolikowska.weatherapp.model.owm.OWMRepository;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class FiveDaysForecastDataTest extends TestHeadlessMode {

    @Test
    void chartVBoxShouldBeSet() throws APIException {

        //given
        VBox vBox = new VBox();
        HourlyWeatherForecast hourlyWeatherForecast = MockRepository.getHourlyWeatherForecast();
        OWMRepository owmRepository = mock(OWMRepository.class);
        given(owmRepository.getHourlyWeatherForecast(10)).willReturn(hourlyWeatherForecast);
        FiveDaysForecastData fiveDaysForecastData = new FiveDaysForecastData(owmRepository, 10);

        //when
        fiveDaysForecastData.setFiveDaysForecast(vBox);

        //then
        assertThat(vBox.getChildren().size(), equalTo(10));
    }

}