package it.katarzynakrolikowska.weatherapp.model.forecast;

import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import it.katarzynakrolikowska.weatherapp.model.formatter.DataFormatter;
import it.katarzynakrolikowska.weatherapp.model.time.*;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;

import java.util.*;

import static it.katarzynakrolikowska.weatherapp.model.constant.WeatherAppConst.*;


public class FiveDaysForecastData extends WeatherForecastData {

    private HourlyWeatherForecast hourlyWeatherForecast;
    private List<LinechartData> list;

    public FiveDaysForecastData(Integer cityId) throws APIException {

        super();
        hourlyWeatherForecast = owmApp.getHourlyWeatherForecast(cityId);
        list = new ArrayList<>();
    }

    public void setFiveDaysForecast(VBox weatherChartVbox) {

        weatherChartVbox.getChildren().clear();

        String days = "";
        String previousDayName = "";
        byte index = 1;

        for (WeatherData data: hourlyWeatherForecast.getDataList()) {

            String time = getTime(data);
            int tempreture = getMainTempreture(data);
            String iconCode = getIconCode(data);
            String dayName = getDayName(data);

            if (!dayName.equals(previousDayName)) {
                days += DataFormatter.getUppercaseFirstLetter(dayName) + "/";
            }

            previousDayName = dayName;

            LinechartData linechartData = new LinechartData(time, tempreture, iconCode);
            list.add(linechartData);

            if (index % AMOUNT_OF_X_AXIS_POINTS == 0) {
                setWeatherChart(weatherChartVbox, DataFormatter.getStrWithoutLastChar(days));
                days = "";
                previousDayName = "";
                list.clear();
            }
            index ++;
        }
    }

    private String getTime(WeatherData data) {

        Date date = data.getDateTime();
        return MyDate.getHourMinute(data.getDateTime(), getTimeZoneOfTheCity()) + "\n" +  MyDate.getShortDayName(date
                , getTimeZoneOfTheCity());
    }

    private Integer getMainTempreture(WeatherData data) {

        return  DataFormatter.getRoundedNumber(data.getMainData().getTemp());
    }

    private String getIconCode(WeatherData data) {

        return data.getWeatherList().get(0).getIconCode();
    }

    private String getDayName(WeatherData data) {

        Date date = data.getDateTime();
        return MyDate.getDayName(date, getTimeZoneOfTheCity());
    }

    private void setWeatherChart(VBox weatherDataVbox, String days) {

        Label label = new Label(days);
        label.setPadding(new Insets(30,0,0,0));
        label.getStyleClass().add("text-18");

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

        WeatherChart weatherChart = new WeatherChart(lineChart, yAxis, xAxis);
        weatherChart.setChart(list);

        weatherDataVbox.getChildren().addAll(label, lineChart);
    }

    private TimeZone getTimeZoneOfTheCity() {

        return CityTimeZone.getTimeZoneOfTheCity(getLatitude(), getLongitude());
    }

    private double getLatitude() {

        return hourlyWeatherForecast.getCityData().getCoordData().getLatitude();
    }

    private double getLongitude() {

        return hourlyWeatherForecast.getCityData().getCoordData().getLongitude();
    }
}
