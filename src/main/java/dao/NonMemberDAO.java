package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import dto.LoginBean;

public class NonMemberDAO {

    /**
     * メールアドレスとパスワードを使用してユーザーを認証する
     * 
     * @param email メールアドレス
     * @param pass パスワード
     * @return 認証成功時はUserDTOオブジェクト、失敗時はnull
     * @throws SQLException データベース接続エラー発生時
     * @throws NoSuchAlgorithmException
     */
    public LoginBean findByEmailAndPassword(String email, String pass) throws SQLException, NoSuchAlgorithmException {
        LoginBean user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // DBManagerからコネクションを取得
            conn = DBManager.getConnection();

            // SQL文の修正: 必要なすべてのカラムをSELECT
            String sql = "SELECT user_id, name, email, pass, kana, birthday, post_code, address, phone, gender, created_at, last_login_at, credit_card_number, credit_card_expiry_date, credit_card_security_code FROM users WHERE email = ? AND pass = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, pass);

            // SQL実行
            rs = pstmt.executeQuery();

            // 結果が存在する場合、ユーザーオブジェクトを生成
            if (rs.next()) {
                user = new LoginBean();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPass(rs.getString("pass"));
                
                user.setKana(rs.getString("kana"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPostCode(rs.getString("post_code"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setGender(rs.getString("gender"));
                user.setCreatedAt(rs.getDate("created_at"));
                user.setLastLoginAt(rs.getDate("last_login_at"));
                user.setCreditCardNumber(rs.getString("credit_card_number"));
                user.setCreditCardExpiryDate(rs.getString("credit_card_expiry_date"));
                user.setCreditCardSecurityCode(rs.getString("credit_card_security_code"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }

        return user;
    }

    /**
     * ログイン時間を更新する
     * 
     * @param userId ユーザーID
     * @throws SQLException データベース接続エラー発生時
     */
    public void updateLastLoginTime(int userId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // DBManagerからコネクションを取得
            conn = DBManager.getConnection();

            // SQL文の準備: 最終ログイン時間を現在時刻に更新
            String sql = "UPDATE users SET last_login_at = ? WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(2, userId);

            // SQL実行
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
    /**
     * ユーザーの情報を更新する
     * 
     * @param email メールアドレス（識別用）
     * @param name 名前
     * @param kana カナ
     * @param birthday 生年月日
     * @param postCode 郵便番号
     * @param address 住所
     * @param phone 電話番号
     * @param gender 性別
     * @param creditCardNumber クレジットカード番号
     * @param creditCardExpiryDate クレジットカードの有効期限
     * @param creditCardSecurityCode クレジットカードのセキュリティコード
     * @throws SQLException データベース接続エラー発生時
     */
    public void updateUserInfo(String email, String name, String kana, String birthday, String postCode, String address, String phone, String gender, String creditCardNumber, String creditCardExpiryDate, String creditCardSecurityCode) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();  // DB接続取得

            // SQL文の準備: ユーザー情報を更新する
            String sql = "UPDATE users SET name = ?, kana = ?, birthday = ?, post_code = ?, address = ?, phone = ?, gender = ?, credit_card_number = ?, credit_card_expiry_date = ?, credit_card_security_code = ? WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, kana);
            pstmt.setString(3, birthday);
            pstmt.setString(4, postCode);
            pstmt.setString(5, address);
            pstmt.setString(6, phone);
            pstmt.setString(7, gender);
            pstmt.setString(8, creditCardNumber);
            pstmt.setString(9, creditCardExpiryDate);
            pstmt.setString(10, creditCardSecurityCode);
            pstmt.setString(11, email);  // メールアドレスをWHERE句で使用

            // SQL実行
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}