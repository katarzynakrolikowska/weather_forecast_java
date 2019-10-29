package it.katarzynakrolikowska.weatherapp.model.forecast;

import org.junit.jupiter.api.BeforeAll;

import static org.testfx.api.FxToolkit.registerPrimaryStage;

public class TestHeadlessMode {

    private static boolean isHeadless = false;

    @BeforeAll
    public static void setUpHeadlessMode() throws Exception {

        if (isHeadless) {
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
            System.setProperty("java.awt.headless", "true");
        }
        registerPrimaryStage();
    }
}
