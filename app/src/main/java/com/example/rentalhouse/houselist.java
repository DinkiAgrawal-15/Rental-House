package com.example.rentalhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class houselist extends AppCompatActivity {
    ImageView imageview;
    TextView text,text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houselist);
        imageview=findViewById(R.id.image);
        text=findViewById(R.id.text);
        text2=findViewById(R.id.text2);
        imageview.setImageResource(getIntent().getIntExtra("house_image",0));
        text.setText(getIntent().getStringExtra("house_name"));
        text2.setText(getIntent().getStringExtra("house_rating"));
    }
}