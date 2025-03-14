package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.NonMemberDAO;
@WebServlet("/NonMemberLogin")
public class NonMemberLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // ticket.jsp を表示  
       request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);  
       System.out.println("login");
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	
    	// 遷移先分岐
    	String login = request.getParameter("login");
    	
        if ("login".equals(login)) {
            request.getRequestDispatcher("./mainJsp/member.jsp").forward(request, response);
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            System.out.println("login");
            //LoginDAOクラスのインスタンスを作成
            NonMemberDAO loginDAO = new NonMemberDAO();
            //validateLoginメソッドを使用してメールアドレスとパスワードの認証
            if (loginDAO.validateLogin(email, password)) {
            	request.getRequestDispatcher("/mainJsp/memberTop.jsp").forward(request, response);      
        } else  {request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);
            }
      } 
    }
}
