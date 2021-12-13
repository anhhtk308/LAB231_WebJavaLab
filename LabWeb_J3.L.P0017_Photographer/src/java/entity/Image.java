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

/**
 * This class contains properties, constructor, getter, setter of Image object
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class Image {
    private int id;
    private int galleryId;
    private String imageUrl;

    /**
     * Parameterless constructor used to initialize a Image object
     */
    public Image() {
    }

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include id, galleryID,
     * imageUrl
     *
     * @param id the id of Image. It is an int number
     * @param galeryId the id of Gallery. It is an int number
     * @param imageUrl the url of image. It is a <code>java.lang.String</code>
     * object
     */
    public Image(int id, int galeryId, String imageUrl) {
        this.id = id;
        this.galleryId = galeryId;
        this.imageUrl = imageUrl;
    }

    /**
     * Get value from id attribute of <code>Image</code> object
     *
     * @return id of Image
     */
    public int getId() {
        return id;
    }

    /**
     * Set value for id attribute of <code>Image</code> object
     *
     * @param id the id of image. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from galleryId attribute of <code>Image</code> object
     *
     * @return id of gallery
     */
    public int getGaleryId() {
        return galleryId;
    }

    /**
     * Set value for galleryId attribute of <code>Image</code> object
     *
     * @param galeryId the ID of Gallery. It is an int number
     */
    public void setGaleryId(int galeryId) {
        this.galleryId = galeryId;
    }

    /**
     * Get value from imageUrl attribute of <code>Image</code> object
     *
     * @return imageUrl of object
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Set value for imageUrl attribute of <code>Image</code> object
     *
     * @param imageUrl the url of Image. It is a <code>java.lang.String</code>
     * object
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
