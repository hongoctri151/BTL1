package com.example.btl1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

import Model.User;
import Model.cook;
import dmax.dialog.SpotsDialog;

public class AddFood extends AppCompatActivity {

    private Button themMon,folder;
    private EditText tenMon,giaMon;
    private ImageView image;
    private int REQUEST_CODE_FOLDER = 123;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    private String link;
    AlertDialog waiting;
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    final DatabaseReference table_food=database.getReference().child("Food");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        final StorageReference storageRef=storage.getReferenceFromUrl("gs://smart-food-court-system-db466.appspot.com");
        AnhXa();
        waiting=new SpotsDialog.Builder().setContext(this).setMessage("Vui lòng đợi").setCancelable(false).build();

        folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_FOLDER);
            }
        });

        themMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(AddFood.this);
                mDialog.setMessage("Vui lòng đợi trong giây lát ...");
                mDialog.show();
                waiting.show();


                        final String name= tenMon.getText().toString();
                        final String price=giaMon.getText().toString();
                        final String menuID="00";
                        final String des="Món mới";
                        if(name.isEmpty()||price.isEmpty()){
                            waiting.dismiss();
                            Toast.makeText(AddFood.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            image.setDrawingCacheEnabled(true);
                            image.buildDrawingCache();
                            Calendar calendar = Calendar.getInstance();
                            final String tenhinh = "image" + calendar.getTimeInMillis();
                            final StorageReference mountainsref = storageRef.child(tenhinh + ".png");
                            Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                            byte[] data = baos.toByteArray();
                            final UploadTask uploadTask = mountainsref.putBytes(data);
                            uploadTask.addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    // Handle unsuccessful uploads
                                }
                            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    // get downloadUrl
                                    Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                        @Override
                                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                            if (!task.isSuccessful()) {
                                                throw task.getException();
                                            }
                                            link = mountainsref.getDownloadUrl().toString();
                                            // Continue with the task to get the download URL
                                            return mountainsref.getDownloadUrl();
                                        }
                                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Uri> task) {
                                            if (task.isSuccessful()) {
                                                waiting.dismiss();
                                                link = task.getResult().toString();
                                            }
                                        }
                                    });
                                }
                            });
                            table_food.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Food food = new Food(des, link, menuID, name, price);

                                    table_food.child(menuID).setValue(food);
                                    Toast.makeText(AddFood.this, "Thêm món ăn thành công", Toast.LENGTH_SHORT).show();
                                    finish();
                                    startActivity(new Intent(AddFood.this, UpdateMenu.class));
                                }




                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }

                            });
                        }

                        }


                });
            }







    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                image.setImageBitmap(bitmap);
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void AnhXa(){
        themMon = findViewById(R.id.btnThemMonLayoutThemMon);
        folder  = findViewById(R.id.btnfolder);
        tenMon  = findViewById(R.id.edtTenMon);
        giaMon  = findViewById(R.id.edtGiaMon);
        image   = findViewById(R.id.ivImage);
    }
    public void updatemenu(View view) {
        Intent intent=new Intent(this,UpdateMenu.class);// trang dang ky
        startActivity(intent);
    }
    public void OrderMenu(View view) {
        Intent intent=new Intent(this,MainActivity.class);// trang dang ky
        startActivity(intent);
    }



    public void AccountMenu(View view) {
        Intent intent=new Intent(this,menu_list.class);// trang dang ky
        startActivity(intent);
    }

    public void order(View view) {
        Intent intent=new Intent(this,Order.class);// trang dang ky
        startActivity(intent);
    }
}