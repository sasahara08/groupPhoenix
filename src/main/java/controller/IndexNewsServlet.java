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

import dao.NewsDAO;
import dto.NewsBean;

@WebServlet("/IndexNewsServlet")
public class IndexNewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsDAO newsDAO = new NewsDAO();
        List<NewsBean> newsList = null;

        try {
            newsList = newsDAO.getAllNews();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("newsList", newsList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/index.jsp");
        dispatcher.forward(request, response);
    }
}
