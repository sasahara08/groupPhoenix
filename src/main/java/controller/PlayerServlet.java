package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PlayerDAO;
import dto.PlayersBean;

@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// "id"パラメータの取得
		String playerIdStr = request.getParameter("id");
		PlayerDAO playerDAO = new PlayerDAO();
		List<PlayersBean> list = null;

		// パラメータが指定されていない場合、一覧を表示する
		if (playerIdStr == null || playerIdStr.isEmpty()) {

			try {
				list = playerDAO.getPlayerList();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			// プレイヤー情報をリクエストに設定
			request.setAttribute("players", list);
			// playe.jspに転送
			request.getRequestDispatcher("/mainJsp/player.jsp").forward(request, response);
			
		} else {
			// パラメータが指定されている場合、選手画面を表示する
			try {
				// プレイヤーIDを整数に変換
				int playerId = Integer.parseInt(playerIdStr);

				PlayersBean player = playerDAO.getPlayer(playerId); // プレイヤー情報を取得

				if (player == null) {
					// プレイヤーが存在しない場合、404エラーを返す
					response.sendError(HttpServletResponse.SC_NOT_FOUND, "指定された選手は存在しません");
					return;
				}

				// プレイヤー情報をリクエストに設定
				request.setAttribute("player", player);
				// playerDetail.jspに転送
				request.getRequestDispatcher("/mainJsp/playerDetail.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				// 数字に変換できなかった場合、400エラーを返す
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "無効な選手IDが指定されました");
			} catch (SQLException e) {
				// データベース関連のエラーが発生した場合、500エラーを返す
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "選手情報の取得中にエラーが発生しました");
			}
		}
	}
}


