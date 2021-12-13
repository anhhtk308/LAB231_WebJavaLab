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
package entity;

import dao.PhotoDAO;
import dao.impl.PhotoDAOImpl;

/**
 * This class contains properties, constructor, getter, setter of Gallery object
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class Gallery {
    private int id;
    private String title;
    private String description;
    private String name;

    /**
     * Parameterless constructor used to initialize a Gallery object
     */
    public Gallery() {
    }

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include id, title,
     * description, name, image
     *
     * @param id the id of Gallery. It is an int number
     * @param title the title of Gallery. It is a <code>java.lang.String</code>
     * object
     * @param description the description of Gallery. It is a
     * <code>java.lang.String</code> object
     * @param name the name of Gallery. It is a <code>java.lang.String</code>
     * object
     */
    public Gallery(int id, String title, String description, String name) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.name = name;
    }

    /**
     * Get value from id attribute of <code>Gallery</code> object
     *
     * @return id of object
     */
    public int getId() {
        return id;
    }

    /**
     * Set value for id attribute of <code>Gallery</code> object
     *
     * @param id the id of Gallery. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from title attribute of <code>Gallery</code> object
     *
     * @return title of object
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set value for title attribute of <code>Gallery</code> object
     *
     * @param title the title of object. It is a <code>java.lang.String</code>
     * object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get value from description attribute of <code>Gallery</code> object
     *
     * @return description of object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set value for description attribute of <code>Gallery</code> object
     *
     * @param description the description of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value from name attribute of <code>Gallery</code> object
     *
     * @return name of object
     */
    public String getName() {
        return name;
    }

    /**
     * Set value for name attribute of <code>Gallery</code> object
     *
     * @param name the name of object. It is a <code>java.lang.String</code>
     * object
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get image url of Gallery of <code>Gallery</code> object
     *
     * @return image of object
     * @throws java.lang.Exception
     */
    public String getImage() throws Exception {
        PhotoDAO photoDAO = new PhotoDAOImpl();
        return photoDAO.getImageByGaleryID(id);
    }

}
