package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.AdminLoginDAO;
import dto.AdminBean;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//画面遷移
		String path = "./admin/AdminLogin.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 変数を用意
		String username = request.getParameter("username");
		String strPassword = request.getParameter("password");
		int password = 0;

		// int型に変換
		if (strPassword != null && !strPassword.equals("")) {
			password = Integer.parseInt(strPassword);
		}

		// ログイン情報のバリデーション
		if (username == null || username.trim().isEmpty() || strPassword == null || strPassword.trim().isEmpty()) {
			request.setAttribute("errorMessage", "ユーザー名とパスワードを入力してください。");
			request.getRequestDispatcher("/admin/AdminLogin.jsp").forward(request, response); // ログインページに戻る
		}

		//　ユーザー情報を検索して取得
		AdminBean admin = AdminLoginDAO.GetAdmin(username, password);

		if (admin.getName() != null) {
			// 認証成功
			HttpSession session = request.getSession();
			session.setAttribute("loggedInAdmin", admin); // セッションにユーザー情報を保存
			request.setAttribute("admin", admin); //名前を表示させる
			
			// 管理メニュー画面へフォワード
	        String path = "/admin/adminMenu.jsp";
	        request.getRequestDispatcher(path).forward(request, response);
		} else {
			// 認証失敗
			request.setAttribute("errorMessage", "ユーザー名またはパスワードが正しくありません。");
			request.getRequestDispatcher("/admin/AdminLogin.jsp").forward(request, response); // ログインページに戻る
		}

	}

}
