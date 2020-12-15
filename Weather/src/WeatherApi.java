import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherApi extends WeatherTest {
    WeatherApi(String city) throws JSONException {
        getCity(city);
    }

    public void getCity(String city) throws JSONException {
        if (!city.equals("")) {
            String output = getUrlContent("http://api.weatherapi.com/v1/current.json?key=2710a6d8c608435aa2b223639200812&q=" + city);

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                System.out.println("Твой город: " + city);
                double temp = obj.getJSONObject("current").getDouble("temp_c");
                double feels_like = obj.getJSONObject("current").getDouble("feelslike_c");
                int humidity = obj.getJSONObject("current").getInt("humidity");
                double pressure = obj.getJSONObject("current").getDouble("pressure_mb") / 1.333;
                System.out.println("Температура: " + Math.round(temp) + "°C");
                System.out.println("Ощущается как: " + Math.round(feels_like) + "°C");
                System.out.println("Влажность: " + humidity + "%");
                System.out.println("Давление: " + Math.round(pressure) + " мм рт.ст.");
            }
        }
    }

    private static String getUrlContent(String urlAdress) {

        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();

        } catch(Exception e) {
            System.out.println("Нет такого города!");
        }

        return content.toString();
    }
}
