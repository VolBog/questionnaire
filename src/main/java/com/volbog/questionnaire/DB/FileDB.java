package com.volbog.questionnaire.DB;

import com.google.gson.Gson;
import com.volbog.questionnaire.Models.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileDB {

    public static List<Question> getQuestions(){
        List<Question> questions = new ArrayList<>();
        Question question = new Question();
        question.setQuestion("Питання 1");
        question.addAnswer("Відповідь 1");
        question.addAnswer("Відповідь 2");
        question.addAnswer("Відповідь 3");
        questions.add(question);

        Question question1 = new Question();
        question1.setQuestion("Питання 2");
        question1.addAnswer("Відповідь 1");
        question1.addAnswer("Відповідь 2");
        question1.addAnswer("Відповідь 3");
        questions.add(question1);
        return questions;
    }
}
