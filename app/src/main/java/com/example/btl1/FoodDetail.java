package com.example.btl1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.FloatingActionButton;
import com.squareup.picasso.Picasso;

import Database.Database;
import Model.Order;

public class FoodDetail extends AppCompatActivity {
    TextView food_name,food_price,food_description,food_number;
    ImageView food_image;
    FloatingActionButton btnCart;
    String foodID="";
    Food currentFood;
    ElegantNumberButton numberButton;
    FirebaseDatabase database;
    DatabaseReference food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //Firebase
        database=FirebaseDatabase.getInstance();
        food=database.getReference("Food");

        btnCart=(FloatingActionButton) findViewById(R.id.btn_cart);


        numberButton=(ElegantNumberButton) findViewById(R.id.number_button);
        food_description=(TextView) findViewById(R.id.food_description);
        food_name=(TextView)findViewById(R.id.food_name);
        food_image=(ImageView) findViewById(R.id.food_image);
        food_price=(TextView) findViewById(R.id.food_price);

        if (getIntent()!=null)
        {
            foodID=getIntent().getStringExtra("FoodId");
            
        }
        
        if (!foodID.isEmpty())
        {
            getDetailFood(foodID);
        }

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new Database(getBaseContext()).addToCart(new Order(
                       foodID,
                       currentFood.getName(),
                       numberButton.getNumber(),
                       currentFood.getPrice(),
                       currentFood.getDescription()));
                Toast.makeText(FoodDetail.this,"Added to Cart",Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void getDetailFood(String foodID) {
        food.child(foodID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentFood=dataSnapshot.getValue(Food.class);

                Picasso.with(getBaseContext()).load(currentFood.getImage()).into(food_image);

                food_price.setText(currentFood.getPrice());
                food_name.setText(currentFood.getName());
                food_description.setText(currentFood.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}