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

import entity.Question;
import java.util.ArrayList;

/**
 * This interface will retrieve data from Question, History table in the database
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public interface QuizDAO {
    
    /**
     * Count the number of Question in Question table. The result is number of Question in
     * Question table
     *
     * @return the number of Question. It is an int number
     * @throws java.lang.Exception
     */
    public int getNumOfQuestion() throws Exception;
    
    /**
     * Get 'num' Question in Question. The result contain a list of
     * <code>Question</code> objects with Id, content, answer, opt, dateCr
     *
     * @param num the number of Question. It is an int number
     * @return a list of <code>Question</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<Question> getQuestion(int num) throws Exception;
    
    /**
     * Insert userId and point into History table
     *
     * @param userID the userId of User object. It is an int number
     * @param point the point of that user. It is a float number
     * @throws java.lang.Exception
     */
    public void insertHistory(int userID,float point) throws Exception;
    
    /**
     * Insert Question into Question table
     *
     * @param question the Question object. It is a <code>Question</code> object
     * @throws java.lang.Exception
     */
    public void insertQuiz(Question question) throws Exception;
    
    /**
     * Count the number of Question in Question table. The result is number of Question in
     * Question table
     *
     * @return the number of Question. It is an int number
     * @throws java.lang.Exception
     */
    public int quizCount() throws Exception;
    
    /**
     * Get limit Question for page. All Question from row (pageSize*pageIndex -
     * (pageSize-1)) to (pageSize*pageIndex) row will be returned. The result
     * contain a list of <code>Question</code> objects with Id, content, answer, opt, dateCr
     *
     * @param pageIndex the index of the page. It is an int number
     * @param pageSize maximum number of Question on one page. It is an int number
     * @return a list of <code>Question</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<Question> getAllQuiz(int pageIndex, int pageSize) throws Exception;
    
    /**
     * Delete Question by id in Question table
     *
     * @param id the id of Question object. It is an int number
     * @throws java.lang.Exception
     */
    public void deleteQuiz(int id) throws Exception;
}
