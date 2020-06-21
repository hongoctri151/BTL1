package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// Class dieu khien hien thi thong tin mon an
public class hienthimonan extends AppCompatActivity {
    private EditText soLuong;
    private TextView gia;
    private Button datHang;
    public static final String Price="price";


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthimonan);
        soLuong=(EditText) findViewById(R.id.txt_soluong);

        gia = (TextView) findViewById(R.id.txt_giatien);
        Bundle bd= getIntent().getExtras();

        datHang=(Button) findViewById(R.id.btnDatmon);
        datHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent=new Intent(hienthimonan.this,Payment.class);
            intent.putExtra("NUMBER",soLuong.getText().toString());

            startActivity(intent);
            }
        });
    }

    public void Announcement(View view) {
        Intent intent=new Intent(this,AnnouncementMenu.class);

        startActivity(intent);
    }

    public void AccountMenu(View view) {
        Intent abc=new Intent(this,accountInfo.class);
        startActivity(abc);
    }



}