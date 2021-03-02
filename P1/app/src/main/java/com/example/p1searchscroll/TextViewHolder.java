package com.example.p1searchscroll;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTextView;
    private View parent;
    private boolean cantonese = false;
    public TextViewHolder (@NonNull View itemView){
        super(itemView);
        mTextView = itemView.findViewById(R.id.text);
        parent = itemView.findViewById(R.id.text_wrapper);
        itemView.setOnClickListener(this);
    }

    public View getParent(){
        return this.parent;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), NumberInfoActivity.class);
        intent.putExtra("extra", mTextView.getText());
        v.getContext().startActivity(intent);
    }



    public void bind(String text, int position){
        mTextView.setText(text);
    }
}
