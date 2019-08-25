package main.weatherapp.model.forecast;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.beans.binding.ObjectExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import java.util.*;

import static main.weatherapp.model.constant.WeatherAppConst.UNIT_OF_Y_AXIS;


public class WeatherChart {

    private LineChart<String, Number> lineChart;
    private NumberAxis numberAxis;
    private CategoryAxis categoryAxis;

    public WeatherChart(LineChart<String, Number> lineChart, NumberAxis numberAxis, CategoryAxis categoryAxis) {

        this.lineChart = lineChart;
        this.numberAxis = numberAxis;
        this.categoryAxis = categoryAxis;
    }

    public void setChart(List<LinechartData> list) {

        lineChart.getData().addAll(new XYChart.Series<>(createTempretureData(list)), new XYChart.Series<>(createDataIcon(list)));
        lineChart.setMinHeight(200);
        lineChart.setLegendVisible(false);
        lineChart.getStyleClass().add("bg-chart");

        categoryAxis.setAutoRanging(true);
        categoryAxis.setTickLabelsVisible(true);
        categoryAxis.setTickMarkVisible(true);

        numberAxis.setAutoRanging(false);
        numberAxis.setUpperBound(getUpperBoundOfChart(list) + 10);
        numberAxis.setLowerBound(getLowerBoundOfChart(list) - 10);
    }

    private ObservableList<XYChart.Data<String, Number>> createTempretureData(List<LinechartData> linechartDataList) {

        var list = FXCollections.<XYChart.Data<String, Number>>observableArrayList();
        for (LinechartData linechartData : linechartDataList) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(linechartData.getHour(), linechartData.getTempreture());

            data.setNode(createDataNode(data.YValueProperty()));
            list.add(data);
        }
        return list;
    }

    private static Node createDataNode(ObjectExpression<Number> value) {

        Label label = new Label();
        label.getStyleClass().add("text-black");
        label.textProperty().bind(value.asString());

        Pane pane = new Pane(label);
        pane.setShape(new Circle(6.0));
        pane.setScaleShape(false);

        label.translateYProperty().bind(label.heightProperty().divide(-1.5));

        return pane;
    }

    private ObservableList<XYChart.Data<String, Number>> createDataIcon(List<LinechartData> linechartDataList) {

        var list = FXCollections.<XYChart.Data<String, Number>>observableArrayList();
        double valueOfYAxis = getLowerBoundOfChart(linechartDataList) - 5;
        for (LinechartData linechartData : linechartDataList) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(linechartData.getHour(), valueOfYAxis);

            data.setNode(createIconNode(linechartData.getIconCode()));
            list.add(data);
        }
        return list;
    }

    private static Node createIconNode(String iconCode) {

        VBox vbox = new VBox(10);
        WeatherForecastData weatherForecastData = new WeatherForecastData();
        WeatherIconView view = new WeatherIconView();
        view.setGlyphName(weatherForecastData.getWeatherGlyphName(iconCode));
        view.setGlyphSize(16);

        Text text = view;
        vbox.getChildren().add(text);

        return vbox;
    }

    private Integer getUpperBoundOfChart(List<LinechartData> list) {

        List<Integer> tempretureList = getTempretureList(list);
        int max = Collections.max(tempretureList) / UNIT_OF_Y_AXIS;

        return max * UNIT_OF_Y_AXIS;
    }

    private List<Integer> getTempretureList(List<LinechartData> list) {

        List<Integer> tempretureList = new ArrayList<>();
        for (LinechartData linechartData : list) {

            tempretureList.add(linechartData.getTempreture());
        }

        return tempretureList;
    }

    private Integer getLowerBoundOfChart(List<LinechartData> list) {

        List<Integer> tempretureList = getTempretureList(list);
        int min = Collections.min(tempretureList) / UNIT_OF_Y_AXIS;

        return min * UNIT_OF_Y_AXIS;
    }
}
