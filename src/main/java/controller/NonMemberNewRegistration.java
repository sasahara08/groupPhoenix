package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MembershipRegistrationCompleteDAO;

@WebServlet("/NonMemberNewRegistration")
public class NonMemberNewRegistration extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームデータの取得
        String name = request.getParameter("name");
        String kana = request.getParameter("kana");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String postCode = request.getParameter("postcode");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String creditCardNumber = request.getParameter("creditcard");
        String creditCardExpiryDate = request.getParameter("expiry");
        String creditCardSecurityCode = request.getParameter("securitycode");

        // DAOインスタンスを作成
        MembershipRegistrationCompleteDAO dao = new MembershipRegistrationCompleteDAO();

        // ユーザー登録処理
        boolean isRegistered = dao.registerUser(name, kana, birthday, gender, postCode, address, phone, email, password, creditCardNumber, creditCardExpiryDate, creditCardSecurityCode);

        // 登録成功した場合、登録完了ページに遷移
        if (isRegistered) {
            response.sendRedirect("membershipRegistrationComplete.jsp");
        } else {
            // 登録失敗した場合、エラーメッセージを表示（またはエラーページへ遷移）
            response.sendRedirect("error.jsp");
        }
    }
}
