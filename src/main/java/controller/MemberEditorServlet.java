import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/memberEditor")
public class MemberEditorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションからユーザーIDを取得
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("user_id");

        if (userId != null) {
            // UserDAOを使ってユーザー情報を取得
            UserDAO userDAO = new UserDAO();
            try {
                User user = userDAO.getUserInfo(userId); // ユーザー情報を取得
                if (user != null) {
                    // ユーザー情報をリクエストスコープに設定
                    request.setAttribute("user", user);
                    // memberEditor.jspに転送
                    RequestDispatcher dispatcher = request.getRequestDispatcher("memberEditor.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // ユーザーが見つからなかった場合
                    response.sendRedirect("error.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // エラーハンドリング
                response.sendRedirect("error.jsp");
            }
        } else {
            // セッションにユーザーIDがない場合（ログインしていない）
            response.sendRedirect("login.jsp");
        }
    }
}
