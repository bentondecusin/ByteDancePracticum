package com.example.p1searchscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import org.json.JSONArray;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchNumberActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private SearchNumberAdapter mSearchNumberAdapter = new SearchNumberAdapter();
    private boolean cantonese = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_number);
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchNumberAdapter);
        mEditText = findViewById(R.id.editTextSearch);

        List<String> items = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            if (cantonese) items.add("呢個係第" + String.valueOf(i) + "行");
            else items.add("这个是第" + String.valueOf(i) + "行");
        }
        mSearchNumberAdapter.notifyItems(items);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}