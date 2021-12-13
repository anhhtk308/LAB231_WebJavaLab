/**
 * Copyright(C) 2021, Hoang Thi Kim Anh.
 * J3.L.P0001
 * Online Quiz
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-12      1.0                 AnhHTK           First Implement
 * 2021-07-14      2.0                 AnhHTK           Second Implement
 */
package controller;

import dao.QuizDAO;
import dao.impl.QuizDAOImpl;
import entity.Question;
import java.io.IOException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method that get time per quiz in context; get parameter
 * numOfQuestion from the HTTP request; calculate time; calls QuestionDAOImpl to
 * get 'n' Question then forward to "TakeQuizAnswer.jsp". Servlet will directly
 * respond to "Error.jsp" when any error occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "TakeQuizAnswerController", urlPatterns = {"/TakeQuizAnswerController"})
public class TakeQuizAnswerController extends HttpServlet {

    /**
     * This method that get time per quiz in context; get parameter
     * numOfQuestion from the HTTP request; calculate time; calls
     * QuestionDAOImpl to get 'n' Question then forward to "TakeQuizAnswer.jsp".
     * Servlet will directly respond to "Error.jsp" when any error occurs
     *
     * @param request stores attributes: answerList,numOfQuestion, min, sec,
     * lstQuestions, error to send to "TakeQuizAnswer.jsp". It is a
     * <code> javax.servlet.http.HttpServletRequest</code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset = UTF-8");

        try {
            //get time per quiz in context
            InitialContext initial = new InitialContext();
            Context context = (Context) initial.lookup("java:comp/env");
            int timePerQ = Integer.parseInt(context.lookup("TPerQ").toString());

            //caculated time 
            QuizDAO quizDAO = new QuizDAOImpl();
            int numOfQuestion = (int) request.getAttribute("numOfQuestion");
            int min = numOfQuestion * timePerQ / 60;
            int sec = numOfQuestion * timePerQ - min * 60;

            ArrayList<Question> lstQuestions;
            lstQuestions = quizDAO.getQuestion(numOfQuestion);

            //get arraylist real answer
            ArrayList<String> lstAnswer = new ArrayList<>();
            for (Question question : lstQuestions) {
                lstAnswer.add(question.getAnswer());
            }
            //declare real answer
            request.getServletContext().setAttribute("answerList", lstAnswer);

            request.setAttribute("numOfQuestion", numOfQuestion);
            request.setAttribute("min", min);
            request.setAttribute("sec", sec);
            request.setAttribute("lstQuestions", lstQuestions);

            request.getRequestDispatcher("TakeQuizAnswer.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
