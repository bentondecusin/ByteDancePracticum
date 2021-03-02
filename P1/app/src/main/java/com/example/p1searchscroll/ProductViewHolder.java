package com.example.p1searchscroll;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTextView;
    private ImageView mImageView;
    private int idx;
    public ProductViewHolder(@NonNull View itemView){
        super(itemView);
    //    mTextView = new TextView();
        mTextView = itemView.findViewById(R.id.text);
        mImageView = itemView.findViewById(R.id.productImage);
        itemView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), ProductViewActivity.class);
        intent.putExtra("extra", mTextView.getText());
        v.getContext().startActivity(intent);
    }

    public void bind(int position){
        mTextView.setText("ok");
    }

}
