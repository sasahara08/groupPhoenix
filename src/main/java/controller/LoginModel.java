package controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import dao.NonMemberDAO;
import dto.LoginBean;

/**
 * ログイン認証を行うモデルクラス
 * 
 * @since : 2025/03/21
 * @author : Generated
 */
public class LoginModel {
    
    /**
     * メールアドレスとパスワードでユーザー認証を行う
     * 
     * @param email メールアドレス
     * @param pass パスワード
     * @return 認証成功時はUserDTOオブジェクト、失敗時はnull
     * @throws SQLException データベース接続エラー発生時
     * @throws NoSuchAlgorithmException 
     */
    public LoginBean authenticate(String email, String pass) throws SQLException,NoSuchAlgorithmException {
    	NonMemberDAO userDAO = new NonMemberDAO();
        return userDAO.findByEmailAndPassword(email, pass);
    }
    
    /**
     * 認証情報の検証を行う
     * 
     * @param email メールアドレス
     * @param pass パスワード
     * @return 検証結果のメッセージ（問題なければnull）
     */
    public String validateCredentials(String email, String pass) {
        if (email == null || email.isEmpty()) {
            return "メールアドレスを入力してください";
        }
        
        if (pass == null || pass.isEmpty()) {
            return "パスワードを入力してください";
        }
        
        // メールアドレスの簡易バリデーション
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return "有効なメールアドレスを入力してください";
        }
        
        return null; // 問題なし
    }
}
