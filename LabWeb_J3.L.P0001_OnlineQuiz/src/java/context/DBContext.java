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
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Contains methods to connect to the database and close the connection
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class DBContext {

    private InitialContext initial;
    private Context context;
    private String dbname;
    private String serverName;
    private String portNumber;
    private String username;
    private String password;

    /**
     * Parameterless constructor used to initialize a digital object
     */
    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbname = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            username = context.lookup("username").toString();
            password = context.lookup("password").toString();
        } catch (NamingException e) {
        }

    }

    /**
     * To connect with the database
     *
     * @return a connection to given database URL
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * Close ResultSet
     *
     * @param rs the ResultSet. It is a <code>java.sql.ResultSet</code> object
     * @throws SQLException
     */
    public void closeRs(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * Close Prepared Statement
     *
     * @param ps the PreparedStatement. It is a
     * <code>java.sql.PreparedStatement</code> object
     * @throws SQLException
     */
    public void closePs(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * Close Connection
     *
     * @param con the Connection. It is a <code>java.sql.Connection</code>
     * object
     * @throws SQLException
     */
    public void closeCon(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

}
