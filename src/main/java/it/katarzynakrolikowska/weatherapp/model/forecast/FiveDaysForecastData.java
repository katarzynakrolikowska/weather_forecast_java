package it.katarzynakrolikowska.weatherapp.model.forecast;

import it.katarzynakrolikowska.weatherapp.model.formatter.*;
import it.katarzynakrolikowska.weatherapp.model.time.CityTimeZone;
import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static it.katarzynakrolikowska.weatherapp.model.constant.WeatherAppConst.WEATHER_DATA_PER_DAY;


public class FiveDaysForecastData extends WeatherForecastData {

    private HourlyWeatherForecast hourlyWeatherForecast;
    private List<LinechartData> listOfLinechartData;

    public FiveDaysForecastData(HourlyWeatherForecast hourlyWeatherForecast) {

        this.hourlyWeatherForecast = hourlyWeatherForecast;
        listOfLinechartData = new ArrayList<>();
    }

    public void setFiveDaysForecast(VBox weatherChartVbox) {

        weatherChartVbox.getChildren().clear();

        String chartTitle = "";
        String previousDayName = "";
        byte index = 1;

        for (WeatherData data: hourlyWeatherForecast.getDataList()) {

            WeatherDataService weatherDataService = new WeatherDataService(data, getTimeZoneOfTheCity());
            String time = weatherDataService.getTime();
            int tempreture = weatherDataService.getMainTempreture();
            String iconCode = weatherDataService.getIconCode();
            String dayName = weatherDataService.getDayName();

            if (!dayName.equals(previousDayName)) {
                chartTitle += DataFormatter.getWordUppercaseFirstLetter(dayName) + "/";
            }

            previousDayName = dayName;

            LinechartData linechartData = new LinechartData(time, tempreture, iconCode);
            listOfLinechartData.add(linechartData);

            if (index % WEATHER_DATA_PER_DAY == 0) {
                buildWeatherChart(weatherChartVbox, DataFormatter.getStrWithoutLastChar(chartTitle));
                chartTitle = "";
                previousDayName = "";
                listOfLinechartData.clear();
            }
            index ++;
        }
    }

    private void buildWeatherChart(VBox weatherDataVbox, String days) {

        Label label = new Label(days);
        label.setPadding(new Insets(30,0,0,0));
        label.getStyleClass().add("text-18");

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

        WeatherChart weatherChart = new WeatherChart(lineChart, yAxis, xAxis);
        weatherChart.setChart(listOfLinechartData);

        weatherDataVbox.getChildren().addAll(label, lineChart);
    }

    private TimeZone getTimeZoneOfTheCity() {

        CityTimeZone cityTimeZone = new CityTimeZone();
        return cityTimeZone.getTimeZoneOfTheCity(getLatitude(), getLongitude());
    }

    private double getLatitude() {

        return hourlyWeatherForecast.getCityData().getCoordData().getLatitude();
    }

    private double getLongitude() {

        return hourlyWeatherForecast.getCityData().getCoordData().getLongitude();
    }


}
