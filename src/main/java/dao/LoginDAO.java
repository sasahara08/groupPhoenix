package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public boolean validateLogin(String email, String password) {
    	//SQL文を記述
    	String query = "SELECT * FROM users WHERE email = ? AND pass = ?";
    	
    	//DBに接続
        try (Connection connection = DBManager.getConnection()) {
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
          
            //sqlを実行
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // レコードが存在すればログインは有効

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
