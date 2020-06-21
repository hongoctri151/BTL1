package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//giao dien ban dau
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SignUp(View view) {
        Intent sign_up=new Intent(this,signUp.class);// trang dang ky
        startActivity(sign_up);
    }


    public void Login(View view) {
        Intent mainMenu=new Intent(this,MainMenu.class);//trang account_menu
        startActivity(mainMenu);
    }

}