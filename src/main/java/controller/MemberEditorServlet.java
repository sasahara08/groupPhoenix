package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.NonMemberDAO;

@WebServlet("/MemberEditorServlet")
public class MemberEditorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションから情報を取得
        String userName = request.getParameter("name");
        String userEmail = request.getParameter("email");
        String userKana = request.getParameter("kana");
        String userBirthday = request.getParameter("birthday");
        String userPostCode = request.getParameter("postCode");
        String userAddress = request.getParameter("address");
        String userPhone = request.getParameter("phone");
        String userGender = request.getParameter("gender");
        String creditCardNumber = request.getParameter("creditCardNumber");
        String creditCardExpiryDate = request.getParameter("creditCardExpiryDate");
        String creditCardSecurityCode = request.getParameter("creditCardSecurityCode");

        // DAOを使ってデータベースを更新
        NonMemberDAO dao = new NonMemberDAO();
        try {
            dao.updateUserInfo(userEmail, userName, userKana, userBirthday, userPostCode, userAddress, userPhone, userGender, creditCardNumber, creditCardExpiryDate, creditCardSecurityCode);
            response.sendRedirect(request.getContextPath() + "/mainJsp/memberEditor.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/mainJsp/error.jsp");
        }
    }
}
