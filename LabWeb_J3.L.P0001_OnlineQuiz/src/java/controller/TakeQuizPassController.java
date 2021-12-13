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
import entity.User;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class contains a method that gets parameter answer, answerList from the
 * HTTP request; check answer of user and calculate point then calls QuizDAOImpl
 * to insertHistory. Servlet will directly respond to "Error.jsp" when any error
 * occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "TakeQuizPassController", urlPatterns = {"/TakeQuizPassController"})
public class TakeQuizPassController extends HttpServlet {

    /**
     * This method that gets parameter answer, answerList from the HTTP request;
     * check answer of user and calculate point then calls QuizDAOImpl to
     * insertHistory. Servlet will directly respond to "Error.jsp" when any
     * error occurs
     *
     * @param request stores attributes: point, pointPercent, error to send to
     * "TakeQuizPass.jsp". It is a
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
        try {
            float point1 = 0;
            //get the list of checkbox answer
            String[] answerOfUser = request.getParameterValues("answer");
            //if the answer not null caculated point 
            //else point =0
            if (answerOfUser != null) {
                //get the truth answer list of question
                ArrayList<String> lstAnswer = (ArrayList<String>) request.getServletContext().getAttribute("answerList");
                ArrayList<String> AnswerOut;
                AnswerOut = new ArrayList<>();
                String a = "";
                int point = 0;
                //get the list of question that check by user
                for (int i = 0; i < lstAnswer.size(); i++) {
                    a = "";
                    for (String x : answerOfUser) {
                        if (x.startsWith("" + i)) {
                            a += x.charAt(1);
                        }
                    }
                    AnswerOut.add(a);
                }
                //compare between the truth answer and user answer
                for (int i = 0; i < lstAnswer.size(); i++) {
                    if (lstAnswer.get(i).equals(AnswerOut.get(i))) {
                        point++;
                    }
                }

                point1 = ((float) point) / lstAnswer.size() * 10;

                request.setAttribute("point", formatNum(point1));
                request.setAttribute("pointP", formatNum(((float) point) / lstAnswer.size() * 100));
            } else {
                request.setAttribute("point", 0);
                request.setAttribute("pointP", 0);
            }

            HttpSession session = request.getSession();
            QuizDAO quizDAO = new QuizDAOImpl();
            User user = (User) session.getAttribute("user");
            quizDAO.insertHistory(user.getId(), (float) point1);

            request.getRequestDispatcher("TakeQuizPass.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    /**
     * This method that format number have one number after '.'
     *
     * @param x the number need to format. It is a float number
     * @return the String after format
     */
    protected String formatNum(float x) {
        if (0 - x == 0) {
            return "0";
        }
        DecimalFormat d = new DecimalFormat("#.0");
        String a = d.format(x);
        return a;
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
