package com.example.navigationbar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String news[], mean[];
    int images[];
    Context context;

    public MyAdapter(String[] news, String[] mean, int[] images, Context context) {
        this.news = news;
        this.mean = mean;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myTxt1.setText(news[position]);
        holder.myTxt2.setText(mean[position]);
        holder.myImage.setImageResource(images [position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsActivity.class);
                intent.putExtra("news", news[position]);
                intent.putExtra("mean", mean[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myTxt1,myTxt2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myTxt1 = itemView.findViewById(R.id.news_txt);
            myTxt2 = itemView.findViewById(R.id.description_txt);
            myImage = itemView.findViewById(R.id.myImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
