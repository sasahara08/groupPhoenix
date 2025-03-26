package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResaleCancelDAO {
	
	// 特定のチケットのステータスを「３」にする。
	// リセール取消時に使用
	public static void changeTicketStatus(int ticketId) {
		// データベース接続
		try (Connection connection = DBManager.getConnection()) {
			// sql設定
			String sql = "UPDATE tickes "
					+ "SET ticket_status_id = 3 "
					+ "WHERE id = ? ";
			// sqlにticketIDを代入して更新
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, ticketId);
			statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// チケット購入の詳細テーブル
	// チケット詳細レコードを1行削除(主キーで選んだレコードを削除)
	public static void deleteTicketDetail(int ticketDetailId) {
		// データベース接続
		try (Connection connection = DBManager.getConnection()) {
			// sql設定
			String sql = "delete from ticket_order_detail where ticket_order_detail_id = ?";
			// sqlにticketIDを代入して更新
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, ticketDetailId);
			statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
