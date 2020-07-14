package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddFood extends AppCompatActivity {
    private Button  themMon,folder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
    }
    public void updatemenu(View view) {
        Intent intent=new Intent(this,UpdateMenu.class);// trang dang ky
        startActivity(intent);
    }
    public void OrderMenu(View view) {
        Intent intent=new Intent(this,MainActivity.class);// trang dang ky
        startActivity(intent);
    }



    public void AccountMenu(View view) {
        Intent intent=new Intent(this,menu_list.class);// trang dang ky
        startActivity(intent);
    }

    public void order(View view) {
        Intent intent=new Intent(this,Order.class);// trang dang ky
        startActivity(intent);
    }
}