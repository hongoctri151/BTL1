package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }



    public void Announcement(View view) {
        Intent Anouncement=new Intent(this,AnnouncementMenu.class);// trang chu
        startActivity(Anouncement);
    }
}