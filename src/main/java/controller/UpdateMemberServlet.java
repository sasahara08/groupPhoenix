package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.NonMemberDAO;

@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 直接アクセスした場合、会員情報編集画面にリダイレクト
        response.sendRedirect("memberEditor.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("back")) {
            // 戻るボタンが押された場合、編集画面に戻る
            response.sendRedirect("memberEditor.jsp");
        } else if (action != null && action.equals("confirm")) {
            // 確定ボタンが押された場合、確認画面からデータベース更新へ

            // フォームの入力データを取得
            String name = request.getParameter("name");
            String kana = request.getParameter("kana");
            String birthday = request.getParameter("birthday");
            String postCode = request.getParameter("postCode");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String creditCardNumber = request.getParameter("creditCardNumber");
            String creditCardExpiryDate = request.getParameter("creditCardExpiryDate");
            String creditCardSecurityCode = request.getParameter("creditCardSecurityCode");

            // セッションに保存
            HttpSession session = request.getSession();
            session.setAttribute("userName", name);
            session.setAttribute("userKana", kana);
            session.setAttribute("userBirthday", birthday);
            session.setAttribute("userPostCode", postCode);
            session.setAttribute("userAddress", address);
            session.setAttribute("userPhone", phone);
            session.setAttribute("userGender", gender);
            session.setAttribute("userCreditCardNumber", creditCardNumber);
            session.setAttribute("userCreditCardExpiryDate", creditCardExpiryDate);
            session.setAttribute("userCreditCardSecurityCode", creditCardSecurityCode);

            // ここで実際にDBを更新する
            NonMemberDAO dao = new NonMemberDAO();
            try {
                dao.updateUserInfo(
                    (String) session.getAttribute("userEmail"),  // 現在のメールアドレス
                    name,
                    kana,
                    birthday,
                    postCode,
                    address,
                    phone,
                    gender,
                    creditCardNumber,
                    creditCardExpiryDate,
                    creditCardSecurityCode
                );
                // 更新完了後、完了画面へ
                response.sendRedirect("/groupPhoenix/mainJsp/memberEditorComplete.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            // 確認画面に遷移
            response.sendRedirect("/groupPhoenix/mainJsp/memberEditorConfirmation.jsp");
        }
    }
}
