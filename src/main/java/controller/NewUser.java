package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.DBManager;

@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private NewUserSecurity securityService = new NewUserSecurity();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新規登録入力画面を表示
		request.getRequestDispatcher("mainJsp/newUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// フォームデータの取得
		String name = request.getParameter("name");
		String kana = request.getParameter("kana");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String postCode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String creditCardNumber = request.getParameter("creditcard");
		String creditCardExpiryDate = request.getParameter("expiry");
		String creditCardSecurityCode = request.getParameter("securitycode");

		// パスワードのハッシュ化
		String hashedPassword = securityService.hashPassword(password);

		// クレジットカード情報の暗号化
		String encryptedCreditCardNumber = securityService.encryptedCreditCardNumber(creditCardNumber);

		// ユーザーオブジェクトの作成
		NewUserSecurity newUserSecurity = new NewUserSecurity();
		NewUserSecurity.setPassword(hashedPassword);
		NewUserSecurity.setCreditCardNumber(encryptedCreditCardNumber);

		
		
		// ユーザー登録処理
		boolean isRegistered = registerUser(name, kana, birthday, gender, postCode, address, phone, email, password,
				creditCardNumber, creditCardExpiryDate, creditCardSecurityCode);

		// 登録成功した場合、登録完了ページに遷移
		if (isRegistered) {
			response.sendRedirect("membershipRegistrationComplete.jsp");
		} else {
			// 登録失敗した場合、エラーメッセージを表示（またはエラーページへ遷移）
			response.sendRedirect("error.jsp");
		}
	}

	// ユーザー情報をusersテーブルに挿入するメソッド
	public boolean registerUser(String name, String kana, String birthday, String gender, String postCode,
			String address, String phone, String email, String password,
			String creditCardNumber, String creditCardExpiryDate, String creditCardSecurityCode) {

		// genderの値を日本語に変更
		if (gender.equals("female")) {
			gender = "女性";
		} else if (gender.equals("male")) {
			gender = "男性";
		} else {
			gender = "その他"; // デフォルト値
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		boolean isRegistered = false;

		try {
			// DBManagerを使って接続
			conn = DBManager.getConnection();

			// 現在の日付を取得
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String createdAt = dateFormat.format(new java.util.Date());
			String lastLoginAt = createdAt; // 最初のログイン日時はアカウント作成日と同じ

			// SQLクエリ（新規会員情報の挿入）
			String sql = "INSERT INTO users (name, kana, birthday, gender, post_code, address, phone, email, pass, created_at, last_login_at, credit_card_number, credit_card_expiry_date, credit_card_security_code) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// PreparedStatementの作成
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, kana);
			stmt.setString(3, birthday); // 生年月日（yyyy-MM-dd形式）
			stmt.setString(4, gender);
			stmt.setString(5, postCode);
			stmt.setString(6, address);
			stmt.setString(7, phone);
			stmt.setString(8, email);
			stmt.setString(9, password); // パスワード（ハッシュ化されていない）
			stmt.setString(10, createdAt);
			stmt.setString(11, lastLoginAt);
			stmt.setString(12, creditCardNumber);
			stmt.setString(13, creditCardExpiryDate);
			stmt.setString(14, creditCardSecurityCode);

			// デバッグ用のログ出力
			System.out.println("Executing SQL: " + sql);
			System.out.println("Parameters: " + name + ", " + kana + ", " + birthday + ", " + gender + ", " + postCode
					+ ", " + address + ", " + phone + ", " + email + ", " + password + ", " + createdAt + ", "
					+ lastLoginAt + ", " + creditCardNumber + ", " + creditCardExpiryDate + ", "
					+ creditCardSecurityCode);

			// SQL実行
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				isRegistered = true;
			}
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// リソースの解放
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isRegistered;
	}
}
