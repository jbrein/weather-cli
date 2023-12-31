package org.example.models;

public class WeatherObj {
    private String main;
    private String description;
    private double temp;
    private double feelsLike;

    public WeatherObj(String main, String description, double temp, double feelsLike){
        this.main = main;
        this.description = description;
        this.temp = temp;
        this.feelsLike = feelsLike;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    @Override
    public String toString() {
        return "WeatherObj{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", temp=" + temp +
                ", feelsLike=" + feelsLike +
                '}';
    }
}
