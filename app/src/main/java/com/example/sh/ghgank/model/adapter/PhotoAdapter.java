package com.example.sh.ghgank.model.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.sh.ghgank.model.Gank;
import com.example.sh.ghgank.model.viewholder.PhotoViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by sh_pc on 2016/6/13.
 */

public class PhotoAdapter extends RecyclerArrayAdapter<Gank.Result>{
    public PhotoAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotoViewHolder(parent);
    }

}
