import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Weatherstack extends WeatherTest{
    Weatherstack(String city) throws JSONException {
        getCity(city);
    }

    public void getCity(String city) throws JSONException {

        if (!city.equals("")) {
            String output = getUrlContent("http://api.weatherstack.com/current?access_key=c0a19c68fac6cd7a4ed703ea2427ff3f&query=" + city);

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                System.out.println("Твой город: " + city);
                int temp = obj.getJSONObject("current").getInt("temperature");
                int feels_like = obj.getJSONObject("current").getInt("feelslike");
                int humidity = obj.getJSONObject("current").getInt("humidity");
                double pressure = obj.getJSONObject("current").getDouble("pressure") / 1.333;
                System.out.println("Температура: " + temp + "°C");
                System.out.println("Ощущается как: " + feels_like + "°C");
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
