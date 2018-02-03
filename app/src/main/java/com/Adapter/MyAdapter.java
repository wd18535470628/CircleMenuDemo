package com.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.circle.circlemenu.R;

import java.util.List;

import Bean.GeRen;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class MyAdapter extends BaseAdapter{
    private int resourceId;
    private List<GeRen> list;
    private Context context;
    public MyAdapter(Context context, int ResourceId, List<GeRen> object){
        this.resourceId = ResourceId;
        this.context = context;
        this.list = object;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GeRen geRen = list.get(position);
        View view = View.inflate(context,resourceId,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.logo_image);
        imageView.setImageResource(geRen.getLogoimageId());
        TextView textView = (TextView) view.findViewById(R.id.geren_title);
        textView.setText(geRen.getName());
        ImageView goimageView = (ImageView) view.findViewById(R.id.go_image);
        goimageView.setImageResource(geRen.getGoImageid());
        return view;
    }
}
