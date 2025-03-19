package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.AdminSaleDAO;
import dto.SaleBean;

/**
 * Servlet implementation class AdminSales
 */


@WebServlet("/AdminSales")
public class AdminSales extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		
		// 遷移先分岐
		String salePage = request.getParameter("salePage");
		
		// 売上管理トップ画面
		if (salePage == null || salePage.isEmpty() || salePage.equals("reset")) {
			
			// 売上一覧を追加
			List<SaleBean> saleList = AdminSaleDAO.createSalesList();
			
			//画面遷移
			request.setAttribute("sales", saleList);
			String path = "./admin/sales.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}else {
			switch(salePage) {
			
			//売上一覧(月別)
			case "saleMonth":
				
				//月別の売上一覧を表示
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
	}

}
