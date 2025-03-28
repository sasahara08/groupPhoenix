package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ResaleticketDAO;
import dao.SeatsDAO;
import dao.TicketDAO;
import dto.Resaleticket;
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
            request.getRequestDispatcher("./mainJsp/Top.jsp").forward(request, response);
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
             int quantity = request.getIntHeader("quantity");
             String seatIdParam = request.getParameter("seatId");
         	int seatId = request.getIntHeader(seatIdParam);

             // DAOでデータ取得
             TicketDAO ticketDAO = new TicketDAO();
             Ticket game = ticketDAO.getGameIdById(ticket1);
             SeatsDAO seatsDAO = new SeatsDAO();
             Optional<Seats> seat = SeatsDAO.getSeatById(seatId);
             request.setAttribute("seatType", seatId);
             request.setAttribute("seatPrice", seatId);
             request.setAttribute("ticket", game);
             request.setAttribute("quantity", quantity);
            
             request.getRequestDispatcher("/mainJsp/buyTicketConfirm.jsp").forward(request, response);
      
        } else if ("buyTicketComplete".equals(ticket)) {
            request.getRequestDispatcher("./mainJsp/buyTicketComplete.jsp").forward(request, response);
        } else if ("buyResaleTicketList".equals(ticket)) {
        	List<Resaleticket> resaletickets = resaleticketDAO.getAllTickets();
    		request.setAttribute("tickets", resaletickets);
                request.getRequestDispatcher("./mainJsp/buyResaleTicketList.jsp").forward(request, response);
        } else if ("buyTicketComplete".equals(ticket)) {
        	
        	String seatIdParam = request.getParameter("seatid");
        	int seatId = request.getIntHeader(seatIdParam);
        	
        	 SeatsDAO seatsDAO = new SeatsDAO();
             Optional<Seats> seat = SeatsDAO.getSeatById(seatId);
             request.setAttribute("seatType", seatId);
             request.setAttribute("seatPrice", seatId);
               
            RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/buyTicketConfirm.jsp");dispatcher.forward(request, response);
                    
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
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
        }
       
