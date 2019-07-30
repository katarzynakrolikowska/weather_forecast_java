package weatherapp.model;

import de.jensd.fx.glyphs.weathericons.WeatherIcon;
import de.jensd.fx.glyphs.weathericons.utils.WeatherIconFactory;
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

import java.util.Map;
import java.util.TreeMap;

public class WeatherChart {

    private LineChart<String, Number> lineChart;
    private NumberAxis numberAxis;
    private CategoryAxis categoryAxis;
    private Label chartLabel;

    public WeatherChart(LineChart<String, Number> lineChart, NumberAxis numberAxis, CategoryAxis categoryAxis,
                        Label chartLabel) {

        this.lineChart = lineChart;
        this.numberAxis = numberAxis;
        this.categoryAxis = categoryAxis;
        this.chartLabel = chartLabel;
    }

    public void setInitialChart() {

        chartLabel.setText(MyDate.getStringDate());
        lineChart.getData().addAll(new XYChart.Series<>(createData()), new XYChart.Series<>(createDataIcon()));
        categoryAxis.setAutoRanging(true);
        categoryAxis.setTickLabelsVisible(true);
        categoryAxis.setTickMarkVisible(true);

        numberAxis.setAutoRanging(false);

        numberAxis.setUpperBound(35);
        numberAxis.setLowerBound(0);
    }

    private ObservableList<XYChart.Data<String, Number>> createData() {
        var list = FXCollections.<XYChart.Data<String, Number>>observableArrayList();
        Map<String, Number> maptest = getMapTest();
        for (Map.Entry<String, Number> entry : maptest.entrySet()) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(entry.getKey(), entry.getValue());

            data.setNode(createDataNode(data.YValueProperty()));
            list.add(data);
        }
        return list;
    }

    private static Map<String, Number> getMapTest() {
        Map<String, Number> mapTest = new TreeMap<>();
        mapTest.put("5:00", 11);
        mapTest.put("8:00", 18);
        mapTest.put("11:00", 24);
        mapTest.put("14:00", 28);
        mapTest.put("17:00", 27);
        mapTest.put("20:00", 17);
        mapTest.put("23:00", 13);

        return mapTest;
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

    private ObservableList<XYChart.Data<String, Number>> createDataIcon() {
        var list = FXCollections.<XYChart.Data<String, Number>>observableArrayList();
        Map<String, Number> maptest = getMapTest();
        for (Map.Entry<String, Number> entry : maptest.entrySet()) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(entry.getKey(), 5);

            data.setNode(createDataNodeIcon());
            list.add(data);
        }
        return list;
    }

    private static Node createDataNodeIcon() {

        VBox vbox = new VBox(10);

        Text label2 = WeatherIconFactory.get().createIcon(WeatherIcon.DAY_RAIN, "15");
        vbox.getChildren().add(label2);

        return vbox;
    }
}
