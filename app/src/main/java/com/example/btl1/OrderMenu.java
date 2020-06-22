package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
// class hien thuc trang order
public class OrderMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_menu);
    }

    public void Announcement(View view) {
        Intent intent=new Intent(this,AnnouncementMenu.class);// trang dang ky
        startActivity(intent);
    }
    public void MainMenu(View view) {
        Intent intent=new Intent(this,MainMenu.class);// trang dang ky
        startActivity(intent);
    }


    public void AccountMenu(View view) {
        Intent intent=new Intent(this,accountInfo.class);// trang dang ky
        startActivity(intent);
    }


    public void thanhtoan(View view) {
        Intent thanhtoan=new Intent(this,rate.class);// trang dang ky
        startActivity(thanhtoan);
    }
}