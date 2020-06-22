package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
//main menu sau khi dang nhap
public class MainMenu extends AppCompatActivity {
    ListView lvMonAn;
    ArrayList<MonAn> arrayMonAn;
    FoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        AnhXa();
        adapter=new FoodAdapter(this,R.layout.dong_mon_an,arrayMonAn);
        lvMonAn.setAdapter(adapter);
        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1)
                {Intent FoodDetail=new Intent(MainMenu.this,hienthimonan.class);
                startActivity(FoodDetail);}
            }
        });

    }
    private void AnhXa(){
        lvMonAn=(ListView) findViewById(R.id.listviewMonAn);
        arrayMonAn=new ArrayList<>();
        arrayMonAn.add(new MonAn("Bánh Cuốn","Giá tiền: 15.000đ",R.drawable.banhcuon));
        arrayMonAn.add(new MonAn("Bánh Bao","Giá tiền: 15.000đ",R.drawable.banhbao));
        arrayMonAn.add(new MonAn("Cơm sườn","Giá tiền: 20.000đ",R.drawable.comsuon));
        arrayMonAn.add(new MonAn("Xôi","Giá tiền: 15.000đ",R.drawable.xoi));
        arrayMonAn.add(new MonAn("Bún","Giá tiền: 20.000đ",R.drawable.bun));
    }
    public void OrderMenu(View view) {
        Intent intent=new Intent(this,OrderMenu.class);// trang dang ky
        startActivity(intent);
    }

    public void Announcement(View view) {
        Intent intent=new Intent(this,AnnouncementMenu.class);// trang dang ky
        startActivity(intent);
    }

    public void AccountMenu(View view) {
        Intent intent=new Intent(this,accountInfo.class);// trang dang ky
        startActivity(intent);
    }
}