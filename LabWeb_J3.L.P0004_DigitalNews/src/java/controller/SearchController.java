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

/**
 * This class has a method to handle searching for news by title, pagination
 * Servlet will switch to error page when any error occurs
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
@WebServlet(name = "SearchControl", urlPatterns = {"/SearchControl"})
public class SearchController extends HttpServlet {

    /**
     * It searches news by title, pagination and pushes new news to
     * SearchResultPage.jsp If the user does not enter or enters a space, then
     * push back to HomePage for the user to re-enter If there are no search
     * results, then push to the error page Each page will have a maximum of 3
     * news Servlet will switch to error page when any error occurs
     *
     * @param request provides important information about a client request to a
     * servlet
     * @param response respond to an HTTP Request to the browser
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String txtSearch = request.getParameter("txtSearch").trim();
            String pageIndex = request.getParameter("index");
            //case the user hasn't clicked on any page yet
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);
            DigiatalDAO digitalDAO = new DigitalDAOImpl();
            int totalNews = digitalDAO.count(txtSearch);
            int pageSize = 3;
            int maxPage = totalNews / pageSize;
            //find max page
            if (totalNews % pageSize != 0) {
                maxPage++;
            }
            List<Digital> listSearch = digitalDAO.search(txtSearch, index, pageSize);

            request.setAttribute("list", listSearch);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("txt", txtSearch);
            request.setAttribute("index", index);

            List<Digital> listTop6News = digitalDAO.getTop(6);
            request.setAttribute("top1", listTop6News.get(0));
            listTop6News.remove(0);
            List<Digital> listTop5News = listTop6News;

            request.setAttribute("top5", listTop5News);

            //case have result
            if (maxPage >= 1 && !txtSearch.equals("")) {
                request.getRequestDispatcher("SearchResultPage.jsp").forward(request, response);
            } else if (txtSearch.equals("")) {
                request.getRequestDispatcher("HomeControl").forward(request, response);
            } else {
                request.setAttribute("error", "Not Found !!!");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
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
