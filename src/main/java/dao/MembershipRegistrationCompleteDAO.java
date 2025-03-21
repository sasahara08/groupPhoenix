import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class MembershipRegistrationCompleteDAO {

    // ユーザー情報をusersテーブルに挿入するメソッド
    public boolean registerUser(String name, String kana, String birthday, String gender, String postCode, 
                                 String address, String phone, String email, String password, 
                                 String creditCardNumber, String creditCardExpiryDate, String creditCardSecurityCode) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isRegistered = false;

        try {
            // DBManagerを使って接続
            conn = DBManager.getConnection();

            // 現在の日付を取得
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String createdAt = dateFormat.format(new java.util.Date());
            String lastLoginAt = createdAt; // 最初のログイン日時はアカウント作成日と同じ

            // SQLクエリ（新規会員情報の挿入）
            String sql = "INSERT INTO users (name, kana, birthday, gender, post_code, address, phone, email, pass, created_at, last_login_at, credit_card_number, credit_card_expiry_date, credit_card_security_code) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // PreparedStatementの作成
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, kana);
            stmt.setString(3, birthday); // 生年月日（yyyy-MM-dd形式）
            stmt.setString(4, gender);
            stmt.setString(5, postCode);
            stmt.setString(6, address);
            stmt.setString(7, phone);
            stmt.setString(8, email);
            stmt.setString(9, password); // パスワード（ハッシュ化されていない）
            stmt.setString(10, createdAt);
            stmt.setString(11, lastLoginAt);
            stmt.setString(12, creditCardNumber);
            stmt.setString(13, creditCardExpiryDate);
            stmt.setString(14, creditCardSecurityCode);

            // SQL実行
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isRegistered = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // リソースの解放
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRegistered;
    }
}
