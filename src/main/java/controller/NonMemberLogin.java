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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);  
	}	
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	
    	// 遷移先分岐
    	String login = request.getParameter("login");
    	System.out.println(login);
    	
        if ("login".equals(login)) {
        	String email = request.getParameter("email");
            String password = request.getParameter("password");
            //LoginDAOクラスのインスタンスを作成
            NonMemberDAO loginDAO = new NonMemberDAO();
            //validateLoginメソッドを使用してメールアドレスとパスワードの認証
            if (loginDAO.validateLogin(email, password)) {
            	request.getRequestDispatcher("/mainJsp/memberTop.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);
            }
        }else  {
            request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);
        } 
    }
}
