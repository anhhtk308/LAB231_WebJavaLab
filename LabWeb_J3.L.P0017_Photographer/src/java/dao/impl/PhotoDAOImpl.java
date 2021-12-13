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
package dao.impl;

import context.DBContext;
import dao.PhotoDAO;
import entity.Contact;
import entity.Gallery;
import entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class has methods for retrieving data from Gallery, Image, Contact, View tables in database.
 * The method will return an object of the class <code> java.lang.Exception</code>
 * when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class PhotoDAOImpl extends DBContext implements PhotoDAO {

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
    @Override
    public List<Gallery> getTopGalley(int number) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<Gallery> listTopGalery = new ArrayList<>();
            String query = "select top (?) * from galery";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, number);
            rs = ps.executeQuery();
            while (rs.next()) {
                listTopGalery.add(new Gallery(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return listTopGalery;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

    /**
     * Count the number of Gallery in database. The result is number of Gallery
     * in database
     *
     * @return number of gallery
     * @throws java.lang.Exception
     */
    @Override
    public int count() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from galery";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

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
    @Override
    public List<Gallery> getListGaleryWithPaging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Gallery> list = new ArrayList<>();
            String query = "select * from galery\n"
                    + "order by id offset ? rows fetch next ? rows only;";
            //open connection to sql
            conn = getConnection();
            //throws the query statement to sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, pageSize * (pageIndex - 1));
            ps.setInt(2, pageSize);
            //run the command and get the results returned
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
     * Get all contact information of photographer. All information about
     * contact of photographer will be returned. The result is a
     * <code>ContactInfor</code> objects with telephone, email, face_url
     * twitter_url, google_url, about, address, city, country, map_url,
     * image_main, main_des, icon_face, icon_twitter, icon_google
     *
     * @return a <code>Contact</code> objects.
     * @throws java.lang.Exception
     */
    @Override
    public Contact getContact() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from contact";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Contact(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14));
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
     * Get the first Image. The first Image (sort by image id) with galleryID
     * will be returned. The result is a <code>Image</code> objects with id,
     * galery_id, image_url
     *
     * @param id the id of Gallery will get image. It is an int number
     * @return a <code>Contact</code> objects.
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    @Override
    public String getImageByGaleryID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select top 1 image_url from image\n"
                    + "where galery_id = ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
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
     * Count the number of Image in Gallery. The result is number of Image in
     * Gallery
     *
     * @param id the id of Gallery will get image
     * @return an integer number that has type is int
     * @throws java.lang.Exception
     */
    @Override
    public int countImage(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from image where galery_id = ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int cout = 0;
            while (rs.next()) {
                cout = rs.getInt(1);
            }
            return cout;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
    }

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
    @Override
    public List<Image> getListImageWithPaging(int galeryID, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        int size = countImage(galeryID);
        try {
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn , * from  image where galery_id = ?) "
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, galeryID);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize - 1);
            ps.setInt(5, pageSize);
            ps.setInt(6, pageIndex);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Image(rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4)));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeRs(rs);
            closePs(ps);
            closeCon(conn);
        }
        return list;
    }

     /**
     * Get Gallery by ID. Gallery based on Gallery_ID will be returned. The
     * result is a <code>Gallery</code> objects with ID, title, description,
     * name, image
     *
     * @param id the Gallery_ID. It is an int number
     * @return a <code>Digital</code> objects.
     * @throws java.lang.Exception
     */
    @Override
    public Gallery getGaleryByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from galery where ID = ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Gallery(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
     * Get value from View field in View table. The result is view of page
     *
     * @return number of view
     * @throws java.lang.Exception
     */
    @Override
    public int getViews() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String query = "select * from [view]";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
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
     * Update value of View field in View table. The value of View field will be
     * update when access page
     *
     * @throws java.lang.Exception
     */
    @Override
    public void increaseView() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String query = "update [view] set [view] = [view] + 1";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closePs(ps);
            closeCon(conn);
        }
    }

}
