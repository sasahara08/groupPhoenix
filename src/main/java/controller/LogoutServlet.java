package controller;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLogout") // サーブレットのURLパターンを設定
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションが存在する場合は無効化
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // セッションを無効化
        }
        // index.jsp にリダイレクト
        response.sendRedirect(request.getContextPath() + "/mainJsp/index.jsp");
    }
}

