package com.coder.usepicasso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class MainActivity extends Activity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= (ImageView) findViewById(R.id.full_image);

        //获取传递过来的imageUrl，并将image显示出来，注意设置placeholer
        Intent intent=getIntent();
        String imageUrl=intent.getExtras().getString("imageUrl");
        Picasso.with(MainActivity.this).load(imageUrl).placeholder(R.mipmap.image_placholder).error(R.mipmap.ic_launcher).into(imageView);

    }


}
