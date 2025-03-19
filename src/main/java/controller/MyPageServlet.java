package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myPage")
public class MyPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ユーザー情報を取得（例：セッションから）
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String user_id = (String) session.getAttribute("user_id");

        // 取得した情報をリクエストスコープに設定
        request.setAttribute("name", name);
        request.setAttribute("user_id", user_id);

        // myPage.jspに転送
        RequestDispatcher dispatcher = request.getRequestDispatcher("myPage.jsp");
        dispatcher.forward(request, response);
    }
}