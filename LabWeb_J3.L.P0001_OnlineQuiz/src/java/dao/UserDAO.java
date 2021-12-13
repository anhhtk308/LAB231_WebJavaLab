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
package dao;

import entity.User;

/**
 * This interface will retrieve data from User table in the database
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public interface UserDAO {
    
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
    public User getUser(String userName,String password) throws Exception;
    
    /**
     * Check user exist. User based on userName will be returned. The
     * result is true if user exist, false if user does not exist
     *
     * @param userName the user name. It is a
     * <code>java.lang.String</code> object
     * @return a <code>User</code> objects.
     * @throws java.lang.Exception
     */
    public boolean getUserExist(String userName) throws Exception;
    
    /**
     * Insert user object into User table. User can login after register successfully
     *
     * @param user the user object. It is a <code>User</code> object
     * @throws java.lang.Exception
     */
    public void insertUser(User user) throws Exception;
}
