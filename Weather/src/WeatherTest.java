import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WeatherTest {
    public static final void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        FileReader fr = new FileReader("/Users/apieceofchalk/IdeaProjects/Weather/src/settings.json");
        Scanner scanner = new Scanner(fr);
        JSONObject settings = new JSONObject(scanner.nextLine());

        String api = settings.getString("api");
        String last_city = settings.getString("city");


        System.out.println("Ваш последний ответ на запрос:");
        if (api.equals("1")){
            OpenWeather ow = new OpenWeather(last_city);
        }
        else if (api.equals("2")) {
            Weatherstack ws = new Weatherstack(last_city);
        }
        else if (api.equals("3")) {
            WeatherApi wa = new WeatherApi(last_city);
        }


        while (true) {

            if (api.equals("1")) {
                System.out.println("----Open weather map----");

                System.out.println("Введите город:");
                String city = in.nextLine();
                if (city.equals("Стоп") | city.equals("Stop")) {
                    api = "0";
                    setSettings(api, last_city);
                } else if (!city.equals("")) {
                    if (!(city.equals("exit") | city.equals("выход"))) {
                        last_city = city;
                        OpenWeather ow = new OpenWeather(city);
                        setSettings(api, last_city);
                    } else {
                        break;
                    }
                }

            } else if (api.equals("2")) {
                System.out.println("----Weatherstack----");

                System.out.println("Введите город на английском:");
                String city = in.nextLine();
                if (city.equals("Стоп") | city.equals("Stop")) {
                    api = "0";
                    setSettings(api, last_city);
                } else if (!city.equals("")) {
                    if (!(city.equals("exit") | city.equals("выход"))) {
                        last_city = city;
                        Weatherstack ws = new Weatherstack(city);
                        setSettings(api, last_city);
                    } else {
                        break;
                    }
                }

            } else if (api.equals("3")) {
                System.out.println("----WeatherApi----");

                System.out.println("Введите город на английском:");
                String city = in.nextLine();
                if (city.equals("Стоп") | city.equals("Stop")) {
                    api = "0";
                    setSettings(api, last_city);
                } else if (!city.equals("")) {
                    if (!(city.equals("exit") | city.equals("выход"))) {
                        last_city = city;
                        WeatherApi wa = new WeatherApi(city);
                        setSettings(api, last_city);
                    } else {
                        break;
                    }
                }
            } else if (api.equals("0")) {
                System.out.println("----Выберите погодный сервис:---- ");
                System.out.println("1 - OpenWeather (запрос на русском).");
                System.out.println("2 - Weatherstack (не позволяет отправлять запросы на русском).");
                System.out.println("3 - WeatherApi (та же самая ситуация).");
                api = in.nextLine();
            } else {
                System.out.println("Некорректный ввод!");
            }
        }
    }

    public static void setSettings (String api, String city) throws Exception {

        FileReader fr = new FileReader("/Users/apieceofchalk/IdeaProjects/Weather/src/settings.json");
        Scanner scanner = new Scanner(fr);
        JSONObject settings = new JSONObject(scanner.nextLine());
        try {
            settings.put("api", api);
            settings.put("city", city);
            FileWriter fw = new FileWriter("/Users/apieceofchalk/IdeaProjects/Weather/src/settings.json");
            fw.write(settings.toString());
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close();
        }
    }

    public static void printMessage(String city, double curr_temp, double f_like, double curr_press, double curr_humidity) throws JSONException {

        System.out.println("Ваш город: " + city);
        System.out.println("Температура: " + Math.round(curr_temp) + "°C");
        System.out.println("Ощущается как: " + Math.round(f_like) + "°C");
        System.out.println("Давление: " + Math.round(curr_press) + " мм рт.ст.");
        System.out.println("Влажность: " + Math.round(curr_humidity) + "%");
    }

    public static String getUrlContent(String urlAdress) {

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
