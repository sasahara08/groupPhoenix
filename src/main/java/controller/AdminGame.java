package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.DBManager;
import dto.GameBean;

/**
 * Servlet implementation class AdminGame
 */
@WebServlet("/game")
public class AdminGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// DataSourceの初期化 (例: JNDI lookupなど)
		// ds = (DataSource) getServletContext().getAttribute("datasource");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");

		// 遷移先分岐
		String gamePage = request.getParameter("gamePage");
		if (gamePage == null || gamePage.isEmpty() || gamePage.equals("reset")) {
			String path = "./admin/game.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else {

			switch (gamePage) {

			//ゲーム一覧→ゲーム情報追加(確認画面)
			//パラメータはjsで取得。
			case "addCheck":
				String path = "/admin/gameAddCheacked.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 送信されたデータのエンコーディングを指定（文字化け対策）
		request.setCharacterEncoding("UTF-8");

		// 遷移先分岐
		String gamePage = request.getParameter("gamePage");
		if (gamePage == null || gamePage.isEmpty() || gamePage.equals("reset")) {
			response.sendRedirect("/game");
		} else {
			// セッションスコープ取得
			HttpSession session = request.getSession();

			// 遷移先パス用変数を作成
			String path = null;
			String gameId = request.getParameter("gameId");
			String gameDay = request.getParameter("gameDay");
			String homeTeam = request.getParameter("homeTeam");
			String awayTeam = request.getParameter("awayTeam");
			String stadium = request.getParameter("stadium");
			int homeTeamId = -1;
			int awayTeamId = -1;
			int stadiumId = -1;

			String homeTeamSql = null;
			String awayTeamSql = null;

			// 遷移先分岐

			switch (gamePage) {

			// 検索ボタン押下
			case "search":

				try (Connection connection = DBManager.getConnection();) {

					//チーム名でチームIDを検索
					if (!homeTeam.isEmpty()) {
						homeTeamSql = "select team_id from teams where team_name = " + homeTeam;
						PreparedStatement homeTeamStatement = connection.prepareStatement(homeTeamSql);

						//ホームチームのIDを取得
						try (ResultSet homeTeamIdSet = homeTeamStatement.executeQuery()) {
							if (homeTeamIdSet.next()) {
								homeTeamId = homeTeamIdSet.getInt("team_id");
							}
						}
					}

					if (!awayTeam.isEmpty()) {
						awayTeamSql = "select team_id from teams where team_name = " + awayTeam;
						PreparedStatement awayTeamStatement = connection.prepareStatement(awayTeamSql);
						//アウェイチームのIDを取得
						try (ResultSet awayTeamIdSet = awayTeamStatement.executeQuery()) {
							if (awayTeamIdSet.next()) {
								awayTeamId = awayTeamIdSet.getInt("team_id");
							}
						}
					}

					// SQLクエリの基本部分
					StringBuilder searchSql = new StringBuilder("SELECT * FROM games ");
					
					searchSql.append("join teams as homeTeam on games.home_team_id = homeTeam.team_id ");
					searchSql.append("join teams as awayTeam on games.away_team_id = awayTeam.team_id ");
					searchSql.append("join stadiums on games.stadium_id = stadiums.stadium_id WHERE 1=1");
					
					// パラメータに基づいてWHERE句を動的に追加
					if (gameId != null && !gameId.isEmpty()) {
						searchSql.append(" AND game_id = ?");
					}
					if (gameDay != null && !gameDay.isEmpty()) {
						searchSql.append(" AND game_day = ?");
					}
					if (homeTeam != null && !homeTeam.isEmpty()) {
						searchSql.append(" AND home_team = ?");
					}
					if (awayTeam != null && !awayTeam.isEmpty()) {
						searchSql.append(" AND away_team = ?");
					}
					if (stadium != null && !stadium.isEmpty()) {
						searchSql.append(" AND stadium = ?");
					}

					// SQL実行
					try (PreparedStatement statement = connection.prepareStatement(searchSql.toString())) {

						int index = 1;

						// パラメータを設定
						if (gameId != null && !gameId.isEmpty()) {
							statement.setString(index++, gameId);
						}
						if (gameDay != null && !gameDay.isEmpty()) {
							Date gameDate = Date.valueOf(gameDay);
							statement.setDate(index++, gameDate);
						}
						if (homeTeam != null && !homeTeam.isEmpty()) {
							statement.setInt(index++, homeTeamId);
						}
						if (awayTeam != null && !awayTeam.isEmpty()) {
							statement.setInt(index++, awayTeamId);
						}
						if (stadium != null && !stadium.isEmpty()) {
							statement.setString(index++, stadium);
						}

						List<GameBean> gameList = new ArrayList<>();

						try (ResultSet resultSet = statement.executeQuery()) {
							// 結果をリクエスト属性にセット
							while (resultSet.next()) {
								int gId = resultSet.getInt("game_id");
								Date gDay = resultSet.getDate("game_date");
								Time gTime = resultSet.getTime("start_time");
								String gHomeTeam = resultSet.getString("homeTeam.team_name");
								String gAwayTeam = resultSet.getString("awayTeam.team_name");
								String gStadium = resultSet.getString("stadiums.stadium_name");
								gameList.add(new GameBean(gId, gDay, gTime, gHomeTeam, gAwayTeam, gStadium));
							}
							request.setAttribute("games", gameList);
							path = "/admin/gameSearched.jsp";
							request.getRequestDispatcher(path).forward(request, response);
						}
					}

				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("error", "データベース接続エラー");
					path = "/admin/game.jsp"; // エラー時の遷移先
					request.getRequestDispatcher(path).forward(request, response);
				}
				break;

			//ゲーム情報追加(確定)
			case "addComplete":
				String hiddenDay = request.getParameter("hiddenDay");
				String hiddenTime = request.getParameter("hiddenTime");
				String hiddenHomeTeam = request.getParameter("hiddenHomeTeam");
				String hiddenAwayTeam = request.getParameter("hiddenAwayTeam");
				String hiddenStadium = request.getParameter("hiddenStadium");

				//チーム名でチームIDを検索するsql
				homeTeamSql = "select team_id from teams where team_name = " + hiddenHomeTeam;
				awayTeamSql = "select team_id from teams where team_name = " + hiddenAwayTeam;

				//StadiumIDを検索
				String stadiumSql = "select stadium_id from games where team_name = " + hiddenStadium;

				// SQLクエリの基本部分
				StringBuilder addSql = new StringBuilder(
						"insert into games (game_date, start_time, home_team_id, away_team_id, stadium_id) value (?, ?, ?, ?, ?)");

				//各Idを検索するsqlを文字列に変換
				try (Connection connection = DBManager.getConnection();
						PreparedStatement statement = connection.prepareStatement(addSql.toString());
						PreparedStatement homeTeamIdSql = connection.prepareStatement(homeTeamSql.toString());
						PreparedStatement awayTeamIdSql = connection.prepareStatement(awayTeamSql.toString());
						PreparedStatement stadiumIdSql = connection.prepareStatement(stadiumSql.toString());) {
					
					//日付と時間をdate型とtime型に変換
					Date gameDate = Date.valueOf(hiddenDay);
					Time gameTimes = Time.valueOf(hiddenTime);

					//ホームチームのIDを取得
					try (ResultSet homeTeamIdSet = homeTeamIdSql.executeQuery()) {
						if (homeTeamIdSet.next()) {
							homeTeamId = homeTeamIdSet.getInt("team_id");
						}
					}

					//アウェイチームのIDを取得
					try (ResultSet awayTeamIdSet = awayTeamIdSql.executeQuery()) {
						if (awayTeamIdSet.next()) {
							awayTeamId = awayTeamIdSet.getInt("team_id");
						}
					}

					//スタジアムのIDを取得
					try (ResultSet stadiumIdSet = stadiumIdSql.executeQuery()) {
						if (stadiumIdSet.next()) {
							stadiumId = stadiumIdSet.getInt("stadium_id");
						}
					}

					//insertのsqlに値を代入
					statement.setDate(1, gameDate);
					statement.setTime(2, gameTimes);
					statement.setInt(3, homeTeamId);
					statement.setInt(4, awayTeamId);
					statement.setInt(5, stadiumId);

					int line = statement.executeUpdate();
					{
						//更新が成功したらlineは1以上
						if (line > 0) {
							path = "/admin/gameAddComplete.jsp";
							request.getRequestDispatcher(path).forward(request, response);
						} else {
							request.setAttribute("errorMessage", "更新に失敗しました");
							path = "/admin/game.jsp";
							request.getRequestDispatcher(path).forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("error", "データベース接続エラー");
					path = "/admin/game.jsp"; // エラー時の遷移先
					request.getRequestDispatcher(path).forward(request, response);
				}

			}

		}
	}
}
