package controller;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/NewUserSecurity")
public class NewUserSecurity {
    private String password;
    private String creditCardNumber;

    // ゲッターとセッター
    public String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public static void setCreditCardNumber(String creditCardNumber) {
        
    }

	public String hashPassword(String password2) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public String encryptedCreditCardNumber(String creditCardNumber2) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}