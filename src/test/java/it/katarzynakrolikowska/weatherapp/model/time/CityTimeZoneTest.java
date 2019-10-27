package it.katarzynakrolikowska.weatherapp.model.time;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CityTimeZoneTest {

    @Test
    void shouldBeAbleToGetTimeZoneOfTheCity() {

        //given
        CityTimeZone cityTimeZone = mock(CityTimeZone.class);
        TimeZone timeZone = TimeZone.getDefault();
        given(cityTimeZone.getTimeZoneOfTheCity(10, 30)).willReturn(timeZone);

        //when
        TimeZone resultTimeZone = cityTimeZone.getTimeZoneOfTheCity(10, 30);

        //then
        assertThat(resultTimeZone, equalTo(timeZone));
    }

    @ParameterizedTest
    @CsvSource({"90, 180", "-90, -180"})
    void shouldBeAbleToGetTimeZoneOfTheCityIfCoordinatesAreValid(double latitude, double longitude) {

        //given
        CityTimeZone cityTimeZone = mock(CityTimeZone.class);
        TimeZone timeZone = TimeZone.getDefault();
        given(cityTimeZone.getTimeZoneOfTheCity(latitude, longitude)).willReturn(timeZone);

        //when
        TimeZone resultTimeZone = cityTimeZone.getTimeZoneOfTheCity(latitude, longitude);

        //then
        assertThat(resultTimeZone, equalTo(timeZone));
    }

    @ParameterizedTest
    @CsvSource({"91, 180", "90, 181"})
    void shouldBeAbleToGetTimeZoneOfTheCityIfCoordinatesAreInValid(double latitude, double longitude) {

        //given
        CityTimeZone cityTimeZone = new CityTimeZone();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> cityTimeZone.getTimeZoneOfTheCity(latitude, longitude));
    }

}