package com.example.rentalhouse;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rentalhouse.MODEL.ModelOwnerclass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupActivity extends AppCompatActivity {
    EditText mfullname,memail,mpassword,mconfirmpassword,mphone,mreferal;
    Button mregisterButton;
    TextView mlogintxt;
    FirebaseAuth auth;
    ProgressBar progressBar;
    FirebaseDatabase rootnode;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
       mfullname=findViewById(R.id.name);
       memail=findViewById(R.id.email);
       mpassword=findViewById(R.id.password);
       mconfirmpassword=findViewById(R.id.confirm_password);
       mphone=findViewById(R.id.phone_number);
       mreferal=findViewById(R.id.referal);
       mregisterButton=findViewById(R.id.btn_register);
       mlogintxt=findViewById(R.id.logintxt);
       progressBar=findViewById(R.id.progressbar);
       auth = FirebaseAuth.getInstance();




       mregisterButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               rootnode= FirebaseDatabase.getInstance();
               reference=rootnode.getReference("owner");
              // ownerclass ownerClass=new ownerclass();

               String email=memail.getText().toString().trim();
               String password=mpassword.getText().toString().trim();
               String  fname=mfullname.getText().toString().trim();
               String cnfrmpassword=mconfirmpassword.getText().toString().trim();
               String  phoneno=mphone.getText().toString().trim();
               String   referal=mreferal.getText().toString().trim();
               ModelOwnerclass ownerclass=new ModelOwnerclass(fname,email,password,cnfrmpassword,phoneno,referal);
               reference.child(phoneno).setValue(ownerclass);
               if (email.matches(emailpattern)){

               }else {
                   memail.setError("Invalid Email");
               }


               if(TextUtils.isEmpty( fname)){
                   mfullname.setError("Name is Required");
                   return;
               }
               if (phoneno.length()>=10){

               }else
               {
                   mphone.setError("Invalid phone number");
               }
               if(TextUtils.isEmpty(phoneno)){
                   mphone.setError("Phone number Required");
                   return;
               }
               if(TextUtils.isEmpty(cnfrmpassword)){
                   mconfirmpassword.setError("confirm Password Is required");
                   return;
               }
               if(!password.equals(cnfrmpassword)){
                   mconfirmpassword.setError("Password is not matching");
                   return;

               }
               if(TextUtils.isEmpty(password)){
                   mpassword.setError("Password is Required");
                   return;
               }
               if(password.length()<6){
                   mpassword.setError("Password must be > = six characters");
                   return;
               }
               progressBar.setVisibility(View.VISIBLE);
               auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(signupActivity.this,"User created",Toast.LENGTH_LONG).show();
                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                       }else{
                           Toast.makeText(signupActivity.this,"Error!!!"+ task.getException().getMessage(),Toast.LENGTH_LONG).show();
                           progressBar.setVisibility(View.GONE);

                       }
                   }
               });
           }
       });
        mlogintxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginPageActivity.class));
            }
        });
    }

    //public void ownerform(View view) {
        //startActivity(new Intent(getApplicationContext(),OwnerForm.class));


    }
