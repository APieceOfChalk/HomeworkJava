import org.json.JSONException;
import org.json.JSONObject;

public class Weatherstack extends WeatherTest{
    Weatherstack(String city) throws JSONException {
        getCity(city);
    }

    public void getCity(String city) throws JSONException {

        if (!city.equals("")) {
            String output = getUrlContent("http://api.weatherstack.com/current?access_key=c0a19c68fac6cd7a4ed703ea2427ff3f&query=" + city);

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                int temp = obj.getJSONObject("current").getInt("temperature");
                int feels_like = obj.getJSONObject("current").getInt("feelslike");
                int humidity = obj.getJSONObject("current").getInt("humidity");
                double pressure = obj.getJSONObject("current").getDouble("pressure") / 1.333;
                printMessage(city, temp, feels_like, humidity, pressure);
            }
        }
    }
}
