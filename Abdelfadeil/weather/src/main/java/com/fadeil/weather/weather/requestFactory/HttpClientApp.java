package com.fadeil.weather.weather.requestFactory;

import com.fadeil.weather.weather.model.WeatherItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HttpClientApp {
    private final String API_KEY = "a39b27a820a1ca7ce33c6fc3ff4cc8e2";
    private String city;
    private String API_URL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID="+API_KEY;


    ///  météo d'aujourd'hui d'une ville
    public WeatherItem getWeatherCityNow(String city) throws Exception {
        API_URL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID="+API_KEY;
        WeatherItem weatherItem = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpEntity entity = null;

        HttpGet request = new HttpGet(API_URL);
             response = httpClient.execute(request);
             entity = response.getEntity();
        // weatherItem = formatterHttpReponse.formtResultHttpReponse(entity) ;
        String result = null;
        Map<String, Object> resultMap = null;
               if (entity != null) {
            result = EntityUtils.toString(entity, "UTF-8");
           // System.out.println(result);
            resultMap = new ObjectMapper().readValue(result, HashMap.class);
        }
         System.out.println(" this is the result");
         System.out.println(result);
        String mainWeather;
        Map<String,Double> mainWeatherMap = null;
        Map<String, Double> mainWeatherClouds = null;
        List<Map<String, Object>> WeatherType = null;
        for (Map.Entry<String,Object> entry : resultMap.entrySet()){
            if (entry.getKey().equals("main")){
                mainWeatherMap = (Map<String, Double>) entry.getValue();
            }
            if (entry.getKey().equals("clouds")){
                mainWeatherClouds = (Map<String, Double>) entry.getValue();
            }
            if (entry.getKey().equals("weather")){
                WeatherType = (List<Map<String, Object>>) entry.getValue();
            }


            
        }
        System.out.println("Weather type ///////// "+WeatherType.size());
        Map<String, Object> WeatherTypeMap = WeatherType.get(0);
        String weatherTypeMain = null;
        for (Map.Entry<String,Object> entry : WeatherTypeMap.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
            if(entry.getKey().equals("main")){
                weatherTypeMain= (String) entry.getValue();
            }
        }
        // création de l'objet météo qui contient toutes les information
        weatherItem = new WeatherItem();
        weatherItem.setCity((String) resultMap.get("name"));
        Object time= resultMap.get("dt");
        Integer timeInt = ((Integer) time);
        Long timeLong = Long.valueOf(timeInt);
        LocalDate date = Instant.ofEpochMilli(timeLong*1000).atZone(ZoneId.systemDefault()).toLocalDate();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        // String transformedDate = new SimpleDateFormat("H:mm  dd MMM yy").format(new Date(timeInt*1000));
        weatherItem.setDate(formattedDate);
        double temperature=     (mainWeatherMap.get("temp") - 273.15F);
        double temperatureMax = (mainWeatherMap.get("temp_max") - 273.15F);
        double temperatureMin = (mainWeatherMap.get("temp_min") - 273.15F);
      //  System.out.println("temperature "+ temperature);
        weatherItem.setTemberature(temperature);
        weatherItem.setTemMax(temperatureMax);
        weatherItem.setTemMin(temperatureMin);
        Integer perssionInt = (Integer) ((Object)mainWeatherMap.get("pressure"));
        Integer humidity = (Integer) ((Object)mainWeatherMap.get("humidity"));
        weatherItem.setPression(perssionInt);
        weatherItem.setHumidite(humidity);
        Integer nuages = (Integer) ((Object)mainWeatherClouds.get("all"));
        weatherItem.setNuages(nuages);
        weatherItem.setWeather(weatherTypeMain);
        //System.out.println("MeteoInfos [ Ville: "+weatherItem.getCity()+ ", date: "+weatherItem.getDate()+ ", temperature="+weatherItem.getTemberature()
               // +", humidity="+weatherItem.getHumidite()+"%, nuages="+weatherItem.getNuages()+" ] ");

        return weatherItem;
    }

/// liste de météo d'une ville de 7 jours
    public List<WeatherItem> getWeathersCity(String city) throws Exception {
        API_URL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID="+API_KEY;
        List<WeatherItem> weatherItemList =null;
        WeatherItem weatherItem = null;
        Map<String, Double> mainWeatherClouds = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpEntity entity = null;

        HttpGet request = new HttpGet(API_URL);
        response = httpClient.execute(request);
        entity = response.getEntity();
        // weatherItem = formatterHttpReponse.formtResultHttpReponse(entity) ;
        String result = null;
        Map<String, Object> resultMap = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
            resultMap = new ObjectMapper().readValue(result, HashMap.class);
        }
        System.out.println(" this is the result");
        System.out.println(result);
        String mainWeather;
        Map<String,Double> mainWeatherMap = null;

        for (Map.Entry<String,Object> entry : resultMap.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
            if (entry.getKey().equals("main")){
                mainWeatherMap = (Map<String, Double>) entry.getValue();
            }
        }
        System.out.println("///////// main weather /////////////");
        for (Map.Entry<String,Double> entry : mainWeatherMap.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }

        // création de l'objet météo qui contient toutes les information
        weatherItem = new WeatherItem();
        weatherItem.setCity((String) resultMap.get("name"));
        Object time= resultMap.get("dt");
        Integer timeInt = ((Integer) time);
        Long timeLong = Long.valueOf(timeInt);
        LocalDate date = Instant.ofEpochMilli(timeLong*1000).atZone(ZoneId.systemDefault()).toLocalDate();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        // String transformedDate = new SimpleDateFormat("H:mm  dd MMM yy").format(new Date(timeInt*1000));
        System.out.println("time format ////////// "+ formattedDate);
        weatherItem.setDate(formattedDate);
        double temperatureMax = (mainWeatherMap.get("temp_max") - 273.15F);
        double temperatureMin = (mainWeatherMap.get("temp_min") - 273.15F);
        System.out.println("temperature "+ temperatureMax);
        double temperature= (mainWeatherMap.get("temp") - 273.15F);
        weatherItem.setTemberature(temperature);
        weatherItem.setTemMax(temperatureMax);
        weatherItem.setTemMin(temperatureMin);
        Integer perssionInt = (Integer) ((Object)mainWeatherMap.get("pressure"));
        Integer humidity = (Integer) ((Object)mainWeatherMap.get("humidity"));
        weatherItem.setPression(perssionInt);
        weatherItem.setHumidite(humidity);
        Integer nuages = (Integer) ((Object)mainWeatherClouds.get("all"));
        weatherItem.setNuages(nuages);

        return weatherItemList;
    }

}
