package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class cook extends AppCompatActivity {
        ListView lvMonAn;
        ArrayList<MonAn> arrayMonAn;
        FoodAdapter adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_cook);
                lvMonAn=(ListView)findViewById(R.id.listviewMonAn);
                final FoodAdapter adapter=new FoodAdapter(this);
                //adapter=new FoodAdapter(this,R.layout.dong_mon_an,arrayMonAn);

                lvMonAn.setAdapter(adapter);


        }

        public void updatemenu(View view) {
                Intent intent=new Intent(this,UpdateMenu.class);// trang dang ky
                startActivity(intent);
        }

}