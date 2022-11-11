package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demo.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    Button button;
    EditText editText;
    Random r;
    int ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view  = activityMainBinding.getRoot();
        setContentView(view);

        button = activityMainBinding.button;
        editText = activityMainBinding.editTextTextPersonName;
        r= new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ln=r.nextInt(6)+1;
                System.out.println("ln :"+ln);

                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("name",editText.getText().toString());
                intent.putExtra("Lucky",""+ln);
                startActivity(intent);
            }
        });

    }
}