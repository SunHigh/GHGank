package com.example.sh.ghgank.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sh.ghgank.R;
import com.example.sh.ghgank.model.Constellation.ConsteApi;
import com.example.sh.ghgank.model.Constellation.ConsteToday;
import com.example.sh.ghgank.model.GankServices;
import com.example.sh.ghgank.model.weather.WeatherApi;
import com.example.sh.ghgank.model.weather.WeatherResult;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sh on 2016/6/4.
 */
public class InfoFragment extends Fragment {
    private String Api_Key = "19aeaf33304f1d60514b02793e30d064";
    private CardView card1;
    private CardView card2;
    private CardView card3;
    private CardView card4;
    private Boolean isLogin = true;
    private TextView tv_summary;
    private TextView tv_all, tv_love, tv_money, tv_work;
    private TextView tv_health;
    private TextView tv_luckyCol;
    private TextView tv_luckyNum;
    private TextView tv_Qfriend;
    private TextView tv_temp;
    private ConsteApi consteApi;
    private WeatherApi weatherApi;
    private GankServices consteService,
            weatherService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        initView(view);
        initEvent();
        queryConstellation();
        queryWeather();
        return view;
    }

    public void queryWeather(){
        final String cityname="nanjing";
        Call<WeatherResult> call = weatherService.getWeather(Api_Key, cityname);
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if (response.isSuccessful()){
                    WeatherResult weatherResult = response.body();
                    if (weatherResult != null && weatherResult.getErrNum()==0){
                        WeatherResult.RetDataBean.TodayBean todayBean =
                                weatherResult.getRetData().getToday();
                        tv_temp.setText(todayBean.getHightemp());
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("GHTest",t.getMessage());
            }
        });
    }


    public void queryConstellation() {
        final String constellation = "天蝎座";
        Call<ConsteToday> call = consteService.
                getConstellation(Api_Key, constellation, "today");
        call.enqueue(new Callback<ConsteToday>() {
            @Override
            public void onResponse(Call<ConsteToday> call, Response<ConsteToday> response) {
                if (response.isSuccessful()){
                    ConsteToday consteResult = response.body();
                    if (consteResult != null && consteResult.getError_code()==0){
                        tv_summary.append(consteResult.getSummary());
                        tv_health.setText(consteResult.getHealth());
                        tv_luckyCol.setText(consteResult.getColor());
                        tv_luckyNum.setText(consteResult.getNumber()+"");
                        tv_Qfriend.setText(consteResult.getQFriend());
                        tv_money.setText(consteResult.getMoney());
                        tv_all.setText(consteResult.getAll());
                        tv_work.setText(consteResult.getWork());
                        tv_love.setText(consteResult.getLove());
                    }
                }
            }

//            private void showLevel(String s) {
//                try{
//                    String s1 = s.replace("\\D+","");
//                    int relevel = Integer.parseInt(s);
//                }catch (NumberFormatException e){
//                    e.printStackTrace();
//                }
//            }

            @Override
            public void onFailure(Call<ConsteToday> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initEvent() {

        card1.setAlpha(0.7f);
        card2.setAlpha(0.7f);
//        card3.setAlpha(0.5f);
//        card4.setAlpha(0.5f);
    }

    private void initView(View view) {
        card1 = (CardView) view.findViewById(R.id.tv1);
        card2 = (CardView) view.findViewById(R.id.tv2);
        card3 = (CardView) view.findViewById(R.id.tv3);
        card4 = (CardView) view.findViewById(R.id.tv4);
        tv_summary = (TextView) view.findViewById(R.id.consSummary);
        tv_all = (TextView) view.findViewById(R.id.tv_all);
        tv_love = (TextView) view.findViewById(R.id.tv_love);
        tv_work = (TextView) view.findViewById(R.id.tv_work);
        tv_money = (TextView) view.findViewById(R.id.tv_money);
        tv_health = (TextView) view.findViewById(R.id.jiankangtext);
        tv_luckyCol = (TextView) view.findViewById(R.id.xingyuncolor);
        tv_luckyNum = (TextView) view.findViewById(R.id.xingyunnumber);
        tv_Qfriend = (TextView) view.findViewById(R.id.Qfriend);
        tv_temp = (TextView) view.findViewById(R.id.tv_card_temp);
        consteApi = ConsteApi.getApi();
        consteService = consteApi.getConsService();
        weatherApi = WeatherApi.getApi();
        weatherService = weatherApi.getWeatherService();

    }



}
