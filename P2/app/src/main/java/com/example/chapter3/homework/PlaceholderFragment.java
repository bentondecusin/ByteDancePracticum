package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private List<String> contactList = new ArrayList<>();
    private LottieAnimationView animationView;
    private ObjectAnimator vanish;
    private ListView mListView;
    public PlaceholderFragment(List<String> contactList){
        this.contactList = contactList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        Bundle args = getArguments();
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        animationView = getView().findViewById(R.id.animation_view);
        mListView = getView().findViewById(R.id.ListView);
   /*     mListView.setAdapter(new ListViewAdapter(contactList) {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return null;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        }); */
        vanish = ObjectAnimator.ofFloat(
                getView().findViewById(R.id.animation_view),
                "alpha",
                1f,0f);
        vanish.setDuration(3000);
        vanish.start();
        getView().postDelayed(new Runnable() {
            @Override
            public void run(){

                animationView.pauseAnimation();

                // 这里会在 3s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

            }
        }, 3000);
    }
}
