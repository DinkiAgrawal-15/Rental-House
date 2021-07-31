package com.example.rentalhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rentalhouse.MODEL.OwnerFormModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OwnerFormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    TextView ownerreg1,ownersnap;
    String[] prop= {"NONE","1BHK","2BHK","Single Room"};
    Spinner tspinner;
    EditText twhatsapp,tphone,taddress,tpincode,tcity,tdistrict,tlandmark,trent;
    RadioButton tFamily,tbech;
    CheckBox tc1,tc2,tc3;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_form);
        twhatsapp=findViewById(R.id.whatsapp);
        tphone=findViewById(R.id.phone);
        taddress=findViewById(R.id.address);
        tpincode=findViewById(R.id.pincode);
        tcity=findViewById(R.id.city);
        tdistrict=findViewById(R.id.district);
        tlandmark=findViewById(R.id.landmark);
        trent=findViewById(R.id.rent);
        tc1=findViewById(R.id.c1);
        tc2=findViewById(R.id.c2);
        tc3=findViewById(R.id.c3);
        tFamily=findViewById(R.id.family);
        tbech=findViewById(R.id.bach);
        tspinner = findViewById(R.id.spinner);
        ownersnap=findViewById(R.id.ownersnap);
        tspinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,prop);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tspinner.setAdapter(aa);
        ownersnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String whatsapp =twhatsapp.getText().toString().trim();
                String address=taddress.getText().toString().trim();
                String phone=tphone.getText().toString().trim();
                String pincode =tpincode.getText().toString().trim();
                String city =tcity.getText().toString().trim();
                String district =tdistrict.getText().toString().trim();
                String landmark=tlandmark.getText().toString().trim();
                String rent =trent.getText().toString().trim();
                String c1=tc1.getText().toString().trim();
                String c2=tc2.getText().toString().trim();
                String c3=tc3.getText().toString().trim();
                String Family=tFamily.getText().toString().trim();
                String bech=tbech.getText().toString().trim();
                if(tFamily.isChecked()){
                     tFamily.setText("Family");
                }else{
                    tbech.setText("bech");
                }
                if(tc1.isChecked()){
                    tc1.setText("none");
                }
                if(tc2.isChecked()){
                    tc2.setText(" Drinking");
                }
                if(tc3.isChecked()){
                    tc3.setText("smoking");
                }
                OwnerFormModel ownerFormModel = new OwnerFormModel(whatsapp,phone,address,pincode,city,district,landmark,rent,c1,c2,c3,Family,bech);
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("OwnerForm");
                reference.child(phone).setValue(ownerFormModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull  Task<Void> task) {
                        startActivity(new Intent(getApplicationContext(), imageuploadActivity.class));

                    }
                });
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),prop[i] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}