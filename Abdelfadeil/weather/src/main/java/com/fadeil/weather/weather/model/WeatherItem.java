package com.fadeil.weather.weather.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherItem {

    private String city;
    private double temMax;
    private double temMin;
    private double temberature;
    private int pression;
    private int humidite;
    private String date;
    private int nuages;
    private String weather;


    @Override
    public String toString() {
        return "MeteoInfos {" +
                "Ville='" + city + '\'' +
                ", date='" + date + '\'' +
                ", temberature actuelle=" + temberature +
                ", temberature max=" + temMax +
                ", temberature min=" + temMin +
                ", pression=" + pression +
                ", weather=" + weather +
                ", humidity=" + humidite +" %"+
                ", nuages=" + nuages +
                '}';
    }
}
