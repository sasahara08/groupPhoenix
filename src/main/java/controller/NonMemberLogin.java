package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.NonMemberDAO;
@WebServlet("/NonMemberLogin")
public class NonMemberLogin extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // login.jsp を表示  
        request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);  
        System.out.println("login");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	
    	// 遷移先分岐
    	String login = request.getParameter("login");
    	
    	if ("login".equals(login)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            System.out.println("login1");
            
         // NonMemberDAOクラスのインスタンスを作成
            NonMemberDAO loginDAO = new NonMemberDAO();
            
         // validateLoginメソッドを使用してメールアドレスとパスワードの認証
            if (loginDAO.validateLogin(email, password)) {
                // ログイン成功 -> セッションにユーザー情報を保存
                HttpSession session = request.getSession();
                session.setAttribute("userEmail", email);  // ここでユーザー情報（emailなど）をセッションに保存
                System.out.println("login2");
                // ログイン後のページに遷移（例えば、memberTop.jsp）
                response.sendRedirect(request.getContextPath() + "/mainJsp/member.jsp");   
            } else {
                // ログイン失敗 -> ログインページに戻る
                response.sendRedirect(request.getContextPath() + "/mainJsp/login.jsp");
                System.out.println("login3");
            }
      } 
    }
}
