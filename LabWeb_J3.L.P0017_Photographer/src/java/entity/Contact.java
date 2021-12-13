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
 * This class contains properties, constructor, getter, setter of Contact object
 * <p>
 * Bugs: None
 *
 * @author Hoang Thi Kim Anh
 */
public class Contact {

    private String telephone;
    private String email;
    private String faceUrl;
    private String twitterUrl;
    private String googleUrl;
    private String about;
    private String address;
    private String city;
    private String country;
    private String mapUrl;
    private String imageMain;
    private String iconFace;
    private String iconTwitter;
    private String iconGoogle;

    /**
     * Parameterless constructor used to initialize a ContactInfor object
     */
    public Contact() {
    }

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include telephone, email,
     * faceUrl, twitterUrl, googleUrl, about, address, city, country, mapUrl,
     * imageMain, mainDes, iconFace, iconTwitter, iconGoogle
     *
     * @param telephone the phone number of Photographer. It is a
     * <code>java.lang.String</code> object
     * @param email the email number of Photographer. It is a
     * <code>java.lang.String</code> object
     * @param faceUrl the url Facebook. It is a <code>java.lang.String</code>
     * object
     * @param twitterUrl the url Twitter. It is a <code>java.lang.String</code>
     * object
     * @param googleUrl the url Google. It is a <code>java.lang.String</code>
     * object
     * @param about the about of Photographer. It is a
     * <code>java.lang.String</code> object
     * @param address the address of Photographer. It is a
     * <code>java.util.String</code> object
     * @param city the city of Photographer. It is a
     * <code>java.util.String</code> object
     * @param country the country of Photographer. It is a
     * <code>java.util.String</code> object
     * @param mapUrl the location of Photographer. It is a
     * <code>java.util.String</code> object
     * @param imageMain the main image that describes Photographer. It is a
     * <code>java.util.String</code> object
     * @param iconFace the url icon image Facebook. It is a
     * <code>java.lang.String</code> object
     * @param iconTwitter the url icon image Twitter. It is a
     * <code>java.lang.String</code> object
     * @param iconGoogle the url icon image Google. It is a
     * <code>java.lang.String</code> object
     */
    public Contact(String telephone, String email, String faceUrl, String twitterUrl, String googleUrl, String about, String address, String city, String country, String mapUrl, String imageMain, String iconFace, String iconTwitter, String iconGoogle) {
        this.telephone = telephone;
        this.email = email;
        this.faceUrl = faceUrl;
        this.twitterUrl = twitterUrl;
        this.googleUrl = googleUrl;
        this.about = about;
        this.address = address;
        this.city = city;
        this.country = country;
        this.mapUrl = mapUrl;
        this.imageMain = imageMain;
        this.iconFace = iconFace;
        this.iconTwitter = iconTwitter;
        this.iconGoogle = iconGoogle;
    }

    /**
     * Get value from telephone attribute of <code>Contact</code> object
     *
     * @return telephone of object
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set value for telephone attribute of <code>Contact</code> object
     *
     * @param telephone the phone number of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Get value from email attribute of <code>Contact</code> object
     *
     * @return email of object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value for email attribute of <code>Contact</code> object
     *
     * @param email the email of object. It is a <code>java.lang.String</code>
     * object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get value url from faceUrl attribute of <code>Contact</code> object
     *
     * @return faceUrl of object
     */
    public String getFaceUrl() {
        return faceUrl;
    }

    /**
     * Set value for faceUrl attribute of <code>Contact</code> object
     *
     * @param faceUrl the Facebook url of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    /**
     * Get value url from twitterUrl attribute of <code>Contact</code> object
     *
     * @return twitterUrl of object
     */
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     * Set value for twitterUrl attribute of <code>Contact</code> object
     *
     * @param twitterUrl the Twitter url of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     * Get value from googleUrl attribute of <code>Contact</code> object
     *
     * @return googleUrl of object
     */
    public String getGoogleUrl() {
        return googleUrl;
    }

    /**
     * Set value for googleUrl attribute of <code>Contact</code> object
     *
     * @param googleUrl the Google url of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    /**
     * Get value from about attribute of <code>Contact</code> object
     *
     * @return about of object
     */
    public String getAbout() {
        return about;
    }

    /**
     * Set value for about attribute of <code>Contact</code> object
     *
     * @param about the about of object. It is a <code>java.lang.String</code>
     * object
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Get value from address attribute of <code>Contact</code> object
     *
     * @return address of object
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set value for address attribute of <code>Contact</code> object
     *
     * @param address the address of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get value from city attribute of <code>Contact</code> object
     *
     * @return city of object
     */
    public String getCity() {
        return city;
    }

    /**
     * Set value for city attribute of <code>Contact</code> object
     *
     * @param city the city of object. It is a <code>java.lang.String</code>
     * object
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get value from country attribute of <code>Contact</code> object
     *
     * @return country of object
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set value for country attribute of <code>Contact</code> object
     *
     * @param country the country of object. It is a
     * <code>java.lang.String</code> object
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get value from mapUrl attribute of <code>Contact</code> object
     *
     * @return mapUrl of object
     */
    public String getMapUrl() {
        return mapUrl;
    }

    /**
     * Set value for mapUrl attribute of <code>Contact</code> object
     *
     * @param mapUrl the mapUrl of object. It is a <code>java.lang.String</code>
     * object
     */
    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    /**
     * Get value from imageMain attribute of <code>Contact</code> object
     *
     * @return imageMain of object
     */
    public String getImageMain() {
        return imageMain;
    }

    /**
     * Set value for imageMain attribute of <code>Contact</code> object
     *
     * @param imageMain the main image url. It is a
     * <code>java.lang.String</code> object
     */
    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    /**
     * Get value from iconFace attribute of <code>Contact</code> object
     *
     * @return iconFace of object
     */
    public String getIconFace() {
        return iconFace;
    }

    /**
     * Set value for iconFace attribute of <code>Contact</code> object
     *
     * @param iconFace the icon facebook url. It is a
     * <code>java.lang.String</code> object
     */
    public void setIconFace(String iconFace) {
        this.iconFace = iconFace;
    }

    /**
     * Get value from iconTwitter attribute of <code>Contact</code> object
     *
     * @return iconTwitter of object
     */
    public String getIconTwitter() {
        return iconTwitter;
    }

    /**
     * Set value for iconTwitter attribute of <code>Contact</code> object
     *
     * @param iconTwitter the icon twitter url. It is a
     * <code>java.lang.String</code> object
     */
    public void setIconTwitter(String iconTwitter) {
        this.iconTwitter = iconTwitter;
    }

    /**
     * Get value from iconGoogle attribute of <code>Contact</code> object
     *
     * @return iconGoogle of object
     */
    public String getIconGoogle() {
        return iconGoogle;
    }

    /**
     * Set value for iconGoogle attribute of <code>Contact</code> object
     *
     * @param iconGoogle the icon google url. It is a
     * <code>java.lang.String</code> object
     */
    public void setIconGoogle(String iconGoogle) {
        this.iconGoogle = iconGoogle;
    }

}
