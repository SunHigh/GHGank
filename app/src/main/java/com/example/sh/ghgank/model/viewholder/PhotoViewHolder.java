package com.example.sh.ghgank.model.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sh.ghgank.R;
import com.example.sh.ghgank.model.Gank;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by sh_pc on 2016/6/13.
 */
public class PhotoViewHolder extends BaseViewHolder<Gank.Result>{
    private ImageView image;

    public PhotoViewHolder(ViewGroup parent) {
        super(parent, R.layout.photo_item);
        image = $(R.id.image);
    }
}
