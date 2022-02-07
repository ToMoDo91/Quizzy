package com.ntk.quizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startQuiz;
    private Button allQues;
    private Button addQues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////////////// startQuiz Section ///////////////////
        // The startQuiz is Null now and we need to bind it with the view button
        startQuiz = findViewById(R.id.startQuiz); //Here we will search and bind the view element *BTN* with the Button in class
        //Now we need to listen to the BTN if some one click it we will do something
        startQuiz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // We can open the about page here but to make the code better
                        // we can call function
                        openQuestionActivity(); //This function will open our startQuiz page
                    }
                }
        );
        /////////////////// startQuiz Section ///////////////////

        /////////////////// AllQuestions Section ///////////////////
        // The AllQuestions is Null now and we need to bind it with the view button
        allQues = findViewById(R.id.allQues); //Here we will search and bind the view element *BTN* with the Button in class
        //Now we need to listen to the BTN if some one click it we will do something
        allQues.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // We can open the about page here but to make the code better
                        // we can call function
                        openAllQuestionsActivity(); //This function will open our AboutPage
                    }
                }
        );

        /////////////////// Add Ques Section ///////////////////
        // The AddQues  is Null now and we need to bind it with the view button
        addQues = findViewById(R.id.addQues); //Here we will search and bind the view element *BTN* with the Button in class
        //Now we need to listen to the BTN if some one click it we will do something
        addQues.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // We can open the about page here but to make the code better
                        // we can call function
                        AddQuesPage(); //This function will open our AddQus page
                    }
                }
        );
    }

    ////////////////////////////////////////////////////////////////////////
    //This function will open our startQuiz Page
    public void openQuestionActivity(){
        // An Intent is a messaging object you can use to request an action from another app component.
        // startActivity function need intent to be called so we do need to make one with our AboutActivity.class
        Intent StartQuestionActivity = new Intent(this,QuestionActivity.class);
        startActivity(StartQuestionActivity);

    }
    ////////////////////////////////////////////////////////////////////////
    //This function will open our startQuiz Page
    public void openAllQuestionsActivity(){
        // An Intent is a messaging object you can use to request an action from another app component.
        // startActivity function need intent to be called so we do need to make one with our AboutActivity.class
        Intent AllQuestionsActivity = new Intent(this,AllQuestions.class);
        startActivity(AllQuestionsActivity);

    }
    ////////////////////////////////////////////////////////////////////////
    //This function will open our AddQuestiontPage
    public void AddQuesPage(){
        // An Intent is a messaging object you can use to request an action from another app component.
        // startActivity function need intent to be called so we do need to make one with our AboutActivity.class
        Intent AddQuestion = new Intent(this,AddQuestion.class);
        startActivity(AddQuestion);

    }
}