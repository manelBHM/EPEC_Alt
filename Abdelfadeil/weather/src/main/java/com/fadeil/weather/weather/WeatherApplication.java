package com.fadeil.weather.weather;

import com.fadeil.weather.weather.requestFactory.HttpClientApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class WeatherApplication implements CommandLineRunner {

    HttpClientApp httpClientApp;

    @Bean
    public HttpClientApp getHttpClientApp() {
        return httpClientApp;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception, IOException {

        // HttpClientApp httpClientApp = new HttpClientApp();

        //System.out.println("Enterez le nom de la ville ... ");
       // Scanner sc = new Scanner(System.in);
        //String city = sc.nextLine();

        //httpClientApp.getWeatherCityNow(city);

    }
}
