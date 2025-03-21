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

import dao.NonMemberDAO;
import dto.LoginBean;

/**
 * ログイン処理を行うサーブレット
 * 
 * @since : 2025/03/21
 * @author : Generated
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * コンストラクタ
     */
    public LoginServlet() {
        super();
    }
    
    /**
     * GET リクエスト処理 - ログインフォームを表示
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // セッションチェック（すでにログインしている場合はメンバーページへ）
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") != null) {
            response.sendRedirect(request.getContextPath() + "/member");
            return;
        }
        
        // ログインページへフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }
    
    /**
     * POST リクエスト処理 - ログイン認証を実行
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        // ログインモデルの作成
        NonMemberDAO dao = new NonMemberDAO();
        LoginBean user = null;
        
        try {
            // ユーザー認証
            user = dao.findByEmailAndPassword(email, pass);
            
            if (user != null) {
                // 認証成功：セッションにユーザー情報を保存
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", user);
                
                // メンバーページへリダイレクト
                response.sendRedirect(request.getContextPath() + "/member");
            } else {
                // 認証失敗
                request.setAttribute("errorMsg", "メールアドレスまたはパスワードが正しくありません");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            // データベースエラー
            e.printStackTrace();
            request.setAttribute("errorMsg", "データベース接続エラーが発生しました");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
