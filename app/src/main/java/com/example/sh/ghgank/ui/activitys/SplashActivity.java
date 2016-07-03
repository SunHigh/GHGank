package com.example.sh.ghgank.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.sh.ghgank.R;
import com.example.sh.ghgank.model.GanHuo.GankApi;
import com.example.sh.ghgank.model.GanHuo.GankResult;
import com.example.sh.ghgank.model.GankServices;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sh_pc on 2016/7/3.
 */
public class SplashActivity extends AppCompatActivity{
    private ImageView image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_splash);
        
        initImage();
    }

    private void initImage() {
        image = (ImageView) findViewById(R.id.splash_image);
        GankApi.getRetrofit()
                .create(GankServices.class)
                .getGanHuo("福利",1,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankResult>() {
                    @Override
                    public void onCompleted() {
                        animateImage();
                    }
                    @Override
                    public void onError(Throwable e) {
                        Glide.with(SplashActivity.this)
                                .load(R.mipmap.wall_picture)
                                .into(image);
                        animateImage();
                    }

                    @Override
                    public void onNext(GankResult gankResult) {
                        //获取Gank.io当前最新
                        Glide.with(SplashActivity.this)
                                .load(gankResult.getResults().get(0).getUrl())
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .into(image);
                        animateImage();
                    }
                });
    }

    private void animateImage() {
        //缩放
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,1.0f,1.0f,1.0f
            , Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(2500);
        image.startAnimation(scaleAnimation);

        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                overridePendingTransition(0,0);
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
