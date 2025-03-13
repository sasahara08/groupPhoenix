package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatsDAO {
	/**
	 * DB接続サンプル
	 * @author shimizu
	 * @throws SQLException
	 */
	public void test() {
		//SQL文を記述
		String sql = "SELECT * FROM seats ORDER BY seat_id";
		//DBに接続
		try(Connection conn = DBManager.getConnection();
			PreparedStatement pStmt = conn.prepareStatement(sql)){
				//sqlを実行
				ResultSet rs = pStmt.executeQuery();
				
				//とりあえずseatsテーブルから取得した値をコンソースに表示しています
				while(rs.next()) {
					System.out.println("seat_id : " + rs.getString("seat_id"));
					System.out.println("seat_type : " + rs.getString("seat_type"));
					System.out.println("seat_price : " + rs.getString("seat_price"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
