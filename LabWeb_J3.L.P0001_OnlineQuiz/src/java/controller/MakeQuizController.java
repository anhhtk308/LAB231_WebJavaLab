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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method that gets parameter content, opt1,2,3,4, ans
 * from the HTTP request; calls QuizDAOImpl to insert question into Question
 * table; Servlet will directly respond to "Error.jsp" when any error occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "MakeQuizController", urlPatterns = {"/MakeQuizController"})
public class MakeQuizController extends HttpServlet {

    /**
     * This method that gets parameter content, opt1,2,3,4, answer from the HTTP
     * request; check user checked answer or not, check all field empty or not;
     * calls QuizDAOImpl to insert question into Question table and forward to
     * "MakeQuizSuccess.jsp" if don't have any error, otherwise, forward to
     * "MakeQuiz.jsp" with message; Servlet will directly respond to "Error.jsp"
     * when any error occurs
     *
     * @param request stores attributes: content, opt1,2,3,4, mess error to send
     * to JSP if user does not check any checkbox answer; It is a
     * <code> javax.servlet.http.HttpServletRequest</code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            QuizDAO quizDAO = new QuizDAOImpl();
            Question question;
            //get parameter of content
            String content = request.getParameter("content").trim();
            //option
            ArrayList<String> lstOptions = new ArrayList<>();

            lstOptions.add(request.getParameter("opt1").trim());
            lstOptions.add(request.getParameter("opt2").trim());
            lstOptions.add(request.getParameter("opt3").trim());
            lstOptions.add(request.getParameter("opt4").trim());

            boolean checked = false;
            for (int i = 1; i <= 4; i++) {
                if (request.getParameter("ans" + i) != null) {
                    checked = true;
                    break;
                }
            }

            if (!checked || content.isEmpty() || request.getParameter("opt1").trim().isEmpty() || request.getParameter("opt2").trim().isEmpty() || request.getParameter("opt3").trim().isEmpty() || request.getParameter("opt4").trim().isEmpty()) {
                question = new Question(content, lstOptions);
                request.setAttribute("question", question);
                if (!checked) {
                    request.setAttribute("mess", "Please choose the right answer!!!");
                } else if (content.isEmpty()) {
                    request.setAttribute("mess", "Please enter content!!!");
                } else if (request.getParameter("opt1").trim().isEmpty()) {
                    request.setAttribute("mess", "Please enter option1!!!");
                } else if (request.getParameter("opt2").trim().isEmpty()) {
                    request.setAttribute("mess", "Please enter option2!!!");
                } else if (request.getParameter("opt3").trim().isEmpty()) {
                    request.setAttribute("mess", "Please enter option3!!!");
                } else if (request.getParameter("opt4").trim().isEmpty()) {
                    request.setAttribute("mess", "Please enter option4!!!");
                }
                request.getRequestDispatcher("MakeQuiz.jsp").forward(request, response);
                return;
            }
            //answers
            String answer = "";
            for (int i = 1; i <= 4; i++) {
                if (request.getParameter("ans" + i) != null) {
                    answer += String.valueOf(i);
                }
            }

            //if not error quiz will be add to database
            question = new Question(content, answer, lstOptions, new Date());
            quizDAO.insertQuiz(question);
            request.getRequestDispatcher("MakeQuizSuccess.jsp").forward(request, response);

        } catch (IOException | ServletException ex) {
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
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
        try {
            processRequest(request, response);
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
