package com.example.volleypractice.volleyService.recyclerviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.volleypractice.R;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter {
    Context mContext;
    ArrayList<String> mList;
    public MyAdapter1(SampleRecyclerActivity sampleRecyclerActivity, ArrayList<String> arrayList) {
        this.mContext = sampleRecyclerActivity;
        this.mList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View view) {
            super(view);
        }
    }
}
