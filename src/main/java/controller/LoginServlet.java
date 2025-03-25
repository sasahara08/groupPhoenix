package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.DBManager;

public class LoginServlet extends HttpServlet {

    // ログイン認証処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // データベース接続
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            
            // SQLクエリ: メールアドレスとパスワードでユーザー認証
            String sql = "SELECT * FROM users WHERE email = ? AND pass = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);  // メールアドレス
            ps.setString(2, password);  // パスワード

            rs = ps.executeQuery();

            // ユーザー情報が見つかればセッションにセットして、マイページへ遷移
            if (rs.next()) {
                String name = rs.getString("name");  // ユーザー名
                int user_id = rs.getInt("user_id");  // ユーザーID

                HttpSession session = request.getSession();
                session.setAttribute("name", name);  // セッションに名前
                session.setAttribute("user_id", user_id);  // セッションにユーザーID
                session.setAttribute("email", email);  // セッションにメールアドレス

                // 最後のログイン日時を更新
                String updateSql = "UPDATE users SET last_login_at = NOW() WHERE user_id = ?";
                try (PreparedStatement updatePs = conn.prepareStatement(updateSql)) {
                    updatePs.setInt(1, user_id);
                    updatePs.executeUpdate();
                }

                // マイページにリダイレクト
                response.sendRedirect("mainJsp/myPage.jsp");

            } else {
                // 認証に失敗した場合
                request.setAttribute("error", "ログインに失敗しました。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // エラーが発生した場合、エラーページにリダイレクト
            response.sendRedirect("error.jsp");
        } finally {
            // リソースを解放
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}