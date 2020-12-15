import org.json.JSONException;
import org.json.JSONObject;

public class WeatherApi extends WeatherTest {
    WeatherApi(String city) throws JSONException {
        getCity(city);
    }

    public void getCity(String city) throws JSONException {

        if (!city.equals("")) {
            String output = getUrlContent("http://api.weatherapi.com/v1/current.json?key=2710a6d8c608435aa2b223639200812&q=" + city);

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                double temp = obj.getJSONObject("current").getDouble("temp_c");
                double feels_like = obj.getJSONObject("current").getDouble("feelslike_c");
                int humidity = obj.getJSONObject("current").getInt("humidity");
                double pressure = obj.getJSONObject("current").getDouble("pressure_mb") / 1.333;
                printMessage(city, temp, feels_like, humidity, pressure);
            }
        }
    }
}
