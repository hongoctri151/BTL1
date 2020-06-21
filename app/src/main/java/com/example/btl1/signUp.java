package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
// trang dang ky
public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void LoginMenu(View view) {
        //chuyen huong ve trang MainMenu
        Intent loginMenu=new Intent(this,MainActivity.class);//tro ve trang chinh
        startActivity(loginMenu);
    }

    public void turn(View view) {
        Intent turnLogin=new Intent(this,MainActivity.class);//tro ve trang chinh
        startActivity(turnLogin);
    }

    public void dangky(View view) {
        //Dang ky thanh thanh vien
        Intent dangky=new Intent(this,MainActivity.class);//tro ve trang chinh
        startActivity(dangky);
    }
}