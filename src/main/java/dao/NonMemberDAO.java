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

            // SQL文の準備
            String sql = "SELECT user_id, name, email, pass FROM users WHERE email = ? AND pass= ? ";
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
                user.setPass(rs.getString("pass")); // 保存されているハッシュ
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
