/**
 * Copyright(C) 2021, Hoang Thi Kim Anh.
 * J3.L.P0004
 * Digital News
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-05-10      1.0                 AnhHTK           First Implement
 * 2021-05-12      2.0                 AnhHTK           Second Implement
 * 2021-05-14      3.0                 AnhHTK           Third Implement
 * 2021-05-17      4.0                 AnhHTK           Four Implement
 */
package controller;

import dao.impl.DigitalDAOImpl;
import entity.Digital;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DigiatalDAO;
import java.text.SimpleDateFormat;

/**
 * This class has a method that handles putting top 1, top5, and current news on
 * the home page Servlet will switch to error page when any error occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "HomeControl", urlPatterns = {"/HomeControl"})
public class HomeController extends HttpServlet {

    /**
     * It push the latest news and the next 5 latest news to the home page When
     * the user selects other news in the next 5 news the servlet will get the
     * id of that news and push that to the current news Servlet will switch to
     * error page when any error occurs
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code> javax.servlet.http.HttpServletRequest </code>
     * @param response respond to an HTTP Request to the browser.
     * It is a <code> javax.servlet.http.HttpServletResponse </code>
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            DigiatalDAO digitalDAO = new DigitalDAOImpl();
            List<Digital> listTop6News = digitalDAO.getTop(6);
            request.setAttribute("top1", listTop6News.get(0));
            String id = request.getParameter("id");
            //case the user does not click on any news
            if (id == null) {
                id = listTop6News.get(0).getId() + "";
            }
            listTop6News.remove(0);
            List<Digital> listTop5News = listTop6News;

            Digital currentNews = digitalDAO.getNewsByID(Integer.parseInt(id));
            String dateConvert = new SimpleDateFormat("MMMM dd yyy '-' HH:mmaaa").format(currentNews.getTimePost()).toLowerCase();
            request.setAttribute("currentNews", currentNews);
            request.setAttribute("dateConvert", dateConvert);
            request.setAttribute("top5", listTop5News);

            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request provides important information about a client request to a
     * servlet. It is a <code> javax.servlet.http.HttpServletRequest </code>
     * @param response respond to an HTTP Request to the browser
     * It is a <code> javax.servlet.http.HttpServletResponse </code>
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
     * @param response respond to an HTTP Request to the browser
     * It is a <code> javax.servlet.http.HttpServletResponse </code>
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
