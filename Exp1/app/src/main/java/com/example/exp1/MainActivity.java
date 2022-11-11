package com.example.exp1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText no;
    RadioGroup rg;
    Button b;
    Switch s;
    TextView t;
    Double ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        no = findViewById(R.id.getno);
        rg = findViewById(R.id.opchoice);
        b = findViewById(R.id.cal);
        s = findViewById(R.id.sw);
        t = findViewById(R.id.showno);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(rg.getCheckedRadioButtonId())
                {
                    case R.id.r1:
                        ans = Double.parseDouble(no.getText().toString());
                        ans+= 0.2*ans;
                        break;
                    case R.id.r2:
                        ans = Double.parseDouble(no.getText().toString());
                        ans+= 0.15*ans;
                        break;
                    case R.id.r3:
                        ans = Double.parseDouble(no.getText().toString());
                        ans+= 0.10*ans;

                }

                if(s.isChecked())
                {
                    t.setText(Math.round(ans)+"");
                }
                else
                {
                    t.setText(ans+"");
                }
            }
        });
    }
}
