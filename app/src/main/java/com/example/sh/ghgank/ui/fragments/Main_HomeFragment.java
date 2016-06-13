package com.example.sh.ghgank.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sh.ghgank.R;

/**
 * Created by sh on 2016/6/7.
 */
public class Main_HomeFragment extends Fragment {
    private String title;
    private int page = 1;


    public static Main_HomeFragment getInstance(String title) {
        Main_HomeFragment mainFragment = new Main_HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        title = bundle.getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }
}
