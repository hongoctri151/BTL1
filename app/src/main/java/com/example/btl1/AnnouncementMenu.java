package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//Class dieu khien hien thi thong tin o trang Thong bao
public class AnnouncementMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_menu);
    }
    public void OrderMenu(View view) {
        Intent intent=new Intent(this,OrderMenu.class);// trang dang ky
        startActivity(intent);
    }
    public void AccountMenu(View view) {
        Intent intent=new Intent(this,accountInfo.class);// trang dang ky
        startActivity(intent);
    }




    public void Announcement(View view) {
        Intent intent=new Intent(this,AnnouncementMenu.class);// trang dang ky
        startActivity(intent);
    }

    public void thanhtoan(View view) {
        Intent intent=new Intent(this,OrderMenu.class);// trang dang ky
        startActivity(intent);
    }
}