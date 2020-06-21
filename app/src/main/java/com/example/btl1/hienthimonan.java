package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hienthimonan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthimonan);
    }

    public void Announcement(View view) {
        Intent intent=new Intent(this,AnnouncementMenu.class);
        startActivity(intent);
    }

    public void AccountMenu(View view) {
        Intent abc=new Intent(this,accountInfo.class);
        startActivity(abc);
    }

    public void thongtindonhang(View view) {
        Intent a=new Intent(this,OrderMenu.class);
        startActivity(a);
    }

    public void datmon(View view) {
        Intent datmon=new Intent(this,Payment.class);
        startActivity(datmon);
    }
}