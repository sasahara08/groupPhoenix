package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.GameBean;

public class AdminGameDAO {

	//チーム名とスタジアム名を付けてゲーム情報を取得
	public static List<GameBean> teamName() {
		List<GameBean> gameList = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			// SQLクエリ
			String sql = """
					    SELECT * FROM games
					    JOIN teams AS homeTeam ON games.home_team_id = homeTeam.team_id
					    JOIN teams AS awayTeam ON games.away_team_id = awayTeam.team_id
					    JOIN stadiums ON games.stadium_id = stadiums.stadium_id order by game_id
					""";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rsGame = statement.executeQuery();
			while (rsGame.next()) {
				GameBean games = new GameBean();
				games.setGameId(rsGame.getInt("game_id"));
				games.setGameDate(rsGame.getDate("game_date"));
				games.setStartTime(rsGame.getTime("start_time"));
				games.setHomeTeamName(rsGame.getString("homeTeam.team_name"));
				games.setAwayTeamName(rsGame.getString("awayTeam.team_name"));
				games.setStadium(rsGame.getString("stadiums.stadium_name"));
				games.setGameDeleteAt(rsGame.getDate("game_delete_at"));
				gameList.add(games);
				
				
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gameList;
	}

	// 特定のidのチーム情報を取得
	// 特定のidのチーム情報を取得
	public static GameBean teamNameForId(int gameId) {
	    GameBean games = null;
	    
	    try (Connection connection = DBManager.getConnection();
	         PreparedStatement statement = connection.prepareStatement("""
	             SELECT * FROM games
	             JOIN teams AS homeTeam ON games.home_team_id = homeTeam.team_id
	             JOIN teams AS awayTeam ON games.away_team_id = awayTeam.team_id
	             JOIN stadiums ON games.stadium_id = stadiums.stadium_id
	             WHERE game_id = ?
	         """)) {

	        statement.setInt(1, gameId); // プレースホルダに gameId を設定
	        try (ResultSet rsGame = statement.executeQuery()) {
	            if (rsGame.next()) { // カーソルを最初の行に移動
	                games = new GameBean();
	                games.setGameId(rsGame.getInt("game_id"));
	                games.setGameDate(rsGame.getDate("game_date"));
	                games.setStartTime(rsGame.getTime("start_time"));
	                games.setHomeTeamName(rsGame.getString("homeTeam.team_name"));
	                games.setAwayTeamName(rsGame.getString("awayTeam.team_name"));
	                games.setStadium(rsGame.getString("stadiums.stadium_name"));
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return games; 
	}


        
        
    //特定のIDの試合情報を削除(テーブルの削除時間を更新)
	public static void deleteGame(int gameId) {
	    try (Connection connection = DBManager.getConnection()) {
	        // 今日の日付を取得
	        LocalDate today = LocalDate.now();

	        // SQL文（パラメータ化）
	        String sql = "UPDATE games SET game_delete_at = ? WHERE game_id = ?";

	        // パラメータを設定
	        try (PreparedStatement delStatement = connection.prepareStatement(sql)) {
	            delStatement.setObject(1, today);
	            delStatement.setInt(2, gameId);

	            // 更新処理を実行
	            int rowsUpdated = delStatement.executeUpdate();
	            System.out.println(rowsUpdated + " 行が更新されました。");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

