package com.fadeil.weather.weather.SearchWeather;

import com.fadeil.weather.weather.model.WeatherItem;
import com.fadeil.weather.weather.requestFactory.HttpClientApp;

import java.io.IOException;
import java.util.Scanner;

public class SearchWeatherForCity {


    public static void main(String[] args) throws Exception {
        HttpClientApp httpClientApp = new HttpClientApp();

        System.out.println("Enterez le nom de la ville ... ");
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();

        WeatherItem weatherItem = httpClientApp.getWeatherCityNow(city);
        System.out.println(weatherItem);

    }
}
