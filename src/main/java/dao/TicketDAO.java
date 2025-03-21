package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TicketsBean;  

public class TicketDAO {  
    private Connection connection;  

    public TicketDAO(Connection connection) {  
        this.connection = connection;  
    }  

    public TicketDAO(int int1, String string, String string2, String string3, String string4, String string5) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public List<TicketsBean> getAllTickets() throws SQLException {  
        List<TicketsBean> tickets = new ArrayList<>();  
        String sql = "SELECT g.game_id, g.game_date, g.start_time, " +  
                     "ht.team_name AS home_team_name, " +  
                     "at.team_name AS away_team_name, " +  
                     "s.stadium_name " +  
                     "FROM games g " +  
                     "JOIN teams ht ON g.home_team_id = ht.team_id " +  
                     "JOIN teams at ON g.away_team_id = at.team_id " +  
                     "JOIN stadiums s ON g.stadium_id = s.stadium_id " +  
                     "WHERE g.game_delete_at IS NULL"; // 削除されていない試合のみを取得  

        try (PreparedStatement stmt = connection.prepareStatement(sql);  
             ResultSet rs = stmt.executeQuery()) {  
            while (rs.next()) {  
            	TicketsBean ticket = new TicketsBean(  
                        rs.getInt("game_id"),  
                        rs.getString("game_date"),  
                        rs.getString("start_time"),  
                        rs.getString("home_team_name"),  
                        rs.getString("away_team_name"),  
                        rs.getString("stadium_name")  
                );  
                tickets.add(ticket);  
            }  
        }  
        return tickets;  
    }  
}  