package com.example.chapter3.homework;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.android.material.tabs.TabLayout.MODE_FIXED;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {
    private List<List<String>> contacts = new ArrayList<List<String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] fam = new String[]{"Family", "Dad", "Mom", "Auntie Marie","Uncle Joe","Auntie Joan", "Dog"};
        String[] fren = new String[]{"Friends", "李二狗", "小翠", "Dawg", "Jake", "Kido San"};
        String[] work = new String[]{"Colleague", "老板", "字节HR小姐姐"};
        contacts.add(Arrays.asList(fam));
        contacts.add(Arrays.asList(fren));
        contacts.add(Arrays.asList(work));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);
        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面
        ViewPager vp = findViewById(R.id.view_pager);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new PlaceholderFragment(contacts.get(position).subList(1,contacts.get(position).size()));
            }

            @Override
            public int getCount() {
                return contacts.size();
            }

            @Override
            public CharSequence getPageTitle(int position){
                return (CharSequence) contacts.get(position).get(0);
            }

        });
        // TODO: ex3-2, 添加 TabLayout 支持 Tab
        TabLayout tl = findViewById(R.id.tab_layout);
        tl.setupWithViewPager(vp);
    }
}
