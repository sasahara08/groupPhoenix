package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Seats;

public class SeatsDAO {
	private static final String sql = "SELECT seat_type, seat_price FROM seats WHERE seat_id = ?";

	public Seats getSeatById(int seatId) {
		Seats seat = null;
		try (Connection conn = DBManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, seatId);
			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					String seatType = rs.getString("seat_type");
					int seatPrice = rs.getInt("seat_price");

					seat = new Seats();
					seat.setSeatId(seatId);
					seat.setSeatPrice(seatPrice);
					seat.setSeatType(seatType);

				}
			}

		} catch (SQLException e) {
			System.err.println("Error retrieving tickets: " + e.getMessage());
		}
		return seat;
	}
}
