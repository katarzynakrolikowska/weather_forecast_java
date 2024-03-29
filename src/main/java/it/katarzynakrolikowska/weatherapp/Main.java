package it.katarzynakrolikowska.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent grid = FXMLLoader.load(getClass().getResource("/mainView.fxml"));

            primaryStage.setTitle("DoubleWeatherApp");
            Image icon = new Image(getClass().getResourceAsStream("/icon/circle_cloud.png"));
            primaryStage.getIcons().add(icon);
            Scene scene = new Scene(grid, 900, 575);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
