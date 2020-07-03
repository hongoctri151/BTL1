package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
    }

    public void MainMenu(View view) {
        Intent home=new Intent(this,MainMenu.class);
        startActivity(home);
    }

    public void Announcement(View view) {
        Intent Anouncement=new Intent(this,AnnouncementMenu.class);
        startActivity(Anouncement);
    }
}