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
package dao;

import entity.Contact;
import entity.Gallery;
import entity.Image;
import java.util.List;

/**
 * This interface will retrieve data from Gallery, Image, Contact, View table in the database
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public interface PhotoDAO {
    
    /**
     * Get top (number) Gallery. (number) Gallery based on Gallery_ID and sorted by
     * ascending time will be returned. The result contain a list of
     * <code>Gallery</code> objects with ID, title, description, name, image
     *
     * @param number the number of latest news. It is an int number
     * @return a list of <code>Digital</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Gallery> getTopGalley(int number) throws Exception;
    
    /**
     * Count the number of Gallery in database. The result is number of Gallery
     * in database
     *
     * @return number of gallery
     * @throws java.lang.Exception
     */
    public int count() throws Exception;
    
    /**
     * get limit Gallery for page. All Gallery from row (pageSize*pageIndex -
     * (pageSize-1)) to (pageSize*pageIndex) row will be returned. The result
     * contain a list of <code>Gallery</code> objects with iID, title,
     * description, name, image
     *
     * @param pageIndex the index of the page. It is an int number
     * @param pageSize maximum number of Gallery on one page. It is an int number
     * @return a list of <code>Gallery</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Gallery> getListGaleryWithPaging(int pageIndex, int pageSize) throws Exception;
    
    /**
     * Get all contact information of photographer. All information about
     * contact of photographer will be returned. The result is a
     * <code>ContactInfor</code> objects with telephone, email, face_url
     * twitter_url, google_url, about, address, city, country, map_url,
     * image_main, main_des, icon_face, icon_twitter, icon_google
     *
     * @return a <code>Contact</code> objects.
     * @throws java.lang.Exception
     */
    public Contact getContact() throws Exception;
    
    /**
     * Get the first Image. The first Image (sort by image id) with galleryID
     * will be returned. The result is a <code>Image</code> objects with id,
     * galery_id, image_url
     *
     * @param id the id of Gallery will get image. It is an int number
     * @return a <code>Contact</code> objects.
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    public String getImageByGaleryID(int id) throws Exception;
    
    /**
     * Count the number of Image in Gallery. The result is number of Image in
     * Gallery
     *
     * @param id the id of Gallery will get image
     * @return an integer number that has type is int
     * @throws java.lang.Exception
     */
    public int countImage(int id) throws Exception;
    
    /**
     * get limit Image for page. All Image from row (pageSize*pageIndex -
     * (pageSize-1)) to (pageSize*pageIndex) row will be returned. The result
     * contain a list of <code>Image</code> objects with id, galery_id,
     * image_url
     *
     * @param galeryID the id of Gallery will get image. It is an int number
     * @param pageIndex the index of the page. It is an int number
     * @param pageSize maximum number of Gallery on one page. It is an int number
     * @return a list of <code>Image</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Image> getListImageWithPaging(int galeryID, int pageIndex, int pageSize) throws Exception;
    
    /**
     * Get Gallery by ID. Gallery based on Gallery_ID will be returned. The
     * result is a <code>Gallery</code> objects with ID, title, description,
     * name, image
     *
     * @param id the Gallery_ID. It is an int number
     * @return a <code>Digital</code> objects.
     * @throws java.lang.Exception
     */
    public Gallery getGaleryByID(int id) throws Exception;
    
    /**
     * Get value from View field in View table. The result is view of page
     *
     * @return number of view
     * @throws java.lang.Exception
     */
    public int getViews() throws Exception;
    
    /**
     * Update value of View field in View table. The value of View field will be
     * update when access page
     *
     * @throws java.lang.Exception
     */
    public void increaseView() throws Exception;
}
