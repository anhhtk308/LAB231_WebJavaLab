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
package entity;

/**
 * This class contains properties, constructor, getter, setter of User object
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private boolean type;
    private String email;

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include id, userName,
     * password, type, email
     *
     * @param id the id of User. It is an int number
     * @param username the userName of User. It is a
     * <code>java.lang.String</code> object
     * @param password the password of User. It is a
     * <code>java.lang.String</code> object
     * @param type the type account of User. It is a
     * <code>java.lang.boolean</code>
     * @param email the email of User. It is a <code>java.lang.String</code>
     * object
     */
    public User(int id, String username, String password, boolean type, String email) {
        this.id = id;
        this.userName = username;
        this.password = password;
        this.type = type;
        this.email = email;
    }

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include userName, password,
     * type, email
     *
     * @param username the userName of User. It is a
     * <code>java.lang.String</code> object
     * @param password the password of User. It is a
     * <code>java.lang.String</code> object
     * @param type the type account of User. It is a
     * <code>java.lang.boolean</code>
     * @param email the email of User. It is a <code>java.lang.String</code>
     * object
     */
    public User(String username, String password, boolean type, String email) {
        this.userName = username;
        this.password = password;
        this.type = type;
        this.email = email;
    }

    /**
     * Parameterless constructor used to initialize a ContactInfor object
     */
    public User() {
    }

    /**
     * Get value from id attribute of <code>User</code> object
     *
     * @return id of object
     */
    public int getId() {
        return id;
    }

    /**
     * Set value for id attribute of <code>User</code> object
     *
     * @param id the id of User. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from userName attribute of <code>User</code> object
     *
     * @return userName of object
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set value for userName attribute of <code>User</code> object
     *
     * @param userName the userName of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get value from password attribute of <code>User</code> object
     *
     * @return password of object
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set value for password attribute of <code>User</code> object
     *
     * @param password the password of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get value from type attribute of <code>User</code> object
     *
     * @return type of object
     */
    public boolean isType() {
        return type;
    }

    /**
     * Set value for type attribute of <code>User</code> object
     *
     * @param type the type account of User. It is a
     * <code>java.lang.boolean</code>
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     * Get value from email attribute of <code>User</code> object
     *
     * @return email of object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value for email attribute of <code>User</code> object
     *
     * @param email the password of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
