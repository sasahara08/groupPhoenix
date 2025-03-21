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
import jakarta.servlet.http.HttpSession;

import dao.DBManager;
import dao.UserDAO;
import dto.UserBean;

/**
 * Servlet implementation class AdminMember
 */
@WebServlet("/AdminMember")
public class AdminMember extends HttpServlet {
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

		request.setCharacterEncoding("UTF-8");

		// 送信種別の取得
		String sendKind = request.getParameter("sendKind");
		if (sendKind == null || sendKind.isEmpty() || sendKind.equals("userReset")) {
			/* 送信種別なし or 取り消し or 会員TOPに戻る */
			// member.jspへ画面遷移
			String path = "./admin/member.jsp";
			request.getRequestDispatcher(path).forward(request, response);

		} else {

			switch (sendKind) {
			//			//会員TOP→会員情報追加(確認画面)
			//			case "userAddCheck":
			//				String path = "/admin/memberAddChecked.jsp";
			//				request.getRequestDispatcher(path).forward(request, response);
			//				break;

			//会員検索結果一覧画面→編集画面遷移
			case "userEdit":
				// URLパラメータからuserIdを取得
				String userId = request.getParameter("userId");
				int intUserId = Integer.parseInt(userId); //型変換

				// DAOを使用してユーザー情報を取得
				UserBean EditUser = UserDAO.userId(intUserId);
				// ユーザー情報をリクエストスコープに保存
				request.setAttribute("users", EditUser);

				String editCheckPath = "/admin/memberEditChecked.jsp";
				request.getRequestDispatcher(editCheckPath).forward(request, response);
				break;

			// 会員情報編集画面→編集内容確認画面へ（これPostかも）

			case "userEditCheck":

				//会員一覧を取得して遷移
				String userSql = "SELECT * FROM users ORDER BY user_id";

				try (Connection conn = DBManager.getConnection();
						PreparedStatement userPStmt = conn.prepareStatement(userSql);) {

					//sqlを実行(全会員取得)
					List<UserBean> userList = new ArrayList<>();
					ResultSet editRs = userPStmt.executeQuery();
					while (editRs.next()) {
						UserBean user = new UserBean();
						user.setUserId(editRs.getInt("user_id"));
						user.setName(editRs.getString("name"));
						user.setKana(editRs.getString("kana"));
						user.setBirthday(editRs.getDate("birthday"));
						user.setPostCode(editRs.getString("post_code"));
						user.setAddress(editRs.getString("address"));
						user.setPhone(editRs.getString("phone"));
						user.setEmail(editRs.getString("email"));
						user.setPass(editRs.getString("pass"));
						user.setGender(editRs.getInt("gender"));
						userList.add(user);
					}
					request.setAttribute("users", userList);

					String editPath = "/admin/memberEditer.jsp";
					request.getRequestDispatcher(editPath).forward(request, response);
					break;

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("エラーです。");
					request.setAttribute("error", "データベース接続エラー");
					String editPath = "/admin/member.jsp"; // エラー時の遷移先
					request.getRequestDispatcher(editPath).forward(request, response);
					break;
				}

				//				//会員検索一覧_削除ボタン→削除内容確認画面
				//			case "userDeleteCheck":
				//				String delUserId = request.getParameter("userId");
				//				int intDelValue = Integer.parseInt(delUserId);
				//
				//				// DAOから該当ユーザー情報を取得
				//				UserBean deleteUser = UserDAO.userId(intDelValue); // DAOメソッドを呼び出し
				//
				//				// セッションスコープにユーザー情報を保存
				//				HttpSession session = request.getSession();
				//				session.setAttribute("newUser", deleteUser); // "newUser"として保存
				//
				//				// 削除確認画面にフォワード
				//				String deleteCheckPath = "/admin/memberDeleteChecked.jsp";
				//				request.getRequestDispatcher(deleteCheckPath).forward(request, response);
				//				break;

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 送信されたデータのエンコーディングを指定（文字化け対策）
		request.setCharacterEncoding("UTF-8");

		// 送信種別の取得
		String sendKind = request.getParameter("sendKind");
		if (sendKind == null || sendKind.isEmpty() || sendKind.equals("userReset")) {
			/* 送信種別なし or 取り消し or 会員TOPに戻る */
			// member.jspへ画面遷移
			String path = "./admin/member.jsp";
			request.getRequestDispatcher(path).forward(request, response);

		}
		/* 送信種別あり */
		else {
			//			// セッションスコープ取得
			//			HttpSession session = request.getSession();
			// 画面遷移先の初期化
			String path = null;

			// ボタン種別チェック
			switch (sendKind) {
			// 検索ボタン押下時
			case "userSearch":
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

				// デバッグ用にクエリを出力
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
						//					String userSearchPath = "/admin/memberSearch.jsp";
						path = "/admin/memberSearch.jsp";
						request.getRequestDispatcher(path).forward(request, response);
					}
					System.out.println("Number of users in userList: " + userList.size());

				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("error", "データベース接続エラー");
					path = "/admin/memberSearch.jsp";
					request.getRequestDispatcher(path).forward(request, response);
				}
				break;

			//会員検索一覧_削除ボタン→削除内容確認画面
			case "userDeleteCheck":
				String delUserId = request.getParameter("userId");
				int intDelValue = Integer.parseInt(delUserId);

				// DAOから該当ユーザー情報を取得
				UserBean deleteUser = UserDAO.userId(intDelValue); // DAOメソッドを呼び出し

				// セッションスコープにユーザー情報を保存
				HttpSession session = request.getSession();
				session.setAttribute("newUser", deleteUser); // "newUser"として保存

				// 削除確認画面にフォワード
				String deleteCheckPath = "/admin/memberDeleteChecked.jsp";
				request.getRequestDispatcher(deleteCheckPath).forward(request, response);
				break;

			case "userSearchTop":
				// userResetにしてTopに飛ばすかも
				String userSearchTopPath = "/admin/memberSearch.jsp";
				request.getRequestDispatcher(userSearchTopPath).forward(request, response);
				break;

			//会員削除内容確認画面→削除完了画面
			case "userDelete":
				String deleteUserId = request.getParameter("userId");
				int intDeleteValue = Integer.parseInt(deleteUserId);
				UserDAO.deleteUser(intDeleteValue);

				String deleteCompletePath = "/admin/memberDeleteComplete.jsp";
				request.getRequestDispatcher(deleteCompletePath).forward(request, response);
				break;

			//			//会員削除内容確認画面→削除完了画面
			//			case "userEditConfirm":
			//				String delUserId = request.getParameter("userId");
			//				int intDelValue = Integer.parseInt(delUserId);
			//				UserDAO.deleteUser(intDelValue);
			//
			//				String deleteCheckPath = "/admin/memberDeleteComplete.jsp";
			//				request.getRequestDispatcher(deleteCheckPath).forward(request, response);
			//				break;

			// 会員情報_追加ボタン押下時
			case "userAddCheck":
				/* 入力情報取得 */
				// 名前
				String addName = request.getParameter("name");
				// ふりがな
				String addKana = request.getParameter("kana");
				// 生年月日
				String addBirthday = request.getParameter("birthday");
				// 郵便番号
				String addPostcode = request.getParameter("postcode");
				// 住所
				String addAddress = request.getParameter("address");
				// 電話番号
				String addPhone = request.getParameter("phone");
				// メールアドレス
				String addEmail = request.getParameter("email");
				//				// 性別
				//				String addGender = request.getParameter("gender");
				// パスワード
				String addPass = request.getParameter("pass");

				// UserBeanにデータを格納
				UserBean addUser = new UserBean(addName, addKana, addBirthday, addPostcode, addAddress, addPhone,
						addEmail, addPass);

				// リクエストスコープに保存
				request.setAttribute("user", addUser);

				// 確認画面に遷移
				path = "/admin/memberAddChecked.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				break;

			// 会員情報_確定ボタン押下時
			case "userAddConfirm":
				// 確認画面からhiddenデータを取得
				String AddConfirmname = request.getParameter("name");
				String AddConfirmkana = request.getParameter("kana");
				String AddConfirmbirthday = request.getParameter("birthday");
				String AddConfirmpostcode = request.getParameter("postcode");
				String AddConfirmaddress = request.getParameter("address");
				String AddConfirmphone = request.getParameter("phone");
				String AddConfirmemail = request.getParameter("email");
				//			    String AddConfirmgender = request.getParameter("gender");
				String AddConfirmpass = request.getParameter("pass");

				UserBean userToAdd = new UserBean(AddConfirmname, AddConfirmkana, AddConfirmbirthday,
						AddConfirmpostcode, AddConfirmaddress, AddConfirmphone, AddConfirmemail, AddConfirmpass);

				try {
					UserDAO.addUser(userToAdd); // データベースに挿入
				} catch (SQLException e) {
					e.printStackTrace(); // 例外をログに出力
				}

				// 完了画面に遷移
				path = "/admin/memberAddComplete.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				break;

			}

			//			// 画面遷移
			//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			//			dispatcher.forward(request, response);
		}
	}
}
