package com.errimyhatim.quizapp_m21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity2 extends AppCompatActivity {

    Button button2;
    RadioButton radioButton, radioButton2;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        radioButton= (RadioButton)findViewById(R.id.radioButton);
        radioButton2= (RadioButton) findViewById(R.id.radioButton2);
        button2= (Button) findViewById(R.id.button2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("key");
        }
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=score+1;
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(QuizActivity2.this, QuizActivity3.class);
                i2.putExtra("key",score);
                startActivity(i2);            }
        });
    }
}