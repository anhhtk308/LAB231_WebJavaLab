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
package dao.impl;

import context.DBContext;
import dao.QuizDAO;
import entity.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class has methods for retrieving data from Question, History tables in database.
 * The method will return an object of the class <code> java.lang.Exception</code>
 * when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class QuizDAOImpl extends DBContext implements QuizDAO {

    /**
     * Count the number of Question in Question table. The result is number of Question in
     * Question table
     *
     * @return the number of Question. It is an int number
     * @throws java.lang.Exception
     */
    @Override
    public int getNumOfQuestion() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "SELECT COUNT(*) as num\n"
                    + "  FROM Question";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
        return 0;
    }

    /**
     * Get 'num' Question in Question. The result contain a list of
     * <code>Question</code> objects with Id, content, answer, opt, dateCr
     *
     * @param num the number of Question. It is an int number
     * @return a list of <code>Question</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Question> getQuestion(int num) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> lstQuestions = new ArrayList<>();
        try {
            conn = getConnection();
            String sql = "SELECT TOP (?) [ID]\n"
                    + "      ,[Content]\n"
                    + "      ,[answer]\n"
                    + "      ,[date]\n"
                    + "      ,[opt1]\n"
                    + "      ,[opt2]\n"
                    + "      ,[opt3]\n"
                    + "      ,[opt4]\n"
                    + "  FROM [dbo].[Question] order by NEWID()";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            while (rs.next()) {
                List<String> lstOpt = new ArrayList<>();
                lstOpt.add(rs.getString(5));
                lstOpt.add(rs.getString(6));
                lstOpt.add(rs.getString(7));
                lstOpt.add(rs.getString(8));
                lstQuestions.add(new Question(rs.getInt(1), rs.getString(2), rs.getString(3), lstOpt, rs.getDate(4)));
            }
            return lstQuestions;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

    /**
     * Insert userId and point into History table
     *
     * @param userID the userId of User object. It is an int number
     * @param point the point of that user. It is a float number
     * @throws java.lang.Exception
     */
    @Override
    public void insertHistory(int userID, float point) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "insert into history(userID,point,date) values (?,?,GETDATE());";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setFloat(2, point);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

    /**
     * Insert Question into Question table
     *
     * @param question the Question object. It is a <code>Question</code> object
     * @throws java.lang.Exception
     */
    @Override
    public void insertQuiz(Question question) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "INSERT INTO Question "
                    + "(Content,answer,date,opt1,opt2,opt3,opt4)\n"
                    + "VALUES (?,?,GETDATE(),?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, question.getContent());
            ps.setString(2, question.getAnswer());
            ps.setString(3, question.getOpt().get(0));
            ps.setString(4, question.getOpt().get(1));
            ps.setString(5, question.getOpt().get(2));
            ps.setString(6, question.getOpt().get(3));
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

    /**
     * Count the number of Question in Question table. The result is number of Question in
     * Question table
     *
     * @return the number of Question. It is an int number
     * @throws java.lang.Exception
     */
    @Override
    public int quizCount() throws Exception {
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        try {
            String sql = "select COUNT (*) as rownum from dbo.Question ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("rownum");
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
        return count;
    }

    /**
     * Get limit Question for page. All Question from row (pageSize*pageIndex -
     * (pageSize-1)) to (pageSize*pageIndex) row will be returned. The result
     * contain a list of <code>Question</code> objects with Id, content, answer, opt, dateCr
     *
     * @param pageIndex the index of the page. It is an int number
     * @param pageSize maximum number of Question on one page. It is an int number
     * @return a list of <code>Question</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Question> getAllQuiz(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> lstQuestions = new ArrayList<>();
        try {
            conn = getConnection();
            String sql = "select * from \n"
                    + " (select *,ROW_NUMBER() OVER(Order By ID ASC) "
                    + "as row_num from dbo.Question) a\n"
                    + " WHERE row_num >= (? - 1)*? +1 AND row_num<= (? * ?) ";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                List<String> lstOpt = new ArrayList<>();
                lstOpt.add(rs.getString(5));
                lstOpt.add(rs.getString(6));
                lstOpt.add(rs.getString(7));
                lstOpt.add(rs.getString(8));
                lstQuestions.add(new Question(rs.getInt(1), rs.getString(2), rs.getString(3), lstOpt, rs.getDate(4)));
            }
            return lstQuestions;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

     /**
     * Delete Question by id in Question table
     *
     * @param id the id of Question object. It is an int number
     * @throws java.lang.Exception
     */
    @Override
    public void deleteQuiz(int id) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        try {
            String sql = "delete from Question where id= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

    /**
     * String hyperlink
     *
     * @param label the text. It is a <code>java.lang.String</code>
     * @param href the url href to controller with param page
     * @return html string. It is a <code>java.lang.String</code>
     */
    public static String hyperlink(String label, String href) {
        return "<a class=\"page_hyperlink\" href=\"" + href + "\">" + label + "</a>";
    }

    /**
     * String pager
     *
     * @param pageIndex the current page index. It is an int number
     * @param pageCount caculated the number of page to pagging. It is an int number
     * @param gap the space of paging. It is an int number
     * @return html string. It is a <code>java.lang.String</code>
     */
    public static String pager(int pageIndex, int pageCount, int gap) {
        String result = "";
        if (pageIndex > gap) {
            result += hyperlink("First", "ManageQuizController?page=" + 1);
        }
        for (int i = gap - 1; i > 0; i--) {
            if (pageIndex - gap >= 0) {
                result += hyperlink("" + (pageIndex - i), "ManageQuizController?page=" + (pageIndex - i));
            }
        }
        result += "<span class=\"page_pageindex\">" + pageIndex + "</span>";
        for (int i = 1; i <= gap; i++) {
            if (pageIndex + i <= pageCount) {
                result += hyperlink("" + (pageIndex + i), "ManageQuizController?page=" + (pageIndex + i));
            }
        }
        if (pageIndex + gap < pageCount) {
            result += hyperlink("Last", "ManageQuizController?page=" + pageCount);
        }
        return result;
    }

}
