package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MembershipRegistrationCompleteDAO {
    public void insertMember(String name, String kana, String birthday, String gender, String postcode, String address, String phone, String email, String password, String expiry, String creditcard, String securitycode) throws SQLException {
        String sql = "INSERT INTO users (name, kana, birthday, gender, post_code, address, phone, email, pass, created_at, last_login_at, credit_card_number, credit_card_expiry_date, credit_card_security_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, kana);
            pstmt.setString(3, birthday);
            pstmt.setString(4, gender);
            pstmt.setString(5, postcode);
            pstmt.setString(6, address);
            pstmt.setString(7, phone);
            pstmt.setString(8, email);
            pstmt.setString(9, password);
            pstmt.setDate(10, java.sql.Date.valueOf(LocalDate.now()));
            pstmt.setTimestamp(11, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setString(12, creditcard);
            pstmt.setString(13, expiry);
            pstmt.setString(14, securitycode);

            pstmt.executeUpdate();
        }
    }
}
