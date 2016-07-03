package com.example.sh.ghgank.ui.activitys;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sh.ghgank.R;
import com.example.sh.ghgank.ui.fragments.HomeFragment;
import com.example.sh.ghgank.ui.fragments.InfoFragment;
import com.example.sh.ghgank.ui.fragments.MeFragment;
import com.example.sh.ghgank.ui.fragments.MessageFragment;
import com.example.sh.ghgank.utils.UnScrolledViewPager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UploadFileListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private UnScrolledViewPager mViewPager;
    private List<Fragment> mFragment;
    private RadioGroup mRadioGroup;
    private RadioButton rbt_home,
            rbt_message,
            rbt_me,
            rbt_info;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"3c427d2fe9e8a2de522054d704fc86c3");
        initView();
        initEvent();
    }

    private void initView() {
        mViewPager = (UnScrolledViewPager) findViewById(R.id.id_main_viewPager);
        mFragment = new ArrayList<>();
        Fragment fragment_home = new HomeFragment();
        Fragment fragment_info = new InfoFragment();
        Fragment fragment_message = new MessageFragment();
        Fragment fragment_me = new MeFragment();
        mFragment.add(fragment_home);
        mFragment.add(fragment_info);
        mFragment.add(fragment_message);
        mFragment.add(fragment_me);

        rbt_home = (RadioButton) findViewById(R.id.rbtn_home);
        rbt_info = (RadioButton) findViewById(R.id.rbtn_info);
        rbt_me = (RadioButton) findViewById(R.id.rbtn_me);
        rbt_message = (RadioButton) findViewById(R.id.rbtn_message);
    }
    private void initEvent() {
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        });

        rbt_home.setOnClickListener(this);
        rbt_info.setOnClickListener(this);
        rbt_message.setOnClickListener(this);
        rbt_me.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbtn_home:mViewPager.setCurrentItem(0);
                break;
            case R.id.rbtn_info:mViewPager.setCurrentItem(1);
                break;
            case R.id.rbtn_message:mViewPager.setCurrentItem(2);
                break;
            case R.id.rbtn_me:mViewPager.setCurrentItem(3);
                break;

        }
    }

}
