package com.example.p1searchscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

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
    private Switch mCantoneseSwitch;
    private ImageButton mCancelButton;
    private List<String> items = new ArrayList<>();
    private List<String> currentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_number);
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchNumberAdapter);

        mEditText = findViewById(R.id.editTextSearch);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentList = new ArrayList<>();
                for(String string : items){
                    if (string.contains(s)) currentList.add(string);
                }
                mSearchNumberAdapter.notifyItems(currentList);

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mCantoneseSwitch = findViewById(R.id.cantoneseSwitch);
        mCantoneseSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantonese = !cantonese;
                items = new ArrayList<>();
                for(int i = 0; i < 100; i++){
                    if (cantonese) items.add("呢個係第" + String.valueOf(i) + "行");
                    else items.add("这个是第" + String.valueOf(i) + "行");
                }
                if (cantonese) mEditText.setHint("請鍵入");
                else mEditText.setHint("请输入");
                mSearchNumberAdapter.notifyItems(items);
                mEditText.setText(mEditText.getText());
            }
        });

        items = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            if (cantonese) items.add("呢個係第" + String.valueOf(i) + "行");
            else items.add("这个是第" + String.valueOf(i) + "行");
        }
        mSearchNumberAdapter.notifyItems(items);

        mCancelButton = findViewById(R.id.cancelImageButton);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("");
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}