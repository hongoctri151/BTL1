package com.example.btl1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.User;
import Model.cook;

//giao dien ban dau
public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnSignUp;

    private EditText edtPassword;
    private EditText edtPhone;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference table_user=database.getReference("User");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=(Button) findViewById(R.id.btnLogin);
        edtPassword=(EditText) findViewById(R.id.password);
        edtPhone=(EditText)findViewById(R.id.phone);
        btnSignUp=(Button) findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(MainActivity.this);
                mDialog.setMessage("Vui lòng đợi trong giây lát...");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {


                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);

                            mDialog.dismiss();
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(MainActivity.this,Home.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Người dùng không tồn tại",Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,signUp.class);
                startActivity(intent);
            }
        });



    }




    public void Cook(View view) {
        Intent mainMenu=new Intent(this, cook.class);//trang account_menu
        startActivity(mainMenu);
    }
}