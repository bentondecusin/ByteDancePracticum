package com.example.p1searchscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SearchNumberActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SearchAdapter mSearchAdapter = new SearchAdapter();
    private boolean cantonese = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_number);

        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchAdapter);

        List<String> items = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            if (cantonese) items.add("呢個係第" + String.valueOf(i) + "行");
            else items.add("这个是第" + String.valueOf(i) + "行");
        }
        mSearchAdapter.notifyItems(items);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}