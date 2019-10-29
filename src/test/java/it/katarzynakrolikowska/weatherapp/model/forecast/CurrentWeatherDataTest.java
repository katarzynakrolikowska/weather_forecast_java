package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.mock.MockRepository;
import it.katarzynakrolikowska.weatherapp.model.owm.OWMRepository;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CurrentWeatherDataTest {

    private CurrentWeather currentWeather;
    private OWMRepository owmRepository;
    private CurrentWeatherData currentWeatherData;

    @BeforeEach
    void setUp() throws APIException {

        //given
        currentWeather = MockRepository.getCurrentWeather();
        owmRepository = mock(OWMRepository.class);
        given(owmRepository.getCurrentWeather(10)).willReturn(currentWeather);
        currentWeatherData = new CurrentWeatherData(owmRepository, 10);
    }

    @Test
    void shouldBeAbleToGetBackgroundCSSClass() throws APIException {

        //when
        String resultClass = currentWeatherData.getBackgroundCSSClass();

        //then
        assertThat(resultClass, equalTo("bg-sunny"));
    }

    @Test
    void shouldBeAbleToGetCurrentWeatherDate() {

        //when
        String resultDate = currentWeatherData.getDate();

        //then
        assertThat(resultDate, equalTo("środa, 12 czerwca 2019"));
    }

    @Test
    void shouldBeAbleToGetTimeOffsetOfCheckedCity() {

        //when
        String resultTimeOffset = currentWeatherData.getStrTimeOffset();

        //then
        assertThat(resultTimeOffset, equalTo(" (UTC +09:00)"));
    }

    @Test
    void shouldBeAbleToGetCityName() {

        //when
        String result = currentWeatherData.getCityName();

        //then
        assertThat(result, equalTo("Mountain Vieew"));
    }

    @Test
    void shouldBeAbleToGetSunriseTime() {

        //when
        String resultSunriseTime = currentWeatherData.getSunriseTime();

        //then
        assertThat(resultSunriseTime, equalTo("21:47"));
    }

    @Test
    void shouldBeAbleToGetSunsetTime() {

        //when
        String resultSunsetTime = currentWeatherData.getSunsetTime();

        //then
        assertThat(resultSunsetTime, equalTo("12:29"));
    }

    @Test
    void shouldBeAbleToGetWeatherDataDescription() {

        //when
        String result = currentWeatherData.getWeatherDescription();

        //then
        assertThat(result, equalTo("Clear sky"));
    }

    @Test
    void shouldBeAbleToGetWeatherGlyphName() {

        //when
        String result = currentWeatherData.getCurrentWeatherGlyphName();

        //then
        assertThat(result, equalTo("DAY_SUNNY"));
    }

    @Test
    void shouldBeAbleToGeMainTempreture() {

        //when
        String result = currentWeatherData.getMainTempreture();

        //then
        assertThat(result, equalTo("30°C"));
    }

    @Test
    void shouldBeAbleToGeWindSpeed() {

        //when
        String result = currentWeatherData.getWindSpeed();

        //then
        assertThat(result, equalTo("5.4 km/h"));
    }

    @Test
    void shouldBeAbleToGetHumidity() {

        //when
        String result = currentWeatherData.getHumidity();

        //then
        assertThat(result, equalTo("53%"));
    }

    @Test
    void shouldBeAbleToGePressure() {

        //when
        String result = currentWeatherData.getPressure();

        //then
        assertThat(result, equalTo("1013 hPa"));
    }
}