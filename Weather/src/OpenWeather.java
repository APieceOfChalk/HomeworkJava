import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class OpenWeather extends WeatherTest{
    OpenWeather(String city) throws JSONException {
        getCity(city);
    }

    public void getCity(String city) throws JSONException {

        if (!city.equals("")) {
            String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&lang=ru&appid=dbe834f44441af9fd34921f95b06acbf");

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                System.out.println("Твой город: " + city);
                double temp = obj.getJSONObject("main").getDouble("temp") - 273.15;
                double feels_like = obj.getJSONObject("main").getDouble("feels_like") - 273.15;
                double temp_min = obj.getJSONObject("main").getDouble("temp_min") - 273.15;
                double temp_max = obj.getJSONObject("main").getDouble("temp_max") - 273.15;
                double pressure = obj.getJSONObject("main").getDouble("pressure") / 1.333;
                int humidity = obj.getJSONObject("main").getInt("humidity");
                System.out.println("Температура: " + Math.round(temp) + "°C");
                System.out.println("Ощущается как: " + Math.round(feels_like) + "°C");
                System.out.println("Минимальная температура: " + Math.round(temp_min) + "°C");
                System.out.println("Максимальная температура: " + Math.round(temp_max) + "°C");
                System.out.println("Давление: " + Math.round(pressure) + " мм рт.ст.");
                System.out.println("Влажность: " + humidity + "%");
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
