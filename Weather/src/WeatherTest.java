import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WeatherTest {
    public static final void main(String[] args) throws JSONException, IOException {

        File file = new File("/Users/apieceofchalk/IdeaProjects/Weather/src/file.txt");
        Scanner in = new Scanner(System.in);

        if (!file.exists()){
            FileWriter writer = new FileWriter(file);
            System.out.println("----Выберите погодный сервис:---- ");
            System.out.println("1 - OpenWeather (запрос на русском).");
            System.out.println("2 - Weatherstack (не позволяет отправлять запросы на русском).");
            System.out.println("3 - WeatherApi (та же самая ситуация).");
            String api = in.nextLine();
            writer.write(api);
            writer.flush();
            writer.close();

            if (api.equals("1")) {
                System.out.println("----Open weather map----");
                System.out.println("Введите город:");
                String city = in.nextLine();

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
                        int temp = obj.getJSONObject("current").getInt("temperature");
                        int feels_like = obj.getJSONObject("current").getInt("feelslike");
                        int humidity = obj.getJSONObject("main").getInt("humidity");
                        double pressure = obj.getJSONObject("main").getDouble("pressure") / 1.333;
                        System.out.println("Температура: " + temp + "°C");
                        System.out.println("Ощущается как: " + feels_like + "°C");
                        System.out.println("Влажность: " + humidity + "%");
                        System.out.println("Давление: " + Math.round(pressure) + " мм рт.ст.");
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
                        int humidity = obj.getJSONObject("current").getInt("humidity");
                        double pressure = obj.getJSONObject("current").getDouble("pressure_mb") / 1.333;
                        System.out.println("Температура: " + Math.round(temp) + "°C");
                        System.out.println("Ощущается как: " + Math.round(feels_like) + "°C");
                        System.out.println("Влажность: " + humidity + "%");
                        System.out.println("Давление: " + Math.round(pressure) + " мм рт.ст.");
                        in.close();
                    }
                }
            }

            else {
                System.out.println("Некорректный ввод!");
            }

        }

        else { // если файл существует //

            String api = Files.readString(Path.of("/Users/apieceofchalk/IdeaProjects/Weather/src/file.txt"));

            if (api.equals("1")) {
                System.out.println("----Open weather map----");
                System.out.println("В прошлый раз Вы использовали этот api, чтобы использовать другой, напишите 'Стоп' и заново запустите программу.");
                System.out.println("Введите город:");
                String city = in.nextLine();

                if (city.equals("Стоп")) {
                    System.out.println("Запустите заново программу!");
                    file.delete();
                }

                else if (!city.equals("")) {
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
                        in.close();
                    }
                }
            }

            else if (api.equals("2")) {
                System.out.println("----Weatherstack----");
                System.out.println("В прошлый раз Вы использовали этот api, чтобы использовать другой, напишите 'Стоп' и заново запустите программу.");
                System.out.println("Введите город на английском:");
                String city = in.nextLine();

                if (city.equals("Стоп")) {
                    System.out.println("Запустите заново программу!");
                    file.delete();
                }

                else if (!city.equals("")) {
                    String output = getUrlContent("http://api.weatherstack.com/current?access_key=c0a19c68fac6cd7a4ed703ea2427ff3f&query=" + city);

                    if (!output.isEmpty()) {
                        JSONObject obj = new JSONObject(output);
                        System.out.println("Твой город: " + city);
                        int temp = obj.getJSONObject("current").getInt("temperature");
                        int feels_like = obj.getJSONObject("current").getInt("feelslike");
                        int humidity = obj.getJSONObject("main").getInt("humidity");
                        double pressure = obj.getJSONObject("main").getDouble("pressure") / 1.333;
                        System.out.println("Температура: " + temp + "°C");
                        System.out.println("Ощущается как: " + feels_like + "°C");
                        System.out.println("Влажность: " + humidity + "%");
                        System.out.println("Давление: " + Math.round(pressure) + " мм рт.ст.");
                        in.close();
                    }
                }
            }

            else if (api.equals("3")) {
                System.out.println("----WeatherApi----");
                System.out.println("В прошлый раз Вы использовали этот api, чтобы использовать другой, напишите 'Стоп' и заново запустите программу.");
                System.out.println("Введите город на английском:");
                String city = in.nextLine();

                if (city.equals("Стоп")) {
                    System.out.println("Запустите заново программу!");
                    file.delete();
                }
                else if (!city.equals("")) {
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
                        in.close();
                    }
                }
            }

            else {
                System.out.println("Некорректный ввод!");
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

