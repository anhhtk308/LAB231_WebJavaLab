/**
 * Copyright(C) 2021, Hoang Thi Kim Anh.
 * J3.L.P0004
 * Digital News
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-06-07      1.0                 AnhHTK           First Implement
 * 2021-06-09      2.0                 AnhHTK           Second Implement
 */
package controller;

import dao.PhotoDAO;
import dao.impl.PhotoDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method that gets top3 Gallery, Contact data from PhotoDAOImple
 * then forward to "Contact.jsp".
 * Servlet will directly respond to "Error.jsp" when any error occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "ContactController", urlPatterns = {"/ContactController"})
public class ContactController extends HttpServlet {

    /**
     * This method will get Contact data from database then forward to
     * "Contact.jsp" Servlet will directly respond to "Error.jsp" when any error
     * occurs
     *
     * @param request stores attributes like: top3Gallery, contact, error to
     * send to JSP. It is a <code> javax.servlet.http.HttpServletRequest
     * </code>
     * @param response provide HTTP-specific functionality in sending a response
     * to client's web browser. It is a <code> javax.servlet.http.HttpServletResponse
     * </code>
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            PhotoDAO photoDAO = new PhotoDAOImpl();
            //get top 3 galery
            request.setAttribute("listTop3Gallery", photoDAO.getTopGalley(3));
            //get contact infor
            request.setAttribute("contact", photoDAO.getContact());
            request.setAttribute("active", "4");
            request.getRequestDispatcher("Contact.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code> javax.servlet.http.HttpServletRequest </code>
     * @param response respond to an HTTP Request to the browser It is a <code> javax.servlet.http.HttpServletResponse
     * </code>
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
     * @param request provides important information about a client request to a
     * servlet. It is a <code> javax.servlet.http.HttpServletRequest </code>
     * @param response respond to an HTTP Request to the browser It is a <code> javax.servlet.http.HttpServletResponse
     * </code>
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
