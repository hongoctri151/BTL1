package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

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

import Model.cook;

public class UpdateMenu extends AppCompatActivity {
    Button btnDel,btnAdd,btnChange;
    ListView lvMonAn;
    // ArrayList<MonAn> arrayMonAn;
    FoodAdapter adapter;
    EditText editText;
    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);
        lvMonAn=(ListView)findViewById(R.id.listviewMonAn);
        final FoodAdapter adapter=new FoodAdapter(this);
        //adapter=new FoodAdapter(this,R.layout.dong_mon_an,arrayMonAn);

        lvMonAn.setAdapter(adapter);

        btnDel=(Button)findViewById(R.id.btn_del);
        btnAdd=(Button)findViewById(R.id.btn_add);
        btnChange=(Button)findViewById(R.id.btn_up);
        editText=(EditText)findViewById(R.id.ed_search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                searchItem(charSequence.toString());

            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(UpdateMenu.this,adapter.getItem(i).toString(),Toast.LENGTH_SHORT).show();
                vitri=i;
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapter.notifyDataSetChanged();
            }
        });

    }
    private void searchItem(String toString) {

        for(int i=0;i<adapter.getCount(); i=i+1) {
            if (!(adapter.getItem(i).toString().contains(toString.toLowerCase()))) {
                Toast.makeText(UpdateMenu.this,adapter.getItem(i).toString(),Toast.LENGTH_SHORT).show();
            }

        }
        adapter.notifyDataSetChanged();
    }


    public void backto(View view) {
        Intent intent=new Intent(this, cook.class);// trang dang ky
        startActivity(intent);
    }

}