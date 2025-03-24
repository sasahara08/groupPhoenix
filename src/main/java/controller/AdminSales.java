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
				
				Integer years = 0;
				
				//月別の売上一覧を表示
				String saleYear = request.getParameter("selectYear");
				
				// パラメータに値が入っていた時だけyearsを初期化
				if(years != 0) {
					years = Integer.parseInt(saleYear);
				}
				
					//月別の売り上げのリストを取得
					List<SaleBean> saleTotalList = AdminSaleDAO.saleSeatAsMonth(years);
					// 販売履歴のある年を取得(2025年販売なら2025年だけ)
					List<String> yearList = AdminSaleDAO.getYear();
					//月別の売り上げのリストをjsonに変換
					String json = AdminSaleDAO.convertListToJson(saleTotalList);
					
					//画面遷移
					request.setAttribute("sales", saleTotalList);
					request.setAttribute("years", yearList);
					request.setAttribute("json", json);
				String path = "./admin/monthlySales.jsp";
				request.getRequestDispatcher(path).forward(request, response);

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
