package com.example.btl1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mancj.materialsearchbar.MaterialSearchBar;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import Adapter.FoodAdapter_c;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SearchFood extends AppCompatActivity {
    MaterialSearchBar materialSearchBar;
    ListView lvFood;
    ArrayList<Food> arrFood;
    ArrayList<Food> arrFoodSearch;
    FoodAdapter_c adapter = null;
    FoodAdapter_c adapterSearch = null;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String userID = user.getUid();
    DatabaseReference mDatabase;
    ArrayList<String> suggestList = new ArrayList<>();

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Note  add this code before setcontentView
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Rubik.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        setContentView(R.layout.activity_search_food);
        //Tìm kiếm
        materialSearchBar = (MaterialSearchBar)findViewById(R.id.searchBar);
        materialSearchBar.setHint("Nhập tên món ăn");
        // end tiem kiem
        lvFood  =   (ListView) findViewById(R.id.listview_food);
        arrFood = new ArrayList<>();
        adapter = new FoodAdapter_c( arrFood,getApplicationContext());
        arrFoodSearch = new ArrayList<>();
        adapterSearch = new FoodAdapter_c(arrFoodSearch,getApplicationContext());

        loadDataAllFood();
        loadSuggest();
        materialSearchBar.setLastSuggestions(suggestList);
        materialSearchBar.setCardViewElevation(10);
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //Khi người dùng nhập vào SearchBar danh sách gợi ý sẽ thay đổi theo.
                ArrayList<String> suggest = new ArrayList<String>();
                for(String search:suggestList){ // Vòng lặp suggetList
                    if(search.toLowerCase().contains(materialSearchBar.getText().toLowerCase()))
                        suggest.add(search);
                }
                materialSearchBar.setLastSuggestions(suggest);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                //Khi Search Bar bị đóng
                //Khôi phục adapter ban đầu
                if(!enabled) {
                    //lvFood.setAdapter(adapter);
                    lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                            //position là vi tri tren listview
                            Food foodSearch = arrFood.get(position);
                            Intent foodDetail = new Intent(SearchFood.this,FoodDetail.class);
                            //gửi FoodId (ten của Food) và id quán đến activity FoodDetail
                            foodDetail.putExtra("FoodID",foodSearch.getMenuID());

                            // mở activity  foodDetail
                            startActivity(foodDetail);
                        }
                    });
                    lvFood.setAdapter((ListAdapter) adapter);

                    arrFoodSearch.clear();
                }
            }

            @Override
            public void onSearchConfirmed(final CharSequence text) {
                //Khi Search hoàn tất
                //hiển thị kết quả của searchAdapter
                startSearch(text);
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });


    }

    private void startSearch(final CharSequence text) {

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Food");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    for(DataSnapshot ds1: ds.getChildren()){
                        Food mon = ds1.getValue(Food.class);
                        if(mon.getName().equals(text.toString())){
                            arrFoodSearch.add(new Food(mon.getDescription(),mon.getImage(),mon.getMenuID(),mon.getName(),mon.getPrice()));
                            adapterSearch.notifyDataSetChanged();
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NotNull DatabaseError databaseError) {

            }
        };
        mDatabase.addListenerForSingleValueEvent(eventListener);


        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //position là vi tri tren listview
                Food foodSearch = arrFoodSearch.get(position);
                Intent foodDetail = new Intent(SearchFood.this,FoodDetail.class);
                //gửi FoodId (ten của Food) và id quán đến activity FoodDetail
                foodDetail.putExtra("FoodID",foodSearch.getMenuID());

                // mở activity  foodDetail
                startActivity(foodDetail);
            }
        });
        lvFood.setAdapter((ListAdapter) adapterSearch);


    }

    private  void loadDataAllFood(){

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Food");

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    for(DataSnapshot ds1: ds.getChildren()){
                        Food mon = ds1.getValue(Food.class);
                        arrFoodSearch.add(new Food(mon.getDescription(),mon.getImage(),mon.getMenuID(),mon.getName(),mon.getPrice()));
                        adapter.notifyDataSetChanged();
                    }
                }


                lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        //position là vi tri tren listview
                        Food food = arrFood.get(position);
                        Intent foodDetail = new Intent(SearchFood.this,FoodDetail.class);
                        //gửi FoodId (ten của Food) và id quán đến activity FoodDetail
                        foodDetail.putExtra("FoodID",food.getName());

                        // mở activity  foodDetail
                        startActivity(foodDetail);
                    }
                });
                lvFood.setAdapter((ListAdapter) adapter);

            }

            @Override
            public void onCancelled(@NotNull DatabaseError databaseError) {

            }
        };
        mDatabase.addListenerForSingleValueEvent(eventListener);




    }

    private void loadSuggest() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Food");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds :dataSnapshot.getChildren())
                {
                    for(DataSnapshot ds1: ds.getChildren()) {
                        Food food = ds1.getValue(Food.class);
                        suggestList.add(food.getName()); //Thêm tên món ăn vào danh sách gợi ý
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }






}