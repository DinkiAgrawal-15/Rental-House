package com.example.rentalhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*public class imageslider extends AppCompatActivity {
    ArrayList <Model> mlist;
     private RecyclerView recyclerView;
     private DatabaseReference root ;
     private ProgressBar mprogressCircle;
    private  myadapterimage madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageslider);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mprogressCircle=findViewById(R.id.progress_circle);
        mlist = new ArrayList<>();
        root = FirebaseDatabase.getInstance().getReference("House_name");
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                for(DataSnapshot  di:snapshot.getChildren()){
                    Model model=di.getValue(Model.class);
                   mlist.add(model);

                }
                madapter=new myadapterimage(imageslider.this, mlist);
               // recyclerView.setLayoutManager(adapter);

               recyclerView.setAdapter(madapter);
               mprogressCircle.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(imageslider.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                mprogressCircle.setVisibility(View.INVISIBLE);

            }
        });
    }
    }*/


