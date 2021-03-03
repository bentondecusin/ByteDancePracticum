package com.example.p1searchscroll;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import android.net.Uri;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTextView;
    private ImageView mImageView;
    private int imgID;
    private Context context;
    private Product product;
    public ProductViewHolder(@NonNull View itemView){
        super(itemView);
        mTextView = itemView.findViewById(R.id.productText);
        mImageView = itemView.findViewById(R.id.productImage);
        context = itemView.getContext();
        itemView.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), ProductViewActivity.class);
        intent.putExtra("title", product.getName());
        intent.putExtra("imgID", imgID);
        intent.putExtra("description", product.getDescription());
        v.getContext().startActivity(intent);
    }

    public void bind(int imgId, Product product) {
        this.product = product;
        String title = product.getName();
        mTextView.setText(title);
        this.imgID = imgId;
        mImageView.setImageResource(imgId);
    }

}
