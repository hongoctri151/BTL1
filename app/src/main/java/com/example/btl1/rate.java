package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
    }

    public void AccountMenu(View view) {
        Intent account=new Intent(this,accountInfo.class);
        startActivity(account);
    }

    public void thanhtoan(View view) {
        Intent intent=new Intent(this,OrderMenu.class);
        startActivity(intent);
    }

    public void Announcement(View view) {
        Intent intent=new Intent(this,AnnouncementMenu.class);
        startActivity(intent);
    }
}