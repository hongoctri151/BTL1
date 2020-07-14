package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class update_food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_food);
    }
    public void backtomain(View view) {
        Intent intent=new Intent(this, UpdateMenu.class);// trang dang ky
        startActivity(intent);
    }
}