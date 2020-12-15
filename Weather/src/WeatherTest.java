import org.json.JSONException;
import java.io.*;
import java.util.Scanner;

public class WeatherTest {
    public static final void main(String[] args) throws JSONException, IOException {

        File file = new File("/Users/apieceofchalk/IdeaProjects/Weather/src/file.txt");
        Scanner in = new Scanner(System.in);

        while (true) {
            if (!file.exists()) {
                FileWriter writer = new FileWriter(file);
                System.out.println("----Выберите погодный сервис:---- ");
                System.out.println("1 - OpenWeather (запрос на русском).");
                System.out.println("2 - Weatherstack (не позволяет отправлять запросы на русском).");
                System.out.println("3 - WeatherApi (та же самая ситуация).");
                String api = in.nextLine();
                writer.write(api + "\n");
                writer.flush();

                if (api.equals("1")) {
                    System.out.println("----Open weather map----");
                    System.out.println("Введите город:");

                    while (true) {
                        String city = in.nextLine();
                        if (city.equals("Стоп")) {
                            System.out.println("Запустите заново программу!");
                            file.delete();
                        }
                        else if (!city.equals("exit")) {
                            OpenWeather ow = new OpenWeather(city);
                            writer.write(city + "\n");
                            writer.flush();
                        } else {
                            break;
                        }
                    }
                } else if (api.equals("2")) {

                    System.out.println("----Weatherstack----");
                    System.out.println("Введите город на английском:");


                    String city = in.nextLine();
                    if (city.equals("Стоп")) {
                        System.out.println("Запустите заново программу!");
                        file.delete();
                    }
                    else if (!city.equals("exit")) {
                        Weatherstack ws = new Weatherstack(city);
                        writer.write(city + "\n");
                        writer.flush();
                    } else {
                        break;
                    }

                } else if (api.equals("3")) {

                    System.out.println("----WeatherApi----");
                    System.out.println("Введите город на английском:");
                    String city = in.nextLine();
                    if (city.equals("Стоп")) {
                        System.out.println("Запустите заново программу!");
                        file.delete();
                    }
                    else if (!city.equals("exit")) {
                        WeatherApi wa = new WeatherApi(city);
                        writer.write(city + "\n");
                        writer.flush();
                    } else {
                            break;
                    }
                } else {
                    System.out.println("Некорректный ввод!");
                }

            } else { // если файл существует //


                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String api = reader.readLine();
                String line, last_city = null;
                FileWriter writer = new FileWriter(file);
                writer.write(api + "\n");
                writer.flush();


                if (api.equals("1")) {
                    System.out.println("----Open weather map----");

                    while ((line = reader.readLine()) != null) {
                        last_city = line;
                    }
                    if (last_city != null) {
                        System.out.println("Ваш последний запрос:");
                        OpenWeather ow = new OpenWeather(last_city);
                    }
                    else {
                        System.out.println("В прошлый раз у вас не было запроса.");
                    }

                    System.out.println("Введите город:");
                    String city = in.nextLine();
                    if (city.equals("Стоп")) {
                        System.out.println("Запустите заново программу!");
                        file.delete();
                    } else if (!city.equals("")) {
                        if (!city.equals("exit")) {
                            OpenWeather ow2 = new OpenWeather(city);
                            writer.write(city + "\n");
                            writer.flush();
                        } else {
                            break;
                        }
                    }
                } else if (api.equals("2")) {
                    System.out.println("----Weatherstack----");

                    while ((line = reader.readLine()) != null) {
                        last_city = line;
                    }
                    if (last_city != null) {
                        System.out.println("Ваш последний запрос:");
                        Weatherstack ws = new Weatherstack(last_city);
                    }
                    else {
                        System.out.println("В прошлый раз у вас не было запроса.");
                    }

                    System.out.println("Введите город на английском:");
                    String city = in.nextLine();
                    if (city.equals("Стоп")) {
                        System.out.println("Запустите заново программу!");
                        file.delete();
                    } else if (!city.equals("")) {
                        if (!city.equals("exit")) {
                            Weatherstack ws2 = new Weatherstack(city);
                            writer.write(city + "\n");
                            writer.flush();
                        } else {
                            break;
                        }
                    }

                } else if (api.equals("3")) {
                    System.out.println("----WeatherApi----");

                    while ((line = reader.readLine()) != null) {
                        last_city = line;
                    }
                    if (last_city != null) {
                        System.out.println("Ваш последний запрос:");
                        WeatherApi wa = new WeatherApi(last_city);
                    }
                    else {
                        System.out.println("В прошлый раз у вас не было запроса.");
                    }

                    System.out.println("Введите город на английском:");
                    String city = in.nextLine();
                    if (city.equals("Стоп")) {
                        System.out.println("Запустите заново программу!");
                        file.delete();
                    } else if (!city.equals("")) {
                        if (!city.equals("exit")) {
                            WeatherApi wa2 = new WeatherApi(city);
                            writer.write(city + "\n");
                            writer.flush();
                        } else {
                            break;
                        }
                    }
                } else {
                    System.out.println("Некорректный ввод!");
                }
            }
        }
    }
}

