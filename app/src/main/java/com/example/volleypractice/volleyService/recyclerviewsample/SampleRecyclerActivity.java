package com.example.volleypractice.volleyService.recyclerviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.volleypractice.R;

import java.util.ArrayList;

public class SampleRecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_recycler);
        initViews();
        arrayList = new ArrayList<>();

        MyAdapter1 adapter1 = new MyAdapter1(this,arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setNestedScrollingEnabled(false);
        sampleAPI();
    }

    private void initViews() {
        recyclerView1 = findViewById(R.id.recyclerView1);
    }
    private void sampleAPI()
    {

    }
}
