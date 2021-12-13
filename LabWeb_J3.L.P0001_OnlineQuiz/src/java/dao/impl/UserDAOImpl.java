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
import dao.UserDAO;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class has methods for retrieving data from User tables in database.
 * The method will return an object of the class <code> java.lang.Exception</code>
 * when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class UserDAOImpl extends DBContext implements UserDAO {

    /**
     * Get user by user. User based on userName and password will be returned. The
     * result is a <code>User</code> objects with ID, userName, password,
     * type, email
     *
     * @param userName the user name. It is a
     * <code>java.lang.String</code> object
     * @param password the password. It is a
     * <code>java.lang.String</code> object
     * @return a <code>User</code> objects.
     * @throws java.lang.Exception
     */
    @Override
    public User getUser(String userName, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "SELECT  [ID],[userName],[passWord],[type],[email]\n"
                    + "FROM [dbo].[user] where [username] like ? and [password] like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5));
                return user;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
        return null;
    }

    /**
     * Check user exist. User based on userName will be returned. The
     * result is true if user exist, false if user does not exist
     *
     * @param userName the user name. It is a
     * <code>java.lang.String</code> object
     * @return a <code>User</code> objects.
     * @throws java.lang.Exception
     */
    @Override
    public boolean getUserExist(String userName) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();

            String sql = "SELECT  [ID]\n"
                    + "      ,[userName]\n"
                    + "      ,[passWord]\n"
                    + "      ,[type]\n"
                    + "      ,[email] "
                    + "  FROM [dbo].[user] where [username] like ? ";

            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
        return false;
    }

    /**
     * Insert user object into User table. User can login after register successfully
     *
     * @param user the user object. It is a <code>User</code> object
     * @throws java.lang.Exception
     */
    @Override
    public void insertUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String sql = "insert into [user] (userName,passWord,type,email) values (?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setBoolean(3, user.isType());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

   

}
