package giorgi.maisuradze.weather.services;

import giorgi.maisuradze.weather.models.DirectionType;
import giorgi.maisuradze.weather.models.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// singleton pattern
public class WeatherDB {

    private static WeatherDB INSTANCE = null;

    private List<Weather> weatherList;

    public static WeatherDB getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new WeatherDB();

            List<Weather> initWeatherList = new ArrayList<>();

            initWeatherList.add(new Weather("Tbilisi",24.3,31,1007, DirectionType.EAST,12.1));
            initWeatherList.add(new Weather("Dubai",51.9,2,407, DirectionType.WEST,72.2));
            initWeatherList.add(new Weather("Berlin",14.7,51,807, DirectionType.WEST,52.1));
            initWeatherList.add(new Weather("Kutaisi",42.0,21,1127, DirectionType.SOUTH,80.9));
            initWeatherList.add(new Weather("Batumi",32.2,91,47, DirectionType.NORTH,12.0));

            INSTANCE.weatherList = initWeatherList;
        }

        return INSTANCE;
    }


    public List<Weather> getWeatherList() {

        return weatherList;
    }

    public Weather getWeatherByCity(String city) {

        return weatherList.stream()
                .filter(c -> c.getCityName().toLowerCase().equals(city.toLowerCase()))
                .collect(Collectors.toList()).stream().findAny().orElse(null);
    }
}