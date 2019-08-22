module weatherApp {
    requires javafx.fxml;
    requires javafx.controls;
    requires de.jensd.fx.glyphs.fontawesome;
    requires de.jensd.fx.glyphs.weathericons;
    requires org.controlsfx.controls;
    requires owm.japis;
    requires java.sql;
    requires gson;
    requires geotimezone;

    exports main.weatherapp.controller to javafx.fxml;
    exports main.weatherapp.model to gson;

    opens main.weatherapp.model;
    opens main.weatherapp.controller;
    opens main.weatherapp;
}