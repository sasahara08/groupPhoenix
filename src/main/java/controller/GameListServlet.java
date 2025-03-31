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
import jakarta.servlet.http.HttpSession;

import dao.ResaleticketDAO;
import dao.SeatsDAO;
import dao.TicketDAO;
import dto.Seats;
import dto.Ticket;

/**
*
* @since  : 2025/03/28
* @author : M.urata
*
*/

@WebServlet("/GameListServlet")
public class GameListServlet extends HttpServlet {
	private TicketDAO ticketDAO;
	private ResaleticketDAO resaleticketDAO;

	@Override
	public void init() {
		ticketDAO = new TicketDAO();
		resaleticketDAO = new ResaleticketDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 全チケット情報を取得
		List<Ticket> tickets = ticketDAO.getAllTickets();
		request.setAttribute("tickets", tickets);
		System.out.println(tickets.size());
		// JSPにフォワード
		request.getRequestDispatcher("/mainJsp/game.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String ticket = request.getParameter("ticket");

		if ("top".equals(ticket)) {
			request.getRequestDispatcher("${pageContext.request.contextPath}/MemberTopServlet").forward(request, response);
		} else if ("buyTicket".equals(ticket)) {
			String ticketParam = request.getParameter("gameId");
			int ticket1 = Integer.parseInt(ticketParam);

			// DAOでデータ取得
			TicketDAO ticketDAO = new TicketDAO();
			Ticket game = null;
			game = ticketDAO.getGameIdById(ticket1);
			request.setAttribute("ticket", game);

			// JSPに転送
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/buyTicket.jsp");
			dispatcher.forward(request, response);

		} else if ("game".equals(ticket)) {
			// 全チケット情報を取得
			List<Ticket> tickets = ticketDAO.getAllTickets();
			request.setAttribute("tickets", tickets);
			System.out.println(tickets.size());
			// JSPにフォワード
			request.getRequestDispatcher("./mainJsp/game.jsp").forward(request, response);

		} else if ("buyTicketConfirm".equals(ticket)) {
			String ticketParam = request.getParameter("gameId");
			int ticket1 = Integer.parseInt(ticketParam);
			String seatIdParam = request.getParameter("seatId");
//			int seatId = request.getIntHeader(seatIdParam);
			
			int seatId = Integer.parseInt(seatIdParam);
			
//			System.out.println("seatId :" + seatId);
			// DAOでデータ取得
			TicketDAO ticketDAO = new TicketDAO();
			Ticket game = null;
			game =ticketDAO.getGameIdById(ticket1);
			System.out.println(game.toString());
		
			SeatsDAO seatsDAO = new SeatsDAO();
			Seats seats = seatsDAO.getSeatById(seatId);
			//List<Ticket> tickets = new ArrayList<>();
			//List<Ticket> tickets = ticketDAO.getTicketids(ticket1, seatId);
			request.setAttribute("ticket", game);
			request.setAttribute("seat", seats);
			//System.out.println(tickets.size());


		      
			request.getRequestDispatcher("/mainJsp/buyTicketConfirm.jsp").forward(request, response);

		} else if ("buyTicketComplete".equals(ticket)) {
			//int ticketId = Integer.parseInt(request.getParameter("ticketId"));

			// JSPからのパラメータを取得
	        String gameIdParam = request.getParameter("gameId");
	        String seatIdParam = request.getParameter("seatId");

	        int gameId = Integer.parseInt(gameIdParam);
	        int seatId = Integer.parseInt(seatIdParam);

	        // BeanとDAOを使用してticketIdを取得
	        Ticket ticketBean = new Ticket();
	        ticketBean.setGameId(gameId);
	        ticketBean.setSeatId(seatId);

	        TicketDAO ticketDAO = new TicketDAO();
	        int ticketId1 = ticketDAO.getTicketId(ticketBean);

	        // JSPに転送
	        request.setAttribute("ticketId", ticketId1);
			
        	// セッションを取得（新規作成しない）
        	HttpSession session = request.getSession(false);

        	// ログイン済みのユーザー情報を取得
        	int userId = (int) session.getAttribute("userId");
        	System.out.println("userId" + userId);
        	request.setAttribute("userId", userId);

        	// DAOを呼び出してステータスを更新
        	try {
        	    // userIdを渡す
        	    resaleticketDAO.updateUserId(userId,ticketId1 );
        	} catch (SQLException e) {
        	    e.printStackTrace();
        	}

        	
        	// JSPから送信されたパラメータを取得
			int newStatusId = 2; // ステータスを「3」に設定
			

			// DAOを呼び出してステータスを更新
			try {
				resaleticketDAO.updateTicketStatus(ticketId1, newStatusId);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

             request.getRequestDispatcher("./mainJsp/buyTicketComplete.jsp").forward(request, response);
		
		} else if ("ResaleTicketList".equals(ticket)) {
//			List<Resaleticket> resaletickets = resaleticketDAO.getAllTickets();
//			request.setAttribute("tickets", resaletickets);
			request.getRequestDispatcher("${pageContext.request.contextPath}/ResaleTicketList").forward(request, response);
			//        } else if ("buyTicketComplete".equals(ticket)) {
			//        	
			//        	String seatIdParam = request.getParameter("seatid");
			//        	int seatId = request.getIntHeader(seatIdParam);
			//        	
			//        	 SeatsDAO seatsDAO = new SeatsDAO();
			//             Optional<Seats> seat = SeatsDAO.getSeatById(seatId);
			//             request.setAttribute("seatType", seatId);
			//             request.setAttribute("seatPrice", seatId);

			//            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/buyTicketConfirm.jsp");dispatcher.forward(request, response);

		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
		}
	}
}
	//        
	//        
	//        @Override
	//        protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//                throws ServletException, IOException {
	//            HttpSession session = request.getSession(false); // Check for an existing session
	//            if (session == null || session.getAttribute("username") == null) { // Redirect if not logged in
	//                response.sendRedirect("mainJsp/login.jsp");
	//                return;
	//            }
	//
	//    		request.getRequestDispatcher("/mainJsp/buyTicket.jsp").forward(request, response);

