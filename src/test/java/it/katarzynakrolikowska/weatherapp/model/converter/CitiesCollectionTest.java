package it.katarzynakrolikowska.weatherapp.model.converter;

import it.katarzynakrolikowska.weatherapp.model.exception.InvalidCityNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class CitiesCollectionTest {

    private Map<String, Integer> citiesMap;

    @BeforeEach
    void setUp() {

        citiesMap = new TreeMap<>();
        citiesMap.put("Warszawa,Polska", 1);
    }

    @Test
    void shouldBeAbleToThrowExceptionIfCityNameIsValid() {

        //when
        //then
        assertThrows(InvalidCityNameException.class, () -> CitiesCollection.getCityId("Krakow,Polska", citiesMap));
    }

    @Test
    void shoulBeAbleToReturnCityIdIfCityNameIsValid() throws InvalidCityNameException {

        //when
        Integer cityId = CitiesCollection.getCityId("Warszawa,Polska", citiesMap);

        //then
        assertThat(cityId, equalTo(1));
    }
}