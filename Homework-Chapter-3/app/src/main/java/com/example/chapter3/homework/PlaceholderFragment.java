package com.example.chapter3.homework;


import android.animation.AnimatorSet;
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
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private List<String> contactList;
    private LottieAnimationView animationView;
    private ObjectAnimator vanish;
    private ObjectAnimator appear;
    private RecyclerView mRecyclerView;
    private SearchContactAdapter mSearchContactAdapter = new SearchContactAdapter();
    private AnimatorSet animatorSet = new AnimatorSet();
    public PlaceholderFragment(List<String> contactList){
        this.contactList = contactList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = getView().findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mSearchContactAdapter);
        mSearchContactAdapter.notifyItems(contactList);
        animationView = getView().findViewById(R.id.animation_view);
        vanish = ObjectAnimator.ofFloat(
                getView().findViewById(R.id.animation_view),
                "alpha",
                1f,0f);
        vanish.setDuration(2000);

        appear = ObjectAnimator.ofFloat(
                getView().findViewById(R.id.animation_view),
                "alpha",
                0f,1f);
        appear.setDuration(5000);
        appear.start();

        appear = ObjectAnimator.ofFloat(
                getView().findViewById(R.id.rv),
                "alpha",
                0f,1f);
        appear.setDuration(2000);


        animatorSet.playTogether(vanish, appear);

        getView().postDelayed(new Runnable() {
            @Override
            public void run(){
                animatorSet.start();
       //         animationView.pauseAnimation();

                // 这里会在 3s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

            }
        }, 5000);
    }
}
