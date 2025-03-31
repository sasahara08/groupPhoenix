package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.DBManager;
import dao.ResaleCancelDAO;
import dto.AdminTicketsBean;
import dto.StadiumsBean;
import dto.TeamsBean;

/**
* 管理者画面_購入チケット情報のCRUD
*
* @since  : 2025/03/24
* @author : C.Tateshita
*
*/

/**
 * Servlet implementation class AdminTicket
 */
@WebServlet("/AdminTicket")
public class AdminTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

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

		// 送信されたデータのエンコーディングを指定（文字化け対策）
		request.setCharacterEncoding("UTF-8");
		// 送信種別の取得
		String sendKind = request.getParameter("sendKind");
		if (sendKind == null || sendKind.isEmpty() || sendKind.equals("ticketTop")) {
			/* 送信種別なし or 取り消し or チケットTOPに戻る */

			//チーム一覧・スタジアム一覧を取得して遷移
			String teamSql = "SELECT * FROM teams ORDER BY team_id";
			String stadiumSql = "SELECT * FROM stadiums ORDER BY stadium_id";

			try (Connection conn = DBManager.getConnection();
					PreparedStatement teamPStmt = conn.prepareStatement(teamSql);
					PreparedStatement stadiumPStmt = conn.prepareStatement(stadiumSql);) {

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

				// データをセット
				request.setAttribute("teams", teamList);
				request.setAttribute("stadiums", stadiumList);

				// tiket.jspへ画面遷移
				String path = "./admin/tiket.jsp";
				request.getRequestDispatcher(path).forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "データベース接続エラー");
				String path = "/admin/game.jsp"; // エラー時の遷移先
				request.getRequestDispatcher(path).forward(request, response);
			}
		} else {
			switch (sendKind) {

			//チケット検索一覧_削除ボタン→削除内容確認画面
			case "resaleTicketDeleteCheck":
				String delOrderDetailId = request.getParameter("orderDetailId");
				int intDelOrderDetailId = Integer.parseInt(delOrderDetailId);

				// DAOから該当ユーザー情報を取得
				AdminTicketsBean deleteResaleTicket = ResaleCancelDAO.OrderDetailId(intDelOrderDetailId);

				// リクエストスコープにユーザー情報を保存
				request.setAttribute("deleteResaleTicket", deleteResaleTicket);

				// 削除確認画面にフォワード
				String deleteCheckPath = "/admin/ticketDeleteChecked.jsp";
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
		// 送信種別の取得
		String sendKind = request.getParameter("sendKind");
		if (sendKind == null || sendKind.isEmpty() || sendKind.equals("ticketTop")) {
			/* 送信種別なし or 取り消し or チケットTOPに戻る */
			response.sendRedirect("/AdminTicket");
		}
		/* 送信種別あり */
		else {
			// 画面遷移先の初期化
			String path = null;

			// ボタン種別チェック
			switch (sendKind) {
			// 検索ボタン押下時
			case "ticketSearch":
				/* 入力情報取得 */
				// 購入者情報
				String ticketStatusId = request.getParameter("purchaseStatus");
				String ticketId = request.getParameter("ticketId");
				String ticketPurchaseDate = request.getParameter("ticketPurchaseDate");
				String ticketUserId = request.getParameter("userId");
				String ticketUserName = request.getParameter("name");
				String ticketUserKana = request.getParameter("kana");

				//				// リセールチケット購入者情報
				//				String resaleTicketStatusId = request.getParameter("resalePurchaseStatus");
				//				String resaleTicketId = request.getParameter("resaleTicketId");
				//				String resaleTicketPurchaseDate = request.getParameter("resaleTicketPurchaseDate");
				//				String resaleTicketUserId = request.getParameter("resaleUserId");
				//				String resaleTicketUserName = request.getParameter("resaleName");
				//				String resaleTicketUserKana = request.getParameter("resaleKana");
				//
				//				// 試合情報
				//				String gameId = request.getParameter("gameId");
				//				String gameDay = request.getParameter("gameDay");
				//				String homeTeam = request.getParameter("homeTeam");
				//				String awayTeam = request.getParameter("awayTeam");
				//				String stadium = request.getParameter("stadium");

				StringBuilder searchTicketSql = new StringBuilder(
						"SELECT TOD.ticket_purchase_status, TOD.created_at, TOD.user_id, T.ticket_status_id, T.ticket_id, users.name, users.kana, games.game_id, games.game_date, games.start_time, home_team.team_id AS home_team_id, away_team.team_id AS away_team_id, stadiums.stadium_id, home_team.team_name, away_team.team_name, stadiums.stadium_name, ticket_statuses.ticket_status, TOD.ticket_order_detail_id "
								+
								"FROM ticket_order_detail AS TOD " +
								"LEFT JOIN tickets AS T ON TOD.ticket_id = T.ticket_id " +
								"LEFT JOIN users ON TOD.user_id = users.user_id " +
								"LEFT JOIN games ON T.game_id = games.game_id " +
								"LEFT JOIN stadiums ON games.stadium_id = stadiums.stadium_id " +
								"LEFT JOIN teams AS home_team ON games.home_team_id = home_team.team_id " +
								"LEFT JOIN teams AS away_team ON games.away_team_id = away_team.team_id " +
								"LEFT JOIN ticket_statuses ON T.ticket_status_id = ticket_statuses.ticket_status_id " +
								"WHERE 1=1");

				// それぞれの項目ごとに検索かけていく
				// 通常購入者情報
				if (ticketStatusId != null && !ticketStatusId.isEmpty()) {
					searchTicketSql.append(" AND T.ticket_status_id = ? ");

					// ticketStatusIdが4の場合は購入状態ステータス2のものが表示
					if ("4".equals(ticketStatusId)) {
						searchTicketSql.append(" AND TOD.ticket_purchase_status = 2 ");
					}
				}
				if (ticketId != null && !ticketId.isEmpty()) {
					searchTicketSql.append(" AND T.ticket_id = ? ");
				}
				if (ticketPurchaseDate != null && !ticketPurchaseDate.isEmpty()) {
					searchTicketSql.append(" AND TOD.created_at = ? ");
				}
				if (ticketUserId != null && !ticketUserId.isEmpty()) {
					searchTicketSql.append(" AND TOD.user_id = ? ");
				}
				if (ticketUserName != null && !ticketUserName.isEmpty()) {
					searchTicketSql.append(" AND users.name = ? ");
				}
				if (ticketUserKana != null && !ticketUserKana.isEmpty()) {
					searchTicketSql.append(" AND users.kana = ? ");
				}

				// リセール購入者情報		
				//				if (resaleTicketStatusId != null && !resaleTicketStatusId.isEmpty()) {
				//					searchTicketSql.append(" AND T.ticket_status_id = ? ");
				//				}
				//				if (resaleTicketId != null && !resaleTicketId.isEmpty()) {
				//					searchTicketSql.append(" AND T.tikcet_id = ? ");
				//				}
				//				if (resaleTicketPurchaseDate != null && !resaleTicketPurchaseDate.isEmpty()) {
				//					searchTicketSql.append(" AND TOD.created_at = ? ");
				//				}
				//				if (resaleTicketUserId != null && !resaleTicketUserId.isEmpty()) {
				//					searchTicketSql.append(" AND TOD.user_id = ? ");
				//				}
				//				if (resaleTicketUserName != null && !resaleTicketUserName.isEmpty()) {
				//					searchTicketSql.append(" AND users.name = ? ");
				//				}
				//				if (resaleTicketUserKana != null && !resaleTicketUserKana.isEmpty()) {
				//					searchTicketSql.append(" AND users.kana = ? ");
				//				}
				//				searchTicketSql.append("ORDER BY TOD.ticket_order_detail_id LIMIT 1");

				// 確認用
				System.out.println("Generated SQL: " + searchTicketSql.toString());
				System.out.println("Received ticketId: " + ticketId);

				// SQL実行
				try (Connection connection = DBManager.getConnection();
						PreparedStatement statement = connection.prepareStatement(searchTicketSql.toString())) {
					int index = 1;

					// パラメータを設定する
					// 通常購入者情報
					if (ticketStatusId != null && !ticketStatusId.isEmpty()) {
						statement.setInt(index++, Integer.parseInt(ticketStatusId));
					}
					if (ticketId != null && !ticketId.isEmpty()) {
						statement.setInt(index++, Integer.parseInt(ticketId));
					}
					if (ticketPurchaseDate != null && !ticketPurchaseDate.isEmpty()) {
						statement.setDate(index++, Date.valueOf(ticketPurchaseDate));
					}
					if (ticketUserId != null && !ticketUserId.isEmpty()) {
						statement.setInt(index++, Integer.parseInt(ticketUserId));
					}
					if (ticketUserName != null && !ticketUserName.isEmpty()) {
						statement.setString(index++, ticketUserName);
					}
					if (ticketUserKana != null && !ticketUserKana.isEmpty()) {
						statement.setString(index++, ticketUserKana);
					}

					// リセール購入者情報
					//					if (ticketStatusId != null && !ticketStatusId.isEmpty()) {
					//						statement.setInt(index++, Integer.parseInt(ticketStatusId));
					//					}
					//					if (resaleTicketId != null && !resaleTicketId.isEmpty()) {
					//						statement.setInt(index++, Integer.parseInt(resaleTicketId));
					//					}
					//					if (resaleTicketPurchaseDate != null && !resaleTicketPurchaseDate.isEmpty()) {
					//						statement.setDate(index++, Date.valueOf(resaleTicketPurchaseDate));
					//					}
					//					if (resaleTicketUserId != null && !resaleTicketUserId.isEmpty()) {
					//						statement.setInt(index++, Integer.parseInt(resaleTicketUserId));
					//					}
					//					if (resaleTicketUserName != null && !resaleTicketUserName.isEmpty()) {
					//						statement.setString(index++, resaleTicketUserName);
					//					}
					//					if (resaleTicketUserKana != null && !resaleTicketUserKana.isEmpty()) {
					//						statement.setString(index++, resaleTicketUserKana);
					//					}

					List<AdminTicketsBean> ticketList = new ArrayList<>();

					try (ResultSet resultSet = statement.executeQuery()) {
						// 結果をリクエスト属性にセット
						while (resultSet.next()) {
							AdminTicketsBean ticketData = new AdminTicketsBean();
							ticketData.setTicketStatusId(resultSet.getInt("T.ticket_status_id"));
							ticketData.setTicketId(resultSet.getInt("T.ticket_id"));
							ticketData.setCreateAt(resultSet.getDate("TOD.created_at"));
							ticketData.setUserId(resultSet.getInt("TOD.user_id"));
							ticketData.setName(resultSet.getString("users.name"));
							ticketData.setKana(resultSet.getString("users.kana"));
							ticketData.setTicketPurchaseStatusId(resultSet.getInt("TOD.ticket_purchase_status"));
							ticketData.setGameId(resultSet.getInt("games.game_id"));
							ticketData.setGameDate(resultSet.getDate("games.game_date"));
							ticketData.setStartTime(resultSet.getTime("games.start_time"));
							ticketData.setHomeTeamName(resultSet.getString("home_team.team_name"));
							ticketData.setAwayTeamName(resultSet.getString("away_team.team_name"));
							ticketData.setStadium(resultSet.getString("stadiums.stadium_name"));
							ticketData.setTicketStatus(resultSet.getString("ticket_statuses.ticket_status"));
							ticketData.setOrderDetailId(resultSet.getInt("TOD.ticket_order_detail_id"));
							ticketList.add(ticketData);
						}
						request.setAttribute("ticketLists", ticketList);

						path = "/admin/ticketSerch.jsp";
						request.getRequestDispatcher(path).forward(request, response);
					}
					// 確認用
					System.out.println("チケットリスト数: " + ticketList.size());

				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("error", "データベース接続エラー");
					path = "/admin/ticketSerch.jsp";
					request.getRequestDispatcher(path).forward(request, response);
				}
				break;
				
				//チケット削除内容確認画面→削除完了画面
			case "resaleTicketDelete":				
				String updateResaleTicketId = request.getParameter("ticketId");
				int intUpdateResaleTicketId = Integer.parseInt(updateResaleTicketId);
				String deleteOrderDetailId = request.getParameter("orderDetailId");
				int intDeleteOrderDetailId = Integer.parseInt(deleteOrderDetailId);

				// DBから該当データ更新、削除
				ResaleCancelDAO.changeTicketStatus(intUpdateResaleTicketId);
				ResaleCancelDAO.deleteTicketDetail(intDeleteOrderDetailId);

				// 削除完了画面にフォワード
				String deleteCompletePath = "/admin/ticketDeleteComplete.jsp";
				request.getRequestDispatcher(deleteCompletePath).forward(request, response);
				break;

			}
		}

	}
}
