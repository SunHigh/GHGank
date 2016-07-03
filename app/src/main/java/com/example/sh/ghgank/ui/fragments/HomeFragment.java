package com.example.sh.ghgank.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sh.ghgank.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sh on 2016/6/4.
 */
public class HomeFragment extends Fragment{
    private TabLayout mTablayout;
    private ViewPager mViewpager;
    private String[] mTitile = {"福利","Android","IOS","休息视频","拓展资源","瞎推荐"};
    private List<Fragment> mFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        mTablayout.setupWithViewPager(mViewpager);
        initEvent();
        return view;
    }

    private void initView(View view) {

        mViewpager = (ViewPager) view.findViewById(R.id.id_home_viewpager);
        mTablayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mFragment = new ArrayList<>();
        //        动态添加Fragment
        for (String title : mTitile){
            mFragment.add(Main_HomeFragment.getInstance(title));
        }

        mViewpager.setOffscreenPageLimit(4);
        //这里使用getChildFragmentManager可以解决TabLayout切换不自动回弹的问题
        mViewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitile[position];
            }

            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        });


    }

    private void initEvent() {
    }
}
