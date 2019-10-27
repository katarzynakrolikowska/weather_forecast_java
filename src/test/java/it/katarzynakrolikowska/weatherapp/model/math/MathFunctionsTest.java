package it.katarzynakrolikowska.weatherapp.model.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathFunctionsTest {

    @ParameterizedTest
    @CsvSource({"20.0, 20.0, 20.0"})
    void shouldBeAbleToReturnTrueIfGivenValueIsBetweenMinAndMax(double value, double min, double max) {

        //given
        //when
        boolean result = MathFunctions.isBetween(value, min, max);

        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"19.0, 20.0, 20.0"})
    void shouldBeAbleToReturnFalseIfGivenValueIsNotBetweenMinAndMax(double value, double min, double max) {

        //given
        //when
        boolean result = MathFunctions.isBetween(value, min, max);

        //then
        assertFalse(result);
    }

}