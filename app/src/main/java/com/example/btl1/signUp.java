package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void LoginMenu(View view) {
        Intent loginMenu=new Intent(this,MainActivity.class);//tro ve trang chinh
        startActivity(loginMenu);
    }

    public void turn(View view) {
        Intent turnLogin=new Intent(this,MainActivity.class);//tro ve trang chinh
        startActivity(turnLogin);
    }

    public void dangky(View view) {
        Intent dangky=new Intent(this,MainActivity.class);//tro ve trang chinh
        startActivity(dangky);
    }
}