package com.example.btl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//giao dien ban dau
public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private String checkUserName="hvtinh1";
    private String checkPassword="123456";
    private EditText edPassword;
    private EditText edUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=(Button) findViewById(R.id.btnLogin);
        edPassword=(EditText) findViewById(R.id.password);
        edUsername=(EditText)findViewById(R.id.username);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edUsername.getText().toString().equals(checkUserName)) {
                    if (edPassword.getText().toString().equals(checkPassword)) {
                        Intent intent=new Intent(MainActivity.this,MainMenu.class);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Bạn đã nhập sai mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Người dùng không tồn tại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void SignUp(View view) {
        Intent sign_up=new Intent(this,signUp.class);// trang dang ky
        startActivity(sign_up);
    }



    public void Cook(View view) {
        Intent mainMenu=new Intent(this,cook.class);//trang account_menu
        startActivity(mainMenu);
    }
}