package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dto.Resaleticket;

public class ResaleticketDAO {
	public List<Resaleticket> getAllTickets() {
		List<Resaleticket> tickets = new ArrayList<>();

		String sql = "SELECT  t.ticket_id, g.game_date, g.start_time, ht.team_name AS home_team_name, t.seat_number, "
				+ "at.team_name AS away_team_name, sd.stadium_name, st.seat_type, st.seat_price  "
				+ "FROM phoenix.tickets t "
				+ "JOIN phoenix.ticket_statuses ts ON t.ticket_status_id = ts.ticket_status_id "
				+ "JOIN seats st ON t.seat_id = st.seat_id "
				+ "LEFT JOIN ticket_order_detail tod ON t.ticket_id = tod.ticket_id "
				+ "LEFT JOIN games g ON t.game_id = g.game_id "
				+ "LEFT JOIN teams ht ON g.home_team_id = ht.team_id "
				+ "LEFT JOIN teams at ON g.away_team_id = at.team_id "
				+ "LEFT JOIN stadiums sd ON g.stadium_id = sd.stadium_id "
				+ "WHERE "
				+ "(g.game_date > CURRENT_DATE "
				+ "OR (g.game_date = CURRENT_DATE AND g.start_time >= CURRENT_TIME)) "
				+ "AND ts.ticket_status_id = 3 "
				+ "AND g.game_delete_at IS NULL ";

		System.out.println(sql);
		try (Connection conn = DBManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int ticketId = rs.getInt("ticket_id");
				Date gameDate = rs.getDate("game_date");
				Time startTime = rs.getTime("start_time");
				String homeTeamName = rs.getString("home_team_name");
				String awayTeamName = rs.getString("away_team_name");
				String stadiumName = rs.getString("stadium_name");
				int seatPrice = rs.getInt("seat_price");
				String seatType = rs.getString("seat_type");
				String seatNumber = rs.getString("seat_number");

				tickets.add(new Resaleticket(ticketId, gameDate, startTime, homeTeamName, awayTeamName, stadiumName,
						seatPrice, seatType, seatNumber));
			}

		} catch (SQLException e) {
			System.err.println("Error retrieving tickets: " + e.getMessage());
		}

		return tickets;
	}

	public Resaleticket getGameIdById(int resaleticket) throws SQLException {
		Resaleticket game = null;
		String sql = "SELECT t.ticket_id, g.game_date, g.start_time, ht.team_name AS home_team_name, t.seat_number, "
				+ "at.team_name AS away_team_name, sd.stadium_name, st.seat_type, st.seat_price  "
				+ "FROM phoenix.tickets t "
				+ "JOIN phoenix.ticket_statuses ts ON t.ticket_status_id = ts.ticket_status_id "
				+ "JOIN seats st ON t.seat_id = st.seat_id "
				+ "LEFT JOIN games g ON t.game_id = g.game_id "
				+ "LEFT JOIN teams ht ON g.home_team_id = ht.team_id "
				+ "LEFT JOIN teams at ON g.away_team_id = at.team_id "
				+ "LEFT JOIN stadiums sd ON g.stadium_id = sd.stadium_id "
				+ "WHERE t.ticket_id = ? ";

		try (
				Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, resaleticket);

			try (ResultSet resultSet = pstmt.executeQuery()) {
				if (resultSet.next()) {
					int ticketId = resultSet.getInt("ticket_id");
					Date gameDate = resultSet.getDate("game_date");
					Time startTime = resultSet.getTime("start_time");
					String homeTeamName = resultSet.getString("home_team_name");
					String awayTeamName = resultSet.getString("away_team_name");
					String stadiumName = resultSet.getString("stadium_name");
					int seatPrice = resultSet.getInt("seat_price");
					String seatType = resultSet.getString("seat_type");
					String seatNumber = resultSet.getString("seat_number");

					game = new Resaleticket(ticketId, gameDate, startTime, homeTeamName, awayTeamName, stadiumName,
							seatPrice, seatType, seatNumber);
				}

			} catch (SQLException e) {
				System.err.println("Error retrieving tickets: " + e.getMessage());
			}
			return game;
		}
	}

//	public void updateTicketStatus(int ticketId, int userId, int newStatusId) throws SQLException {
//		String sql = "UPDATE phoenix.tickets t "
//				+ "JOIN phoenix.ticket_order_detail tod "
//				+ "ON t.ticket_id = tod.ticket_id "
//				+ "SET t.ticket_status_id = 2, tod.user_id = 1 "
//				+ "WHERE tod.ticket_id = ? " ;
//
//		try (Connection conn = DBManager.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//			pstmt.setInt(1, newStatusId);
//			pstmt.setInt(2, userId);
//			pstmt.setInt(3, ticketId);
//			pstmt.executeUpdate();
//		}
	
	
	public void updateTicketStatus(int ticketId, int newStatusId) throws SQLException {
		String sql = "UPDATE tickets SET ticket_status_id = ? WHERE ticket_id = ?";

		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, newStatusId);
			pstmt.setInt(2, ticketId);
			pstmt.executeUpdate();
		}
	}
	
	public void updateUserId(int userId, int ticketId) throws SQLException {
		String sql = "INSERT INTO ticket_order_detail (ticket_id ,user_id, created_at) VALUES ( ?, ?, now()) " ;

		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println("updateUserId userId" + userId);
			pstmt.setInt(1, ticketId);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
		}
	}

	public void insertResaleticket(Resaleticket bean) {
		String sql = "INSERT INTO ticket_order_detail (user_id, created_at) VALUES (?, now()) FROM tickets t " +
				"LEFT JOIN ticket_order_detail tod ON t.ticket_id = tod.ticket_id ";

		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, bean.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


//	 public List<Resaleticket> getTicketIdsByGameAndSeat(int gameId, int seatId) throws SQLException {
//	        List<Resaleticket> ticketIds = new ArrayList<>();
//	        String sql = "SELECT ticketId FROM tickets WHERE gameId = ? AND seatId = ?";
//	        try (Connection conn = DBManager.getConnection();
//	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//	            pstmt.setInt(1, gameId);
//	            pstmt.setInt(2, seatId);
//	            ResultSet rs = pstmt.executeQuery();
//	            while (rs.next()) {
//	                int ticketId =rs.getInt("ticketId");
//	                
//	                ticketIds.add(new Resaleticket(ticketId, gameDate, new Time(0,0,0), new String(), new String(), new String(),
//							0, 0, new String()));            }
//	        }
//	        return ticketIds;
//	    }

	
}
