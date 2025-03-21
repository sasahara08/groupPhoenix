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
	private int gender;
	private String pass;
	private Date createdAt;
	private LocalDateTime LastLoginAt;
	private String creditCardNumber;
	private String creditCardExpiryDate;

	// デフォルトコンストラクタ（空のコンストラクタ）
	public UserBean() {
		//		this.createdAt = new Date(); // データが作られた日を初期値に設定
		//		this.LastLoginAt = LocalDateTime.now(); // 現在日時を初期値に設定
	}

	public UserBean(int userId, String name, String kana, String phone, String email) {
		this.userId = userId;
		this.name = name;
		this.kana = kana;
		this.phone = phone;
		this.email = email;
	}

	public UserBean(int userId, String name, String kana, Date birthday, String postCode, String address, String phone,
			String email, int gender) {
		this.userId = userId;
		this.name = name;
		this.kana = kana;
		this.birthday = birthday;
		this.postCode = postCode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}

	public UserBean(String name, String kana, Date birthday, String postCode, String address, String phone,
			String email, int gender, String pass) {
		this.name = name;
		this.kana = kana;
		this.birthday = birthday;
		this.postCode = postCode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.pass = pass;
	}

	public UserBean(String name, String kana, String birthday, String postCode, String address, String phone,
			String email, String pass) {
		this.name = name;
		this.kana = kana;
		this.birthday = java.sql.Date.valueOf(birthday); // String型をDate型に変換
		this.postCode = postCode;
		this.address = address;
		this.phone = phone;
		this.email = email;
//		this.gender = Integer.parseInt(gender); // String型をint型に変換
		this.pass = pass;
	}

	//	public UserBean(int userId, String name, String kana, Date birthday, String postCode, String address, String phone,
	//			String email, String pass) {
	//		this.userId = userId;
	//		this.name = name;
	//		this.kana = kana;
	//		this.birthday = birthday;
	//		this.postCode = postCode;
	//		this.address = address;
	//		this.phone = phone;
	//		this.email = email;
	//		this.pass = pass;
	//	}

	public UserBean(int userId, String name, String kana, Date birthday, String postCode, String address, String phone,
			String email, int gender, String pass, Date createdAt, LocalDateTime lastLoginAt,
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
		this.LastLoginAt = lastLoginAt;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExpiryDate = creditCardExpiryDate;
	}

	public UserBean(int userId, String name, String kana, Date birthday, String postCode, String address, String phone,
			String email, int gender, String pass) {
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
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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
