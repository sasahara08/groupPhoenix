package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketList
 */
@WebServlet("/TicketList")
public class TicketList extends HttpServlet {

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // ticket.jsp を表示  
        request.getRequestDispatcher("/mainJsp/ticket.jsp").forward(request, response);  
   	}

	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	
	    	String ticket = request.getParameter("ticket");
	    	
	        if ("resaleTicketSalesConfirmation".equals(ticket)) {
	            request.getRequestDispatcher("./mainJsp/resaleTicketSalesConfirmation.jsp").forward(request, response);
	        } else if ("ticketDisplay".equals(ticket)) {
	            request.getRequestDispatcher("./mainJsp/ticketDisplay.jsp").forward(request, response);
	        } else if ("ticket".equals(ticket)) {
	            request.getRequestDispatcher("./mainJsp/ticket.jsp").forward(request, response);
	        } else if ("resaleTicketSalesComplete".equals(ticket)) {
	            request.getRequestDispatcher("./mainJsp/resaleTicketSalesComplete.jsp").forward(request, response);
	        } else if ("memberTop".equals(ticket)){
	            request.getRequestDispatcher("./mainJsp/memberTop.jsp").forward(request, response);
	        } else {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
	        }
	    }
	}
