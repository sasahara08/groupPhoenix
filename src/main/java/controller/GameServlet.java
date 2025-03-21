package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.DBManager;
import dao.GameDAO;
import dto.TicketsBean;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(GameServlet.class.getName());
    

    @Override
    public void init() throws ServletException {
        logger.info("GameServletの初期化処理を開始します。");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        logger.info("doGetメソッドが呼び出されました。");
        List<TicketsBean> games = new ArrayList<>();
        
        try (Connection connection = DBManager.getConnection()) {
            logger.info("ゲーム情報をデータベースから取得しています...");
            GameDAO gameDAO = new GameDAO(connection);
            games = gameDAO.getAllTickets();
            logger.info("ゲーム情報の取得に成功しました。");
        } catch (SQLException e) {
            logger.severe("データベース接続エラー: " + e.getMessage());
            request.setAttribute("errorMessage", "データベース接続エラーが発生しました。");
        } 

        if (games == null || games.isEmpty()) {
            logger.warning("ゲーム情報が見つかりませんでした。");
            request.setAttribute("errorMessage", "試合情報が見つかりませんでした。");
        } else {
            logger.info("取得したゲーム情報の数: " + games.size());
            request.setAttribute("games", games); 
        }
        
        logger.info("ゲームリストをmainJsp/game.jspにフォワードします。");
        request.getRequestDispatcher("/mainJsp/game.jsp").forward(request, response);
    }
}
