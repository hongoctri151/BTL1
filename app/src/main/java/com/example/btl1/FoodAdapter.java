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
    //private List<MonAn> monAnList;
    String FoodName[]={"Bánh cuốn","Bánh bao","Cơm sườn","Xôi","Bún"};
    int Price[]={15000,15000,25000,10000,25000};
    int Image[]={R.drawable.banhcuon,R.drawable.banhbao,R.drawable.comsuon,R.drawable.xoi,R.drawable.bun};
    String detail[]={"Bánh cuốn được làm từ bột gạo hấp tráng mỏng, cuộn tròn, bên trong độn nhân rau hoặc thịt",
            "Bánh bao trứng muối, có vỏ bánh thơm mùi sữa, nhân trứng muối chảy bùi bùi. Xứng đáng là món ngon cho khách hàng lựa chọn!",
            "Đĩa cơm sườn với sườn nướng, bì, chả, trứng, giúp bạn no bụng với đầy đủ chất dinh dưỡng!",
            "Xôi được làm từ gạo nếp dẻo, là món ăn không thể thiếu để giúp bạn nạp đầy dinh dưỡng",
            "Bún với sợi trắng mềm, ăn kèm rau thơm và thịt bò"
    };

    /*public FoodAdapter(Context context, int layout, List<MonAn> monAnList) {
        this.context = context;
        this.layout = layout;
        this.monAnList = monAnList;
    }*/
    public FoodAdapter (Context context)
    {
        this.context=context;
    }

    @Override
    public int getCount() {
        return FoodName.length;
    }

    @Override
    public Object getItem(int i) {
        return FoodName[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_mon_an, null);}
            // Ánh xạ view

            TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
            TextView txtMota = (TextView) view.findViewById(R.id.textviewMoTa);
            ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);
            //gán giá trị

        /*MonAn monAn=monAnList.get(i);
        txtTen.setText(monAn.getTen()) ;
        txtMota.setText(monAn.getMota());
        imgHinh.setImageResource(monAn.getHinh());*/

            txtTen.setText(FoodName[i]);
            txtMota.setText(String.valueOf(Price[i]));
            imgHinh.setImageResource(Image[i]);

        return view;
    }
}
