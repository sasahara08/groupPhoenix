package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dto.Ticket;

public class TicketDAO {

	// 全てのチケットを取得するメソッド
	public List<Ticket> getAllTickets() {
		List<Ticket> tickets = new ArrayList<>();
		String sql = "SELECT g.game_id, g.game_date, g.start_time, ht.team_name AS home_team_name, "
				+ "at.team_name AS away_team_name, sd.stadium_name "
				+ "FROM tickets t "
				+ "JOIN ticket_statuses ts ON t.ticket_status_id = ts.ticket_status_id "
				+ "LEFT JOIN games g ON t.game_id = g.game_id "
				+ "LEFT JOIN teams ht ON g.home_team_id = ht.team_id "
				+ "LEFT JOIN teams at ON g.away_team_id = at.team_id "
				+ "LEFT JOIN stadiums sd ON g.stadium_id = sd.stadium_id "
				+ "WHERE (g.game_date > CURRENT_DATE "
				+ "OR (g.game_date = CURRENT_DATE AND g.start_time >= CURRENT_TIME)) "
				+ "AND ts.ticket_status_id = 1 "
				+ "AND g.game_delete_at IS NULL "
				+ "GROUP BY g.game_id "
				+ "ORDER BY g.game_date "
				+ "LIMIT 3 ";

		System.out.println(sql);
		try (Connection conn = DBManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int gameId = rs.getInt("game_id");
				Date gameDate = rs.getDate("game_date");
				Time startTime = rs.getTime("start_time");
				String homeTeamName = rs.getString("home_team_name");
				String awayTeamName = rs.getString("away_team_name");
				String stadiumName = rs.getString("stadium_name");

				tickets.add(new Ticket(gameId, gameDate, startTime, homeTeamName, awayTeamName, stadiumName, 0, null, 0,
						0));
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving tickets: " + e.getMessage());
		}
		return tickets;

	}

	public Ticket getGameIdById(int ticket1) {
		Ticket game = null;
		String sql = "SELECT g.game_id, game_date , g.start_time, ht.team_name AS home_team_name, at.team_name AS away_team_name, sd.stadium_name, st.seat_price, st.seat_type "
				+ "FROM tickets t "
				+ "JOIN ticket_statuses ts ON t.ticket_status_id = ts.ticket_status_id "
				+ "JOIN seats st ON t.seat_id = st.seat_id "
				+ "LEFT JOIN games g ON t.game_id = g.game_id "
				+ "LEFT JOIN teams ht ON g.home_team_id = ht.team_id "
				+ "LEFT JOIN teams at ON g.away_team_id = at.team_id "
				+ "LEFT JOIN stadiums sd ON g.stadium_id = sd.stadium_id "
				+ "WHERE g.game_id = ?";

		try (
				Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, ticket1); // パラメータを設定

			try (ResultSet resultSet = pstmt.executeQuery()) {
				if (resultSet.next()) {
					System.out.println(resultSet.getDate("game_date"));
					int gameId = resultSet.getInt("game_id");
					Date gameDate = resultSet.getDate("game_date");
					Time startTime = resultSet.getTime("start_time");
					String homeTeamName = resultSet.getString("home_team_name");
					String awayTeamName = resultSet.getString("away_team_name");
					String stadiumName = resultSet.getString("stadium_name");
					int seatPrice = resultSet.getInt("seat_price");
					String seatType = resultSet.getString("seat_type");

					game = new Ticket(gameId, gameDate, startTime, homeTeamName, awayTeamName, stadiumName, seatPrice, seatType, 0, 0);
				}
			}

		} catch (SQLException e) {
			System.err.println("Error retrieving tickets: " + e.getMessage());
		}
		return game;
	}
	
	public Ticket getSeatdById(int ticket1) {
		Ticket game = null;
		String sql = "SELECT g.game_id, game_date , g.start_time, ht.team_name AS home_team_name, at.team_name AS away_team_name, sd.stadium_name, st.seat_price, st.seat_type "
				+ "FROM tickets t "
				+ "JOIN ticket_statuses ts ON t.ticket_status_id = ts.ticket_status_id "
				+ "JOIN seats st ON t.seat_id = st.seat_id "
				+ "LEFT JOIN games g ON t.game_id = g.game_id "
				+ "LEFT JOIN teams ht ON g.home_team_id = ht.team_id "
				+ "LEFT JOIN teams at ON g.away_team_id = at.team_id "
				+ "LEFT JOIN stadiums sd ON g.stadium_id = sd.stadium_id "
				+ "WHERE g.game_id = ? , s.seat_id = ?";

		try (
				Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, ticket1); // パラメータを設定

			try (ResultSet resultSet = pstmt.executeQuery()) {
				if (resultSet.next()) {
					System.out.println(resultSet.getDate("game_date"));
					int gameId = resultSet.getInt("game_id");
					Date gameDate = resultSet.getDate("game_date");
					Time startTime = resultSet.getTime("start_time");
					String homeTeamName = resultSet.getString("home_team_name");
					String awayTeamName = resultSet.getString("away_team_name");
					String stadiumName = resultSet.getString("stadium_name");
					int seatPrice = resultSet.getInt("seat_price");
					String seatType = resultSet.getString("seat_type");

					game = new Ticket(gameId, gameDate, startTime, homeTeamName, awayTeamName, stadiumName, seatPrice, seatType, 0, 0);
				}
			}

		} catch (SQLException e) {
			System.err.println("Error retrieving tickets: " + e.getMessage());
		}
		return game;

}

