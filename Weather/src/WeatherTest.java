import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WeatherTest {
    public static final void main(String[] args) throws JSONException {
        final File file = new File("/user/apieceofchalk/downloads/");
        Scanner in = new Scanner(System.in);
        System.out.println("----Выберите погодный сервис:---- ");
        System.out.println("1 - OpenWeather (запрос на русском).");
        System.out.println("2 - Weatherstack (не позволяет отправлять запросы на русском).");
        System.out.println("3 - WeatherApi (та же самая ситуация).");
        String api = in.nextLine();


        if (api.equals("1")) {
            System.out.println("----Open weather map----");
            System.out.println("Введите город:");
            String city = in.nextLine();
            if (!city.equals("")) {
                String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&lang=ru&appid=dbe834f44441af9fd34921f95b06acbf");
                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    System.out.println("Твой город: " + city);
                    Double temp = obj.getJSONObject("main").getDouble("temp") - 273.15;
                    Double feels_like = obj.getJSONObject("main").getDouble("feels_like") - 273.15;
                    System.out.println("Температура: " + Math.round(temp) + "°C");
                    System.out.println("Ощущается как: " + Math.round(feels_like) + "°C");
                    in.close();
                }
            }
        }
        else if (api.equals("2")) {
            System.out.println("----Weatherstack----");
            System.out.println("Введите город на английском:");
            String city = in.nextLine();
            if (!city.equals("")) {
                String output = getUrlContent("http://api.weatherstack.com/current?access_key=c0a19c68fac6cd7a4ed703ea2427ff3f&query=" + city);
                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    System.out.println("Твой город: " + city);
                    Double temp = obj.getJSONObject("current").getDouble("temperature");
                    Double feels_like = obj.getJSONObject("current").getDouble("feelslike");
                    System.out.println("Температура: " + Math.round(temp) + "°C");
                    System.out.println("Ощущается как: " + Math.round(feels_like) + "°C");
                    in.close();
                }
            }
        }
        else if (api.equals("3")) {
            System.out.println("----WeatherApi----");
            System.out.println("Введите город на английском:");
            String city = in.nextLine();
            if (!city.equals("")) {
                String output = getUrlContent("http://api.weatherapi.com/v1/current.json?key=2710a6d8c608435aa2b223639200812&q=" + city);
                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    System.out.println("Твой город: " + city);
                    double temp = obj.getJSONObject("current").getDouble("temp_c");
                    double feels_like = obj.getJSONObject("current").getDouble("feelslike_c");
                    System.out.println("Температура: " + Math.round(temp) + "°C");
                    System.out.println("Ощущается как: " + Math.round(feels_like) + "°C");
                    in.close();
                }
            }
        }
        else {
            System.out.println("Некорректный ввод!");
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

