package com.ntk.quizzy;

import java.util.ArrayList;

public class Database {  //Our Database is a singleton object

    public ArrayList<QuestionStructure> ListofQues = new ArrayList<QuestionStructure>();
    private Database() { //constructor function

        AnswerStructure Q1One = new AnswerStructure("Rat", false);
        AnswerStructure Q1Two = new AnswerStructure("Snail", false);
        AnswerStructure Q1Three = new AnswerStructure("Dog", true); //This is the right answer :-)
        AnswerStructure Q1Four = new AnswerStructure("Giraffe", false);
        QuestionStructure Q1 = new QuestionStructure(0,"What is this?",Q1One,Q1Two ,Q1Three,Q1Four ,R.drawable.dog);

        ////This is The second Question in our database
        AnswerStructure Q2One = new AnswerStructure("Cat", true);
        AnswerStructure Q2Two = new AnswerStructure("Dog", false);
        AnswerStructure Q2Three = new AnswerStructure("Rabbit", false); //This is the right answer :-)
        AnswerStructure Q2Four = new AnswerStructure("Horse", false);
        QuestionStructure Q2 = new QuestionStructure(1,"What's this animal?",Q2One,Q2Two ,Q2Three,Q2Four,R.drawable.cat);

        ListofQues.add(Q1);
        ListofQues.add(Q2);
    }

    private static  Database mDatabase;

    public ArrayList<QuestionStructure> getListofQues(){  //singleton
        return ListofQues;
    }

    public static Database get (){  //singleton
        if(mDatabase == null){
            mDatabase = new Database();
        }
        return mDatabase;
    }

}
