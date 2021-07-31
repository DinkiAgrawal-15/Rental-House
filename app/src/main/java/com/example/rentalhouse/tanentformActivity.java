package com.example.rentalhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rentalhouse.MODEL.ModelTanentclass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tanentformActivity extends AppCompatActivity {
    EditText tname, temail, tphone, toccupation, taddress;
    Button btn_register;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanentform);
        tname = findViewById(R.id.name);
        temail=findViewById(R.id.email);
        tphone = findViewById(R.id.phone);
        toccupation = findViewById(R.id.occupation);
        taddress = findViewById(R.id.address);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ownerclass ownerClass=new ownerclass();

                String name = tname.getText().toString().trim();
                String email = temail.getText().toString().trim();
                String phone = tphone.getText().toString().trim();
                String occupation = toccupation.getText().toString().trim();
                String address = taddress.getText().toString().trim();
                if (email.matches(emailpattern)) {

                } else {
                    temail.setError("Invalid");
                }
                if (TextUtils.isEmpty(name)) {
                    tname.setError("Name is Required");
                    return;
                }
                if (phone.length() >= 10) {

                } else {
                    tphone.setError("Invalid phone number");
                }
                if (TextUtils.isEmpty(phone)) {
                    tphone.setError("Phone number Required");
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    taddress.setError("Address is Required");
                    return;
                }
                if (TextUtils.isEmpty(occupation)) {
                    toccupation.setError("occupation is Required");
                    return;
                }

                ModelTanentclass ModelTanentclass = new ModelTanentclass(name, email, phone, occupation, address);
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("tanent");
                reference.child(phone).setValue(ModelTanentclass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                                       startActivity(new Intent(getApplicationContext(), propertylistActivity.class));

                    }
                });
            }
        });
    }
}