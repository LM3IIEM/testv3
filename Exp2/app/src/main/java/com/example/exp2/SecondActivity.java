package com.example.exp2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcome;
    TextView attemptresult;
    ImageView dice;
    Button roll;
    int num1,num2,count=3;
    Random random;
    Boolean flag;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        welcome=findViewById(R.id.welcome);
        dice=findViewById(R.id.dice);
        roll=findViewById(R.id.roll);
        attemptresult=findViewById(R.id.attemptresult);
        result = findViewById(R.id.result);
        Intent i=getIntent();
        String str= i.getStringExtra("name");
        welcome.setText("Hi! Welcome "+ str+ " for the game");
        attemptresult.setText("You have "+count+" attempts.");
        random= new Random();
        num1=random.nextInt(6)+1;
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2= random.nextInt(6)+1;
                switch (num2){
                    case 1:
                        dice.setImageResource(R.drawable.dice1);
                        break;
                    case 2:
                        dice.setImageResource(R.drawable.dice2);
                        break;
                    case 3:
                        dice.setImageResource(R.drawable.dice3);
                        break;
                    case 4:
                        dice.setImageResource(R.drawable.dice4);
                        break;
                    case 5:
                        dice.setImageResource(R.drawable.dice5);
                        break;
                    case 6:
                        dice.setImageResource(R.drawable.dice6);
                        break;
                }
                count=count-1;
                attemptresult.setText("You have "+count+" attempts");
                if(num2==num1){
                    //flag=true;
                    //result.setText("You got the secret number"+num1);
                    //new Handler().postDelayed(() -> finish(), 2000);
                    Toast.makeText(getApplicationContext(),"You got the secret number "+num1,Toast.LENGTH_LONG).show();
                    //new Handler().postDelayed(() -> finish(), 1000);
                    finish();
                }
                if(count==0 && num2!=num1){

                    //result.setText("You did not get the secret number"+num1);
                    //new Handler().postDelayed(() -> finish(), 2000);
                    Toast.makeText(getApplicationContext(),"You lost! the secret number was "+num1,Toast.LENGTH_LONG).show();
                    //new Handler().postDelayed(() -> finish(), 1000);
                    finish();
                }
                if(count==0 && num2==num1){
                    //result.setText("You got the secret number"+num1);

                    Toast.makeText(getApplicationContext(),"You got the secret number "+num1,Toast.LENGTH_LONG).show();
                    //new Handler().postDelayed(() -> finish(), 1000);
                    finish();
                }
            }
        });



    }
}
