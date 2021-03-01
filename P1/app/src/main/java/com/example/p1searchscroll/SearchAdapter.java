package com.example.p1searchscroll;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<TextViewHolder> {
    @NonNull
    private List<String> mItems = new ArrayList<>();

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_text, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        holder.bind(mItems.get(position), position);
        if (position % 2 == 0) holder.getParent().setBackgroundColor(Color.parseColor("#2F7BED"));
        else holder.getParent().setBackgroundColor(Color.parseColor("#03dac4"));

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void notifyItems(@NonNull List<String> items){
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }




}
