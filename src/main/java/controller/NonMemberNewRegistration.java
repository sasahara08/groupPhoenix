import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MembershipRegistrationCompleteDAO;

@WebServlet("/nonMemberNewRegistration")
public class NonMemberNewRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String kana = request.getParameter("kana");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String postcode = request.getParameter("postcode");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String expiry = request.getParameter("expiry");
        String creditcard = request.getParameter("creditcard");
        String securitycode = request.getParameter("securitycode");

        MembershipRegistrationCompleteDAO dao = new MembershipRegistrationCompleteDAO();
        try {
            dao.insertMember(name, kana, birthday, gender, postcode, address, phone, email, password, expiry, creditcard, securitycode);
            response.sendRedirect("membershipRegistrationComplete.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // エラーページにリダイレクト
        }
    }
}
