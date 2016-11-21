package com.vipinkr.quiz;

/**
 * Created by Vipin K R on 21-11-2016.
 */
public class Question {
    private int id;
    private String question;
    private String opta;
    private String optb;
    private String optc;
    private String answer;

    public Question() {
        id = 0;
        question = "";
        opta = "";
        optb = "";
        optc = "";
        answer = "";
    }

    public Question(String question, String opta, String optb, String optc, String answer) {
       // this.id = id;
        this.question = question;
        this.opta = opta;
        this.optb = optb;
        this.optc = optc;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpta() {
        return opta;
    }

    public void setOpta(String opta) {
        this.opta = opta;
    }

    public String getOptb() {
        return optb;
    }

    public void setOptb(String optb) {
        this.optb = optb;
    }

    public String getOptc() {
        return optc;
    }

    public void setOptc(String optc) {
        this.optc = optc;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
