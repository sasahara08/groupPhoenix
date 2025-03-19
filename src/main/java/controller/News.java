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
//import dao.NewsDAO;
//
///**
// * Servlet implementation class News
// */
//@WebServlet("/mainjsp/News")
//public class News extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/news.jsp");
//        dispatcher.forward(request, response);
//    }
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
////	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		// TODO Auto-generated method stub
////		doGet(request, response);
////	}
//    
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // ニュースIDを取得
//        String newsIdParam = request.getParameter("id");
//        int newsId = Integer.parseInt(newsIdParam);
//
//        // DAOを使ってニュース情報を取得
//        NewsDAO newsDAO = new NewsDAO();
//        NewsDTO news = newsDAO.getNewsById(newsId);
//
//        // ニュース情報をリクエストスコープに設定
//        request.setAttribute("news", news);
//
//        // JSPにフォワード
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/newsDetail.jsp");
//        dispatcher.forward(request, response);
//    }
//
//
//}
//


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

import dao.NewsDAO;
import dto.NewsBean;

@WebServlet("/mainJsp/news")
public class News extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // DAOでデータ取得
        NewsDAO newsDAO = new NewsDAO();
        List<NewsBean> newsList  = null;
		try {
			newsList = newsDAO.getAllNews();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        // ニュース情報をリクエストスコープに設定
        request.setAttribute("newsList", newsList);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/news.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // IDを取得
        String idParam = request.getParameter("id");
        int id = Integer.parseInt(idParam);

        // DAOでデータ取得
        NewsDAO newsDAO = new NewsDAO();
        NewsBean news = newsDAO.getNewsById(id);

        // ニュース情報をリクエストスコープに設定
        request.setAttribute("news", news);
        
         // JSPに転送
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/newsDetail.jsp");
        dispatcher.forward(request, response);
    }
}


