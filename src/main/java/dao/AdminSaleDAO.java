package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.SaleBean;

// @auther Y.sasahara

public class AdminSaleDAO {

	//　ゲームテーブルのidからチーム名を取得
	public static String GetTeamNameForId(int teamId) {

		String teamName = null;
		String sql = "select * from teams WHERE team_id = ?";

		try (Connection connection = DBManager.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, teamId);

			// チームネーム取得
			try (ResultSet rsGame = statement.executeQuery()) {
				if (rsGame.next()) {
				teamName = rsGame.getString("team_Name");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return teamName;
	}

	// ゲーム名を作成
	public static String CreateGameName(int gameId, int homeTeamId, int awayTeamId) {

		String homeTeamName = null;
		String awayTeamName = null;
		String gameName = null;

		Date gameDate = null;

		try (Connection connection = DBManager.getConnection()) {

			// DBからゲーム情報を取得
			String sql = "select * from games where game_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, gameId);
			ResultSet rsGame = statement.executeQuery();

			// 日付を文字列型に
			if (rsGame.next()) {
				gameDate = rsGame.getDate("game_date");
				String strDate = new SimpleDateFormat("yyyy-MM-dd").format(gameDate);

				// チーム名を取得
				homeTeamName = GetTeamNameForId(homeTeamId);
				awayTeamName = GetTeamNameForId(awayTeamId);

				// ゲーム名表示用に文字列を結合
				gameName = strDate + "  " + homeTeamName + "VS" + awayTeamName;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameName;
	}

	// 売上計算用メソッド-------------------------------------------------

	// 特定のシートの座席単価を取得
	public static int getUnitPrice(int seatId) {
		int unit_price = 0;
		try (Connection connection = DBManager.getConnection()) {
			String sql = "select seat_price from seats where seat_id = ?";
			//sqlセット
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, seatId);

			// sql実行
			ResultSet price = statement.executeQuery();

			if (price.next()) {
				unit_price = price.getInt("seat_price");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return unit_price;
	}

	// 特定の試合の特定の席の売り上げを集計する
	public static int salesValue(int gameId, int seatId) {

		int salesPrice = 0;

		try (Connection connection = DBManager.getConnection()) {
			// 特定の試合の特定のシートの数を集計
			String sql = "select count(*) as seatCount from tickets join ticket_statuses "
					+ "on tickets.ticket_status_id = ticket_statuses.ticket_status_id "
					+ "where game_id = ? and seat_id = ? and (ticket_statuses.ticket_status_id = 2 OR ticket_statuses.ticket_status_id = 3 OR ticket_statuses.ticket_status_id = 4)";

			//sqlセット
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, gameId);
			statement.setInt(2, seatId);
			// sql実行
			ResultSet seatCount = statement.executeQuery();

			// シートの数をセット(未売分はカウントしない)
			if (seatCount.next()) {
				int seatCountForsales = seatCount.getInt("seatCount");

				// シートの単価をセット
				int unit_price = getUnitPrice(seatId);

				// 売買済みのシート数×単価
				salesPrice = seatCountForsales * unit_price;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesPrice;
	}
	
	// 特定の月ごとに売上を集計する
	public static List<SaleBean> saleMonth(){
		
		List<SaleBean> saleList = new ArrayList<>();
		int saleManth = 0;
		
		//ゲーム情報を取得
		try (Connection connection = DBManager.getConnection()) {
			String sql = "select games.date_format(game_date, '%Y-%m') as saleMonth from tickets "
					+ "join games on games.game_id = tickets.game_id "
					+ "join ticket_statuses on tickets.ticket_status_id = ticket_statuses.ticket_status_id "
					+ "group by games.date_format(game_date, '%Y-%m') "
					+ "where ticket_statuses.ticket_status_id = 2 OR ticket_statuses.ticket_status_id = 3 OR ticket_statuses.ticket_status_id = 4";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rsSaleMonth = statement.executeQuery();
			
			// 仕分け処理
			while (rsSaleMonth.next()) {
				
				saleManth = 0;
				SaleBean sale = new SaleBean();
				
				sale.setSaleManth(rsSaleMonth.getString("saleMonth"));
				
		}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saleList;
	}

	// 特定の試合の売上高(合計)を取得
	public static int allSalePriceForGame(int gameId) {

		int allPrice = 0;

		//ゲーム情報を取得
		try (Connection connection = DBManager.getConnection()) {

			// シート数を取得して各シートの売上高を加算
			String sql = "select * from seats";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rsSeat = statement.executeQuery();

			// 加算処理
			while (rsSeat.next()) {
				int seatPrice = salesValue(gameId, (rsSeat.getInt("seat_id")));

				allPrice += seatPrice;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allPrice;

	}

	// -------------------------------------------------------------------

	// シートごとの販売数を取得（String型で返す）
	public static String getSoldSeatCountAsString(int gameId, int seatId) {
		String soldSeatCount = "0";

		try (Connection connection = DBManager.getConnection()) {
			// 指定されたシートIDの販売済みシート数を取得するSQL
			String sql = "SELECT COUNT(*) AS soldSeats FROM tickets "
					+ "JOIN ticket_statuses ON tickets.ticket_status_id = ticket_statuses.ticket_status_id "
					+ "WHERE game_id = ? AND seat_id = ? AND (ticket_statuses.ticket_status_id = 2 OR ticket_statuses.ticket_status_id = 3 OR ticket_statuses.ticket_status_id = 4)";

			// パラメータを設定
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, gameId);
			statement.setInt(2, seatId);

			// クエリを実行して結果を取得
			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					// 数値を文字列に変換してセット
					soldSeatCount = String.valueOf(rs.getInt("soldSeats"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return soldSeatCount;
	}

	// 売上一覧表示用に配列のオブジェクトを作成
	public static List<SaleBean> createSalesList() {

		List<SaleBean> saleList = new ArrayList<>();

		//ゲーム情報を取得
		try (Connection connection = DBManager.getConnection()) {
			String sql = "SELECT * FROM games";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rsGame = statement.executeQuery();

			while (rsGame.next()) {
				SaleBean sales = new SaleBean();

				int gameId = rsGame.getInt("game_id");
				int homeTeamId = rsGame.getInt("home_team_id");
				int awayTeamId = rsGame.getInt("away_team_id");

				//試合名を取得
				String gameName = CreateGameName(gameId, homeTeamId, awayTeamId);

				//試合の売上を集計
				int gameSalesPrice = allSalePriceForGame(gameId);

				// 各席の販売数をカウント
				String outSeat = getSoldSeatCountAsString(gameId, 1);
				String nInSeat = getSoldSeatCountAsString(gameId, 2);
				String sInSeat = getSoldSeatCountAsString(gameId, 3);
				String backnetSeat = getSoldSeatCountAsString(gameId, 4);

				//オブジェクトに値をセットして配列に追加
				sales.setGameId(gameId);
				sales.setGameName(gameName);
				sales.setGameDate(rsGame.getDate("game_date"));
				sales.setSalesValue(gameSalesPrice);
				sales.setOutSeat(outSeat);
				sales.setnInSeat(nInSeat);
				sales.setsInSeat(sInSeat);
				sales.setBacknetSeat(backnetSeat);
				saleList.add(sales);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleList;
	}

}
