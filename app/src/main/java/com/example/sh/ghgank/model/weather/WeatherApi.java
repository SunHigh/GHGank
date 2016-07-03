package com.example.sh.ghgank.model.weather;

import com.example.sh.ghgank.model.GankServices;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sh_pc on 2016/7/3.
 */
public class WeatherApi
{
    public static final String Base_Url = "http://apis.baidu.com";

    public static WeatherApi getApi(){
        return WeatherHoler.weatherApi;
    }

    private static class WeatherHoler {
        private static WeatherApi weatherApi = new WeatherApi();
    }
    private GankServices weatherService;

    private WeatherApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherService = retrofit.create(GankServices.class);

    }
    public GankServices getWeatherService(){
        return weatherService;
    }
}
