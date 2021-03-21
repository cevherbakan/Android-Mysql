package com.example.mysql_data_connection;

import android.content.Intent;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilhanem.retrofitloginpost.adapter.CustomAdapter;
import com.mobilhanem.retrofitloginpost.model.UserResponse;

import java.util.List;

public class PersonProfileActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<UserResponse> userResponses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_profile);

        Intent i = getIntent();
        userResponses = (List<UserResponse>) i.getSerializableExtra("mylist");

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CustomAdapter(userResponses);
        mRecyclerView.setAdapter(mAdapter);


    }
}