package com.ntk.quizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {


    //Let's create what we need in the question view
    //So we need a TextView to display the text of the question and four buttons for our options
    //and Image to display the image question
    private ImageView imageView;
    private TextView questitle;
    private Button btnop1, btnop2,btnop3,btnop4;
    private ImageView quesImage;
    //All of these variables are now null, so we need to bind them with our view elements by id



    ////////////////////////////////////// We need it to pick random number from our Question list
    public   Random random = new  Random();
    //////////////////////////////////////

    //////////////////////////////////////
    //We need this list to store our asked question
    //We do not want to ask the question two times
    public ArrayList<Integer> AskedQuestionIds = new ArrayList<Integer>();
    //////////////////////////////////////

    //////////////////////////////////////
    public QuestionStructure  QuestionTOAsk;
    //////////////////////////////////////

    ////////////////////////////////////// After all we will send this to the result view
    int NumberOfRightAnswer = 0;
    //////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //////////////////////////////////////
        //Bind the view with the Code
        questitle = findViewById(R.id.questitle);
        btnop1 = findViewById(R.id.btnop1);
        btnop2 = findViewById(R.id.btnop2);
        btnop3 = findViewById(R.id.btnop3);
        btnop4 = findViewById(R.id.btnop4);
        quesImage = findViewById(R.id.quesImage);
        //////////////////////////////////////

        // We need to listen to every button
        //Maybe there is a way to do it better but it is not our main case now
        btnop1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Boolean isItRight = QuestionTOAsk.getOptionOne().getItRight();
                        checkUserResponse(isItRight);
                    }
                }
        );
        btnop2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Boolean isItRight = QuestionTOAsk.getOptionTwo().getItRight();
                        checkUserResponse(isItRight);
                    }
                }
        );
        btnop3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Boolean isItRight = QuestionTOAsk.getOptionThree().getItRight();
                        checkUserResponse(isItRight);
                    }
                }
        );
        btnop4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Boolean isItRight = QuestionTOAsk.getOptionFour().getItRight();
                        checkUserResponse(isItRight);
                    }
                }
        );


        askQuestion(); //On create we need to ask our first question :-)


    }

    //This function will take question from our database and ask it.
    //This function will ask another question every time we call it also.
    public void askQuestion(){

        int QuesNumber = random.nextInt(Database.get().getListofQues().size()); //Random will pick one randomly.
        QuestionTOAsk   =  Database.get().getListofQues().get(QuesNumber); //Here is our picked question

        if(AskedQuestionIds.contains(QuestionTOAsk.getId()) == false){  //This will check if the random question is asked before
            //We are here that means this is the first time the question being asked
            //let us view it to the user
            questitle.setText(QuestionTOAsk.getQus()); //Send the title to the view :-)
            btnop1.setText(QuestionTOAsk.getOptionOne().getAnswer()); // Same thing for options.
            btnop2.setText(QuestionTOAsk.getOptionTwo().getAnswer());
            btnop3.setText(QuestionTOAsk.getOptionThree().getAnswer());
            btnop4.setText(QuestionTOAsk.getOptionFour().getAnswer());
            quesImage.setImageResource(QuestionTOAsk.getQuesImage()); //Image

            //Now we need to add it as an asked question to make the application remember that he asked it before
            AskedQuestionIds.add(QuestionTOAsk.getId());

        }else if (AskedQuestionIds.size() < Database.get().ListofQues.size()){ //if the question being asked before we will repeat picking.
         askQuestion();
        }else {
            //If the user did answer all the questions we can move to the result Activity of quiz

            Intent res = new Intent( this, Result.class);
            res.putExtra("nOfRightAnswers",String.valueOf(NumberOfRightAnswer));
            res.putExtra("nOfQuestions",String.valueOf(Database.get().getListofQues().size()));
            startActivity(res);
            finish(); //This will end this page we do not need it any more :-)
            //if we did not kill it the user will be able to back
        }
    }

    public void checkUserResponse(Boolean Answer){
        //In this function we will check our answer store it and ask another question
        //Here We can view something like Good or try again or what ever we want
        //We can view the right answer also to teach the user
        // before ask a new question :-)
        if(Answer){ //If The Answer is True
            //Here we can do something if the answer is right
            //For example we can add one number to the result
            NumberOfRightAnswer = NumberOfRightAnswer + 1 ;
        }
        askQuestion(); //Next Question
    }

}