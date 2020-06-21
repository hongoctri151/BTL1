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
        arrayMonAn.add(new MonAn("Bánh Cuốn","Bánh cuốn nóng",R.drawable.banhcuon));
        arrayMonAn.add(new MonAn("Bánh Bao","Bánh bao nóng",R.drawable.banhbao));
        arrayMonAn.add(new MonAn("Cơm sườn","Cơm sườn giá rẻ",R.drawable.comsuon));
        arrayMonAn.add(new MonAn("Xôi","Xôi nước cốt dừa",R.drawable.xoi));
        arrayMonAn.add(new MonAn("Bún","Bún bò Huế",R.drawable.bun));
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