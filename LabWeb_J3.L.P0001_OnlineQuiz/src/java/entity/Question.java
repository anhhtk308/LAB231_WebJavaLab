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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class contains properties, constructor, getter, setter of Question
 * object
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class Question {

    private int id;
    private String content;
    private String answer;
    private List<String> opt;
    private Date dateCr;

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include id, content, answer,
     * opt, dateCr
     *
     * @param id the id of User. It is an int number
     * @param content the content of Question. It is a
     * <code>java.lang.String</code> object
     * @param answer the answer of Question. It is a
     * <code>java.lang.String</code> object
     * @param opt the list option answer of Question. It is a
     * <code>java.util.List</code>
     * @param dateCr the date created of Question. It is a
     * <code>java.util.Date</code> object
     */
    public Question(int id, String content, String answer, List<String> opt, Date dateCr) {
        this.id = id;
        this.content = content;
        this.answer = answer;
        this.opt = opt;
        this.dateCr = dateCr;
    }
    
    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include content, opt
     *
     * @param content the content of Question. It is a
     * <code>java.lang.String</code> object
     * @param opt the list option answer of Question. It is a
     * <code>java.util.List</code>
     */
    public Question(String content, List<String> opt) {
        this.content = content;
        this.opt = opt;
    }

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include id, content, answer,
     * opt, dateCr
     *
     * @param content the content of Question. It is a
     * <code>java.lang.String</code> object
     * @param answer the answer of Question. It is a
     * <code>java.lang.String</code> object
     * @param opt the list option answer of Question. It is a
     * <code>java.util.List</code>
     * @param dateCr the date created of Question. It is a
     * <code>java.util.Date</code> object
     */
    public Question(String content, String answer, List<String> opt, Date dateCr) {
        this.content = content;
        this.answer = answer;
        this.opt = opt;
        this.dateCr = dateCr;
    }

    /**
     * Parameterless constructor used to initialize a ContactInfor object
     */
    public Question() {
        this.opt = new ArrayList<>();
    }

    /**
     * Set value for id attribute of <code>Question</code> object
     *
     * @param id the id of User. It is an int number
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Get value from id attribute of <code>Question</code> object
     *
     * @return id of object
     */
    public int getId() {
        return id;
    }

    /**
     * Get value from content attribute of <code>Question</code> object
     *
     * @return content of object
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value for content attribute of <code>Question</code> object
     *
     * @param content the content of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get value from answer attribute of <code>Question</code> object
     *
     * @return answer of object
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set value for answer attribute of <code>Question</code> object
     *
     * @param answer the answer of object. It is a <code>java.lang.String</code>
     * object
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Get value from opt attribute of <code>Question</code> object
     *
     * @return opt of object
     */
    public List<String> getOpt() {
        return opt;
    }

    /**
     * Set value for opt attribute of <code>Question</code> object
     *
     * @param opt the opt of object. It is a <code>java.util.List</code> object
     */
    public void setOpt(List<String> opt) {
        this.opt = opt;
    }

    /**
     * Get value from dateCr attribute of <code>Question</code> object
     *
     * @return dateCr of object
     */
    public Date getDateCr() {
        return dateCr;
    }

    /**
     * Set value for dateCr attribute of <code>Question</code> object
     *
     * @param dateCr the dateCr of object. It is a <code>java.util.Date</code>
     * object
     */
    public void setDateCr(Date dateCr) {
        this.dateCr = dateCr;
    }

    /**
     * Get date format
     *
     * @return dateCr dd-MMM-yyyy
     */
    public String getDateFormat() {
        return new SimpleDateFormat("dd-MMM-yyyy").format(this.dateCr);
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", content=" + content + ", answer=" + answer + ", dateCr=" + dateCr + '}';
    }

}
