package com.example.sh.ghgank.model;

import com.example.sh.ghgank.model.Constellation.ConsteToday;
import com.example.sh.ghgank.model.GanHuo.GankResult;
import com.example.sh.ghgank.model.weather.WeatherResult;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sh_pc on 2016/6/24.
 */
public interface GankServices {

    @GET("api/data/{type}/{count}/{page}")
    Observable<GankResult> getGanHuo(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
    );


    @GET("/bbtapi/constellation/constellation_query")
    Call<ConsteToday> getConstellation(
            @Header("apikey")String apikey,
            @Query("consName")String constellation,
            @Query("type")String type
    );

    @GET("/weatherservice/cityname")
    Call<WeatherResult> getWeather(
            @Header("apikey") String apikey,
            @Query("cityname") String cityname
    );
}
