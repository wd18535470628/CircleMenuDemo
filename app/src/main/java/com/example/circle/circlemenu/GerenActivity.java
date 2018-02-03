package com.example.circle.circlemenu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

import com.Adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import Bean.GeRen;

public class GerenActivity extends Activity {
    private ListView listView;
    private List<GeRen> list;
    private GeRen geren;
    private ImageView back_image;
    private int[] images = new int[]{R.drawable.matched_perfect_icon,R.drawable.matched_perfect_icon,R.drawable.matched_perfect_icon
    ,R.drawable.matched_perfect_icon};
    private String[] titles = new String[]{"个人资料","意见反馈","检查更新","帮助"};
    private int[] goImages = new int[]{R.drawable.nim_arrow_right,R.drawable.nim_arrow_right,R.drawable.nim_arrow_right,R.drawable.nim_arrow_right};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_geren);

        initData();
        initView();

    }
    public void initView(){
        MyAdapter adapter = new MyAdapter(GerenActivity.this,R.layout.geren_item,list);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        back_image = (ImageView) findViewById(R.id.back_image);
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GerenActivity.this,CircleActivity.class));
                finish();
            }
        });
    }
    public void initData(){
        list = new ArrayList<GeRen>();
        for (int i = 0;i<titles.length;i++){
            geren = new GeRen(images[i],titles[i],goImages[i]);
            list.add(geren);
        }
    }
}
