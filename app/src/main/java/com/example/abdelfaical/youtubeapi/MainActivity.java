package com.example.abdelfaical.youtubeapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        MyAdapter myAdapter = new MyAdapter(this, stringList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
    }

    private ArrayList<String> stringList (){
        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 0; i<=10; i++){
            stringArrayList.add("Title "+i);
        }
        return stringArrayList;
    }
}
