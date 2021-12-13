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
package dao;

import entity.Digital;
import java.util.List;

/**
 * This class contains interfaces for retrieving data from digital tables in the database.
 * <p>Bugs: None
 * 
 * @author Hoang Thi Kim Anh
 */
public interface DigiatalDAO {
    /**
     * Get top number latest news. number latest news based on posting time and sorted by descending time will be returned
     * The result contain a list of <code>Digital</code> objects
     * with id, title, description, image, author, timePost, shortDes
     * 
     * @param number the number of latest news
     * @return a list of <code>Digital</code> objects. It is a <code>java.util.List</code> object
     * @throws java.lang.Exception
    */
    public List<Digital> getTop(int number) throws Exception;
    
    /**
     * Get the digital by id. All the digital matched with id will be returned
     * The result contain a <code>Digital</code> objects
     * with id, title, description, image, author, timePost, shortDes
     * 
     * @param id the id of the news
     * @return a <code>Digital</code> objects
     * @throws java.lang.Exception
    */
    public Digital getNewsByID(int id) throws Exception;
    
    /**
     * Find digital by title. All digital from row pageSize * (pageIndex - 1) to next pageSize rows
     * matching text will be returned
     * The result contain a list of <code>Digital</code> objects
     * with id, title, description, image, author, timePost, shortDes
     * 
     * @param txt the text user want to search
     * @param pageIndex the index of the page
     * @param pageSize maximum number of news on one page
     * @return a list of <code>Digital</code> objects. It is a <code>java.util.List</code> object
     * @throws java.lang.Exception
    */
    public List<Digital> search(String txt, int pageIndex, int pageSize) throws Exception;
    
    /**
     * Count the number of news title containing the text the user is looking for
     * The result is number of news title containing the text the user is looking for
     * 
     * @param txt the text user want to search
     * @return an integer number
     * @throws java.lang.Exception
    */
    public int count(String txt) throws Exception;
}
