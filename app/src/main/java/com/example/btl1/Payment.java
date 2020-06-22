package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//class hien thuc trang order
public class Payment extends AppCompatActivity {
    private TextView tvTotalPrice;
    private TextView tvSoluong;
    private TextView tvGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Bundle bd= getIntent().getExtras();
        tvGia=(TextView) findViewById(R.id.giatien);
        tvSoluong=(TextView) findViewById(R.id.soluong);

        if (bd!=null)
        {   String soLuong=bd.getString("NUMBER");

                tvSoluong.setText(soLuong);}

    }

    public void AccountMenu(View view) {
        Intent acc=new Intent(this,accountInfo.class);
        startActivity(acc);
    }

    public void Announcement(View view) {
        Intent avc=new Intent(this,AnnouncementMenu.class);
        startActivity(avc);
    }

    public void MainMenu(View view) {
        Intent a=new Intent(this,MainMenu.class);
        startActivity(a);
    }

    public void thanhtoantienmat(View view) {
        Intent tienmat=new Intent(this,OrderMenu.class);
        startActivity(tienmat);
    }
}