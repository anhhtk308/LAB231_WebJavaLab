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

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class contains a method that get parameter username, password, email,
 * userType from the HTTP request; calls UserDAOImpl to get user exist, insert
 * User to User table. Servlet will directly respond to "Error.jsp" when any
 * error occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    /**
     * This method that get parameter username, password, email, userType from
     * the HTTP request; calls UserDAOImpl to get user exist; check user exist.
     * Turn to "Register.jsp" if exist, otherwise turn to TakeQuizController and
     * insert User to User table Servlet will directly respond to "Error.jsp"
     * when any error occurs
     *
     * @param request stores attributes: username, password, email, userType,
     * error to send to "Register.jsp" if register fail, otherwise store session
     * user. It is a <code> javax.servlet.http.HttpServletRequest
     * </code>
     * @param response sending a response to client's web browser. It is a
     * <code> javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            UserDAO userDAO = new UserDAOImpl();
            String userName = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String email = request.getParameter("email").trim();
            String type = request.getParameter("userType");

            boolean isExist = userDAO.getUserExist(userName);
            if (isExist || userName.isEmpty() || password.isEmpty() || email.isEmpty()) {
                request.setAttribute("userName", userName);
                //request.setAttribute("password", password);
                request.setAttribute("email", email);
                request.setAttribute("userType", type);
                if (isExist) {
                    request.setAttribute("mess", "User Name already exist!!!");
                } else if (userName.isEmpty()) {
                    request.setAttribute("mess", "Please enter User Name!!!");
                } else if (password.isEmpty()) {
                    request.setAttribute("mess", "Please enter Password!!!");
                } else if (email.isEmpty()) {
                    request.setAttribute("mess", "Please enter Email!!!");
                }
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                boolean isTeacher = false;
                if (type.equals("1")) {
                    isTeacher = true;
                }
                User user = new User(userName, password, isTeacher, email);
                userDAO.insertUser(user);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("TakeQuizController");
            }
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
