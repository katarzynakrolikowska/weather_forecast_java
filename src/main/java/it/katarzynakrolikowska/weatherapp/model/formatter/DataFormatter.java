package it.katarzynakrolikowska.weatherapp.model.formatter;

public class DataFormatter {

    public static String getWordUppercaseFirstLetter(String word) {

        if (!word.isEmpty()) {
            char firstLetter = word.toUpperCase().charAt(0);
            String otherLetters = word.substring(1).toLowerCase();

            return firstLetter + otherLetters;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Integer getRoundedNumberToInteger(double number) {

        return (int) Math.rint(number);
    }

    public static double getKmPerHour(double metersPerSec) {

        if (metersPerSec >= 0) {
            return getRoundTwoDecimalPlaces(metersPerSec * 3.6);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static double getRoundTwoDecimalPlaces(double number) {

        return Math.round(number * 100.0) / 100.0;
    }

    public static String getStrWithoutLastChar(String str) {

        if (str.length() > 0) {
            return str.substring(0, str.length() - 1);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
