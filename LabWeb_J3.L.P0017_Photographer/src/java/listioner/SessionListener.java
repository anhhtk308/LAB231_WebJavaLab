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
package listioner;

import dao.PhotoDAO;
import dao.impl.PhotoDAOImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * This class implement HttpSessionListener, has method that catch
 * sessionCreated event to count the viewCount access page
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class SessionListener implements HttpSessionListener {

    /**
     * Catch sessionCreated event. When session is created, this method will
     * catch that event, then update the viewCount in View table in database,
     * push list viewCount count to session
     *
     * @param se the session event. It is a
     * <code>javax.servlet.http.HttpSessionEvent;</code> object
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        PhotoDAO photoDAO = new PhotoDAOImpl();
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(5);
        try {
            photoDAO.increaseView();
             //get viewCount count
            int numberOfViews = photoDAO.getViews();
            //format viewCount to 6 number
            List<String> listViews = new ArrayList<>();
            String formatViews = String.format("%06d", numberOfViews);
            for (int i = formatViews.length() - 1; i >= 0; i--) {
                listViews.add(formatViews.charAt(i) + "");
            }
            session.setAttribute("numberOfViews", listViews);
        } catch (Exception ex) {
            Logger.getLogger(SessionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Catch Destroyed event.
     *
     * @param se the session event. It is a
     * <code>javax.servlet.http.HttpSessionEvent;</code> object
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
