package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.AdminBean;

public class AdminLoginDAO {
	
	// 管理者名とパスワードで検索をかけるてオブジェクトで返す
	public static AdminBean GetAdmin(String name, int pass) {
		// 変数を用意
		AdminBean admin = new AdminBean();
		
		try (Connection connection = DBManager.getConnection()) {
			String sql = "select * from admin where name = ? and pass = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			// sqlに名前とパスワードをセット
			statement.setString(1, name);
			statement.setInt(2, pass);
			// 実行
			ResultSet rsUser = statement.executeQuery();
			
			if(rsUser.next()) {
				
				admin.setName(rsUser.getString("name"));
				admin.setPass(rsUser.getInt("pass"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	};
}