//String sql = "SELECT t.ticket_id,t.game_id,t.seat_id,t.seat_number,t.ticket_status_id,"
//		+ "s.ticket_status,st.seat_type,st.seat_price,tod.ticket_order_detail_id, "
//		+ "tod.ticket_order_id,tod.quantity,g.game_date,g.start_time,g.home_team_id, "
//		+ "ht.team_name AS home_team_name,g.away_team_id,at.team_name AS away_team_name, "
//		+ "g.stadium_id,sd.stadium_name,o.user_id,o.created_at "
//		+ "FROM tickets t "
//		+ "JOIN ticket_statuses s ON t.ticket_status_id = s.ticket_status_id "
//		+ "JOIN seats st ON t.seat_id = st.seat_id "
//		+ "LEFT JOIN ticket_order_detail tod ON t.ticket_id = tod.tikcet_id "
//		+ "LEFT JOIN ticket_orders o ON tod.ticket_order_id = o.ticket_order_id "
//		+ "LEFT JOIN games g ON t.game_id = g.game_id "
//		+ "LEFT JOIN teams ht ON g.home_team_id = ht.team_id "
//		+ "LEFT JOIN teams at ON g.away_team_id = at.team_id "
//		+ "LEFT JOIN stadiums sd ON g.stadium_id = sd.stadium_id ";
//
//try (Connection conn = DBManager.getConnection();
//     PreparedStatement stmt = conn.prepareStatement(sql);
//     ResultSet rs = stmt.executeQuery()) {
//
//    while (rs.next()) {
//        int ticketId = rs.getInt("ticket_id");
//        int gameId = rs.getInt("game_id");
//        int seatId = rs.getInt("seat_id");
//        String seatNumber = rs.getString("seat_number");
//        int ticketStatusId = rs.getInt("ticket_status_id");
//        String ticketStatus = rs.getString("ticket_status");
//        String seatType = rs.getString("seat_type");
//        double seatPrice = rs.getDouble("seat_price");
//        int ticketOrderDetailId = rs.getInt("ticket_order_detail_id");
//        int ticketOrderId = rs.getInt("ticket_order_id");
//        int quantity = rs.getInt("quantity");
//        Date gameDate = rs.getDate("game_date");
//        Time startTime = rs.getTime("start_time");
//        int homeTeamId = rs.getInt("home_team_id");
//        String homeTeamName = rs.getString("home_team_name");
//        int awayTeamId = rs.getInt("away_team_id");
//        String awayTeamName = rs.getString("away_team_name");
//        int stadiumId = rs.getInt("stadium_id");
//        String stadiumName = rs.getString("stadium_name");
//        int userId = rs.getInt("user_id");
//        String dateString = rs.getString("created_at");
//
//        // Parse created_at into LocalDateTime
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime createdAt = LocalDateTime.parse(dateString, formatter);
//
//        // Create and populate Ticket object
//        Ticket ticket = new Ticket(ticketId, gameId, seatId, seatNumber, ticketStatusId, ticketStatus, seatType,
//                                    seatPrice, ticketOrderDetailId, ticketOrderId, quantity, gameDate, startTime,
//                                    homeTeamId, awayTeamId, stadiumId, homeTeamName, awayTeamName, stadiumName,
//                                    userId, createdAt);
