package com.example.sh.ghgank.model.Constellation;

import com.example.sh.ghgank.model.GankServices;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sh_pc on 2016/6/24.
 */
public class ConsteApi {
    public static final String Base_Url = "http://apis.baidu.com";
    public static final String Api_Key = "19aeaf33304f1d60514b02793e30d064";

    public static ConsteApi getApi(){
        return ConsteHolder.consteApi;
    }

    private static class ConsteHolder {
        private static ConsteApi consteApi = new ConsteApi();
    }
    private GankServices consService;

    private ConsteApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        consService = retrofit.create(GankServices.class);
    }

    public GankServices getConsService(){
        return consService;
    }

}
