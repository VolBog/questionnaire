package com.volbog.questionnaire;

import com.volbog.questionnaire.DB.FileDB;
import com.volbog.questionnaire.Models.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "quiestionareServlet", value = "/questions")
public class QuestionnaireServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        String userName = (String) session.getAttribute("userName");
        if(userName == null || userName.isEmpty()){
            resp.sendRedirect("/");
            return;
        }
        List<Question> questionList = FileDB.getQuestions();
        req.setAttribute("questionList", questionList);
        req.getRequestDispatcher("questions.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Question> questionList = FileDB.getQuestions();
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < questionList.size(); i++) {
            String myRadio= req.getParameter(String.valueOf(i));
            answers.add(Integer.valueOf(myRadio));
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("results", answers);
        resp.sendRedirect("/results");
    }
}
