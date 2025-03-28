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

import dao.ResaleDAO;
import dto.Resale;  

/**
*
* @since  : 2025/03/28
* @author : M.urata
*
*/

@WebServlet("/TicketList") 
public class TicketList extends HttpServlet {
    private ResaleDAO resaleDAO;

    @Override
    public void init() {
        resaleDAO = new ResaleDAO();
    }

    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    	 List<Resale> resales = resaleDAO.getAllTickets();
         request.setAttribute("tickets", resales);
         System.out.println(resales.size());
         // JSPにフォワード
         request.getRequestDispatcher("/mainJsp/ticket.jsp").forward(request, response);
     }

        

    	@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	
	    	
	    	// 遷移先分岐
	    	String resale = request.getParameter("resale");
	    	
	        if ("resaleTicketSalesConfirmation".equals(resale)) {
	        	String resaleParam = request.getParameter("ticketId");
	             int resale1 = Integer.parseInt(resaleParam);

	             // DAOでデータ取得
	             ResaleDAO resaleDAO = new ResaleDAO();
	             Resale game1 = null;
	             try {
					game1 = resaleDAO.getGameIdById(resale1);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				request.setAttribute("ticket", game1);
	             
	              // JSPに転送
	             RequestDispatcher dispatcher = request.getRequestDispatcher("./mainJsp/resaleTicketSalesConfirmation.jsp");
	             dispatcher.forward(request, response);
	     	
	        } else if ("ticketDisplay".equals(resale)) {
	        	String resaleParam = request.getParameter("ticketId");
	             int resale1 = Integer.parseInt(resaleParam);

	             // DAOでデータ取得
	             ResaleDAO resaleDAO = new ResaleDAO();
	             Resale game = null;
				try {
					game = resaleDAO.getGameIdById(resale1);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	             request.setAttribute("ticket", game);
	             
	              // JSPに転送
	             RequestDispatcher dispatcher = request.getRequestDispatcher("./mainJsp/ticketDisplay.jsp");
	             dispatcher.forward(request, response);
	        	
	        } else if ("ticket".equals(resale)) {
	        	 List<Resale> resales = resaleDAO.getAllTickets();
	             request.setAttribute("tickets", resales);
	            request.getRequestDispatcher("./mainJsp/ticket.jsp").forward(request, response);
	        } else if ("resaleTicketSalesComplete".equals(resale)) {
	        
	                // JSPから送信されたパラメータを取得
	                int ticketId = Integer.parseInt(request.getParameter("ticketId"));
	                int newStatusId = 3; // ステータスを「3」に設定

	                // DAOを呼び出してステータスを更新
	                try {
						resaleDAO.updateTicketStatus(ticketId, newStatusId);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

	                // リダイレクトで元のページに戻る
	              	
	            request.getRequestDispatcher("./mainJsp/resaleTicketSalesComplete.jsp").forward(request, response);
	        } else if ("memberTop".equals(resale)){
	            request.getRequestDispatcher("./mainJsp/memberTop.jsp").forward(request, response);
	        } else {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
	        }
	    }
}
