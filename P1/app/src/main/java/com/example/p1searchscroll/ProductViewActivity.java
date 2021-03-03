package com.example.p1searchscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);
        String title = getIntent().getStringExtra("title");
        int imgID = getIntent().getIntExtra("imgID", 0);
        String description = getIntent().getStringExtra("description");

        setContentView(R.layout.activity_product_view);
        TextView mTitle = findViewById(R.id.titleTextView);
        TextView mDescription = findViewById(R.id.descriptionTextView);
        ImageView mImage = findViewById(R.id.prodcutImageView);

        mTitle.setText(title);
        mDescription.setText(description);
        mImage.setImageResource(imgID);
    }
}