package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.databinding.ActivityMain2Binding;
import com.example.demo.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding activityMain2Binding;
    ImageView imageView;
    TextView textView;
    TextView ftextView;
    Button button;
    Random r;
    int i;
    int ln;
    String res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i=0;
        activityMain2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view  = activityMain2Binding.getRoot();
        setContentView(view);

        textView = activityMain2Binding.textView;
        button = activityMain2Binding.button2;
        imageView = activityMain2Binding.imageView;
        ftextView = activityMain2Binding.textView2;

        r= new Random();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String lucky = intent.getStringExtra("Lucky");

        System.out.println(name+"  "+lucky);

        textView.setText("Welcome " + name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ln=r.nextInt(6)+1;
                System.out.println("ln :"+ln);
                switch (ln){
                    case 1:
                        imageView.setImageResource(R.drawable.dice_1);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.dice_2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.dice_3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.dice_4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.dice_5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.dice_6);
                        break;
                    default:
                        imageView.setImageResource(R.drawable.logo);

                }
                i++;
                ftextView.setText("You have "+(4-i)+" more attepts");

                if(i>=4 || Integer.parseInt(lucky)==ln){
                    if(Integer.parseInt(lucky)==ln){
                        res="congratulations!!";
                    }else{
                        res="Better luck next time";
                    }
                    //1. create a toast obj
                    Toast toast = Toast.makeText(getApplicationContext(),//get context
                            res,//message to toast
                            Toast.LENGTH_LONG//duration
                    );
                    //2. show the toast obj
                    toast.show();
                    finish();
                }



            }
        });
    }
}