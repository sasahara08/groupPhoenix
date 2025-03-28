package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * ユーザー情報を転送するためのDTOクラス
 * 
 * @since : 2025/03/21
 * @author : Generated
 */
public class LoginBean implements Serializable {
    private int userId;
    private String name;
    private String kana;
    private java.sql.Date birthday;
    private String gender;
    private String postCode;
    private String address;
    private String phone;
    private String email;
    private String pass;
    private java.sql.Date createdAt;
    private java.sql.Date lastLoginAt;
    private String creditCardNumber;
    private String creditCardExpiryDate;
    private String creditCardSecurityCode;
    
    // コンストラクタ
    public LoginBean() {}
    
    // getter, setter
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getKana() {
        return kana;
    }
    
    public void setKana(String kana) {
        this.kana = kana;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = (java.sql.Date) birthday;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getPostCode() {
        return postCode;
    }
    
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPass() {
        return pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = (java.sql.Date) createdAt;
    }
    
    public Date getLastLoginAt() {
        return lastLoginAt;
    }
    
    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = (java.sql.Date) lastLoginAt;
    }
    
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    
    public String getCreditCardExpiryDate() {
        return creditCardExpiryDate;
    }
    
    public void setCreditCardExpiryDate(String creditCardExpiryDate) {
        this.creditCardExpiryDate = creditCardExpiryDate;
    }
    
    public String getCreditCardSecurityCode() {
        return creditCardSecurityCode;
    }
    
    public void setCreditCardSecurityCode(String creditCardSecurityCode) {
        this.creditCardSecurityCode = creditCardSecurityCode;
    }
}