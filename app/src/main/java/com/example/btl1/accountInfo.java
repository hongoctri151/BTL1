package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//Class dieu khien hien thi thong tin o trang Account
public class accountInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
    }



    public void OrderMenu(View view) {
        Intent intent=new Intent(this,OrderMenu.class);// trang chu
        startActivity(intent);
    }

    public void Announcement(View view) {
        Intent intent=new Intent(this,AnnouncementMenu.class);// trang chu
        startActivity(intent);
    }

    public void Mainactivity(View view) {
        Intent Logout=new Intent(this,MainActivity.class);// trang chu
        startActivity(Logout);
    }

    public void AccountMenu(View view) {
        Intent intent=new Intent(this,accountInfo.class);// trang chu
        startActivity(intent);
    }

    public void Setting(View view) {
        Intent Setting=new Intent(this,Setting.class);// trang chu
        startActivity(Setting);
    }


    public void Help(View view) {
        Intent help=new Intent(this,Help.class);// trang chu
        startActivity(help);
    }
}