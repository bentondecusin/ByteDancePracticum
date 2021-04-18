package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {
    ViewPager pager = null;
    LayoutInflater layoutInflater = null;
    List<View> pages = new ArrayList<View>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Fresco.initialize(this);

        layoutInflater = getLayoutInflater();
        pager = (ViewPager) findViewById(R.id.view_pager);

    }
}