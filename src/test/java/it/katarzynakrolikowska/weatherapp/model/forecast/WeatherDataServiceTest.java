package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.mock.MockRepository;
import net.aksingh.owmjapis.model.param.WeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class WeatherDataServiceTest {

    private WeatherData weatherData;
    private TimeZone timeZone;
    private WeatherDataService weatherDataService;

    @BeforeEach
    void setUp() {

        weatherData = MockRepository.getWeatherData();
        timeZone = TimeZone.getDefault();
        weatherDataService = new WeatherDataService(weatherData, timeZone);
    }

    @Test
    void shouldBeAbleToGetTime() {

        //when
        String result = weatherDataService.getTime();

        //then
        assertThat(result, equalTo("01:00\nczw."));
    }

    @Test
    void shouldBeAbleToGetMainTempreture() {

        //when
        Integer result = weatherDataService.getMainTempreture();

        //then
        assertThat(result, equalTo(30));
    }

    @Test
    void shouldBeAbleToGetIconCode() {

        //when
        String result = weatherDataService.getIconCode();

        //then
        assertThat(result, equalTo("01d"));
    }

    @Test
    void shouldBeAbleToGetDayName() {

        //when
        String result = weatherDataService.getDayName();

        //then
        assertThat(result, equalTo("czwartek"));
    }
}