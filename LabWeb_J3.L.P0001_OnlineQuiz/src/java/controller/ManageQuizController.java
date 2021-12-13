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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method get parameter page, qid from the HTTP request;
 * calls QuizDAOImpl to count quiz, get list question with paging, delete
 * Question by id. Servlet will directly respond to "Error.jsp" when any error
 * occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "ManageQuizController", urlPatterns = {"/ManageQuizController"})
public class ManageQuizController extends HttpServlet {

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
     * This method that get parameter page from the HTTP request; calls
     * QuizDAOImpl to count quiz, caculated the number of page to pagging; calls
     * QuizDAOImpl to get list question with paging then forward to
     * "ManageQuiz.jsp". Servlet will directly respond to "Error.jsp" when any
     * error occurs
     *
     * @param request stores attributes: pageGap, pageCount, pageIndex,
     * lstQuestions,totalQuestions error to send to JSP. It is a
     * <code> javax.servlet.http.HttpServletRequest</code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            QuizDAO quizDAO = new QuizDAOImpl();
            //the number of quiz per one page
            int pageSize = 3;
            //the space of paging
            int pageGap = 2;
            //the current page index
            int pageIndex = 0;
            //check page index
            String pageindexString = request.getParameter("page");
            if (pageindexString == null) {
                pageindexString = "1";
            }
            pageIndex = Integer.parseInt(pageindexString);
            //count the number of quiz
            int count = quizDAO.quizCount();
            //caculated the number of page to pagging
            int pageCount = (count % pageSize == 0) ? count / pageSize : count / pageSize + 1;
            ArrayList<Question> lstQuestions = quizDAO.getAllQuiz(pageIndex, pageSize);

            request.setAttribute("pageGap", pageGap);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("lstQuestions", lstQuestions);
            request.setAttribute("totalQuestions", count);
            request.getRequestDispatcher("ManageQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * This method that get parameter qid from the HTTP request; calls
     * QuizDAOImpl to delete Question by id. Servlet will directly respond to
     * "Error.jsp" when any error occurs
     *
     * @param request stores attributes: It is a
     * <code> javax.servlet.http.HttpServletRequest</code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //check condition to delete quiz, if condition is valid then delete
            QuizDAO quizDAO = new QuizDAOImpl();
            int id = 0;
            String qId = request.getParameter("qid");
            id = Integer.parseInt(qId);
            quizDAO.deleteQuiz(id);
            doGet(request, response);
        } catch (Exception ex) {
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
