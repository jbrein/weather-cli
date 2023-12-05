package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.LatLon;
import org.example.models.WeatherObj;
import org.example.models.WeatherObject;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
    private RestTemplate template = new RestTemplate();

    private final String API_GEO_URL = "http://api.openweathermap.org/geo/1.0/zip";

    private final String API_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?lat=";

    private final String API_KEY = "Your API Key here!";

    public LatLon getLatLon(String zipcode){
        String url = API_GEO_URL + "?zip=" + zipcode + "&appid=" + API_KEY;
        return template.getForObject(url, LatLon.class);
    }

    public WeatherObject getWeather(LatLon latLon){
        String url = API_WEATHER_URL + latLon.getLat() + "&lon=" + latLon.getLon() + "&units=imperial&appid=" + API_KEY;
        return template.getForObject(url, WeatherObject.class);
    }

    public WeatherObj getWeatherByObjectMapper(LatLon latLon){
        String url = API_WEATHER_URL + latLon.getLat() + "&lon=" + latLon.getLon() + "&units=imperial&appid=" + API_KEY;
        String response = template.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response);
            JsonNode weather = root.path("weather");
            String main = weather.path(0).path("main").asText();
            String description = weather.path(0).path("description").asText();
            double temp = root.path("main").path("temp").asDouble();
            double feelsLike = root.path("main").path("feels_like").asDouble();
            return new WeatherObj(main, description, temp, feelsLike);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}

