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
    private Button datHang;
    int pos=0;
    String num;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthimonan);
        //Lay du lieu tu main menu
        Intent intent=getIntent();
        pos=intent.getExtras().getInt("POSITION");

        final FoodAdapter adapter=new FoodAdapter(this);
        final ImageView img=(ImageView) findViewById(R.id.imgid);
        final TextView price=(TextView) findViewById(R.id.price);

        img.setImageResource(adapter.Image[pos]);
        price.setText(String.valueOf(adapter.Price[pos]));
        number=(EditText) findViewById(R.id.txt_soluong);
        //truyen du lieu sang payment
       num=number.getText().toString();
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
        intent.putExtra("POSITION",pos);
        intent.putExtra("NUMBER",num);
        startActivity(intent);
    }
    public void thanhtoan(View view) {
        Intent abc=new Intent(this,OrderMenu.class);
        startActivity(abc);
    }
}