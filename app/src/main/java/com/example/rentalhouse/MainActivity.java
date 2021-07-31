package com.example.rentalhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setTitle("Content");

    }
    public void owner(View view) {
        startActivity(new Intent(getApplicationContext(), OwnerFormActivity.class));
    }
    public void tanent(View view) {
        startActivity(new Intent(getApplicationContext(), tanentformActivity.class));
    }
}