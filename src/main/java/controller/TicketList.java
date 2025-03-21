package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.TicketDAO;
import dto.TicketsBean;  

@WebServlet("/TicketList")  
public class TicketList extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        List<TicketsBean> tickets = null;  

        // データベース接続  
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password")) {  
            TicketDAO ticketDAO = new TicketDAO(connection);  
            tickets = ticketDAO.getAllTickets();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  

        // JSPに試合情報を転送  
        request.setAttribute("tickets", tickets);  
        request.getRequestDispatcher("./mainJsp/ticket.jsp").forward(request, response);  
    }  
}  
//	
//	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    	request.setCharacterEncoding("UTF-8");
//	    	
	    	
//	    	// 遷移先分岐
//	    	String ticket = request.getParameter("ticket");
//	    	
//	        if ("resaleTicketSalesConfirmation".equals(ticket)) {
//	            request.getRequestDispatcher("./mainJsp/resaleTicketSalesConfirmation.jsp").forward(request, response);
//	        } else if ("ticketDisplay".equals(ticket)) {
//	            request.getRequestDispatcher("./mainJsp/ticketDisplay.jsp").forward(request, response);
//	        } else if ("ticket".equals(ticket)) {
//	            request.getRequestDispatcher("./mainJsp/ticket.jsp").forward(request, response);
//	        } else if ("resaleTicketSalesComplete".equals(ticket)) {
//	            request.getRequestDispatcher("./mainJsp/resaleTicketSalesComplete.jsp").forward(request, response);
//	        } else if ("memberTop".equals(ticket)){
//	            request.getRequestDispatcher("./mainJsp/memberTop.jsp").forward(request, response);
//	        } else {
//	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
//	        }
//	    }
