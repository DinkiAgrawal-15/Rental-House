package com.example.rentalhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tanentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanent_login);
    }

    public void register(View view) {
        startActivity(new Intent(getApplicationContext(),signup_tanent.class));

    }
}