package com.fadeil.weather.weather.controller;

import com.fadeil.weather.weather.model.WeatherItem;
import com.fadeil.weather.weather.requestFactory.HttpClientApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WeatherController {

    public String city;
    public final HttpClientApp httpClientApp;

    public WeatherController(HttpClientApp httpClientApp) {
        this.httpClientApp = httpClientApp;
    }


    @GetMapping("/")
    public String accueuil(Model model, @RequestParam(name="city", required = false) String city) throws Exception {
        try{
            if (model.getAttribute("city")==null){
                WeatherItem weatherItem = httpClientApp.getWeatherCityNow("paris");
                model.addAttribute("weatherItem", weatherItem);
                model.addAttribute("city", weatherItem.getCity());

            }  else {

                WeatherItem weatherItem = httpClientApp.getWeatherCityNow(city);
                model.addAttribute("weatherItem", weatherItem);
                model.addAttribute("city", weatherItem.getCity());
            }
            return "index";
        }catch (Exception e){
            e.getStackTrace();
            return "index";
        }
    }



    @GetMapping("/meteo/accueil")
           public String pageAccueuil(Model model, HttpSession session, @RequestParam(name="city", required = false) String city) throws Exception {
        try{
            if (city==null){
                city="paris";
            }
                WeatherItem weatherItem = httpClientApp.getWeatherCityNow(city);
                model.addAttribute("weatherItem", weatherItem);
                model.addAttribute("city", city);
                return "index";
               }catch (Exception e){
                   e.getStackTrace();
                   return "index";
               }

    }

    @GetMapping("/meteo/search")
    public String searchCityWeather(
            @RequestParam(name="city", required = false) String city, Model model) throws Exception {
        try{
            if (city==null){
                city="paris";
            }
                WeatherItem weatherItem = httpClientApp.getWeatherCityNow(city);
                model.addAttribute("weatherItem", weatherItem);
                model.addAttribute("city", city);
            return "accueil";
        }catch (Exception e){
            e.getStackTrace();
            return "accueil";
        }
    }

}
