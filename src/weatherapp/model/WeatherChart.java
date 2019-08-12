package weatherapp.model;

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

public class WeatherChart {

    private LineChart<String, Number> lineChart;
    private NumberAxis numberAxis;
    private CategoryAxis categoryAxis;

    public WeatherChart(LineChart<String, Number> lineChart, NumberAxis numberAxis, CategoryAxis categoryAxis) {

        this.lineChart = lineChart;
        this.numberAxis = numberAxis;
        this.categoryAxis = categoryAxis;

    }

    public void setChart(List<ChartData> list) {

        lineChart.getData().addAll(new XYChart.Series<>(createData(list)), new XYChart.Series<>(createDataIcon(list)));
        lineChart.setMinHeight(180);
        lineChart.setLegendVisible(false);
        lineChart.getStyleClass().add("bg-chart");
        categoryAxis.setAutoRanging(true);
        categoryAxis.setTickLabelsVisible(true);
        categoryAxis.setTickMarkVisible(true);

        numberAxis.setAutoRanging(false);

        numberAxis.setUpperBound(getUpperBoundOfChart(list) + 10);
        numberAxis.setLowerBound(getLowerBoundOfChart(list) - 10);
    }

    private ObservableList<XYChart.Data<String, Number>> createData(List<ChartData> chartDataList) {
        var list = FXCollections.<XYChart.Data<String, Number>>observableArrayList();
        for (ChartData chartData : chartDataList) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(chartData.getHour(), chartData.getTempreture());

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

    private ObservableList<XYChart.Data<String, Number>> createDataIcon(List<ChartData> chartDataList) {
        var list = FXCollections.<XYChart.Data<String, Number>>observableArrayList();
        double valueOfYAxis = getLowerBoundOfChart(chartDataList) - 5;
        for (ChartData chartData : chartDataList) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(chartData.getHour(), valueOfYAxis);

            data.setNode(createDataNodeIcon(chartData.getIconCode()));
            list.add(data);
        }
        return list;
    }

    private static Node createDataNodeIcon(String iconCode) {

        VBox vbox = new VBox(10);
        ForecastData forecastData = new ForecastData();
        WeatherIconView view = new WeatherIconView();
        view.setGlyphName(forecastData.getWeatherGlyphName(iconCode));
        view.setGlyphSize(16);

        Text text = view;
        vbox.getChildren().add(text);

        return vbox;
    }

    private Integer getUpperBoundOfChart(List<ChartData> list) {

        List<Integer> tempretureList = getTempretureList(list);
        int max = Collections.max(tempretureList) / 5;

        return max * 5;
    }

    private List<Integer> getTempretureList(List<ChartData> list) {

        List<Integer> tempretureList = new ArrayList<>();
        for (ChartData chartData : list) {

            tempretureList.add(chartData.getTempreture());
        }

        return tempretureList;
    }

    private Integer getLowerBoundOfChart(List<ChartData> list) {

        List<Integer> tempretureList = getTempretureList(list);
        int min = Collections.min(tempretureList) / 5;

        return min * 5;
    }
}
