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

import dao.AdminGameDAO;
import dao.DBManager;
import dto.GameBean;
import dto.StadiumsBean;
import dto.TeamsBean;

/**
 * @since : 2025/03/17 Y.sasahara
 * 
 * @return : 管理者画面内に置ける試合情報のCRUD
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

			//チーム一覧・スタジアム一覧・ゲーム一覧を取得して遷移
			String teamSql = "select * from teams order by team_id";
			String stadiumSql = "select * from stadiums order by stadium_id";
			String gameSql = "select * from games order by game_id";

//			System.out.print(teamSql);//取得確認用

			try (Connection conn = DBManager.getConnection();
					PreparedStatement teamPStmt = conn.prepareStatement(teamSql);
					PreparedStatement stadiumPStmt = conn.prepareStatement(stadiumSql);
					PreparedStatement gamePStmt = conn.prepareStatement(gameSql);) {

				//sqlを実行(全チーム取得)
				List<TeamsBean> teamList = new ArrayList<>();
				ResultSet rsTeam = teamPStmt.executeQuery();
				while (rsTeam.next()) {
					TeamsBean team = new TeamsBean();
					team.setTeamId(rsTeam.getInt("team_id"));
					team.setTeamName(rsTeam.getString("team_name"));
					teamList.add(team);
				}

				//sqlを実行(全スタジアム取得)
				List<StadiumsBean> stadiumList = new ArrayList<>();
				ResultSet rsStadium = stadiumPStmt.executeQuery();
				while (rsStadium.next()) {
					StadiumsBean stadiums = new StadiumsBean();
					stadiums.setStadiumsId(rsStadium.getInt("stadium_id"));
					stadiums.setStadiumsName(rsStadium.getString("stadium_name"));
					stadiumList.add(stadiums);
				}

				//sqlを実行(全試合情報取得)
				List<GameBean> gameList = AdminGameDAO.teamName();

				// 確認用
				//				System.out.println(teamList);
				//				System.out.println(stadiumList);
				//				System.out.println(gameList);
				//				System.out.println("gameTop遷移");

				//画面遷移
				request.setAttribute("teams", teamList);
				request.setAttribute("stadiums", stadiumList);
				request.setAttribute("games", gameList);
				String path = "./admin/game.jsp";
				request.getRequestDispatcher(path).forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "データベース接続エラー");
				String path = "/admin/game.jsp"; // エラー時の遷移先
				request.getRequestDispatcher(path).forward(request, response);
			}
		} else {

			switch (gamePage) {

			//ゲーム一覧→ゲーム情報追加(確認画面)
			//パラメータはjsで取得。
			case "addCheck":
				String path = "/admin/gameAddCheacked.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				break;

			//ゲーム一覧画面→編集画面遷移
			case "edit":

				//チーム一覧とスタジアム一覧を取得して遷移
				String teamSql = "select * from teams order by team_id";
				String stadiumSql = "select * from stadiums order by stadium_id";
				
				try (Connection conn = DBManager.getConnection();
						PreparedStatement teamPStmt = conn.prepareStatement(teamSql);
						PreparedStatement stadiumPStmt = conn.prepareStatement(stadiumSql);) {
					
					//sqlを実行(全チーム取得)
					List<TeamsBean> teamList = new ArrayList<>();
					ResultSet editRs = teamPStmt.executeQuery();
					while (editRs.next()) {
						TeamsBean team = new TeamsBean();
						team.setTeamId(editRs.getInt("team_id"));
						team.setTeamName(editRs.getString("team_name"));
						teamList.add(team);
					}

					//sqlを実行(全スタジアム取得)
					List<StadiumsBean> stadiumList = new ArrayList<>();
					ResultSet editRsStadium = stadiumPStmt.executeQuery();
					while (editRsStadium.next()) {
						StadiumsBean stadiums = new StadiumsBean();
						stadiums.setStadiumsId(editRsStadium.getInt("stadium_id"));
						stadiums.setStadiumsName(editRsStadium.getString("stadium_name"));
						stadiumList.add(stadiums);
					}
					
//					System.out.println(teamList);
//					System.out.println(stadiumList);

					request.setAttribute("teams", teamList);
					request.setAttribute("stadiums", stadiumList);

					String editPath = "/admin/gameEdit.jsp";
					request.getRequestDispatcher(editPath).forward(request, response);
					break;

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("エラーです。");
					request.setAttribute("error", "データベース接続エラー");
					String editPath = "/admin/game.jsp"; // エラー時の遷移先
					request.getRequestDispatcher(editPath).forward(request, response);
					break;
				}

				// 試合編集画面→編集内容確認画面へ
			case "editCheck":
				String gameId = request.getParameter("gameId");
				int intValue = Integer.parseInt(gameId);

				GameBean EditGameList = AdminGameDAO.teamNameForId(intValue);
				
				request.setAttribute("games", EditGameList);

				String editCheckPath = "/admin/gameEditChecked.jsp";
				request.getRequestDispatcher(editCheckPath).forward(request, response);
				break;

			//試合一覧画面から→削除内容確認画面
			case "delete":
				String delGameId = request.getParameter("gameId");
				int intDelValue = Integer.parseInt(delGameId);

				GameBean deleteGameList = AdminGameDAO.teamNameForId(intDelValue);
				request.setAttribute("games", deleteGameList);

				String deleteCheckPath = "/admin/gameDeleteChecked.jsp";
				request.getRequestDispatcher(deleteCheckPath).forward(request, response);
				break;
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
//			HttpSession session = request.getSession();

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
						homeTeamSql = "SELECT team_id FROM teams WHERE team_name = ?";
						PreparedStatement homeTeamStatement = connection.prepareStatement(homeTeamSql);
						homeTeamStatement.setString(1, homeTeam); // パラメータを設定

						try (ResultSet homeTeamIdSet = homeTeamStatement.executeQuery()) {
							if (homeTeamIdSet.next()) {
								homeTeamId = homeTeamIdSet.getInt("team_id");
							}
						}
					}

					if (!awayTeam.isEmpty()) {
						awayTeamSql = "SELECT team_id FROM teams WHERE team_name = ?";
						PreparedStatement awayTeamStatement = connection.prepareStatement(awayTeamSql);
						awayTeamStatement.setString(1, awayTeam); // パラメータを設定

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
					searchSql.append("join stadiums on games.stadium_id = stadiums.stadium_id");

					// 時間があれば実装
					//					searchSql.append("join stadiums on games.stadium_id = stadiums.stadium_id WHERE game_delete_at is null");

					// パラメータに基づいてWHERE句を動的に追加
					if (gameId != null && !gameId.isEmpty()) {
						searchSql.append(" AND game_id = ?");
					}
					if (gameDay != null && !gameDay.isEmpty()) {
						searchSql.append(" AND game_date = ?");
					}
					if (homeTeam != null && !homeTeam.isEmpty()) {
						searchSql.append(" AND homeTeam.team_id = ?");
					}
					if (awayTeam != null && !awayTeam.isEmpty()) {
						searchSql.append(" AND awayTeam.team_id = ?");
					}
					if (stadium != null && !stadium.isEmpty()) {
						searchSql.append(" AND stadiums.stadium_name = ?");
					}

					searchSql.append(" order by game_id");

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
								GameBean games = new GameBean();
								games.setGameId(resultSet.getInt("game_id"));
								games.setGameDate(resultSet.getDate("game_date"));
								games.setStartTime(resultSet.getTime("start_time"));
								games.setHomeTeamName(resultSet.getString("homeTeam.team_name"));
								games.setAwayTeamName(resultSet.getString("awayTeam.team_name"));
								games.setStadium(resultSet.getString("stadiums.stadium_name"));
								gameList.add(games);
							}
							
								request.setAttribute("games", gameList);
							
							System.out.println(gameList);
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
				String formattedTime = hiddenTime + ":00";
				String hiddenHomeTeam = request.getParameter("hiddenHomeTeam");
				String hiddenAwayTeam = request.getParameter("hiddenAwayTeam");
				String hiddenStadium = request.getParameter("hiddenStadium");
				

				homeTeamSql = "SELECT team_id FROM teams WHERE team_name = ?";
				awayTeamSql = "SELECT team_id FROM teams WHERE team_name = ?";

				//StadiumIDを検索
				String stadiumSql = "SELECT stadium_id FROM stadiums WHERE stadium_name = ?";

				// SQLクエリの基本部分
				StringBuilder addSql = new StringBuilder(
						"insert into games (game_date, start_time, home_team_id, away_team_id, stadium_id) value (?, ?, ?, ?, ?)");

				//各Idを検索するsqlを文字列に変換
				try (Connection connection = DBManager.getConnection();
						PreparedStatement statement = connection.prepareStatement(addSql.toString());
						PreparedStatement homeTeamIdSql = connection.prepareStatement(homeTeamSql.toString());
						PreparedStatement awayTeamIdSql = connection.prepareStatement(awayTeamSql.toString());
						PreparedStatement stadiumIdSql = connection.prepareStatement(stadiumSql.toString());) {
					
					// プレースホルダに値を設定
					homeTeamIdSql.setString(1, hiddenHomeTeam);
					awayTeamIdSql.setString(1, hiddenAwayTeam);
					stadiumIdSql.setString(1, hiddenStadium);
					
					//日付と時間をdate型とtime型に変換
					Date gameDate = Date.valueOf(hiddenDay);
					Time gameTimes = Time.valueOf(formattedTime);

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
				break;
			//ゲーム情報編集(確定)
			case "editComplete":
				String editGameId = request.getParameter("gameId");
				String editGameDay = request.getParameter("gameDay");
				String editGameTime = request.getParameter("gameTime");
				String editHomeTeam = request.getParameter("homeTeam");
				String editAwayTeam = request.getParameter("awayTeam");
				String editStadium = request.getParameter("stadium");

				//日付と時間をdate型とtime型に変換
				Date gameDate = Date.valueOf(editGameDay);
				Time gameTimes = Time.valueOf(editGameTime);

				// update処理
				try (Connection connection = DBManager.getConnection()) {
				    // SQLクエリ（プレースホルダーを使用）
				    String sql = """
				        UPDATE games 
				        SET game_date = ?, 
				            start_time = ?, 
				            home_team_id = ?, 
				            away_team_id = ?, 
				            stadium_id = ? 
				        WHERE game_id = ?
				    """;

				    try (PreparedStatement statement = connection.prepareStatement(sql)) {
				        // プレースホルダーに値をセット
				        statement.setDate(1, gameDate);
				        statement.setTime(2, gameTimes);
				        statement.setInt(3, Integer.parseInt(editHomeTeam)); // IDは数値
				        statement.setInt(4, Integer.parseInt(editAwayTeam)); // IDは数値
				        statement.setInt(5, Integer.parseInt(editStadium));  // IDは数値
				        statement.setInt(6, Integer.parseInt(editGameId));   // IDは数値
				        

					//ここで実行
					int rowsUpdated = statement.executeUpdate();
					System.out.println("更新された行数: " + rowsUpdated);

					//画面遷移
					path = "/admin/gameEditComplete.jsp";
					request.getRequestDispatcher(path).forward(request, response);
					}

				} catch (NumberFormatException e) {
			        e.printStackTrace();
			        request.setAttribute("error", "数値変換エラー（IDが不正）");
			        path = "/admin/game.jsp";
			        request.getRequestDispatcher(path).forward(request, response);
			    } catch (IllegalArgumentException e) {
			        e.printStackTrace();
			        request.setAttribute("error", "時間または日付のフォーマットが不正");
			        path = "/admin/game.jsp";
			        request.getRequestDispatcher(path).forward(request, response);
			    } catch (SQLException e) {
			        e.printStackTrace();
			        request.setAttribute("error", "データベースエラー（SQL構文ミスの可能性あり）");
			        path = "/admin/game.jsp";
			        request.getRequestDispatcher(path).forward(request, response);
			    } catch (Exception e) {
			        e.printStackTrace();
			        request.setAttribute("error", "予期せぬエラーが発生しました");
			        path = "/admin/game.jsp";
			        request.getRequestDispatcher(path).forward(request, response);
			    }
			    break;

			//ゲーム情報削除(確定)
			case "deleteComplete":
				String deleteGameId = request.getParameter("gameId");
				//メソッド用にintに変換
				int intValue = Integer.parseInt(deleteGameId);
				AdminGameDAO.deleteGame(intValue);
				//画面遷移
				path = "/admin/gameEditComplete.jsp";
				request.getRequestDispatcher(path).forward(request, response);

				break;

			}

		}
	}
}
