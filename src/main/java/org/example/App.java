package org.example;

import org.example.models.LatLon;
import org.example.models.WeatherObj;
import org.example.models.WeatherObject;
import org.example.services.WeatherService;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter zipcode: ");
        String zipcode = input.nextLine();

        WeatherService service = new WeatherService();
        LatLon latLon = service.getLatLon(zipcode);
        System.out.println("You are in " + latLon.getName());
        System.out.println("Your latitude is " + latLon.getLat() + " and longitude is " + latLon.getLon());

        WeatherObject weather = service.getWeather(latLon);
        System.out.println("Current temp is: " + weather.getMain().getTemp());
        System.out.println("Today's weather: " + weather.getWeather()[0].getDescription());

        WeatherObj weatherObj = service.getWeatherByObjectMapper(latLon);

        System.out.println("It feels like: " + weatherObj.getFeelsLike());
        if(weatherObj.getFeelsLike() < 50){
            System.out.println("You may want to bring a jacket!");
        }
    }
}
