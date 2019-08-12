package weatherapp.model;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;

import java.util.*;

public class FiveDaysForecastData extends ForecastData{

    private String city;
    private HourlyWeatherForecast hourlyWeatherForecast;
    private List<ChartData> list;

    public FiveDaysForecastData(String city) throws APIException {

        this.city = city;

        OWMApp owmApp = new OWMApp("c97170a4281250525e54004602df728e");
        hourlyWeatherForecast = owmApp.getHourlyWeatherForecast(city);
        list = new ArrayList<>();

    }

    public void setFiveDaysForecast(VBox weatherDataVbox) {

        byte index = 1;
        String forecastDate = "";

        for (WeatherData data: hourlyWeatherForecast.getDataList()) {

            Date date = data.getDateTime();

//            forecastDate += MyDate.getDayName(date) + " ";

            String dayName = MyDate.getDayName(date);
            String hour = MyDate.getHourMinute(data.getDateTime()) + "\n" + dayName;
            int temp = DataFormatter.getRoundedNumber(data.getMainData().getTemp());
            String iconCode = data.getWeatherList().get(0).getIconCode();

            ChartData chartData = new ChartData(hour, temp, iconCode);
            list.add(chartData);

            if (index % 8 == 0) {
                setWeatherChart(forecastDate, weatherDataVbox);
                list.clear();
                forecastDate = "";
            }
            index ++;
        }
    }

    private void setWeatherChart(String forecastDate, VBox weatherDataVbox) {

        Label label = new Label(forecastDate);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

        WeatherChart weatherChart = new WeatherChart(lineChart, yAxis, xAxis);
        weatherChart.setChart(list);

        weatherDataVbox.getChildren().addAll(label, lineChart);
    }

}
