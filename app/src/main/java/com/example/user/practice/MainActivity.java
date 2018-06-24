package com.example.user.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //variables
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImages();
    }

    //to initialise the test objects
    private void initImages(){
        mImageUrls.add("https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_960_720.png");
        mNames.add("Banter Group");

        mImageUrls.add("https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_960_720.png");
        mNames.add("Hiking Group");

        mImageUrls.add("https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_960_720.png");
        mNames.add("Wot Group");

        mImageUrls.add("https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_960_720.png");
        mNames.add("Another Group");

        mImageUrls.add("https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_960_720.png");
        mNames.add("EGEG");

        mImageUrls.add("https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_960_720.png");
        mNames.add("Nani");

        mImageUrls.add("https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_960_720.png");
        mNames.add("Huh");

        mImageUrls.add("https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_960_720.png");
        mNames.add("Hi Weikang");

        initRecyclerView();
    }

    //setting up recyclerview
    private void initRecyclerView(){
        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);
        MyAdapter mAdapter = new MyAdapter(mNames, mImageUrls, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
