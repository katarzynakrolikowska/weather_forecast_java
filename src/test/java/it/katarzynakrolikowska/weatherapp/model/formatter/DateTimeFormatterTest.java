package it.katarzynakrolikowska.weatherapp.model.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DateTimeFormatterTest {
    private Date date;
    private TimeZone timeZone;

    @BeforeEach
    void setData() {
        date = new Date();
        date.setTime(60000);
        timeZone = TimeZone.getDefault();
    }

    @Test
    void shouldBeAbleToGetHourMinuteNotation() {

        //when
        String result = DateTimeFormatter.getHourMinute(date, timeZone);

        //then
        assertThat(result, equalTo("01:01"));
    }

    @Test
    void shouldBeAbleToGetDayMonthYearNotation() {

        //when
        String result = DateTimeFormatter.getDayMonthYear(date, timeZone);

        //then
        assertThat(result, equalTo("czwartek, 1 stycznia 1970"));
    }

    @Test
    void shouldBeAbleToGetDayShortNotation() {

        //when
        String result = DateTimeFormatter.getShortDayName(date, timeZone);

        //then
        assertThat(result, equalTo("czw."));
    }

    @Test
    void shouldBeAbleToGetDayNotation() {

        //when
        String result = DateTimeFormatter.getDayName(date, timeZone);

        //then
        assertThat(result, equalTo("czwartek"));
    }

}