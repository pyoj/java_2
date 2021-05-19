package giorgi.maisuradze.weather.controller;

import giorgi.maisuradze.weather.models.Weather;
import giorgi.maisuradze.weather.services.WeatherDB;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/weather")
public class WeatherController {

    private final WeatherDB DB = WeatherDB.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> getWeatherList() {

        return DB.getWeatherList();
    }

    @GET
    @Path("{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weather getWeatherByCity(@PathParam("city") String city) {

        return DB.getWeatherByCity(city);
    }

}
