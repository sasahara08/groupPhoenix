package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(GameServlet.class.getName());
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        logger.info("GameServletの初期化処理を開始します。");
        try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDataSource"); // データソースの名前を適宜変更
        } catch (NamingException e) {
            logger.severe("データソースの取得に失敗しました: " + e.getMessage());
            throw new ServletException("データソースの初期化に失敗しました", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        logger.info("doGetメソッドが呼び出されました。");
        List<GameTicket> games = new ArrayList<>();
        
        try (Connection connection = dataSource.getConnection()) {
            logger.info("ゲーム情報をデータベースから取得しています...");
            GameDAO gameDAO = new GameDAO(connection);
            games = gameDAO.getAllGames();
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
        
        logger.info("ゲームリストをmainJsp/gameList.jspにフォワードします。");
        request.getRequestDispatcher("/mainJsp/gameList.jsp").forward(request, response);
    }
}
