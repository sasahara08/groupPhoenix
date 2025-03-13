package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResaleTicketList
 */
@WebServlet("/ResaleTicketList")
public class ResaleTicketList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // ticket.jsp を表示  
       request.getRequestDispatcher("/mainJsp/buyResaleTicketList.jsp").forward(request, response);  
  	}

	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	
	    	String resaleticket = request.getParameter("resaleticket");
	    	
	        if ("buyResaleTicketConfirmation".equals(resaleticket)) {
	            request.getRequestDispatcher("./mainJsp/buyResaleTicketConfirmation.jsp").forward(request, response);
	        } else if ("game".equals(resaleticket)) {
	            request.getRequestDispatcher("./mainJsp/game.jsp").forward(request, response);
	        } else if ("buyResaleTicketComplete".equals(resaleticket)) {
	            request.getRequestDispatcher("./mainJsp/buyResaleTicketComplete.jsp").forward(request, response);
	        } else if ("buyResaleTicketList".equals(resaleticket)) {
	            request.getRequestDispatcher("./mainJsp/buyResaleTicketList.jsp").forward(request, response);
	        } else if ("memberTop".equals(resaleticket)){
	            request.getRequestDispatcher("./mainJsp/memberTop.jsp").forward(request, response);
	        } else {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
	        }
	    }
	}

