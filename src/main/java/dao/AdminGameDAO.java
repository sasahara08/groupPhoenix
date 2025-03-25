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
				if (rsGame.next()) {
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
	
	// gemesテーブルの一番大きいgame_idを取得
	public static int getGameId() {
		int gameId = 0;
		try (Connection connection = DBManager.getConnection()) {
			// gamesテーブルから一番idの大きいレコードを取得
			String sql = "select game_id from games order by game_id desc limit 1";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rsGameId = statement.executeQuery();
			
			if(rsGameId.next()) {
			gameId = rsGameId.getInt("game_id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}return gameId;
	}

	// ticketテーブルにticketを追加する(試合追加時に使用)
	public static void addTicket(int gameId) {
		try (Connection connection = DBManager.getConnection()) {
			//変数の用意
			String seatAlphabet = null;
			int checkCountSeat = -1;
			// １種類のシートに対してのticketの発行枚数
			int seatsNum = 5;
			// シート種類の回数知家kkと発行をくり返す為、シート種類を取得
			String sql = "select count(*) seatCount from seats";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rsSeat = statement.executeQuery();
			if(rsSeat.next()) {
			checkCountSeat = rsSeat.getInt("seatCount");
			}

			// チケットを発行(insert)
			
			sql = "INSERT INTO tickets (game_id, seat_id, seat_number, ticket_status_id) VALUES (?, ?, ?, 1)";
			for (int i = 1 ; i <= checkCountSeat; i++) {
				for (int j = 1; j <= seatsNum; j++) {
					switch(i){
						case 1:
							seatAlphabet = "A";
							break;
						case 2:
							seatAlphabet = "B";
							break;
						case 3:
							seatAlphabet = "C";
							break;
						case 4:
							seatAlphabet = "D";
							break;
						case 5:
							seatAlphabet = "E";
							break;
						case 6:
							seatAlphabet = "F";
							break;
					}
					
					String seatNumber = seatAlphabet + "00" + j;
					
				try (PreparedStatement addStatement = connection.prepareStatement(sql)) {
					addStatement.setInt(1, gameId);
					addStatement.setInt(2, i);
					addStatement.setString(3, seatNumber);
					// sql実行
					addStatement.executeUpdate();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
