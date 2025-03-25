package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.NewsBean;

public class NewsDAO {

    // ニュース一覧を取得するメソッド
    public List<NewsBean> getAllNews() throws SQLException {
        List<NewsBean> newsList = new ArrayList<>();
        // DATE_FORMATを使ってstart_atを'yyyy.MM.dd'形式にフォーマット
        String sql = "SELECT news_id, title, main_text, created_at, updated_at, DATE_FORMAT(start_at, '%Y.%m.%d') AS start_at, ending_at FROM news ORDER BY created_at DESC";

        try (
                Connection conn = DBManager.getConnection(); // DB接続を取得
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet resultSet = pstmt.executeQuery() // SQLを実行して結果を取得
        ) {

            while (resultSet.next()) {
                NewsBean news = new NewsBean();
                news.setNewsId(resultSet.getInt("news_id"));
                news.setTitle(resultSet.getString("title"));
                news.setMainText(resultSet.getString("main_text"));
                news.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                if (resultSet.getTimestamp("updated_at") != null) {
                    news.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
                }

                // フォーマットされたstart_atを取得
                String startAt = resultSet.getString("start_at");
                news.setStartAt(startAt); // 文字列として保存

                if (resultSet.getTimestamp("ending_at") != null) {
                    news.setEndingAt(resultSet.getTimestamp("ending_at").toLocalDateTime());
                }
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // エラーをログに出力
            throw e; // エラーを再スロー
        }
        return newsList; // ニュース一覧を返す
    }

    public NewsBean getNewsById(int id) {
        NewsBean news = null;
        String sql = "SELECT news_id, title, main_text, created_at, updated_at, DATE_FORMAT(start_at, '%Y.%m.%d') AS start_at, ending_at FROM news WHERE news_id = ?";

        try (
                Connection conn = DBManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id); // パラメータを設定

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    news = new NewsBean();
                    news.setNewsId(resultSet.getInt("news_id"));
                    news.setTitle(resultSet.getString("title"));
                    news.setMainText(resultSet.getString("main_text"));
                    news.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                    if (resultSet.getTimestamp("updated_at") != null) {
                        news.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
                    }

                    // フォーマットされたstart_atを取得
                    String startAt = resultSet.getString("start_at");
                    news.setStartAt(startAt); // 文字列として保存

                    if (resultSet.getTimestamp("ending_at") != null) {
                        news.setEndingAt(resultSet.getTimestamp("ending_at").toLocalDateTime());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // エラーのログを出力
        }
        return news;
    }
}
