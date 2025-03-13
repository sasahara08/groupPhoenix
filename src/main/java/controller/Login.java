package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	private static final String URL = "jdbc:mysql://localhost:3306/phoenix?characterEncoding=UTF-8&serverTimeZone=JST";
	private static final String USERNAME = "Recurrent6C";
	private static final String PASSWORD = "6cjava";

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("会員ID (user_id): ");
        String userId = scanner.nextLine();

        System.out.print("パスワード (pass): ");
        String password = scanner.nextLine();

        if (validateLogin(userId, password)) {
            System.out.println("ログイン成功！");
        } else {
            System.out.println("ログイン失敗。ユーザーIDまたはパスワードが間違っています。");
        }

        scanner.close();
    }

    public static boolean validateLogin(String userId, String password) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM users WHERE user_id = ? AND pass = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // If a record exists, login is valid

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
		}
	}
}
