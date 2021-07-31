package com.example.rentalhouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/*
public class myadapterimage extends RecyclerView.Adapter<myadapterimage.ViewHolder> {

    ArrayList <Model> mlist;
       Context context;

       public  myadapterimage(Context context,ArrayList<Model> mlist){

        this.context=context;
        this.mlist=mlist;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myadapterimage.ViewHolder holder, int position) {
        Model model=mlist.get(position);
        holder.Housename.setText(model.getHouse_name());

        Glide.with(context)
                .load(model.getImageurl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }



        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView Housename;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.m_image);
               Housename=itemView.findViewById(R.id.r_t);
            }



        }
}
/*  @NonNull
    @Override
         public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
         View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
         return  new RecyclerView.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myadapterimage.ViewHolder holder, int position) {
        ArrayList mlist=.get(position);
        Glide.with(context)
                .load(articleList.getImageUssrl())
                .into(holder.articleimg);

        holder.articlename.setText(articleList.getArticleName());
    }

   /* @Override
          public void onBindViewHolder(@NonNull  myadapterimage.MyViewHolder holder, int position) {
        Glide.with(context).load(mlist.get(position).getImageurl()).into(holder.imageView);
    }

        @Override
        public int getItemCount() {
        return mlist.size();
    }

}*/


   /*class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView textView;


    public MyViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.m_image);
        textView=itemView.findViewById(R.id.r_t);
    }*/
