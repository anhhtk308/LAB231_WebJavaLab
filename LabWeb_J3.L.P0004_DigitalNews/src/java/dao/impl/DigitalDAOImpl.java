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
package dao.impl;

import context.DBContext;
import entity.Digital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.DigiatalDAO;

/**
 * This class has methods for retrieving data from digital tables in database.
 * In the searching, the data is normalized (removing spaces from both ends)
 * before searching The method will return an object of the class
 * <code> java.lang.Exception</code> when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class DigitalDAOImpl extends DBContext implements DigiatalDAO {

    /**
     * Get top number latest news. number latest news based on posting time and
     * sorted by descending time will be returned The result contain a list of
     * <code>Digital</code> objects with id, title, description, image, author,
     * timePost, shortDes
     *
     * @param number the number of latest news. It is a integer number
     * @return a list of <code>Digital</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    @Override
    public List<Digital> getTop(int number) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Digital> list = new ArrayList<>();
            String query = "select top (?) * from digital\n"
                    + "order by timePost desc";

            //open connection to sql
            conn = getConnection();
            //throws the query statement to sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, number);
            //run the command and get the results returned
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                list.add(d);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

    /**
     * Get the digital by id. All the digital matched with id will be returned
     * The result contain a <code>Digital</code> objects with id, title,
     * description, image, author, timePost, shortDes
     *
     * @param id the id of the news. It is a integer number
     * @return a <code>Digital</code> objects
     * @throws java.lang.Exception
     */
    @Override
    public Digital getNewsByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from digital\n"
                    + "where ID = ?";
            //open connection to sql
            conn = getConnection();
            //throws the query statement to sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            //run the command and get the results returned
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                return d;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
        return null;
    }

    /**
     * Find digital by title. All digital from row pageSize * (pageIndex - 1) to
     * next pageSize rows matching text will be returned The result contain a
     * list of <code>Digital</code> objects with id, title, description, image,
     * author, timePost, shortDes
     *
     * @param txt the text user want to search. It is a <code>java.lang.String</code> object
     * @param pageIndex the index of the page. It is a integer number
     * @param pageSize maximum number of news on one page. It is a integer number
     * @return a list of <code>Digital</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    @Override
    public List<Digital> search(String txt, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Digital> list = new ArrayList<>();
            String query = "select * from digital\n"
                    + "where title like ?\n"
                    + "order by id\n"
                    + "offset ? rows fetch next ? rows only;";
            //open connection to sql
            conn = getConnection();
            //throws the query statement to sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            ps.setInt(2, pageSize * (pageIndex - 1));
            ps.setInt(3, pageSize);
            //run the command and get the results returned
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7));
                list.add(d);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

    /**
     * Count the number of news title containing the text the user is looking
     * for The result is number of news title containing the text the user is
     * looking for
     *
     * @param txt the text user want to search. It is a <code>java.lang.String</code> object
     * @return an integer number
     * @throws java.lang.Exception
     */
    @Override
    public int count(String txt) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select count(*) from digital \n"
                    + "where title like ?";
            //open connection to sql
            conn = getConnection();
            //throws the query statement to sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            //run the command and get the results returned
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            throw e;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

}
