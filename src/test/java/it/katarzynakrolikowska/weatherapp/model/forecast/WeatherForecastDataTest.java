package it.katarzynakrolikowska.weatherapp.model.forecast;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class WeatherForecastDataTest {

    @Test
    void shouldBeAbleToGetProperGlyphName() {

        //given
        //when
        //then
        assertAll(
                () -> assertThat(getGlyphName("01n"), equalTo("NIGHT_CLEAR")),
                () -> assertThat(getGlyphName("02d"), equalTo("DAY_CLOUDY")),
                () -> assertThat(getGlyphName("02n"), equalTo("NIGHT_ALT_CLOUDY")),
                () -> assertThat(getGlyphName("03d"), equalTo("CLOUD")),
                () -> assertThat(getGlyphName("03n"), equalTo("CLOUD")),
                () -> assertThat(getGlyphName("04d"), equalTo("CLOUDY")),
                () -> assertThat(getGlyphName("04n"), equalTo("CLOUDY")),
                () -> assertThat(getGlyphName("09d"), equalTo("SHOWERS")),
                () -> assertThat(getGlyphName("09n"), equalTo("SHOWERS")),
                () -> assertThat(getGlyphName("10d"), equalTo("DAY_RAIN")),
                () -> assertThat(getGlyphName("10n"), equalTo("NIGHT_RAIN")),
                () -> assertThat(getGlyphName("11d"), equalTo("THUNDERSTORM")),
                () -> assertThat(getGlyphName("11n"), equalTo("THUNDERSTORM")),
                () -> assertThat(getGlyphName("13d"), equalTo("SNOW")),
                () -> assertThat(getGlyphName("13n"), equalTo("SNOW")),
                () -> assertThat(getGlyphName("50d"), equalTo("FOG")),
                () -> assertThat(getGlyphName("50n"), equalTo("FOG"))
        );

    }

    private String getGlyphName(String iconCode) {

        WeatherForecastData weatherForecastData = new WeatherForecastData();
        return weatherForecastData.getWeatherGlyphName(iconCode);
    }
}