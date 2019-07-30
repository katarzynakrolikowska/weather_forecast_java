package weatherapp;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import weatherapp.model.WeatherChart;

public class Controller {

    @FXML
    private CategoryAxis timeAxis01;
    @FXML
    private NumberAxis tempretureAxis01;
    @FXML
    private LineChart<String, Number> lineChart01;
    @FXML
    private Label chartDate01;

    @FXML
    private CategoryAxis timeAxis02;
    @FXML
    private NumberAxis tempretureAxis02;
    @FXML
    private LineChart<String, Number> lineChart02;
    @FXML
    private Label chartDate02;

    @FXML
    private CategoryAxis timeAxis03;
    @FXML
    private NumberAxis tempretureAxis03;
    @FXML
    private LineChart<String, Number> lineChart03;
    @FXML
    private Label chartDate03;

    @FXML
    private CategoryAxis timeAxis04;
    @FXML
    private NumberAxis tempretureAxis04;
    @FXML
    private LineChart<String, Number> lineChart04;
    @FXML
    private Label chartDate04;

    @FXML
    private CategoryAxis timeAxis05;
    @FXML
    private NumberAxis tempretureAxis05;
    @FXML
    private LineChart<String, Number> lineChart05;
    @FXML
    private Label chartDate05;


    @FXML
    private CategoryAxis timeAxis11;
    @FXML
    private NumberAxis tempretureAxis11;
    @FXML
    private LineChart<String, Number> lineChart11;
    @FXML
    private Label chartDate11;

    @FXML
    private CategoryAxis timeAxis12;
    @FXML
    private NumberAxis tempretureAxis12;
    @FXML
    private LineChart<String, Number> lineChart12;
    @FXML
    private Label chartDate12;

    @FXML
    private CategoryAxis timeAxis13;
    @FXML
    private NumberAxis tempretureAxis13;
    @FXML
    private LineChart<String, Number> lineChart13;
    @FXML
    private Label chartDate13;

    @FXML
    private CategoryAxis timeAxis14;
    @FXML
    private NumberAxis tempretureAxis14;
    @FXML
    private LineChart<String, Number> lineChart14;
    @FXML
    private Label chartDate14;

    @FXML
    private CategoryAxis timeAxis15;
    @FXML
    private NumberAxis tempretureAxis15;
    @FXML
    private LineChart<String, Number> lineChart15;
    @FXML
    private Label chartDate15;


    @FXML
    public void initialize() {

        WeatherChart weatherChart01 = new WeatherChart(lineChart01, tempretureAxis01, timeAxis01, chartDate01);
        WeatherChart weatherChart02 = new WeatherChart(lineChart02, tempretureAxis02, timeAxis02, chartDate02);
        WeatherChart weatherChart03 = new WeatherChart(lineChart03, tempretureAxis03, timeAxis03, chartDate03);
        WeatherChart weatherChart04 = new WeatherChart(lineChart04, tempretureAxis04, timeAxis04, chartDate04);
        WeatherChart weatherChart05 = new WeatherChart(lineChart05, tempretureAxis05, timeAxis05, chartDate05);

        weatherChart01.setInitialChart();
        weatherChart02.setInitialChart();
        weatherChart03.setInitialChart();
        weatherChart04.setInitialChart();
        weatherChart05.setInitialChart();

        WeatherChart weatherChart11 = new WeatherChart(lineChart11, tempretureAxis11, timeAxis11, chartDate11);
        WeatherChart weatherChart12 = new WeatherChart(lineChart12, tempretureAxis12, timeAxis12, chartDate12);
        WeatherChart weatherChart13 = new WeatherChart(lineChart13, tempretureAxis13, timeAxis13, chartDate13);
        WeatherChart weatherChart14 = new WeatherChart(lineChart14, tempretureAxis14, timeAxis14, chartDate14);
        WeatherChart weatherChart15 = new WeatherChart(lineChart15, tempretureAxis15, timeAxis15, chartDate15);

        weatherChart11.setInitialChart();
        weatherChart12.setInitialChart();
        weatherChart13.setInitialChart();
        weatherChart14.setInitialChart();
        weatherChart15.setInitialChart();

    }


}
