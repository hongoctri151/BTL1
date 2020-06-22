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
        Intent receiveData=getIntent();

        tvTotalPrice=(TextView) findViewById(R.id.tong);
        tvGia=(TextView) findViewById(R.id.giatien);
        tvSoluong=(TextView) findViewById(R.id.soluong);

       String number=receiveData.getStringExtra("NUMBER");
       String price=receiveData.getStringExtra("PRICE");

       tvGia.setText(price);
       tvSoluong.setText(number);

       int intGia=Integer.parseInt(price);
       int intSoluong=Integer.parseInt(number);

       int Total=intGia*intSoluong;

       tvTotalPrice.setText(String.valueOf(Total));
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

    public void thanhtoan(View view) {
        Intent a=new Intent(this,OrderMenu.class);
        startActivity(a);
    }
}