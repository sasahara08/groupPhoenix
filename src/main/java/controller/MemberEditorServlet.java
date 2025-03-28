package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.MemberEditorDAO;

@WebServlet("/memberEditor")
public class MemberEditorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションからユーザーIDを取得
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");  // user_idがIntegerとして格納されている
        System.out.println(userId);

        if (userId != null) {
            try {
                // ユーザー情報をDAOから取得
                MemberEditorDAO dao = new MemberEditorDAO();
                String[] userInfo = dao.getUserById(userId);  // 取得するのはString[]としている

                if (userInfo != null) {
                    // ユーザー情報をリクエストスコープに設定
                    request.setAttribute("userInfo", userInfo);
                    // memberEditor.jspに転送
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/memberEditor.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // ユーザーが見つからなかった場合
                    response.sendRedirect("error.jsp");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                // エラーハンドリング
                request.setAttribute("errorMessage", "データベースエラーが発生しました。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // セッションにユーザーIDがない場合（ログインしていない）
            response.sendRedirect("login.jsp");
        }
    }
}
