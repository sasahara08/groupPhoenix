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

import dao.ResaleticketDAO;
import dao.TicketDAO;
import dto.Resaleticket;
import dto.Ticket;

/**
*
* @since  : 2025/03/28
* @author : M.urata
*
*/
@WebServlet("/ResaleTicketList")
public class ResaleTicketList extends HttpServlet {
	private ResaleticketDAO resaleticketDAO;
	private TicketDAO ticketDAO; 
       
	@Override
    public void init() {
		resaleticketDAO = new ResaleticketDAO();
		ticketDAO = new TicketDAO();
    }

    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		List<Resaleticket> resaletickets = resaleticketDAO.getAllTickets();
		request.setAttribute("tickets", resaletickets);
         System.out.println(resaletickets.size());
		 // ticket.jsp を表示  
       request.getRequestDispatcher("/mainJsp/buyResaleTicketList.jsp").forward(request, response);  
  	}

    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	
	    	String resaleticket = request.getParameter("resaleticket");
	    	
	        if ("buyResaleTicketConfirmation".equals(resaleticket)) {
	        	
	        	String resaleticketParam = request.getParameter("ticketId");
	             int resaleticket1 = Integer.parseInt(resaleticketParam);

	             // DAOでデータ取得
	             ResaleticketDAO resaleticketDAO = new ResaleticketDAO();
	             Resaleticket ticket = null;
	             try {
					ticket = resaleticketDAO.getGameIdById(resaleticket1);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				request.setAttribute("ticket", ticket);
	             
	              // JSPに転送
	             RequestDispatcher dispatcher = request.getRequestDispatcher("./mainJsp/resaleTicketSalesConfirmation.jsp");
	             dispatcher.forward(request, response);
	        	
	            request.getRequestDispatcher("./mainJsp/buyResaleTicketConfirmation.jsp").forward(request, response);
	        } else if ("game".equals(resaleticket)) {
	        	 List<Ticket> tickets = ticketDAO.getAllTickets();
	             request.setAttribute("tickets", tickets);request.getRequestDispatcher("./mainJsp/game.jsp").forward(request, response);
	        } else if ("buyResaleTicketComplete".equals(resaleticket)) {
	        	
	        	response.setContentType("application/json");

//	            try {
//	                // リクエストデータを取得
//	                StringBuilder sb = new StringBuilder();
//	                String line;
//	                while ((line = request.getReader().readLine()) != null) {
//	                    sb.append(line);
//	                }
//	                JSONObject json = new JSONObject(sb.toString());
//	                String ticketId = json.getString("ticket_id");
//	                String userId = json.getString("user_id");
//
//	                // Beanを介してデータを設定
//	                resaleticket = new Resaleticket();
//	                Resaleticket.setTicketId(ticketId);
//	                Resaleticket.setUserId(userId);
//	                Resaleticket.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
//
//	                // DAOを呼び出してDBに保存
//	                ResaleticketDAO dao = new ResaleticketDAO();
//	                dao.void addTicketOrder(int ticketId, int userId, LocalDateTime createdAt) {
//					}
//
//	                response.setStatus(HttpServletResponse.SC_OK);
//	                response.getWriter().write("{\"message\":\"Success\"}");
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//	                response.getWriter().write("{\"message\":\"Error\"}");
//	            }
//	        }
//	    }

	        	
	            request.getRequestDispatcher("./mainJsp/buyResaleTicketComplete.jsp").forward(request, response);
	        } else if ("buyResaleTicketList".equals(resaleticket)) {
	        	   // 全チケット情報を取得
	        	List<Resaleticket> resaletickets = resaleticketDAO.getAllTickets();
	    		request.setAttribute("tickets", resaletickets);
	            request.getRequestDispatcher("./mainJsp/buyResaleTicketList.jsp").forward(request, response);
	        } else if ("memberTop".equals(resaleticket)){
	            request.getRequestDispatcher("./mainJsp/memberTop.jsp").forward(request, response);
	        } else {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
	        }
	    }
	}

