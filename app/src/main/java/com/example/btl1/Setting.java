package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void MainMenu(View view) {
        Intent home=new Intent(this,MainMenu.class);// trang dang ky
        startActivity(home);
    }

    public void Announcement(View view) {
        Intent Anouncemnet=new Intent(this,AnnouncementMenu.class);// trang dang ky
        startActivity(Anouncemnet);
    }
}