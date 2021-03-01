package com.example.p1searchscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NumberInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String message = this.getIntent().getStringExtra("extra");
        setContentView(R.layout.activity_number_info);
        TextView mTextView = findViewById(R.id.messageView);
        mTextView.setText(message);
    }
}