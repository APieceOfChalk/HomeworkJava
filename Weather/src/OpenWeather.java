import org.json.JSONException;
import org.json.JSONObject;

public class OpenWeather extends WeatherTest{
    OpenWeather(String city) throws JSONException {
        getCity(city);
    }

    public void getCity(String city) throws JSONException {

        if (!city.equals("")) {
            String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&lang=ru&appid=dbe834f44441af9fd34921f95b06acbf");

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                double temp = obj.getJSONObject("main").getDouble("temp") - 273.15;
                double feels_like = obj.getJSONObject("main").getDouble("feels_like") - 273.15;
                double pressure = obj.getJSONObject("main").getDouble("pressure") / 1.333;
                int humidity = obj.getJSONObject("main").getInt("humidity");
                printMessage(city, temp, feels_like, humidity, pressure);
            }
        }
    }
}
