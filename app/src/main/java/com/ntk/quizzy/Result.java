package com.ntk.quizzy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultText = findViewById(R.id.resultText);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nOfRightAnswers = extras.getString("nOfRightAnswers");
            String nOfQuestions = extras.getString("nOfQuestions");
            resultText.setText(nOfRightAnswers + " Of " + nOfQuestions);
            //The key argument here must match that used in the other activity
        }

    }

}