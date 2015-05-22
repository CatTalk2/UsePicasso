package com.coder.usepicasso;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by QiWangming on 2015/5/22.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;

    //传入图片url地址（多张图片）
    private ArrayList<String> urls;

    public ImageAdapter(Context context,ArrayList<String> urls) {
        this.context = context;
        this.urls=urls;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView=new ImageView(context);

        Picasso.with(context).load(urls.get(i)).placeholder(R.mipmap.image_placholder).error(R.mipmap.ic_launcher).into(imageView);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(280, 280));

        return imageView;
    }
}
