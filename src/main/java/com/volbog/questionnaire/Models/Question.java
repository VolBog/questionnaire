package com.volbog.questionnaire.Models;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private List<String> answers;

    public Question() {
        answers = new ArrayList<>();
    }

    public Question(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    public void addAnswer(String answer) {
        this.answers.add(answer);
    }
}
