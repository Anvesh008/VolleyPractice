package com.example.volleypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.volleypractice.volleyService.recyclerviewsample.SampleRecyclerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigateToRecycerView(View view) {
        Intent intent = new Intent(this, SampleRecyclerActivity.class);
        startActivity(intent);
    }
}
