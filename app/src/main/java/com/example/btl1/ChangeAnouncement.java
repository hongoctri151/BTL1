package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChangeAnouncement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_anouncement);
    }



    public void Announcement(View view) {
        Intent Anouncemnet=new Intent(this,AnnouncementMenu.class);// trang dang ky
        startActivity(Anouncemnet);
    }
}