package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.mock.MockRepository;
import it.katarzynakrolikowska.weatherapp.settings.SystemProperties;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FiveDaysForecastDataTest {


    @BeforeAll
    public static void setUpProperties() throws Exception {
        SystemProperties.setUpHeadlessProperties();
    }

    @Test
    void ChartVBoxShouldBeSet() {

        //given
        VBox vBox = new VBox();
        HourlyWeatherForecast hourlyWeatherForecast = MockRepository.getHourlyWeatherForecast();
        FiveDaysForecastData fiveDaysForecastData = new FiveDaysForecastData(hourlyWeatherForecast);

        //when
        fiveDaysForecastData.setFiveDaysForecast(vBox);

        //then
        assertThat(vBox.getChildren().size(), equalTo(10));
    }

}