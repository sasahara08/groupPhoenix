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
		String sql = "SELECT * FROM news ORDER BY created_at DESC";

		try (
				Connection conn = DBManager.getConnection(); // DB接続を取得
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//            ResultSet rs = pstmt.executeQuery() // SQLを実行して結果を取得
				ResultSet resultSet = pstmt.executeQuery() // SQLを実行して結果を取得
		) {

			while (resultSet.next()) {
				NewsBean news = new NewsBean();
				news.setNewsId(resultSet.getInt("news_id"));
				news.setTitle(resultSet.getString("title"));
				news.setMainText(resultSet.getString("main_text"));
				news.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
				if(resultSet.getTimestamp("updated_at") != null) {
					news.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
				}
				news.setStartAt(resultSet.getTimestamp("start_at").toLocalDateTime());
				if(resultSet.getTimestamp("ending_at") != null) {
					news.setEndingAt(resultSet.getTimestamp("ending_at").toLocalDateTime());
				}
				newsList.add(news);
			}

			//            while (resultSet.next()) {
			//                // ニュース情報をNewsBeanオブジェクトに設定
			//                NewsBean news = new NewsBean(
			//                		news.setNewsId(resultSet.getInt("news_id"));
			//                		news.setTitle(resultSet.getString("title"));
			//                		news.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
			//                		news.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
			//                		news.setStartAt(resultSet.getTimestamp("start_at").toLocalDateTime());
			//                		news.setEndingAt(resultSet.getTimestamp("ending_at").toLocalDateTime());
			//                );
			//                // リストに追加
			//                newsList.add(news);
			//            }
		} catch (SQLException e) {
			e.printStackTrace(); // エラーをログに出力
			throw e; // エラーを再スロー
		}
		return newsList; // ニュース一覧を返す
	}

	public NewsBean getNewsById(int id) {
		NewsBean news = null;
		String sql = "SELECT * FROM news WHERE news_id = ?";

		try (
				// データベース接続を直接行う
				Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, id); // パラメータを設定

			// クエリの実行
			try(ResultSet resultSet = pstmt.executeQuery()) {
				if (resultSet.next()) {
					news = new NewsBean();
					// ニュース情報をDTOに設定
					news.setNewsId(resultSet.getInt("news_id"));
					news.setTitle(resultSet.getString("title"));
					news.setMainText(resultSet.getString("main_text"));
					news.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
					if(resultSet.getTimestamp("updated_at") != null) {
						news.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
					}
					news.setStartAt(resultSet.getTimestamp("start_at").toLocalDateTime());
					if(resultSet.getTimestamp("ending_at") != null) {
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