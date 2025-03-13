package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.LoginDAO;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//リクエストからメールアドレスとパスワードを取得
    	String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //LoginDAOクラスのインスタンスを作成
        LoginDAO loginDAO = new LoginDAO();
        //validateLoginメソッドを使用してメールアドレスとパスワードの認証
        if (loginDAO.validateLogin(email, password)) {
            // ログイン成功の場合は会員TOPへ遷移
        	request.getRequestDispatcher("memberTop.jsp").forward(request, response);
        } else {
            // ログイン失敗の場合は再度ログイン画面へ遷移
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
