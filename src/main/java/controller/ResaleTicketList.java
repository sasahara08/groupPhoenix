package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.ResaleticketDAO;
import dao.TicketDAO;
import dto.Resaleticket;
import dto.Ticket;

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
        try {
            List<Resaleticket> resaletickets = resaleticketDAO.getAllTickets();
            request.setAttribute("tickets", resaletickets);
            System.out.println("Resale tickets size: " + resaletickets.size());

            // JSPを表示
            request.getRequestDispatcher("/mainJsp/buyResaleTicketList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while fetching tickets.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String resaleticket = request.getParameter("resaleticket");
        if (resaleticket == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action parameter is missing");
            return;
        }

        try {
            if ("buyResaleTicketConfirmation".equals(resaleticket)) {
                String resaleticketParam = request.getParameter("ticketId");
                if (resaleticketParam == null || resaleticketParam.isEmpty()) {
                    throw new IllegalArgumentException("ticketId parameter is missing");
                }

                int resaleticket1 = Integer.parseInt(resaleticketParam);
                Resaleticket ticket = resaleticketDAO.getGameIdById(resaleticket1);

                request.setAttribute("ticket", ticket);

                // JSPに転送
                request.getRequestDispatcher("./mainJsp/buyResaleTicketConfirmation.jsp").forward(request, response);

            } else if ("game".equals(resaleticket)) {
                List<Ticket> tickets = ticketDAO.getAllTickets();
                request.setAttribute("tickets", tickets);
                request.getRequestDispatcher("./mainJsp/game.jsp").forward(request, response);

            } else if ("buyResaleTicketComplete".equals(resaleticket)) {
            	
            	int ticketId = Integer.parseInt(request.getParameter("ticketId"));

            	// セッションを取得（新規作成しない）
            	HttpSession session = request.getSession(false);

            	// ログイン済みのユーザー情報を取得
            	int userId = (int) session.getAttribute("userId");
            	System.out.println("userId" + userId);
            	request.setAttribute("userId", userId);

            	// DAOを呼び出してステータスを更新
            	try {
            	    // userIdを渡す
            	    resaleticketDAO.updateUserId(userId,ticketId );
            	} catch (SQLException e) {
            	    e.printStackTrace();
            	}

            	
            	// JSPから送信されたパラメータを取得
    			int newStatusId = 2; // ステータスを「3」に設定
    			

    			// DAOを呼び出してステータスを更新
    			try {
    				resaleticketDAO.updateTicketStatus(ticketId, newStatusId);
    			} catch (SQLException e) {
    				// TODO 自動生成された catch ブロック
    				e.printStackTrace();
    			}

    			// リダイレクトで元のページに戻る
            	
            	
//                HttpSession session = request.getSession(false);
//                if (session == null || session.getAttribute("userId") == null) {
//                    throw new IllegalStateException("User is not logged in.");
//                }
//
//                int userId1 = (int) session.getAttribute("userId");
//
//                // Beanを作成してデータを設定
//                Resaleticket bean = new Resaleticket();
//                bean.setUserId(userId1);
//                resaleticketDAO.insertResaleticket(bean);
//
//                // ステータスを更新
//                int ticketId = Integer.parseInt(request.getParameter("ticketId"));
//                int newStatusId = 2; // ステータスを「4」に設定
//                resaleticketDAO.updateTicketStatus(ticketId, userId1, newStatusId);
//
//                String[] selectedValues = request.getParameterValues("values");
//                if (selectedValues == null || selectedValues.length == 0) {
//                    throw new IllegalArgumentException("No values selected.");
//                }
//
//                Ticket ticket = new Ticket(userId1, null, null, resaleticket, resaleticket, resaleticket, userId1,
//                        resaleticket, userId1, userId1, userId1);
//                List<Integer> ticketIds = ticket.fetchTicketIds(Arrays.asList(selectedValues));
//
//                request.setAttribute("ticketIds", ticketIds);
                request.getRequestDispatcher("./mainJsp/buyResaleTicketComplete.jsp").forward(request, response);

            } else if ("buyResaleTicketList".equals(resaleticket)) {
                List<Resaleticket> resaletickets = resaleticketDAO.getAllTickets();
                request.setAttribute("tickets", resaletickets);
                request.getRequestDispatcher("./mainJsp/buyResaleTicketList.jsp").forward(request, response);

            } else if ("memberTop".equals(resaleticket)) {
                request.getRequestDispatcher("./mainJsp/memberTop.jsp").forward(request, response);

            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format");
        } catch (IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "A database error occurred.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
        }
    }
}