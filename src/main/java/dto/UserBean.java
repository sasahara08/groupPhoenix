package dto;

import java.time.LocalDateTime;
import java.util.Date;

public class UserBean {
	
	private int userId;
	private String name;
	private String kana;
	private Date birthday;
	private String postCode;
	private String address;
	private String phone;
	private String email;
	private GenderEnum gender;
	private String pass;
	private Date createdAt;
	private LocalDateTime LastLoginAt;
	private String creditCardNumber;
	private String creditCardExpiryDate;
	
	
	public UserBean(int userId, String name, String kana, Date birthday, String postCode, String address, String phone,
			String email, GenderEnum gender, String pass, Date createdAt, LocalDateTime lastLoginAt,
			String creditCardNumber, String creditCardExpiryDate) {
		this.userId = userId;
		this.name = name;
		this.kana = kana;
		this.birthday = birthday;
		this.postCode = postCode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.pass = pass;
		this.createdAt = createdAt;
		LastLoginAt = lastLoginAt;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExpiryDate = creditCardExpiryDate;
	}


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
		this.birthday = birthday;
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


	public int getGender() {
		return gender.getValue();
	}


	public void setGender(int value) {
		this.gender = GenderEnum.fromValue(value);
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
		this.createdAt = createdAt;
	}


	public LocalDateTime getLastLoginAt() {
		return LastLoginAt;
	}


	public void setLastLoginAt(LocalDateTime lastLoginAt) {
		LastLoginAt = lastLoginAt;
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
	
	
	
	
}
