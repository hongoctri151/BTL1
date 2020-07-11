package com.example.btl1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Adapter.FoodAdapter_c;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class menu_list extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<com.example.btl1.Food> arrFood= new ArrayList<>();
    FoodAdapter_c viewFoodAdapter;
    com.example.btl1.Food Food;
    Query mDatabase;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        khoitaoMenu();
    }
   /* public static void runAnimation(RecyclerView recyclerView){
        LayoutAnimationController controller =null;
        controller = AnimationUtils.loadLayoutAnimation(recyclerView.getContext(),R.anim)
    }*/

    private void khoitaoMenu() {
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_food);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Food");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    if(dataSnapshot.getValue() != null){
                        Food=ds.getValue(com.example.btl1.Food.class);
                        arrFood.add(Food);
                    }
                }
                final FoodAdapter_c viewFoodAdapter = new FoodAdapter_c(arrFood,getApplicationContext());
                recyclerView.setAdapter(viewFoodAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}