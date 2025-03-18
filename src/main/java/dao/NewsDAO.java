package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.NewsBean;

public class NewsDAO {

    // データベース接続情報を直接記述
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public NewsBean getNewsById(int id) {
        NewsBean news = null;
        String sql = "SELECT * FROM news WHERE id = ?";

        try (
            // データベース接続を直接行う
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id); // パラメータを設定

            // クエリの実行
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // ニュース情報をDTOに設定
                    news = new NewsBean(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("main_text"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime(),
                        rs.getTimestamp("start_at").toLocalDateTime(),
                        rs.getTimestamp("ending_at").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // エラーのログを出力
        }
        return news;
    }
}
