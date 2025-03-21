package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import dto.LoginBean;

/**
 * ユーザー情報のデータアクセスオブジェクト
 * 
 * @since : 2025/03/21
 * @author : Generated
 */
public class NonMemberDAO {
    
    /**
     * メールアドレスとパスワードを使用してユーザーを認証する
     * 
     * @param email メールアドレス
     * @param pass パスワード
     * @return 認証成功時はUserDTOオブジェクト、失敗時はnull
     * @throws SQLException データベース接続エラー発生時
     */
    public LoginBean findByEmailAndPassword(String email, String pass) throws SQLException {
    	LoginBean user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // DBManagerからコネクションを取得
            conn = DBManager.getConnection();
            
            // SQL文の準備
            String sql = "SELECT user_id, name, email, pass FROM users WHERE email = ? AND pass = ?";
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
            }
            
            // ログイン成功した場合、last_login_atを更新
            if (user != null) {
                updateLastLoginTime(conn, user.getUserId());
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            // リソースのクローズ
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
        
        return user;
    }
    
    /**
     * 最終ログイン日時を更新する
     * 
     * @param conn 既存のデータベース接続
     * @param userId ユーザーID
     * @throws SQLException SQL実行エラー発生時
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
    
    /**
     * ユーザーIDによるユーザー情報の取得
     * 
     * @param userId ユーザーID
     * @return ユーザー情報のDTO
     * @throws SQLException データベース接続エラー発生時
     */
    public LoginBean findById(int userId) throws SQLException {
    	LoginBean user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = DBManager.getConnection();
            
            String sql = "SELECT * FROM users WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                user = new LoginBean();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setKana(rs.getString("kana"));
                user.setBirthday(rs.getDate("birthday"));
                user.setGender(rs.getString("gender"));
                user.setPostCode(rs.getString("post_code"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setPass(rs.getString("pass"));
                user.setCreatedAt(rs.getDate("created_at"));
                user.setLastLoginAt(rs.getTimestamp("last_login_at"));
                // クレジットカード情報は必要に応じて取得
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
}