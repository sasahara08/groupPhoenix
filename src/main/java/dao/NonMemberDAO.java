package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import dto.LoginBean;

public class NonMemberDAO {

    private static final int ITERATIONS = 10000; // PBKDF2の繰り返し回数
    private static final int KEY_LENGTH = 256; // PBKDF2のキー長（ビット）

    /**
     * パスワードをPBKDF2でハッシュ化する
     * 
     * @param password パスワード
     * @param salt ソルト
     * @param iterations 繰り返し回数
     * @param keyLength キー長
     * @return ハッシュ化されたパスワード
     * @throws NoSuchAlgorithmException
     */
    private byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLength) throws NoSuchAlgorithmException {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            return skf.generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new NoSuchAlgorithmException("Error during PBKDF2 password hashing", e);
        }
    }

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

            // SQL文の準備
            String sql = "SELECT user_id, name, email, pass FROM users WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            // SQL実行
            rs = pstmt.executeQuery();

            // 結果が存在する場合、ユーザーオブジェクトを生成
            if (rs.next()) {
                user = new LoginBean();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPass(rs.getString("pass")); // 保存されているハッシュ
            }

            // パスワードの一致を確認
            if (user != null && checkPasswordPBKDF2(pass, user.getPass())) {
                updateLastLoginTime(conn, user.getUserId()); // ログイン時間を更新
            } else {
                user = null; // パスワードが一致しなければnullを返す
            }

        } catch (SQLException | NoSuchAlgorithmException e) {
            throw e;
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }

        return user;
    }

    /**
     * パスワードがPBKDF2でハッシュ化された値と一致するかを確認する
     * 
     * @param password 入力されたパスワード
     * @param storedHash 保存されたハッシュ値（ソルト + ハッシュ）
     * @return 一致すればtrue
     * @throws NoSuchAlgorithmException
     */
    private boolean checkPasswordPBKDF2(String password, String storedHash) throws NoSuchAlgorithmException {
        // storedHashの形式をチェック（必ず ':' が含まれていること）
        if (storedHash == null || !storedHash.contains(":")) {
            throw new IllegalArgumentException("Invalid stored hash format.");
        }

        // storedHashを ':' で分割
        String[] parts = storedHash.split(":");
        
        // 2つの部分（salt と hash）が必要
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid stored hash format, expected salt:hash.");
        }

        // salt と hash をそれぞれデコード
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] storedHashBytes = Base64.getDecoder().decode(parts[1]);

        // パスワードをハッシュ化
        byte[] hash = pbkdf2(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);

        // 比較
        return java.util.Arrays.equals(storedHashBytes, hash);
    }

    /**
     * ログイン時間を更新する
     * 
     * @param conn コネクション
     * @param userId ユーザーID
     * @throws SQLException データベース接続エラー発生時
     */
    private void updateLastLoginTime(Connection conn, int userId) throws SQLException {
        PreparedStatement pstmt = null;

        try {
            String sql = "UPDATE users SET last_login_at = ? WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
        }
    }
}
