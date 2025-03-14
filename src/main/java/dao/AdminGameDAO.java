package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class AdminGameDAO {

	//チーム名とスタジアム名を付けてゲーム情報を取得
	public static ResultSet teamName() {
		try (Connection connection = DBManager.getConnection()) {
			// SQLクエリ
			String sql = """
					    SELECT * FROM games
					    JOIN teams AS homeTeam ON games.home_team_id = homeTeam.team_id
					    JOIN teams AS awayTeam ON games.away_team_id = awayTeam.team_id
					    JOIN stadiums ON games.stadium_id = stadiums.stadium_id
					""";

			PreparedStatement statement = connection.prepareStatement(sql);
			return statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//特定のidのチームを取得
	public static ResultSet teamNameForId(int gameId) {
        try (Connection connection = DBManager.getConnection()) {
            // SQLクエリ
            String sql = """
                SELECT * FROM games 
                JOIN teams AS homeTeam ON games.home_team_id = homeTeam.team_id 
                JOIN teams AS awayTeam ON games.away_team_id = awayTeam.team_id 
                JOIN stadiums ON games.stadium_id = stadiums.stadium_id where game_id = 
            """ + gameId;

            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
