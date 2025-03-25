package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewUserDAO {
    private int userId;  // user_id
    private String name;
    private String kana;
    private Date birthday;
    private String gender;
    private String postcode;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String creditcard;
    private String expiry;
    private String securitycode;
    

    // getter と setter を追加
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

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreditcard() {
        return creditcard;
    }
    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    public String getExpiry() {
        return expiry;
    }
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getSecuritycode() {
        return securitycode;
    }
    public void setSecuritycode(String securitycode) {
        this.securitycode = securitycode;
    }



	public boolean registerUser(String name, String kana, String birthday, String gender,
			String postcode, String address, String phone,
			String email, String password,
			String creditCardNumber, String creditCardExpiryDate,
			String creditCardSecurityCode) {

		String sql = "INSERT INTO users (name, kana, birthday, gender, postcode, address, phone, email, password, "
				+ "creditcard, expiry, securitycode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = DBManager.getConnection(); // DBManagerから接続を取得
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, name);
			pstmt.setString(2, kana);
			pstmt.setString(3, birthday);
			pstmt.setString(4, gender);
			pstmt.setString(5, postcode);
			pstmt.setString(6, address);
			pstmt.setString(7, phone);
			pstmt.setString(8, email);
			pstmt.setString(9, password);
			pstmt.setString(10, creditCardNumber);
			pstmt.setString(11, creditCardExpiryDate);
			pstmt.setString(12, creditCardSecurityCode);

			int rowsInserted = pstmt.executeUpdate();
			return rowsInserted > 0; // 登録成功
		} catch (SQLException e) {
				System.err.println("SQLエラー: " + e.getMessage());
			    e.printStackTrace(); // スタックトレースを出力
			    return false; // 登録失敗
		}
	}
}

