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
        if (position % 4 == 0) holder.getParent().setBackgroundColor(Color.parseColor("#93e3dc"));
        else if (position % 4 == 1) holder.getParent().setBackgroundColor(Color.parseColor("#57c6d0"));
        else if (position % 4 == 2) holder.getParent().setBackgroundColor(Color.parseColor("#4c8cf3"));
        else holder.getParent().setBackgroundColor(Color.parseColor("#385bad"));

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
