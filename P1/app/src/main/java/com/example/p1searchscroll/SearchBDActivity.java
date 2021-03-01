package com.example.p1searchscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SearchBDActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
   // private SearchAdapter mSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_b_d);
    }
}