package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dto.AdminBean;

/**
 * Servlet implementation class AdminTop
 */
@WebServlet("/AdminTop")
public class AdminTop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//---ログイン情報取得--------------------------------------------------------------
		
		// セッションを取得（新規作成しない）
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loggedInAdmin") == null) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		// ログイン済みの管理者情報を取得
		AdminBean admin = (AdminBean) session.getAttribute("loggedInAdmin");
		request.setAttribute("admin", admin);
		
		//---------------------------------------------------------------------------------

		// 管理メニュー画面へフォワード
		String path = "/admin/adminMenu.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
