package jp.co.opst.spring.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String userId;
    private String password;
    private String fstName;
    private String lstName;
    private String authority;

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the fstName
     */
    public String getFstName() {
        return fstName;
    }
    /**
     * @param fstName the fstName to set
     */
    public void setFstName(String fstName) {
        this.fstName = fstName;
    }
    /**
     * @return the lstName
     */
    public String getLstName() {
        return lstName;
    }
    /**
     * @param lstName the lstName to set
     */
    public void setLstName(String lstName) {
        this.lstName = lstName;
    }
    /**
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }
    /**
     * @param authority the authority to set
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }



}
