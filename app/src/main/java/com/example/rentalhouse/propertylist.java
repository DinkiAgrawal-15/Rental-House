package com.example.rentalhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Member;

public class propertylist extends AppCompatActivity {
    RecyclerView mRecyclerview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertylist);
        mRecyclerview = findViewById(R.id.recyclerView);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("user");

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model,mylistAdapter>firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Model, mylistAdapter>(
                        Model.class,
                        R.layout.list_design,
                        mylistAdapter.class,
                        reference
                ) {
                    @Override
                    protected void onBindViewHolder(@NonNull @NotNull mylistAdapter holder, int position, @NonNull @NotNull Model model) {
                        holder.setdetails(getApplicationContext(),model.getHouse_name(),model.getImageurl());
                    }


                    @NonNull
                    @NotNull
                    @Override
                    public mylistAdapter onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
                        return null;
                    }
                };
        mRecyclerview.setAdapter(firebaseRecyclerAdapter);
    }
}


       /* mylistdata[] myListData = new mylistdata[]{
                new mylistdata("Silicon valley", 5, R.drawable.house1),
                new mylistdata("Santi Ban", 5, R.drawable.house1),
                new mylistdata("white stone", 5, R.drawable.house1),
                new mylistdata("house1", 5, R.drawable.house1),
                new mylistdata("reliamnce", 5, R.drawable.house1),
                new mylistdata("bhawan1", 5, R.drawable.house1),
                new mylistdata("Radhemaa", 5, R.drawable.house1),
                new mylistdata("Sweethome", 5, R.drawable.house1),
                new mylistdata("rocking house", 5, R.drawable.house1),
                new mylistdata("Santi Ban", 5, R.drawable.house1),

        };

      mylistAdapter adapter = new mylistAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }*/
