package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import dto.Seats;

public class SeatsDAO {
	private static final String sql = "SELECT seat_type, seat_price FROM seats WHERE seat_id = ?";

    public static Optional<Seats> getSeatById(int seatId) {
    	String sql = null;
		try (Connection conn = DBManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            stmt.setInt(1, seatId);
            while (rs.next()) {
                    String SeatType = rs.getString("seat_type");
                    int SeatPrice = rs.getInt("seat_price");
                    
                    Seats seat = new Seats(SeatType, SeatPrice);
                }
            
    } catch (SQLException e) {
        System.err.println("Error retrieving tickets: " + e.getMessage());
    }
        return Optional.empty();
    }
}

	
