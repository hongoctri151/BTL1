package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import Interface.ItemClickListener;
import ViewHolder.FoodViewHolder;
import ViewHolder.MenuViewHolder;

public class DeleteFood extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference category;
    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Category,MenuViewHolder> adapter;
    TextView LV;
    Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_food);

        database=FirebaseDatabase.getInstance();
        category=database.getReference().child("Food");
        del=(Button)findViewById(R.id.delete);
        //Load Menu
        recycler_menu=(RecyclerView)findViewById(R.id.recycle_menu);
        recycler_menu.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler_menu.setLayoutManager(layoutManager);

        loadMenu();
    }

    private void loadMenu() {
        adapter=new FirebaseRecyclerAdapter<Category, MenuViewHolder>(Category.class,R.layout.menu_item,MenuViewHolder.class,category)
        {
            @Override
            protected void populateViewHolder(final MenuViewHolder menuViewHolder, Category model, int position) {
                menuViewHolder.txtMenuName.setText(model.getName());

                Picasso.with(getBaseContext()).load(model.getImage()).into(menuViewHolder.imageView);

                final Category clickItem=model;
                menuViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, final int position, boolean isLongClick) {
                        final String name=adapter.getItem(position).getName();
                        Toast.makeText(DeleteFood.this,"Bạn đã chọn món "+name,Toast.LENGTH_LONG).show();
                        //Intent foodList=new Intent(DeleteFood.this,UpdateMenu.class);
                        del.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                adapter.getRef(position).removeValue();
                                Toast.makeText(DeleteFood.this,"Bạn đã xóa món "+name,Toast.LENGTH_LONG).show();
                                Intent foodList=new Intent(DeleteFood.this,UpdateMenu.class);

                                startActivity(foodList);

                            }
                        });
                       // startActivity(foodList);
                    }

                });
            }
        };
        recycler_menu.setAdapter(adapter);

    }
}