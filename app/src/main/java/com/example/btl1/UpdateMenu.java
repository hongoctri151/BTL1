package com.example.btl1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.FoodAdapter_c;
import Model.cook;

public class UpdateMenu extends AppCompatActivity {
    Button btnDel,btnAdd,btnChange;
    RecyclerView recyclerView;
    ArrayList<com.example.btl1.Food> arrFood= new ArrayList<>();
    FoodAdapter_c viewFoodAdapter;
    com.example.btl1.Food Food;
    Query mDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);
        khoitaoMenu();




        btnDel=(Button)findViewById(R.id.btn_del);
        btnAdd=(Button)findViewById(R.id.btn_add);
        btnChange=(Button)findViewById(R.id.btn_up);





    }

    public void addFood(View view) {
        Intent intent=new Intent(this, AddFood.class);// trang dang ky
        startActivity(intent);
    }
    public void updatemenu(View view) {
        Intent intent=new Intent(this, cook.class);// trang dang ky
        startActivity(intent);
    }
    public void OrderMenu(View view) {
        Intent intent=new Intent(this, MainActivity.class);// trang dang ky
        startActivity(intent);
    }



    public void AccountMenu(View view) {
        Intent intent=new Intent(this, menu_list.class);// trang dang ky
        startActivity(intent);
    }
    public void update(View view) {
        Intent intent=new Intent(this, update_food.class);// trang dang ky
        startActivity(intent);
    }

    public void order(View view) {
        Intent intent=new Intent(this, Order.class);// trang dang ky
        startActivity(intent);
    }
    public void backto(View view) {
        Intent intent=new Intent(this, cook.class);// trang dang ky
        startActivity(intent);
    }
    private void khoitaoMenu() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_food);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Food");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (dataSnapshot.getValue() != null) {
                        Food = ds.getValue(com.example.btl1.Food.class);
                        arrFood.add(Food);
                    }
                }
                final FoodAdapter_c viewFoodAdapter = new FoodAdapter_c(arrFood, getApplicationContext());
                recyclerView.setAdapter(viewFoodAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}