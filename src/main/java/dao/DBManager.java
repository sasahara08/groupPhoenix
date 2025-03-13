/**
 *
 * DBマネージャー
 * @since  : 1.0 : 2025/02/20
 *
 * Copyright (c) リカレントスクール.<br>
 *
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* データベースの接続を行う
*
* @since  : 2025/02/20
* @author : K.Imazawa
*
*/
public class DBManager {

	private static final String NAME_DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/phoenix?characterEncoding=UTF-8&serverTimeZone=JST";
	private static final String USER = "Recurrent6C";
	private static final String PASSWORD = "6cjava";
	/**
	*
	* コネクションを確立します
	*
	* @since  : 2025/02/20 K.Imazawa
	*
	* @return  Connection コネクション
	*
	* @throws SQLException DBのオープンに失敗した場合
	*/
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(NAME_DRIVER_MYSQL);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
}
