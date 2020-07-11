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
        Intent home=new Intent(this,Home.class);
        startActivity(home);
    }

    public void Announcement(View view) {
        Intent Anouncemnet=new Intent(this,AnnouncementMenu.class);
        startActivity(Anouncemnet);
    }

    public void AnouncementSetting(View view) {
        Intent ChangeAnouncemnet=new Intent(this,ChangeAnouncement.class);
        startActivity(ChangeAnouncemnet);
    }

    public void ChangePassword(View view) {
        Intent ChangePassword=new Intent(this,ChangePassword.class);
        startActivity(ChangePassword);
    }
}