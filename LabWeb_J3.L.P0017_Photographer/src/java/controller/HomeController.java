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
import entity.Gallery;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method that calls PhotoDAOImpl to get top 3 Gallery,
 * list paging Gallery, Contact, a total of the gallery; get parameter index
 * page from the HTTP request and find maxPage then forward to the
 * "Homepage.jsp". Servlet will directly respond to "Error.jsp" when any error
 * occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeControl"})
public class HomeController extends HttpServlet {

    /**
     * This class contains a method that calls PhotoDAOImpl to get top 3
     * Gallery, list paging Gallery, Contact, a total of the gallery; get
     * parameter index page from the HTTP request and find maxPage then forward
     * to the "Homepage.jsp". Each page will have a maximum of 3 Gallery.
     * Servlet will directly respond to "Error.jsp" when any error occurs
     *
     * @param request stores attributes: top3Gallery, listPagingGallery,
     * gallery, maxPage, index, contact, error to send to JSP.
     * It is a <code> javax.servlet.http.HttpServletRequest
     * </code>
     * @param response sending a response to client's web browser.
     * It is a <code> javax.servlet.http.HttpServletResponse
     * </code>
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            PhotoDAO photoDAO = new PhotoDAOImpl();
            //push top3Gallery to header
            List<Gallery> listTop3Gallery = photoDAO.getTopGalley(3);
            request.setAttribute("listTop3Gallery", listTop3Gallery);
            request.setAttribute("contact", photoDAO.getContact());

            //check index page
            String pageIndex = request.getParameter("index");
            int index = 0;
            if (pageIndex != null) {
                index = Integer.parseInt(pageIndex);
            } else {
                index = 1;
            }

            //count total result 
            int totalGallery = photoDAO.count();
            if (totalGallery <= 0) {
                request.setAttribute("error", "No result!!");
            }
            int pageSize = 3;
            //Find the number of page will have
            int maxPage = totalGallery / pageSize;
            if ((totalGallery % pageSize) != 0) {
                maxPage++;
            }

            //when the parameter returned is not true
            if (index > maxPage || index < 1) {
                request.setAttribute("error", "Don't have this Page");
            }

            //get list gallery with paging
            List<Gallery> listGalleryWithPage = photoDAO.getListGaleryWithPaging(index, pageSize);
            request.setAttribute("listGallery", listGalleryWithPage);
            request.setAttribute("index", index);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("active", "0");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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
