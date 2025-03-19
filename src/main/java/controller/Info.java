//package controller;
//
//import java.io.IOException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Info
// */
//@WebServlet("/mainJsp/Info")
//public class Info extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/info.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    /**
//     * POSTリクエストの処理
//     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // フォームから送信されたデータを取得
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String confirmEmail = request.getParameter("confirm-email");
//        String message = request.getParameter("message");
//
//        // 送信完了に遷移するか、確認画面に遷移するかを判定
//        if (request.getParameter("action") != null && request.getParameter("action").equals("complete")) {
//            // 完了画面に遷移
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoComplete.jsp");
//            dispatcher.forward(request, response);
//        } else {
//            // 確認画面に遷移
//            request.setAttribute("name", name);
//            request.setAttribute("email", email);
//            request.setAttribute("confirmEmail", confirmEmail);
//            request.setAttribute("message", message);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
//            dispatcher.forward(request, response);
//        }
//    }
//    
////	/**
////	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
////	 */
////
////    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        // フォームから送信されたデータを取得
////        String name = request.getParameter("name");
////        String email = request.getParameter("email");
////        String confirmEmail = request.getParameter("confirm-email");
////        String message = request.getParameter("message");
////
////        // 取得したデータをリクエスト属性に設定
////        request.setAttribute("name", name);
////        request.setAttribute("email", email);
////        request.setAttribute("confirmEmail", confirmEmail);
////        request.setAttribute("message", message);
////
////        // 確認画面に転送
////        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
////        dispatcher.forward(request, response);
////    }
//    
//
//}


package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.InquiriesDAO;
import dto.InquiriesBean;

@WebServlet("/mainJsp/Info")
public class Info extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GETリクエストの処理
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/info.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * POSTリクエストの処理
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // フォームから送信されたデータを取得
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String confirmEmail = request.getParameter("confirm-email");
//        String message = request.getParameter("message");
//
//        // "action" パラメータで処理を分岐
//        if (request.getParameter("action") != null && request.getParameter("action").equals("complete")) {
//            // データベースに問い合わせ内容を保存
//            InquiriesDAO dao = new InquiriesDAO();
//            LocalDateTime createdAt = LocalDateTime.now();
//            InquiriesBean inquiry = new InquiriesBean(0, 1, createdAt, message, null, null); // user_id は仮定で 1 を使用
//
//            try {
//                dao.saveInquiry(inquiry);
//            } catch (SQLException e) {
//                e.printStackTrace();
//                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データベース保存中にエラーが発生しました。");
//                return;
//            }
//
//            // 完了画面に遷移
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoComplete.jsp");
//            dispatcher.forward(request, response);
//
//        } else {
//            // 確認画面に遷移
//            request.setAttribute("name", name);
//            request.setAttribute("email", email);
//            request.setAttribute("confirmEmail", confirmEmail);
//            request.setAttribute("message", message);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
//            dispatcher.forward(request, response);
//        }
//    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // データベースから取得する処理を追加
        InquiriesDAO dao = new InquiriesDAO();
        List<InquiriesBean> inquiriesList = null; // データベースから取得するデータ

        try {
            inquiriesList = dao.getInquiries(); // DAOメソッドで問い合わせ情報を取得
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データベース操作中にエラーが発生しました。");
            return;
        }

        // JSPにデータを渡す
        request.setAttribute("inquiriesList", inquiriesList);

        // 完了画面に転送
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoComplete.jsp");
        dispatcher.forward(request, response);
    }

}
