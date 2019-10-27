package it.katarzynakrolikowska.weatherapp.settings;

import static org.testfx.api.FxToolkit.registerPrimaryStage;

public class SystemProperties {

    public static void setUpHeadlessProperties() throws Exception {
        if (Boolean.getBoolean("headless")) {
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
            System.setProperty("java.awt.headless", "true");
        }
        registerPrimaryStage();
    }
}
