package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
				String strDate = new SimpleDateFormat("yyyy年 MM月 dd日 ").format(gameDate);

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

	// 月別売り上げ画面の販売年取得
	public static List<String> getYear() {
		List<String> years = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {

			String sql = "SELECT DATE_FORMAT(games.game_date, '%Y') AS saleYear " +
					"FROM tickets " +
					"JOIN games ON games.game_id = tickets.game_id " +
					"GROUP BY DATE_FORMAT(games.game_date, '%Y') " +
					"ORDER BY saleYear;";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rsYear = statement.executeQuery();

			while (rsYear.next()) {
				String year = rsYear.getString("saleYear");
				years.add(year);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return years;
	}

	// 特定の月の全販売数を表示(座席ごと)
	public static List<SaleBean> saleSeatAsMonth(Integer searchYear) {

		List<SaleBean> saleTotalList = new ArrayList<>();

		//　初回のアクセス時は現在の年を検索
		//  検索年の入力があった際はその年を入力
		if (searchYear == 0) {
			// 今年の年を入力
			LocalDate today = LocalDate.now();
			searchYear = today.getYear();
		}

		//ゲーム情報を取得(月ごとの検索、月ごとの売上高を確認)
		try (Connection connection = DBManager.getConnection()) {

			// SQLクエリ
			String sql = "SELECT DATE_FORMAT(games.game_date, '%m') AS saleMonth, " +
					"SUM(CASE WHEN ticket_statuses.ticket_status_id IN (2, 3, 4) THEN seats.seat_price ELSE 0 END) AS totalSeatPrice, "
					+

					// シートID 1 のカウント（1, 2, 3, 4 の ticket_status_id）
					"SUM(CASE WHEN seats.seat_id = 1 AND ticket_statuses.ticket_status_id IN (1, 2, 3, 4) THEN 1 ELSE 0 END) AS seat1CountTotal, "
					+
					// シートID 2 のカウント（1, 2, 3, 4 の ticket_status_id）
					"SUM(CASE WHEN seats.seat_id = 2 AND ticket_statuses.ticket_status_id IN (1, 2, 3, 4) THEN 1 ELSE 0 END) AS seat2CountTotal, "
					+
					// シートID 3 のカウント（1, 2, 3, 4 の ticket_status_id）
					"SUM(CASE WHEN seats.seat_id = 3 AND ticket_statuses.ticket_status_id IN (1, 2, 3, 4) THEN 1 ELSE 0 END) AS seat3CountTotal, "
					+
					// シートID 4 のカウント（1, 2, 3, 4 の ticket_status_id）
					"SUM(CASE WHEN seats.seat_id = 4 AND ticket_statuses.ticket_status_id IN (1, 2, 3, 4) THEN 1 ELSE 0 END) AS seat4CountTotal, "
					+

					// シートID 1 のカウント（2, 3, 4 の ticket_status_id）
					"SUM(CASE WHEN seats.seat_id = 1 AND ticket_statuses.ticket_status_id IN (2, 3, 4) THEN 1 ELSE 0 END) AS seat1Count, "
					+
					// シートID 2 のカウント（2, 3, 4 の ticket_status_id）
					"SUM(CASE WHEN seats.seat_id = 2 AND ticket_statuses.ticket_status_id IN (2, 3, 4) THEN 1 ELSE 0 END) AS seat2Count, "
					+
					// シートID 3 のカウント（2, 3, 4 の ticket_status_id）
					"SUM(CASE WHEN seats.seat_id = 3 AND ticket_statuses.ticket_status_id IN (2, 3, 4) THEN 1 ELSE 0 END) AS seat3Count, "
					+
					// シートID 4 のカウント（2, 3, 4 の ticket_status_id）
					"SUM(CASE WHEN seats.seat_id = 4 AND ticket_statuses.ticket_status_id IN (2, 3, 4) THEN 1 ELSE 0 END) AS seat4Count "
					+

					"FROM tickets " +
					"JOIN games ON games.game_id = tickets.game_id " +
					"JOIN ticket_statuses ON tickets.ticket_status_id = ticket_statuses.ticket_status_id " +
					"JOIN seats ON seats.seat_id = tickets.seat_id " +
					"WHERE ticket_statuses.ticket_status_id IN (1, 2, 3, 4) " +
					"AND YEAR(games.game_date) = ? " +
					"GROUP BY DATE_FORMAT(games.game_date, '%m') " +
					"ORDER BY saleMonth;";

			PreparedStatement statement = connection.prepareStatement(sql);
			//対象の年を代入
			statement.setInt(1, searchYear);
			//sql実行
			ResultSet rsSaleMonth = statement.executeQuery();

			// 各月の値と売り上げをセット
			while (rsSaleMonth.next()) {
				
				DecimalFormat df = new DecimalFormat("#.0");

				// 変数用意
				SaleBean sale = new SaleBean();

				//beanにセット
				sale.setSaleManth(rsSaleMonth.getString("saleMonth"));
				sale.setSalesValue(rsSaleMonth.getInt("totalSeatPrice"));
				sale.setOutSeat(rsSaleMonth.getInt("seat1Count"));
				sale.setnInSeat(rsSaleMonth.getInt("seat2Count"));
				sale.setsInSeat(rsSaleMonth.getInt("seat3Count"));
				sale.setBacknetSeat(rsSaleMonth.getInt("seat4Count"));
				sale.setTotalOutSeat(rsSaleMonth.getInt("seat1CountTotal"));
				sale.setTotalNInSeat(rsSaleMonth.getInt("seat2CountTotal"));
				sale.setTotalSInSeat(rsSaleMonth.getInt("seat3CountTotal"));
				sale.setTotalBacknetSeat(rsSaleMonth.getInt("seat4CountTotal"));
				sale.setOutSeatSellOutRate(
						(rsSaleMonth.getInt("seat1CountTotal") != 0)
								? Double.parseDouble(df.format((double) rsSaleMonth.getInt("seat1Count")
										/ rsSaleMonth.getInt("seat1CountTotal") * 100))
								: 0);
				sale.setOutSeatSellNInSeat(
						(rsSaleMonth.getInt("seat2CountTotal") != 0)
								? Double.parseDouble(df.format((double) rsSaleMonth.getInt("seat2Count")
										/ rsSaleMonth.getInt("seat2CountTotal") * 100))
								: 0);
				sale.setOutSeatSellSInSeat(
						(rsSaleMonth.getInt("seat3CountTotal") != 0)
								? Double.parseDouble(df.format((double) rsSaleMonth.getInt("seat3Count")
										/ rsSaleMonth.getInt("seat3CountTotal") * 100))
								: 0);
				sale.setOutSeatSellBacknetSeat(
						(rsSaleMonth.getInt("seat4CountTotal") != 0)
								? Double.parseDouble(df.format((double) rsSaleMonth.getInt("seat4Count")
										/ rsSaleMonth.getInt("seat4CountTotal") * 100))
								: 0);

				saleTotalList.add(sale);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleTotalList;
	}
	
	// Javaオブジェクトをjsonに変換
	public static String convertListToJson(List<SaleBean> saleTotalList) {
	    StringBuilder json = new StringBuilder("[");
	    for (int i = 0; i < saleTotalList.size(); i++) {
	        SaleBean sale = saleTotalList.get(i);
	        json.append(sale.toJson());
	        if (i < saleTotalList.size() - 1) {
	            json.append(",");
	        }
	    }
	    json.append("]");
	    return json.toString();
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
			String sql = "SELECT COUNT(*) AS seatCount FROM tickets " +
					"JOIN ticket_statuses ON tickets.ticket_status_id = ticket_statuses.ticket_status_id " +
					"WHERE game_id = ? AND seat_id = ? " +
					"AND ticket_statuses.ticket_status_id IN (2, 3, 4)";

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

	// 特定の月ごとに売上を集計する(引数に集計したい年を代入する)
	public static List<SaleBean> saleMonth(Integer searchYear) {

		List<SaleBean> saleList = new ArrayList<>();

		//　初回のアクセス時は現在の年を検索
		//  検索年の入力があった際はその年を入力
		if (searchYear == 0) {
			// 今年の年を入力
			LocalDate today = LocalDate.now();
			searchYear = today.getYear();
		}

		//ゲーム情報を取得(月ごとの検索、月ごとの売上高を確認)
		try (Connection connection = DBManager.getConnection()) {

			String sql = "SELECT DATE_FORMAT(games.game_date, '%Y-%m') AS saleMonth, " +
					"SUM(seats.seat_price) AS totalSeatPrice, " +
					"SUM(CASE WHEN seats.seat_id = 1 THEN 1 ELSE 0 END) AS seat1Count, " +
					"SUM(CASE WHEN seats.seat_id = 2 THEN 1 ELSE 0 END) AS seat2Count, " +
					"SUM(CASE WHEN seats.seat_id = 3 THEN 1 ELSE 0 END) AS seat3Count, " +
					"SUM(CASE WHEN seats.seat_id = 4 THEN 1 ELSE 0 END) AS seat4Count " +
					"FROM tickets " +
					"JOIN games ON games.game_id = tickets.game_id " +
					"JOIN ticket_statuses ON tickets.ticket_status_id = ticket_statuses.ticket_status_id " +
					"JOIN seats ON seats.seat_id = tickets.seat_id " +
					"WHERE ticket_statuses.ticket_status_id IN (2, 3, 4) " +
					"AND YEAR(games.game_date) = ? " +
					"GROUP BY DATE_FORMAT(games.game_date, '%Y-%m') " +
					"ORDER BY saleMonth;";

			PreparedStatement statement = connection.prepareStatement(sql);
			//対象の年を代入
			statement.setInt(1, searchYear);
			//sql実行
			ResultSet rsSaleMonth = statement.executeQuery();

			// 各月の値と売り上げをセット
			while (rsSaleMonth.next()) {

				// 変数用意
				SaleBean sale = new SaleBean();

				//beanにセット
				sale.setSaleManth(rsSaleMonth.getString("saleMonth"));
				sale.setSalesValue(rsSaleMonth.getInt("totalSeatPrice"));
				sale.setOutSeat(rsSaleMonth.getInt("seat1Count"));
				sale.setnInSeat(rsSaleMonth.getInt("seat2Count"));
				sale.setsInSeat(rsSaleMonth.getInt("seat3Count"));
				sale.setBacknetSeat(rsSaleMonth.getInt("seat4Count"));
				saleList.add(sale);
			}

		} catch (Exception e) {
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
	public static int getSoldSeatCountAsString(int gameId, int seatId) {
		int soldSeatCount = 0;

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
					soldSeatCount = rs.getInt("soldSeats");
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
				int outSeat = getSoldSeatCountAsString(gameId, 1);
				int nInSeat = getSoldSeatCountAsString(gameId, 2);
				int sInSeat = getSoldSeatCountAsString(gameId, 3);
				int backnetSeat = getSoldSeatCountAsString(gameId, 4);

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
