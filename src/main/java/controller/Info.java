package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Info
 */
@WebServlet("/mainJsp/Info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/info.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームから送信されたデータを取得
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String confirmEmail = request.getParameter("confirm-email");
        String message = request.getParameter("message");

        // 取得したデータをリクエスト属性に設定
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("confirmEmail", confirmEmail);
        request.setAttribute("message", message);

        // 確認画面に転送
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
        dispatcher.forward(request, response);
    }
    

}
