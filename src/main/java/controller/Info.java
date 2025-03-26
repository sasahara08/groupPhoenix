////package controller;
////
////import java.io.IOException;
////
////import jakarta.servlet.RequestDispatcher;
////import jakarta.servlet.ServletException;
////import jakarta.servlet.annotation.WebServlet;
////import jakarta.servlet.http.HttpServlet;
////import jakarta.servlet.http.HttpServletRequest;
////import jakarta.servlet.http.HttpServletResponse;
////
/////**
//// * Servlet implementation class Info
//// */
////@WebServlet("/mainJsp/Info")
////public class Info extends HttpServlet {
////	private static final long serialVersionUID = 1L;
////
////	/**
////	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
////	 */
////    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/info.jsp");
////        dispatcher.forward(request, response);
////    }
////
////    /**
////     * POSTリクエストの処理
////     */
////    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        // フォームから送信されたデータを取得
////        String name = request.getParameter("name");
////        String email = request.getParameter("email");
////        String confirmEmail = request.getParameter("confirm-email");
////        String message = request.getParameter("message");
////
////        // 送信完了に遷移するか、確認画面に遷移するかを判定
////        if (request.getParameter("action") != null && request.getParameter("action").equals("complete")) {
////            // 完了画面に遷移
////            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoComplete.jsp");
////            dispatcher.forward(request, response);
////        } else {
////            // 確認画面に遷移
////            request.setAttribute("name", name);
////            request.setAttribute("email", email);
////            request.setAttribute("confirmEmail", confirmEmail);
////            request.setAttribute("message", message);
////
////            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
////            dispatcher.forward(request, response);
////        }
////    }
////    
//////	/**
//////	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//////	 */
//////
//////    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//////        // フォームから送信されたデータを取得
//////        String name = request.getParameter("name");
//////        String email = request.getParameter("email");
//////        String confirmEmail = request.getParameter("confirm-email");
//////        String message = request.getParameter("message");
//////
//////        // 取得したデータをリクエスト属性に設定
//////        request.setAttribute("name", name);
//////        request.setAttribute("email", email);
//////        request.setAttribute("confirmEmail", confirmEmail);
//////        request.setAttribute("message", message);
//////
//////        // 確認画面に転送
//////        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
//////        dispatcher.forward(request, response);
//////    }
////    
////
////}
//
//package controller;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import dto.InquiriesBean;
//
//@WebServlet("/mainJsp/info")
//public class Info extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * POSTリクエストの処理
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String confirm = request.getParameter("confirm");
//		
////		//確認ボタンが押された場合
////		if(confirm!=null) {
////			InquiriesBean info = new InquiriesBean();
////			//InquiriesBeanのセットメソッド（セッター）を使用してInquiriesBeanにフォームに入力した内容を格納
////			info.setInquiryText(request.getParameter("message"));
////			
////			
////			request.setAttribute("info", info);
////			// 確認画面に転送
////			RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation");
////			dispatcher.forward(request, response);
////		}else {
////			// 完了画面に転送
////			RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoComplete.jsp");
////			dispatcher.forward(request, response);
////			
////		}
//		
//		// 確認ボタンが押された場合
//		if (confirm != null) {
//		    InquiriesBean info = new InquiriesBean();
//
////		     フォームデータを InquiriesBean に設定
////		    info.setInquiryId(Integer.parseInt(request.getParameter("inquiry_id"))); // inquiry_id を取得
////		    info.setUserId(Integer.parseInt(request.getParameter("user_id"))); // user_id を取得
//		    
//		    info.setName(request.getParameter("name")); // 名前を取得
//		    info.setEmail(request.getParameter("email")); // メールを取得
//
//		    
//		    info.setInquiryText(request.getParameter("message")); // メッセージを取得
//		    
//
//
//		    // response_text を設定
//		    info.setResponseText(request.getParameter("response_text"));
//
//		    // response_at の設定（nullチェック付き）
//		    String responseAtParam = request.getParameter("response_at");
//		    if (responseAtParam != null && !responseAtParam.isEmpty()) {
//		        info.setResponseAt(LocalDateTime.parse(responseAtParam)); // ISO-8601形式の日時をパース
//		    }
//
//		    // InquiriesBean オブジェクトをリクエストスコープに保存
//		    request.setAttribute("info", info);
//
//		    // 確認画面に転送
//		    RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoConfirmation.jsp");
//		    dispatcher.forward(request, response);
//		} else {
//		    // 完了画面に転送
//		    RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/infoComplete.jsp");
//		    dispatcher.forward(request, response);
//		}
//		
//	}
//
//	/**
//	 * GETリクエストの処理
//	 */
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/info.jsp");
//		dispatcher.forward(request, response);
//
//	}
//
//}

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

@WebServlet("/mainJsp/info")
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
