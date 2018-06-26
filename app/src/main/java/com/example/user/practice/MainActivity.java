package com.example.user.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //variables
    private ArrayList<Group> mGroups = new ArrayList<>();
    //private ArrayList<String> mNames = new ArrayList<>();
    //private ArrayList<String> mImageUrls = new ArrayList<>();

    //Firebase variables
    //Database
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mGroupsDatabaseReference;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise Adapter and recyclerview etc
        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);
        final MyAdapter mAdapter = new MyAdapter(mGroups, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initialise Firebase variables
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mGroupsDatabaseReference = mFirebaseDatabase.getReference().child("groups");

        //database child event listener
        mChildEventListener = new ChildEventListener() {
            //datasnapshot contains data at that location when listener is triggered
            //first adding group object into the arraylist, then use adpater.notifyiteminserted

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Group group = dataSnapshot.getValue(Group.class);
                mGroups.add(group);
                mAdapter.notifyItemInserted(mGroups.size() - 1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        //add a child event listener. SO the reference (mGroupDatabaseRef) defines which part of
        //database to listen to, mchildEventlistener defines what to do
        mGroupsDatabaseReference.addChildEventListener(mChildEventListener);

        //initImages();
    }

    //to initialise the test objects
    /*private void initImages(){
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
    }*/

    //setting up recyclerview
    private void initRecyclerView(){
        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);
        MyAdapter mAdapter = new MyAdapter(mGroups, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
