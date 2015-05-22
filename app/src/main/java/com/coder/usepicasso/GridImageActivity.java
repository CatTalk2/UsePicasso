package com.coder.usepicasso;

/**
 * Created by QiWangming on 2015/5/22.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class GridImageActivity extends Activity {

    private ImageAdapter adapter;
    private GridView gridView;
    private ArrayList<String> urls=new ArrayList<>();
    private final String baseUrl="http://www.jycoder.com/json/Image/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);


        gridView= (GridView) findViewById(R.id.grid_view);

        //Õº∆¨Urlµÿ÷∑
        for(int i=1;i<=18;i++){
            urls.add(baseUrl+i+".jpg");
        }

        adapter=new ImageAdapter(GridImageActivity.this,urls);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(GridImageActivity.this,MainActivity.class);
                intent.putExtra("imageUrl",urls.get(i));
                startActivity(intent);
            }
        });
    }
}
