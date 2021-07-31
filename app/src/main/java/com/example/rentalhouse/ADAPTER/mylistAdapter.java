package com.example.rentalhouse.ADAPTER;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalhouse.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class mylistAdapter  extends RecyclerView.ViewHolder {
      View view;
    public mylistAdapter(@NonNull @NotNull View itemView) {
        super(itemView);
        view=itemView;
    }
    public  void  setdetails(Context context,String House_name,String imageurl){
        TextView mhousename=view.findViewById(R.id.idName);
        ImageView imageView=view.findViewById(R.id.idImage);
        mhousename.setText(House_name);
        Picasso.get().load(imageurl).into(imageView);
    }
}


  /*  public mylistAdapter(mylistdata[] listdata)
    {

        this.listdata = listdata;
    }

    @NonNull
    @Override
    public mylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_design, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull mylistAdapter.ViewHolder holder, int position) {
        final mylistdata myListData = listdata[position];
        holder.house_name.setText(listdata[position].getHouse_name());
        holder.house_image.setImageResource(listdata[position].getHouse_image());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), houselist.class);
                i.putExtra("house_name", myListData.getHouse_name());
                i.putExtra("house_rating",myListData.getHouse_rating());
                i.putExtra("house_image",myListData.getHouse_image());

                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView house_image;
        public TextView house_name, house_rating;
        public View relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            this.house_image = (ImageView) itemView.findViewById(R.id.idImage);
            this.house_name = (TextView) itemView.findViewById(R.id.idName);
            this.house_rating=(TextView)itemView.findViewById(R.id.idRating);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativelayout);


        }
    }
}
*/