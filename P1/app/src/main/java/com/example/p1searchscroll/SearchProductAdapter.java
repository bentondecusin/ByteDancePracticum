package com.example.p1searchscroll;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    @NonNull
    private List<Product> mItems = new ArrayList<>();
    private List<Integer> imgs = new ArrayList<>();
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        imgs.add(R.drawable.b1);
        imgs.add(R.drawable.b2);
        imgs.add(R.drawable.b3);
        imgs.add(R.drawable.b4);
        imgs.add(R.drawable.b5);
        imgs.add(R.drawable.b6);
        imgs.add(R.drawable.b7);
        imgs.add(R.drawable.b8);
        imgs.add(R.drawable.b9);
        imgs.add(R.drawable.b10);
        imgs.add(R.drawable.b11);
        return new ProductViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        String id = mItems.get(position).getId();
        holder.bind(imgs.get(Integer.parseInt(id) - 1), mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void notifyItems(@NonNull List<Product> items){
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }




}
