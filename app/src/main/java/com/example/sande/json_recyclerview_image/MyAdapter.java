package com.example.sande.json_recyclerview_image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        List<Category> categoryList;
        Context ctx;

    public MyAdapter(List<Category> categoryList,Context context) {
        this.categoryList = categoryList;
        this.ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singleitem_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Category c = categoryList.get(position);

        Picasso.with(ctx).load(c.getImage()).into(viewHolder.iv);
        viewHolder.id.setText(c.getId());
        viewHolder.name.setText(c.getName());
        viewHolder.category.setText(c.getDescription());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView iv;
        TextView id,name,category;
        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView);
            id = itemView.findViewById(R.id.textView);
            name = itemView.findViewById(R.id.textView2);
            category = itemView.findViewById(R.id.textView3);
        }
    }
}
