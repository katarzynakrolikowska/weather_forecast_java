module weatherApp {
    requires javafx.fxml;
    requires javafx.controls;
    requires de.jensd.fx.glyphs.fontawesome;
    requires de.jensd.fx.glyphs.weathericons;
    requires org.controlsfx.controls;
    requires owm.japis;
    requires java.sql;

    opens weatherapp;
}