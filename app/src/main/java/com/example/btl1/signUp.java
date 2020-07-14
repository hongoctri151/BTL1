package com.example.btl1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.User;

// trang dang ky
public class signUp extends AppCompatActivity {
    Button btnSignUp;
    EditText name,passWord,phone,email;
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    final DatabaseReference table_user=database.getReference("User");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /***************************/
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        name=(EditText)findViewById(R.id.edtName);
        passWord=(EditText)findViewById(R.id.edtPassword);
        email=(EditText)findViewById(R.id.edtMail);
        phone=(EditText)findViewById(R.id.edtPhone);

        /***************************/
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(signUp.this);
                mDialog.setMessage("Vui lòng đợi trong giây lát ...");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(phone.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(signUp.this,"Số điện thoại đã tồn tại",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            User user=new User(name.getText().toString(),passWord.getText().toString());
                            table_user.child(phone.getText().toString()).setValue(user);
                            Toast.makeText(signUp.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }


    public void LoginMenu(View view) {
        //chuyen huong ve trang MainMenu
        Intent loginMenu=new Intent(this,MainActivity.class);//tro ve trang chinh
        startActivity(loginMenu);
    }

    public void turn(View view) {
        Intent turnLogin=new Intent(this,MainActivity.class);//tro ve trang chinh
        startActivity(turnLogin);
    }


}