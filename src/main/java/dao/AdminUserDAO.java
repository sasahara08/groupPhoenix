package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.UserBean;

public class AdminUserDAO {
	/**
	 * DB接続サンプル
	 * @author tateshita
	 * @throws SQLException
	 */
	//会員情報一覧を取得（Passとクレジットカード情報以外）
	//DBから「ユーザー情報」を取得、それをUserBeanというオブジェクトのリスト（userList）として返す
	public static List<UserBean> userBase() {
		List<UserBean> userList = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			// SQLクエリ
			String sql = """
					    SELECT * FROM users
					""";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rsUser = statement.executeQuery();
			while (rsUser.next()) {
				UserBean user = new UserBean();
				user.setUserId(rsUser.getInt("user_id"));
				user.setName(rsUser.getString("name"));
				user.setKana(rsUser.getString("kana"));
				user.setBirthday(rsUser.getDate("birthday"));
				user.setPostCode(rsUser.getString("post_code"));
				user.setAddress(rsUser.getString("address"));
				user.setPhone(rsUser.getString("phone"));
				user.setEmail(rsUser.getString("email"));
				user.setGender(rsUser.getInt("gender"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	//会員情報_user_idが一致するもの
	public static UserBean userId(int userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		UserBean user = null;

		try (Connection connection = DBManager.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, userId); // プレースホルダーにuserIdをセット

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					// UserBeanにデータをセット
					user = new UserBean();
					user.setUserId(resultSet.getInt("user_id"));
					user.setName(resultSet.getString("name"));
					user.setKana(resultSet.getString("kana"));
					user.setBirthday(resultSet.getDate("birthday"));
					user.setPostCode(resultSet.getString("post_code"));
					user.setAddress(resultSet.getString("address"));
					user.setPhone(resultSet.getString("phone"));
					user.setEmail(resultSet.getString("email"));
					//	                user.setGender(resultSet.getString("gender"));
					user.setPass(resultSet.getString("pass"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user; // ユーザー情報を返す
	}

	// 特定の会員ID情報を削除(テーブルから削除) 確認後の画面
	public static void deleteUser(int userId) {
		try (Connection connection = DBManager.getConnection()) {

			// SQL文
			String sql = "DELETE FROM users WHERE user_id = ?";

			// パラメータを設定(1つ目のプレースホルダーにuserIdを設定)
			try (PreparedStatement delStatement = connection.prepareStatement(sql)) {
				delStatement.setInt(1, userId);

				// 削除処理を実行
				int rowsDeleted = delStatement.executeUpdate();
				// 結果を表示
				System.out.println(rowsDeleted + " 行が更新されました。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addUser(UserBean user) throws SQLException {
		String sql = "INSERT INTO users (name, kana, birthday, post_code, address, phone, email, pass) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = DBManager.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, user.getName());
			statement.setString(2, user.getKana());

			// java.util.Dateからjava.sql.Dateに変換
			if (user.getBirthday() != null) {
				java.sql.Date sqlDate = new java.sql.Date(user.getBirthday().getTime()); // java.sql.Dateに変換
				statement.setDate(3, sqlDate); // 変換後のDateを渡す
			} else {
				statement.setDate(3, null); // 値がnullの場合はnullをセット
			}

			statement.setString(4, user.getPostCode());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getPhone());
			statement.setString(7, user.getEmail());

			statement.setString(8, user.getPass());

			//	        statement.setString(8, user.getGender());

			// SQLクエリをコンソールに出力
			System.out.println("SQL Query: " + statement.toString());

			statement.executeUpdate(); // INSERT文を実行
		}
	}

	public List<UserBean> searchUsers(String userId, String name, String kana, String phone, String email)
			throws SQLException {
		List<UserBean> userList = new ArrayList<>();
		StringBuilder searchUserSql = new StringBuilder("SELECT * FROM users WHERE 1=1");

		// 条件付きでクエリを組み立てる
		if (userId != null && !userId.isEmpty()) {
			searchUserSql.append("AND users.user_id = ? ");
		}
		if (name != null && !name.isEmpty()) {
			searchUserSql.append("AND users.name = ? ");
		}
		if (kana != null && !kana.isEmpty()) {
			searchUserSql.append("AND users.kana = ? ");
		}
		//		if (birthday != null && !birthday.isEmpty()) {
		//			searchUserSql.append("AND users.birthday = ? ");
		//		}
		//		if (postcode != null && !postcode.isEmpty()) {
		//			searchUserSql.append("AND users.post_code = ? ");
		//		}
		//		if (address != null && !address.isEmpty()) {
		//			searchUserSql.append("AND users.address = ? ");
		//		}
		if (phone != null && !phone.isEmpty()) {
			searchUserSql.append("AND users.phone = ? ");
		}
		if (email != null && !email.isEmpty()) {
			searchUserSql.append("AND users.email = ? ");
		}
		//		if (gender != null && !gender.isEmpty()) {
		//			searchUserSql.append("AND users.gender = ? ");
		//		}

		try (Connection connection = DBManager.getConnection();
				PreparedStatement searchUserStatement = connection.prepareStatement(searchUserSql.toString())) {
			int index = 1;

			// パラメータを設定する
			if (userId != null && !userId.isEmpty()) {
				searchUserStatement.setInt(index++, Integer.parseInt(userId));
			}
			if (name != null && !name.isEmpty()) {
				searchUserStatement.setString(index++, name);
			}
			if (kana != null && !kana.isEmpty()) {
				searchUserStatement.setString(index++, kana);
			}
			//			if (birthday != null && !birthday.isEmpty()) {
			//				searchUserStatement.setDate(index++, Date.valueOf(birthday));
			//			}
			//			if (postcode != null && !postcode.isEmpty()) {
			//				searchUserStatement.setString(index++, postcode);
			//			}
			//			if (address != null && !address.isEmpty()) {
			//				searchUserStatement.setString(index++, address);
			//			}
			if (phone != null && !phone.isEmpty()) {
				searchUserStatement.setString(index++, phone);
			}
			if (email != null && !email.isEmpty()) {
				searchUserStatement.setString(index++, email);
			}
			//			if (gender != null && !gender.isEmpty()) {
			//				searchUserStatement.setString(index++, gender);
			//			}

			// クエリを実行
			try (ResultSet resultSet = searchUserStatement.executeQuery()) {
				while (resultSet.next()) {
					UserBean users = new UserBean(
							resultSet.getInt("user_id"),
							resultSet.getString("name"),
							resultSet.getString("kana"),
							//							resultSet.getDate("birthday"),
							//							resultSet.getString("postcode"),
							//							resultSet.getString("address"),
							resultSet.getString("phone"),
							resultSet.getString("email"));
					//							GenderEnum.fromValue(resultSet.getInt("gender")), // GenderEnumに変換
					//							resultSet.getString("pass"));
					userList.add(users);
				}
			}
		}

		return userList;
	}

	public static void editUser(UserBean user) throws SQLException {
		String editUserSql = "UPDATE users SET name = ?, kana = ?, birthday = ?, post_code = ?, address = ?, phone = ?, email = ?, pass = ? WHERE user_id = ?";
		try (Connection connection = DBManager.getConnection();
				PreparedStatement statement = connection.prepareStatement(editUserSql)) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getKana());

			// java.util.Dateからjava.sql.Dateに変換
			if (user.getBirthday() != null) {
				java.sql.Date sqlDate = new java.sql.Date(user.getBirthday().getTime()); // java.sql.Dateに変換
				statement.setDate(3, sqlDate); // 変換後のDateを渡す
			} else {
				statement.setDate(3, null); // 値がnullの場合はnullをセット
			}
			statement.setString(4, user.getPostCode());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getPhone());
			statement.setString(7, user.getEmail());
			statement.setString(8, user.getPass());
			statement.setInt(9, user.getUserId());
			statement.executeUpdate();
		}
	}
}
