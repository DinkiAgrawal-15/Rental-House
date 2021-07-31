package com.example.rentalhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class signup_tanentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_tanent);
    }

    public void ownerform(View view) {
        startActivity(new Intent(getApplicationContext(), propertylistActivity.class));

    }
}