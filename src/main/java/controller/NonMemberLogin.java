package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.NonMemberDAO;
import dto.LoginBean;

@WebServlet("/NonMemberLogin")
public class NonMemberLogin extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // login.jsp を表示
        request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        NonMemberDAO loginDAO = new NonMemberDAO();
        LoginBean user = null;

        try {
            // メールアドレスとパスワードを使用してユーザーを認証
            user = loginDAO.findByEmailAndPassword(email, password);

            if (user != null) {
                // 認証成功 -> セッションにユーザー情報を保存
                HttpSession session = request.getSession();
                session.setAttribute("userName", user.getName());  // ユーザー名
                session.setAttribute("userEmail", user.getEmail());  // メールアドレス
                session.setAttribute("userId", user.getUserId());  // ユーザーID

                // 新しい情報をセッションに保存
                session.setAttribute("userKana", user.getKana());  // カナ
                session.setAttribute("userBirthday", user.getBirthday());  // 生年月日
                session.setAttribute("userPostCode", user.getPostCode());  // 郵便番号
                session.setAttribute("userAddress", user.getAddress());  // 住所
                session.setAttribute("userPhone", user.getPhone());  // 電話番号
                session.setAttribute("userGender", user.getGender());  // 性別
                session.setAttribute("userCreatedAt", user.getCreatedAt());  // 登録日
                session.setAttribute("userLastLoginAt", user.getLastLoginAt());  // 最終ログイン日
                session.setAttribute("userCreditCardNumber", user.getCreditCardNumber());  // クレジットカード番号
                session.setAttribute("userCreditCardExpiryDate", user.getCreditCardExpiryDate());  // クレジットカード有効期限
                session.setAttribute("userCreditCardSecurityCode", user.getCreditCardSecurityCode());  // クレジットカードセキュリティコード
                
                // 最終ログイン時間を更新
                loginDAO.updateLastLoginTime(user.getUserId());  // 最終ログイン時間を更新する

                // 会員トップページにリダイレクト
                response.sendRedirect(request.getContextPath() + "/MemberTopServlet");
            } else {
                // 認証失敗 -> ログインページに戻る
                request.setAttribute("errorMsg", "メールアドレスまたはパスワードが間違っています");
                request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // エラーメッセージをログインページに渡す
            request.setAttribute("errorMsg", "システムエラーが発生しました。詳細は管理者にお問い合わせください。");
            request.getRequestDispatcher("/mainJsp/login.jsp").forward(request, response);
        }
    }
}
