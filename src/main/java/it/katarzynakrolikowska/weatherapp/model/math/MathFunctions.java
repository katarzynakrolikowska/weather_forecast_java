package it.katarzynakrolikowska.weatherapp.model.math;

public class MathFunctions {

    public static boolean isBetween(double value, double minValue, double maxValue) {
        if (value >= minValue && value <= maxValue)
            return true;
        else
            return false;
    }
}
