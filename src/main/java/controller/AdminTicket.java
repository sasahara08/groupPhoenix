package controller;

import java.io.IOException;
import java.sql.Connection;
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
import dto.StadiumsBean;
import dto.TeamsBean;
import dto.UserBean;

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
				// 会員ID
				String userId = request.getParameter("userid");
				// 名前
				String name = request.getParameter("name");
				// ふりがな
				String kana = request.getParameter("kana");
				// 電話番号
				String phone = request.getParameter("phone");
				// メールアドレス
				String email = request.getParameter("email");

				//会員一覧を取得
				//				String userSearchSql = "SELECT * FROM users";				
				StringBuilder searchUserSql = new StringBuilder("SELECT * FROM users WHERE 1=1");

				// それぞれの項目ごとに検索かけていく
				if (userId != null && !userId.isEmpty()) {
					searchUserSql.append(" AND users.user_id = ? ");
				}
				if (name != null && !name.isEmpty()) {
					searchUserSql.append(" AND users.name = ? ");
				}
				if (kana != null && !kana.isEmpty()) {
					searchUserSql.append(" AND users.kana = ? ");
				}
				if (phone != null && !phone.isEmpty()) {
					searchUserSql.append(" AND users.phone = ? ");
				}
				if (email != null && !email.isEmpty()) {
					searchUserSql.append(" AND users.email = ? ");
				}
				//				try (Connection conn = DBManager.getConnection();
				//						PreparedStatement userSearchPStmt = conn.prepareStatement(userSearchSql);) {
				//				
				//				
				//				try (Connection connection = DBManager.getConnection();
				//						PreparedStatement searchUserStatement = connection.prepareStatement(searchUserSql.toString())) {

				// 確認用
				System.out.println("Generated SQL: " + searchUserSql.toString());
				System.out.println("Received userId: " + userId);

				// SQL実行
				try (Connection connection = DBManager.getConnection();
						PreparedStatement statement = connection.prepareStatement(searchUserSql.toString())) {
					int index = 1;

					// パラメータを設定する
					if (userId != null && !userId.isEmpty()) {
						statement.setInt(index++, Integer.parseInt(userId));
					}
					if (name != null && !name.isEmpty()) {
						statement.setString(index++, name);
					}
					if (kana != null && !kana.isEmpty()) {
						statement.setString(index++, kana);
					}
					//			if (birthday != null && !birthday.isEmpty()) {
					//				statement.setDate(index++, Date.valueOf(birthday));
					//			}
					//			if (postcode != null && !postcode.isEmpty()) {
					//				statement.setString(index++, postcode);
					//			}
					//			if (address != null && !address.isEmpty()) {
					//				statement.setString(index++, address);
					//			}
					if (phone != null && !phone.isEmpty()) {
						statement.setString(index++, phone);
					}
					if (email != null && !email.isEmpty()) {
						statement.setString(index++, email);
					}
					//			if (gender != null && !gender.isEmpty()) {
					//				statement.setString(index++, gender);
					//			}

					List<UserBean> userList = new ArrayList<>();

					try (ResultSet resultSet = statement.executeQuery()) {
						// 結果をリクエスト属性にセット
						while (resultSet.next()) {
							UserBean user = new UserBean();
							user.setUserId(resultSet.getInt("user_id"));
							user.setName(resultSet.getString("name"));
							user.setKana(resultSet.getString("kana"));
							user.setBirthday(resultSet.getDate("birthday"));
							user.setPostCode(resultSet.getString("post_code"));
							user.setAddress(resultSet.getString("address"));
							user.setPhone(resultSet.getString("phone"));
							user.setEmail(resultSet.getString("email"));
							//							user.setGender(resultSet.getInt("gender"));
							userList.add(user);
						}
						request.setAttribute("users", userList);

						// // セッションスコープに保存
						// HttpSession session = request.getSession(); //ここじゃなくてもOK？
						// session.setAttribute("users", userList);

						path = "/admin/memberSearch.jsp";
						request.getRequestDispatcher(path).forward(request, response);
					}
					// 確認用
					System.out.println("Number of users in userList: " + userList.size());

				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("error", "データベース接続エラー");
					path = "/admin/memberSearch.jsp";
					request.getRequestDispatcher(path).forward(request, response);
				}
				break;

			}
		}

	}
}
