package com.example.p1searchscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchBDActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private SearchProductAdapter mSearchProductAdapter = new SearchProductAdapter();
    private String byteInfoString = "[\n" +
            "  {\n" +
            "    \"id\": \"1\", \n "+
            "    \"url\": \"https://p16a.tiktokcdn.com/img/bytedance-alisg/4ac74bbefc4455d0b350fff1fcd530c7~noop.image\",\n" +
            "    \"title\": \"今日头条\",\n" +
            "    \"description\": \"今日头条是一个通用信息平台，致力于连接人与信息，让优质丰富的信息得到高效精准的分发，促使信息创造价值…等超过100个内容领域。\n更多信息，请访问： https://www.toutiao.com/.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"2\", \n "+
            "    \"url\": \"https://p16.tiktokcdn.com/img/bytedance-alisg/4bcac7e2843bd01c3158dcaefda77ada~noop.image\",\n" +
            "    \"title\": \"抖音短视频\",\n" +
            "    \"description\": \"抖音是一个帮助用户表达自我，记录美好生活的短视频平台。截至2020年1月，抖音日活跃用户超过4亿。\n更多信息，请访问： https://www.douyin.com/.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"3\", \n "+
            "    \"url\": \"https://p16.tiktokcdn.com/img/bytedance-alisg/ee00c524104d04941515770bb37103f1~noop.image\",\n" +
            "    \"title\": \"抖音火山版\",\n" +
            "    \"description\": \"抖音火山版，在品牌升级后的火山，交到更多的朋友，看见更大的世界。海量用户在火山分享千行万业，交流兴趣…户多样化的产品使用需求。\n更多信息，请访问： https://www.huoshan.com/.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"4\", \n "+
            "    \"url\": \"https://p16a.tiktokcdn.com/img/bytedance-alisg/a863b4860b58e31a4b536cb614f89a7c~noop.image\",\n" +
            "    \"title\": \"西瓜视频\",\n" +
            "    \"description\": \"西瓜视频是国内领先的 PUGC 视频平台，它通过个性化推荐，源源不断地为不同人群提供优质内容，同时鼓…松地向全世界分享视频作品。\n更多信息，请访问： https://www.ixigua.com/.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"5\", \n "+
            "    \"url\": \"https://p16a.tiktokcdn.com/img/bytedance-alisg/91408b9cc1f092a3bbefde619fa9aebd~noop.image\",\n" +
            "    \"title\": \"懂车帝\",\n" +
            "    \"description\": \"懂车帝是“看车、选车、买车”一站式汽车媒体和服务平台，产品基于个性化推荐引擎帮助用户发现感兴趣的汽车…车类手机应用。\n更多信息，请访问： https://www.dongchediapp.com/.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"6\", \n "+
            "    \"url\": \"https://p16b.tiktokcdn.com/img/bytedance-alisg/3ea30dbbe4cbccbc5b88af812cbc2c0c~noop.image\",\n" +
            "    \"title\": \"GoGoKid英语\",\n" +
            "    \"description\": \"GoGoKid是一个面向4-12岁孩子的在线少儿英语1对1学习平台。主打100%纯北美外教；教材对标…效的英语学习体验。\n更多信息，请访问： https://www.gogokid.com.cn.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"7\", \n "+
            "    \"url\": \"https://p16.tiktokcdn.com/img/bytedance-alisg/2140623c613f0740b8d47b4397d0d29b~noop.image\",\n" +
            "    \"title\": \"皮皮虾\",\n" +
            "    \"description\": \"皮皮虾APP，年轻人聚集的内容互动社区。皮皮虾以「分享快乐的力量」为使命 ，致力于打造一个让年轻人最…户自由表达和分享生活中的快乐。\n更多信息，请访问： https://mp.pipix.com/.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"8\", \n "+
            "    \"url\": \"https://p16a.tiktokcdn.com/img/bytedance-alisg/bdac2b5bd3d203ca3521161f466511f6~noop.image\",\n" +
            "    \"title\": \"飞书\",\n" +
            "    \"description\": \"飞书是新一代企业办公套件，整合即时沟通、日历、音视频会议、在线文档、云盘、工作台等功能于一体，为企业…组织和个人，更高效、更愉悦。\n更多信息，请访问： https://www.feishu.cn/.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"9\", \n "+
            "    \"url\": \"https://p16a.tiktokcdn.com/img/bytedance-alisg/2a4016d503e3643c15c32e754a0eb98b~noop.image\",\n" +
            "    \"title\": \"番茄小说\",\n" +
            "    \"description\": \"番茄小说是一个面向网文热爱者的免费阅读平台，拥有海量正版小说，涵盖青春、言情、玄幻、校园、仙侠、都市…品中的新兴国民级产品。\n更多信息，请访问： https://changdunovel.com/.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"10\", \n "+
            "    \"url\": \"https://p16.tiktokcdn.com/img/bytedance-alisg/226b882d4e9704863ff17ab7d6d7fbc9~noop.image\",\n" +
            "    \"title\": \"Faceu激萌\",\n" +
            "    \"description\": \"一款更多年轻人都喜爱的相机APP，海量酷炫贴纸、激萌表情包、实时美颜、趣味特效、视频跟拍让摄影社交更…，每天为用户提供1.7亿次服务\n更多信息，请访问： https://www.faceu.com.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"11\", \n "+
            "    \"url\": \"https://p16b.tiktokcdn.com/img/bytedance-alisg/9be428969c0f7f8e578a595b7febe9b1~noop.image\",\n" +
            "    \"title\": \"轻颜相机\",\n" +
            "    \"description\": \"轻颜相机是一款主打高级感的质感自拍相机，连续霸榜应用商店。拥有时下最流行的滤镜、美颜效果、和海量拍照…，一键就能get潮流自拍。\n更多信息，请访问： https://m.ulikecam.com/.\"\n" +
            "  }\n" +
            "]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Product> items = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_b_d);
        mRecyclerView = findViewById(R.id.rv_product);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchProductAdapter);
        mEditText = findViewById(R.id.editTextSearch);
        JSONArray byteInfoJSON = new JSONArray();
        try {
            byteInfoJSON = new JSONArray(byteInfoString);
        } catch (JSONException e) {
            byteInfoJSON = new JSONArray();
        }
        for(int i = 0; i < 11; i++){
            try {
                JSONObject product = byteInfoJSON.getJSONObject(i);
                items.add(new Product(product.getString("id"), product.getString("title"), product.getString("description")));
            } catch (JSONException e) {
                break;
            }
        }
        mSearchProductAdapter.notifyItems(items);

    }
}