package main.weatherapp.model.formatter;

public class DataFormatter {

    public static String getUppercaseFirstLetter(String word) {

        char firstLetter = word.toUpperCase().charAt(0);
        String otherLetters = word.substring(1).toLowerCase();

        return firstLetter + otherLetters;
    }

    public static Integer getRoundedNumber(double number) {

        return (int) Math.rint(number);
    }

    public static double getKmPerHour(double metersPerSec) {

        return getRoundTwoDecimalPlaces(metersPerSec * 3.6);
    }

    private static double getRoundTwoDecimalPlaces(double number) {

        return Math.round(number * 100.0) / 100.0;
    }

    public static String getStrWithoutLastChar(String str) {

        return str.substring(0, str.length() - 1);
    }
}
