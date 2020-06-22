package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

// Class dieu khien hien thi thong tin mon an
public class hienthimonan extends AppCompatActivity {
    private EditText number;
    //private Button datHang;

    int pos=0;
    String num,price;
    final FoodAdapter adapter=new FoodAdapter(this);
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthimonan);
        //Lay du lieu tu main menu
        Intent intent=getIntent();
        pos=intent.getExtras().getInt("POSITION");

        final TextView FoodDetail = (TextView) findViewById(R.id.detail);
        final ImageView img=(ImageView) findViewById(R.id.imgid);
        final TextView price=(TextView) findViewById(R.id.price);

        img.setImageResource(adapter.Image[pos]);
        FoodDetail.setText(adapter.detail[pos]);
        price.setText(String.valueOf(adapter.Price[pos]));
        number=(EditText) findViewById(R.id.txt_soluong);
        //truyen du lieu sang payment


    }

    public void Announcement(View view) {
        Intent intent=new Intent(this,AnnouncementMenu.class);

        startActivity(intent);
    }

    public void AccountMenu(View view) {
        Intent abc=new Intent(this,accountInfo.class);
        startActivity(abc);
    }

    public void payment(View view){
        Intent intent=new Intent(hienthimonan.this,Payment.class);
        intent.putExtra("PRICE",String.valueOf(adapter.Price[pos]));
        intent.putExtra("NUMBER",number.getText().toString());
        intent.putExtra("POSITION",pos);
        startActivity(intent);
    }
    public void thanhtoan(View view) {
        Intent abc=new Intent(this,OrderMenu.class);
        startActivity(abc);
    }
}