package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NonMemberDAO {

	public boolean validateLogin(String email, String password) {
	    String query = "SELECT * FROM users WHERE email = ? AND pass = ?";
	    
	    try (Connection connection = DBManager.getConnection()) {
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, password);

	        // SQLを実行
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            // ユーザーが存在する場合
	            return true;
	        } else {
	            // ユーザーが存在しない場合
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


    // メールアドレスに基づいてユーザーIDを取得するメソッド
    public int getUserIdByEmail(String email) {
    	String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection connection = DBManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            // SQLを実行
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("user_id"); // ユーザーIDを返す
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // ユーザーが見つからなかった場合は-1を返す
    }

    // メールアドレスに基づいてユーザー名を取得するメソッド
    public String getUserNameByEmail(String email) {
        String query = "SELECT name FROM users WHERE email = ?";
        try (Connection connection = DBManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            // SQLを実行
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name"); // ユーザー名を返す
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // ユーザーが見つからなかった場合はnullを返す
    }
}
