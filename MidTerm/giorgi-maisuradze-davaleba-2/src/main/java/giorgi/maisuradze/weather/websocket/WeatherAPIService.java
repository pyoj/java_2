package giorgi.maisuradze.weather.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIService {

    final private static String API = "http://localhost:8080/giorgi_maisuradze_davaleba_1_war_exploded/api/weather";

    final private static String allCommand = "all";

    public static String processCommand(String command) {
        String result;

        try {
            if (allCommand.equals(command)) {
                result = getAllWeathers();
            } else {
                result = tryGetWeatherByCityName(command);
            }
        } catch (IOException e) {
            result = "მოხდა შეცდომა: " + e.getMessage();
        }


        return result;
    }

    private static String getAllWeathers() throws IOException {
        return makeHttpRequest(API);
    }

    private static String tryGetWeatherByCityName(String cityName) throws IOException {

        return makeHttpRequest(API + "/" + cityName);
    }

    private static String makeHttpRequest(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        String content = null;

        while ((output = br.readLine()) != null) {
            content = output;
        }

        conn.disconnect();

        return content;
    }
}
