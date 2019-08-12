package weatherapp.model;

import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

import java.util.Date;

public class CurrentForecastData extends ForecastData {

    private String city;
    private CurrentWeather currentWeather;

    public CurrentForecastData(String city) throws APIException {

        this.city = city;

        OWMApp owmApp = new OWMApp("c97170a4281250525e54004602df728e");
        this.currentWeather = owmApp.getCurrentWeather(city);
    }

    public String getBackgroundClass() {

        switch (getCurrentWeatherIconCode()) {
            case "01d":
                return "bg-orange";
            case "01n":
            case "02n":
            case "03n":
            case "09n":
            case "10n":
            case "13n":
            case "50n":
                return "bg-darkblue";
            case "02d":
                return "bg-lightgray";
            case "03d":
            case "04d":
            case "04n":
                return "bg-cloudy";
            case "09d":
            case "10d":
            default:
                return "bg-lightblue";
            case "11d":
            case "11n":
                return "bg-purple";
            case "13d":
                return "bg-snow";
            case "50d":
                return "bg-mist";
        }
    }

    public String getCityName() {

        return currentWeather.getCityName();
    }

    public String getSunriseTime() {

        Date date = currentWeather.getSystemData().getSunriseDateTime();

        return MyDate.getHourMinute(date);
    }

    public String getSunsetTime() {

        Date date = currentWeather.getSystemData().getSunsetDateTime();

        return MyDate.getHourMinute(date);
    }

    public String getWeatherDescription() {

        String desc = currentWeather.getWeatherList().get(0).getMoreInfo();
        return DataFormatter.getUppercaseFirstLetter(desc);
    }

    public String getCurrentWeatherGlyphName() {

        return getWeatherGlyphName(getCurrentWeatherIconCode());
    }

    private String getCurrentWeatherIconCode() {

        return currentWeather.getWeatherList().get(0).getIconCode();
    }

    public String getMainTempreture() {

        double temp = currentWeather.getMainData().getTemp();

        return DataFormatter.getRoundedNumber(temp) + "°C";
    }

    public String getWindSpeed() {

        double wind = currentWeather.getWindData().getSpeed();

        return DataFormatter.getKmPerHour(wind) + " km/h";
    }

    public String getHumidity() {

        double humidity = currentWeather.getMainData().getHumidity();

        return DataFormatter.getRoundedNumber(humidity) + "%";
    }

    public String getPressure() {

        double pressure = currentWeather.getMainData().getPressure();

        return DataFormatter.getRoundedNumber(pressure) + " hPa";
    }
}
