package it.katarzynakrolikowska.weatherapp.model.converter;

import it.katarzynakrolikowska.weatherapp.model.constant.WeatherAppConst;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JSONConverterTest {

    JSONConverter jsonConverter;

    @BeforeEach
    void setUp() {
        jsonConverter = new JSONConverter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"file", ""})
    void shouldBeAbleToThrowExceptionIfFileIsNotFound(String source) {

        //when
        //then
        assertThrows(FileNotFoundException.class, () -> jsonConverter.getCitiesMapFromJSON(source));
    }

    @Test
    void shouldBeAbleToThrowExceptionIfFileIsNull() {

        //given
        String source = null;

        //when
        //then
        assertThrows(FileNotFoundException.class, () -> jsonConverter.getCitiesMapFromJSON(source));
    }

    @Test
    void shouldBeAbleToLoadCitiesFromValidFile() throws IOException {

        //given
        Map<String, Integer> cities;

        //when
        cities = jsonConverter.getCitiesMapFromJSON(WeatherAppConst.JSON_FILE_WITH_CITIES);

        //then
        assertThat(cities.size(), equalTo(168820));
    }
}