package weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            Parent grid = FXMLLoader.load(getClass().getResource("sample.fxml"));

            primaryStage.setTitle("weatherForTravel");
            Scene scene = new Scene(grid, 900, 575);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
//            for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
//                System.out.println(ste);
//            }
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
