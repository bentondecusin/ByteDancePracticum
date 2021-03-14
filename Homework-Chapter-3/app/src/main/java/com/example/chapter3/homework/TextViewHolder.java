package com.example.chapter3.homework;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextViewHolder extends RecyclerView.ViewHolder{
    private TextView mTextView;
    private View parent;
    public TextViewHolder(@NonNull View itemView){
        super(itemView);
        mTextView = itemView.findViewById(R.id.text);
        parent = itemView.findViewById(R.id.text_wrapper);
    }

    public View getParent(){
        return this.parent;
    }

    public void bind(String text){
        mTextView.setText(text);
    }
}
