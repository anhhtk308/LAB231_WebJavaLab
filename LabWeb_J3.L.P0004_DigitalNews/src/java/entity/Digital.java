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
package entity;

import java.util.Date;

/**
 * This class contains properties, constructor, getter, setter, toString of
 * Digital object
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class Digital {

    private int id;
    private String title;
    private String description;
    private String image;
    private String author;
    private Date timePost;
    private String shortDes;

    /**
     * Parameterless constructor used to initialize a digital object
     */
    public Digital() {
    }

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include id, title,
     * description, image, author, timePost, shortDes
     *
     * @param id the id of the news. It is a integer number
     * @param title the title of the news. It is a <code>java.lang.String</code> object
     * @param description the description of the news. It is a <code>java.lang.String</code> object
     * @param image the link image of the news. It is a <code>java.lang.String</code> object
     * @param author the author of the news. It is a <code>java.lang.String</code> object
     * @param timePost the time post of the news. It is a <code>java.util.Date</code> object
     * @param shortDes the short description of the news. It is a <code>java.lang.String</code> object
     */
    public Digital(int id, String title, String description, String image, String author, Date timePost, String shortDes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.timePost = timePost;
        this.shortDes = shortDes;
    }

    /**
     * Get value of id from id attribute
     *
     * @return id of object
     */
    public int getId() {
        return id;
    }

    /**
     * Set value for id attribute of object
     *
     * @param id the id of object. It a integer number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value of title from title attribute
     *
     * @return title of object
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set value for title attribute of object
     *
     * @param title the title of object. It is a <code>java.lang.String</code> object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get value of description from description attribute
     *
     * @return description of object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set value for description attribute of object
     *
     * @param description the description of object. It is a <code>java.lang.String</code> object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value of image from image attribute
     *
     * @return link image of object
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value for image attribute of object
     *
     * @param image the image of object. It is a <code>java.lang.String</code> object
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get value of author from author attribute
     *
     * @return author of object
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set value for author attribute of object
     *
     * @param author the author of object. It is a <code>java.lang.String</code> object
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get value of timePost from timePost attribute
     *
     * @return timePost of object
     */
    public Date getTimePost() {
        return timePost;
    }

    /**
     * Set value for timePost attribute of object
     *
     * @param timePost the timePost of object. It is a <code>java.util.Date</code> object
     */
    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    /**
     * Get value of shortDes from shortDes attribute
     *
     * @return shortDes of object.
     */
    public String getShortDes() {
        return shortDes;
    }

    /**
     * Set value for shortDes attribute of object
     *
     * @param shortDes the shortDes of object.It is a <code>java.lang.String</code> object
     */
    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

}
