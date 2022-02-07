package com.ntk.quizzy;

public class AnswerStructure {

    private String answer;
    private Boolean isItRight;

    public AnswerStructure(String answer, Boolean isItRight) {
        this.answer = answer;
        this.isItRight = isItRight;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getItRight() {
        return isItRight;
    }

    public void setItRight(Boolean itRight) {
        isItRight = itRight;
    }






}
