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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String resaleticket = request.getParameter("resaleticket");

		if ("resaleTicketConfirmation".equals(resaleticket)) {

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

			request.getRequestDispatcher("./mainJsp/resaleTicketConfirmation.jsp").forward(request, response);
		} else if ("game".equals(resaleticket)) {
			List<Ticket> tickets = ticketDAO.getAllTickets();
			request.setAttribute("tickets", tickets);
			request.getRequestDispatcher("./mainJsp/game.jsp").forward(request, response);
		} else if ("resaleTicketSalesComplete".equals(resaleticket)) {

			// JSPから送信されたパラメータを取得
			int ticketId = Integer.parseInt(request.getParameter("ticketId"));
			int newStatusId = 4; // ステータスを「4」に設定

			// DAOを呼び出してステータスを更新
			try {
				resaleticketDAO.updateTicketStatus(ticketId, newStatusId);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			// ユーザーIDと現在時刻を取得
			String userId = request.getParameter("user_id");
			int id = Integer.parseInt(userId);
			// Beanを作成してデータを設定
			Resaleticket bean = new Resaleticket();
			bean.setUserId(id);

			// DAOを介してデータを挿入
			ResaleticketDAO dao = new ResaleticketDAO();
			dao.insertResaleticket(bean);

			response.getWriter().println("データが挿入されました！");

			// リダイレクトで元のページに戻る
			request.getRequestDispatcher("./mainJsp/resaleTicketSalesComplete.jsp").forward(request, response);

		} else if ("buyResaleTicketList".equals(resaleticket)) {
			// 全チケット情報を取得
			List<Resaleticket> resaletickets = resaleticketDAO.getAllTickets();
			request.setAttribute("tickets", resaletickets);
			request.getRequestDispatcher("./mainJsp/buyResaleTicketList.jsp").forward(request, response);
		} else if ("memberTop".equals(resaleticket)) {
			request.getRequestDispatcher("./mainJsp/memberTop.jsp").forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
		}

	}
}
