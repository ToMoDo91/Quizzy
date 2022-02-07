package com.ntk.quizzy;

import android.graphics.drawable.Drawable;

public class QuestionStructure {
    //Every Question has id , title and four answers.
    private int id ;
    private String qus;
    private AnswerStructure optionOne;
    private AnswerStructure optionTwo;
    private AnswerStructure optionThree;
    private AnswerStructure optionFour;
    private int quesImage;

    public QuestionStructure(int id, String qus, AnswerStructure optionOne, AnswerStructure optionTwo, AnswerStructure optionThree, AnswerStructure optionFour , int quesImage) {
        this.id = id;
        this.qus = qus;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.quesImage = quesImage;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQus() {
        return qus;
    }

    public void setQus(String qus) {
        this.qus = qus;
    }

    public AnswerStructure getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(AnswerStructure optionOne) {
        this.optionOne = optionOne;
    }

    public AnswerStructure getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(AnswerStructure optionTwo) {
        this.optionTwo = optionTwo;
    }

    public AnswerStructure getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(AnswerStructure optionThree) {
        this.optionThree = optionThree;
    }

    public AnswerStructure getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(AnswerStructure optionFour) {
        this.optionFour = optionFour;
    }

    public int getQuesImage() {
        return quesImage;
    }

    public void setQuesImage(int quesImage) {
        this.quesImage = quesImage;
    }

}
