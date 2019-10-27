package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.settings.SystemProperties;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeatherChartTest {

    private CategoryAxis categoryAxis;
    private NumberAxis numberAxis;
    private LineChart<String, Number> lineChart;
    private WeatherChart weatherChart;


    @BeforeAll
    public static void setUpProperties() throws Exception {
        SystemProperties.setUpHeadlessProperties();
    }

    @BeforeEach
    void setUp() {

        //given
        categoryAxis = new CategoryAxis();
        numberAxis = new NumberAxis();
        lineChart = new LineChart<>(categoryAxis, numberAxis);
        weatherChart = new WeatherChart(lineChart, numberAxis, categoryAxis);

        //when
        weatherChart.setChart(getLinechartDataList());
    }

    private List<LinechartData> getLinechartDataList() {

        LinechartData data1 = new LinechartData("00:00", -8, "03n");
        LinechartData data2 = new LinechartData("10:00", 19, "03d");

        return Arrays.asList(data1, data2);
    }

    @Test
    void numberAxisShouldBeSet() {

        //then
        assertFalse(numberAxis.isAutoRanging());
        assertThat(numberAxis.getLowerBound(), equalTo(-15.0));
        assertThat(numberAxis.getUpperBound(), equalTo(25.0));
    }

    @Test
    void categoryAxisShouldBeSet() {

        //then
        assertTrue(categoryAxis.isAutoRanging());
        assertTrue(categoryAxis.isTickMarkVisible());
        assertTrue(categoryAxis.isTickLabelsVisible());
    }

    @Test
    void linechartShouldBeSet() {

        //then
        assertThat(lineChart.getXAxis(), equalTo(categoryAxis));
        assertThat(lineChart.getYAxis(), equalTo(numberAxis));
    }
}