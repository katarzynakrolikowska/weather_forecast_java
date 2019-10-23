package it.katarzynakrolikowska.weatherapp.model.forecast;

public class LinechartData {

    private String hour;
    private Integer tempreture;
    private String iconCode;

    public LinechartData(String hour, Integer tempreture, String iconCode) {
        this.hour = hour;
        this.tempreture = tempreture;
        this.iconCode = iconCode;
    }

    public String getHour() {
        return hour;
    }

    public Integer getTempreture() {
        return tempreture;
    }

    public String getIconCode() {
        return iconCode;
    }


}
