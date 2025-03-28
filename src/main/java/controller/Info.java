package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.InquiriesDAO; // saveInquiryメソッドを含むクラスをインポート
import dto.InquiriesBean;

@WebServlet("/info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * POSTリクエストの処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String confirm = request.getParameter("confirm");
		System.out.println(confirm);
		// フォームデータをInquiriesBeanにセット
		InquiriesBean inquiry = new InquiriesBean();
		inquiry.setName(request.getParameter("name")); // 名前を設定
		inquiry.setEmail(request.getParameter("email")); // メールを設定
		inquiry.setInquiryText(request.getParameter("message")); // メッセージを設定
		
		if (confirm == null) {

			//            inquiry.setCreatedAt(LocalDateTime.now()); // 作成日時を現在時刻に設定

			try {
				// DAOクラスのsaveInquiryメソッドを呼び出してデータベースに保存
				InquiriesDAO dao = new InquiriesDAO(); // DAOクラスのインスタンスを作成
				dao.saveInquiry(inquiry); // INSERT文を実行
			} catch (SQLException e) {
				e.printStackTrace();
				// エラーメッセージをリクエストに設定
				//                request.setAttribute("error", "データベースエラーが発生しました: " + e.getMessage());
				//                // エラー画面に転送する場合:
				//                RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/error.jsp");
				//                dispatcher.forward(request, response);
				//                return;
			}

			// 完了画面に転送
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoComplete.jsp");
			dispatcher.forward(request, response);
		} else {
//		    // InquiriesBean オブジェクトをリクエストスコープに保存
		    request.setAttribute("info", inquiry);

			// 確認画面に遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * GETリクエストの処理
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/info.jsp");
		dispatcher.forward(request, response);
	}
}

//package controller;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import dao.InquiriesDAO; // saveInquiryメソッドを含むクラスをインポート
//import dto.InquiriesBean;
//
//@WebServlet("/info")
//public class Info extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * POSTリクエストの処理
//     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // フォームからメールアドレスを取得
//        String email = request.getParameter("email");
//        String confirmEmail = request.getParameter("confirm-email");
//
//        // メールアドレスの一致確認
//        if (email == null || confirmEmail == null || !email.trim().equals(confirmEmail.trim())) {
//            // 不一致の場合、エラーメッセージをリクエストスコープに設定
//            request.setAttribute("errorMessage", "入力されたメールアドレスが一致しません。正しく入力してください。");
//
//            // 再入力フォームに戻るように転送
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/info.jsp");
//            dispatcher.forward(request, response);
//            return;
//        }
//
//        // フォームデータをInquiriesBeanにセット
//        String confirm = request.getParameter("confirm");
//        InquiriesBean inquiry = new InquiriesBean();
//        inquiry.setName(request.getParameter("name")); // 名前を設定
//        inquiry.setEmail(email); // 確認済みのメールアドレスを設定
//        inquiry.setInquiryText(request.getParameter("message")); // メッセージを設定
//
//        if (confirm == null) {
//            try {
//                // DAOクラスのsaveInquiryメソッドを呼び出してデータベースに保存
//                InquiriesDAO dao = new InquiriesDAO();
//                dao.saveInquiry(inquiry); // INSERT文を実行
//            } catch (SQLException e) {
//                e.printStackTrace();
//                // エラーメッセージをリクエストに設定
//                request.setAttribute("error", "データベースエラーが発生しました: " + e.getMessage());
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/error.jsp");
//                dispatcher.forward(request, response);
//                return;
//            }
//
//            // 完了画面に転送
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoComplete.jsp");
//            dispatcher.forward(request, response);
//        } else {
//            // InquiriesBean オブジェクトをリクエストスコープに保存
//            request.setAttribute("info", inquiry);
//
//            // 確認画面に転送
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
//            dispatcher.forward(request, response);
//        }
//    }
//
//    /**
//     * GETリクエストの処理
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/info.jsp");
//        dispatcher.forward(request, response);
//    }
//}