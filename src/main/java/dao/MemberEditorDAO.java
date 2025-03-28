package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberEditorDAO {

    // ユーザーIDに基づいてユーザー情報を取得（String[] で返す）
    public String[] getUserById(int userId) throws SQLException {
        String[] userInfo = null;
        String sql = "SELECT name, kana, post_code, address, phone, email, pass, credit_card_number, credit_card_expiry_date, credit_card_security_code "
                   + "FROM users WHERE user_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);  // user_idをセット
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // 必要な情報を配列に格納
                userInfo = new String[10]; // 配列に10項目を格納する
                userInfo[0] = rs.getString("name");
                userInfo[1] = rs.getString("kana");
                userInfo[2] = rs.getString("post_code");
                userInfo[3] = rs.getString("address");
                userInfo[4] = rs.getString("phone");
                userInfo[5] = rs.getString("email");
                userInfo[6] = rs.getString("pass");
                userInfo[7] = rs.getString("credit_card_number");
                userInfo[8] = rs.getString("credit_card_expiry_date");
                userInfo[9] = rs.getString("credit_card_security_code");
            }
        }

        return userInfo;
    }

    // ユーザー情報を更新
    public boolean updateUser(int userId, String name, String kana, String postCode, String address, String phone, String email, String password, String creditCard, String expiry, String securityCode) {
        String sql = "UPDATE users SET name = ?, kana = ?, post_code = ?, address = ?, phone = ?, email = ?, pass = ?, credit_card_number = ?, credit_card_expiry_date = ?, credit_card_security_code = ? WHERE user_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, kana);
            stmt.setString(3, postCode);
            stmt.setString(4, address);
            stmt.setString(5, phone);
            stmt.setString(6, email);
            stmt.setString(7, password);
            stmt.setString(8, creditCard);
            stmt.setString(9, expiry);
            stmt.setString(10, securityCode);
            stmt.setInt(11, userId);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
