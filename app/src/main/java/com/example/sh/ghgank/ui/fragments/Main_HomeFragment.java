package com.example.sh.ghgank.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

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
}
