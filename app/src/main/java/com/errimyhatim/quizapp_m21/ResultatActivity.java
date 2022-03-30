package com.errimyhatim.quizapp_m21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ResultatActivity extends AppCompatActivity {
    Button bAccueil;
    int score;
    int resultat;
    TextView s;
    ProgressBar progressBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        bAccueil= (Button) findViewById(R.id.bAccueil);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("key");
        }
        resultat= score *20;

        String f=Integer.toString(resultat);

        s = (TextView) findViewById(R.id.textScore);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        s.setText(f);
        progressBar.setProgress(resultat);


        bAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultatActivity.this, MainActivity.class));
            }
        });
    }
}