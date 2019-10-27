package it.katarzynakrolikowska.weatherapp.model.formatter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class DataFormatterTest {

    @ParameterizedTest
    @ValueSource(strings = {"anna", "ANNA", "aNNA", "Anna", "a"})
    void shouldBeAbleToGetWordWithUppercaseFirstLetter(String word) {

        //when
        String resultWord = DataFormatter.getWordUppercaseFirstLetter(word);

        //then
        assertThat(resultWord.charAt(0), is('A'));
    }

    @Test
    void shouldBeAbleToThrowExceptionIfWordToUppercaseFirstLetterIsEmpty() {

        //given
        String word = "";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> DataFormatter.getWordUppercaseFirstLetter(word));
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.49, 10.50, 10.01, 10.00})
    void shouldBeAbleToGetRoundedDownToInteger(double number) {

        //when
        int resultNumber = DataFormatter.getRoundedNumberToInteger(number);

        //then
        assertThat(resultNumber, equalTo(10));
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.51, 10.99})
    void shouldBeAbleToGetRoundedUpToInteger(double number) {

        //when
        int resultNumber = DataFormatter.getRoundedNumberToInteger(number);

        //then
        assertThat(resultNumber, equalTo(11));
    }

    @Test
    void shouldBeAbleToConvertMetersPerSecToKmPerHour() {

        //given
        double metersPerSec = 25.2562;

        //when
        double result = DataFormatter.getKmPerHour(metersPerSec);

        //then
        assertThat(result, equalTo(90.92));
    }

    @Test
    void shouldBeAbleToThrowExceptionIfMetersPerSecValueIsLessThanZero() {

        //given
        double metersPerSec = -2;

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> DataFormatter.getKmPerHour(metersPerSec));
    }

    @ParameterizedTest
    @ValueSource(strings = {"qwert", "q"})
    void shouldBeAbleToGetStringWithoutLastChar(String str) {

        //when
        String resultStr = DataFormatter.getStrWithoutLastChar(str);

        //then
        assertThat(resultStr.length(), equalTo(str.length() - 1));
    }

    @Test
    void shouldBeAbleToThrowExceptionIfStrToSubstringIsEmpty() {

        //given
        String str = "";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> DataFormatter.getStrWithoutLastChar(str));
    }

}