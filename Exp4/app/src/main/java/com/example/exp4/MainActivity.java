package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //initialize the variable
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewId);
        contactAdapter = new ContactAdapter(
                this,
                Arrays.asList("Ruhan","Kevin","Aditya","Haydon"),
                Arrays.asList("1234567","1234568","1234569","12345677"),
                new int[]{R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p2}
        );
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}