package com.errimyhatim.quizapp_m21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {
    Button button2;
    RadioButton radioButton, radioButton2;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        radioButton= (RadioButton)findViewById(R.id.radioButton);
        radioButton2= (RadioButton) findViewById(R.id.radioButton2);
        button2= (Button) findViewById(R.id.button2);


        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = score+1;
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(QuizActivity.this, QuizActivity2.class);
                i.putExtra("key",score);
                startActivity(i);
            }
        });
    }
}