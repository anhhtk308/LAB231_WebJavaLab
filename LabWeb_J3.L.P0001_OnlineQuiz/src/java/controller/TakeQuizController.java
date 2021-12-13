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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method that calls QuizDAOImpl to getNumOfQuestion; get
 * parameter isSubmit from the HTTP request. Servlet will directly respond to
 * "Error.jsp" when any error occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "TakeQuizController", urlPatterns = {"/TakeQuizController"})
public class TakeQuizController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * This method that calls QuestionDAOImpl to getNumOfQuestion; then turn to
     * TakeQuiz.jsp if don't have any error. Servlet will directly respond to
     * "Error.jsp" when any error occurs
     *
     * @param request stores attributes: numOfQuestion, error to send to
     * "TakeQuiz.jsp". It is a <code> javax.servlet.http.HttpServletRequest
     * </code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        try {
            QuizDAO quizDAO = new QuizDAOImpl();
            int numberOfQuestion = quizDAO.getNumOfQuestion();
            request.setAttribute("numOfQuestion", numberOfQuestion);
            request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * This method get parameter isSubmit from the HTTP request; turn to
     * TakeQuizAnswerController if isSubmit == null, otherwise turn to
     * TakeQuizPassController. Servlet will directly respond to "Error.jsp" when
     * any error occurs
     *
     * @param request stores attributes: numOfQuestion, error to send to
     * TakeQuizAnswerController. It is a <code> javax.servlet.http.HttpServletRequest
     * </code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        try {
            //check if the user submitted it or not
            String isSubmit = request.getParameter("isSubmit");
            //If not, then post question
            if (isSubmit == null) {
                request.setAttribute("numOfQuestion", Integer.parseInt(request.getParameter("number")));
                //user takeQuizAnser to display quiz to the take quiz answer page
                request.getRequestDispatcher("TakeQuizAnswerController").forward(request, response);
            } else {
                //if user is have been submit
                //perfomed funtion submit answer
                request.getRequestDispatcher("TakeQuizPassController").forward(request, response);
            }
        } catch (IOException | NumberFormatException | ServletException ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

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
