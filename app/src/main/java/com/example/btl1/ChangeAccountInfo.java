package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChangeAccountInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_account_info);
    }



    public void Announcement(View view) {
        Intent Anouncement=new Intent(this,AnnouncementMenu.class);
        startActivity(Anouncement);
    }
}