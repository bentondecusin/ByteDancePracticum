package com.example.p1searchscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button s_number = findViewById(R.id.button_num);
        s_number.setText("Search for boring numbers!");
        s_number.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchNumberActivity.class);
                startActivity(intent);
            }
        });
        Button s_byte = findViewById(R.id.button_byte);
        s_byte.setText("Search for ByteDance products!");
        s_byte.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchBDActivity.class);
                startActivity(intent);
            }
        });
    }
}