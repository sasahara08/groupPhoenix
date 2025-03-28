package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.TicketsBean;

public class ResaleCancelDAO {

	//チケット情報_ticket_idが一致するもの
	public static TicketsBean OrderDetailId(int orderDetailId) {
		String sql = "SELECT TOD.ticket_purchase_status, TOD.created_at, TOD.user_id, T.ticket_status_id, T.tikcet_id, users.name, users.kana, games.game_id, games.game_date, games.start_time, home_team.team_id AS home_team_id, away_team.team_id AS away_team_id, stadiums.stadium_id, home_team.team_name, away_team.team_name, stadiums.stadium_name, ticket_statuses.ticket_status, TOD.ticket_order_detail_id "
				+
				"FROM ticket_order_detail AS TOD " +
				"LEFT JOIN tickets AS T ON TOD.ticket_id = T.tikcet_id " +
				"LEFT JOIN users ON TOD.user_id = users.user_id " +
				"LEFT JOIN games ON T.game_id = games.game_id " +
				"LEFT JOIN stadiums ON games.stadium_id = stadiums.stadium_id " +
				"LEFT JOIN teams AS home_team ON games.home_team_id = home_team.team_id " +
				"LEFT JOIN teams AS away_team ON games.away_team_id = away_team.team_id " +
				"LEFT JOIN ticket_statuses ON T.ticket_status_id = ticket_statuses.ticket_status_id " +
				"WHERE TOD.ticket_order_detail_id = ?";

		TicketsBean ticket = null;

		try (Connection connection = DBManager.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, orderDetailId); // プレースホルダーにorderDetailIdをセット

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					// TicketBeanにデータをセット
					ticket = new TicketsBean();
					ticket.setTicketStatusId(resultSet.getInt("T.ticket_status_id"));
					ticket.setTicketId(resultSet.getInt("T.tikcet_id"));
					ticket.setCreateAt(resultSet.getDate("TOD.created_at"));
					ticket.setUserId(resultSet.getInt("TOD.user_id"));
					ticket.setName(resultSet.getString("users.name"));
					ticket.setKana(resultSet.getString("users.kana"));
					ticket.setTicketPurchaseStatusId(resultSet.getInt("TOD.ticket_purchase_status"));
					ticket.setGameId(resultSet.getInt("games.game_id"));
					ticket.setGameDate(resultSet.getDate("games.game_date"));
					ticket.setStartTime(resultSet.getTime("games.start_time"));
					ticket.setHomeTeamName(resultSet.getString("home_team.team_name"));
					ticket.setAwayTeamName(resultSet.getString("away_team.team_name"));
					ticket.setStadium(resultSet.getString("stadiums.stadium_name"));
					ticket.setTicketStatus(resultSet.getString("ticket_statuses.ticket_status"));
					ticket.setOrderDetailId(resultSet.getInt("TOD.ticket_order_detail_id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket; // チケット情報を返す
	}

	// 特定のチケットのステータスを「３」にする。
	// リセール取消時に使用
	public static void changeTicketStatus(int ticketId) {
		// データベース接続
		try (Connection connection = DBManager.getConnection()) {
			// sql設定
			String sql = "UPDATE tickets "
					+ "SET ticket_status_id = 3 "
					+ "WHERE tikcet_id = ? ";
			// sqlにticketIDを代入して更新
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, ticketId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// チケット購入の詳細テーブル
	// チケット詳細レコードを1行削除(主キーで選んだレコードを削除)
	public static void deleteTicketDetail(int ticketDetailId) {
		// データベース接続
		try (Connection connection = DBManager.getConnection()) {
			// sql設定
			String sql = "DELETE FROM ticket_order_detail WHERE ticket_order_detail_id = ?";
			// sqlにticketIDを代入して更新
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, ticketDetailId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
