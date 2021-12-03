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
import java.util.List;
@WebServlet(name = "resultsServlet", value = "/results")
public class ResultsServlet extends HttpServlet {
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
        List<Integer> results = (List<Integer>) session.getAttribute("results");
        System.out.println(results);
        req.setAttribute("results", results);

        req.getRequestDispatcher("results.jsp").forward(req, resp);
    }
}
