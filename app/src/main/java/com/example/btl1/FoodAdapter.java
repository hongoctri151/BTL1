package com.example.btl1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
//Adapter cua custom listview Food
public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonAn> monAnList;

    public FoodAdapter(Context context, int layout, List<MonAn> monAnList) {
        this.context = context;
        this.layout = layout;
        this.monAnList = monAnList;
    }

    @Override
    public int getCount() {
        return monAnList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        // Ánh xạ view
        TextView txtTen=(TextView) view.findViewById(R.id.textviewTen);
        TextView txtMota=(TextView) view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh=(ImageView) view.findViewById(R.id.imageviewHinh);
        //gán giá trị
        MonAn monAn=monAnList.get(i);
        txtTen.setText(monAn.getTen()) ;
        txtMota.setText(monAn.getMota());
        imgHinh.setImageResource(monAn.getHinh());
        return view;
    }
}
