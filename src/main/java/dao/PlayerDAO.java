package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.PlayersBean;

public class PlayerDAO {
	   // プレイヤー情報の一覧を取得するメソッド
    public  List<PlayersBean> getPlayerList() throws SQLException {
        PlayersBean player = null;
        String sql = "SELECT p.*, s.player_status " +
                     "FROM players p " +
                     "LEFT JOIN player_statuses s ON p.player_status_id = s.player_status_id ";
        
        List<PlayersBean> list = null;
        
        // データベース接続とクエリ実行
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	list  = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) { // 結果がある場合
                    player = new PlayersBean();
                    player.setPlayerId(rs.getInt("player_id"));
                    player.setName(rs.getString("name"));
                    player.setKana(rs.getString("kana"));
                    player.setImage(rs.getString("image"));
                    player.setBirthday(rs.getDate("birthday") != null ? rs.getDate("birthday").toLocalDate() : null);
                    player.setHeight(rs.getInt("height"));
                    player.setWeight(rs.getInt("weight"));
                    player.setBirthPlace(rs.getString("birth_place"));
                    player.setPosition(rs.getString("position"));
                    player.setComment(rs.getString("comment"));
                    player.setJoinedAt(rs.getDate("joined_at") != null ? rs.getDate("joined_at").toLocalDate() : null);
                    player.setEndingAt(rs.getDate("ending_at") != null ? rs.getDate("ending_at").toLocalDate() : null);
                    player.setPlayerStatusId(rs.getInt("player_status_Id"));
                    player.setPlayerStatus(rs.getString("player_status"));
                    
                    // 年齢を計算してセット
                    if (player.getBirthday() != null) {
                        LocalDate now = LocalDate.now();
                        player.setAge(now.getYear() - player.getBirthday().getYear());
                    }
                    list.add(player);
                    
                }
            }
        } catch (SQLException e) {
            throw new SQLException("選手情報の取得中にエラーが発生しました: " + e.getMessage(), e);
        }
        return list;
    }

    // プレイヤー情報を取得するメソッド
    public PlayersBean getPlayer(int playerId) throws SQLException {
        PlayersBean player = null;
        String sql = "SELECT p.*, s.player_status " +
                     "FROM players p " +
                     "LEFT JOIN player_statuses s ON p.player_status_id = s.player_status_id " +
                     "WHERE p.player_id = ?";

        // データベース接続とクエリ実行
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playerId); // プレイヤーIDをセット

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { // 結果がある場合
                    player = new PlayersBean();
                    player.setPlayerId(rs.getInt("player_id"));
                    player.setName(rs.getString("name"));
                    player.setKana(rs.getString("kana"));
                    player.setImage(rs.getString("image"));
                    player.setBirthday(rs.getDate("birthday") != null ? rs.getDate("birthday").toLocalDate() : null);
                    player.setHeight(rs.getInt("height"));
                    player.setWeight(rs.getInt("weight"));
                    player.setBirthPlace(rs.getString("birth_place"));
                    player.setPosition(rs.getString("position"));
                    player.setComment(rs.getString("comment"));
                    player.setJoinedAt(rs.getDate("joined_at") != null ? rs.getDate("joined_at").toLocalDate() : null);
                    player.setEndingAt(rs.getDate("ending_at") != null ? rs.getDate("ending_at").toLocalDate() : null);
                    player.setPlayerStatusId(rs.getInt("player_status_Id"));
                    player.setPlayerStatus(rs.getString("player_status"));
                    
                    // 年齢を計算してセット
                    if (player.getBirthday() != null) {
                        LocalDate now = LocalDate.now();
                        player.setAge(now.getYear() - player.getBirthday().getYear());
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException("選手情報の取得中にエラーが発生しました: " + e.getMessage(), e);
        }
        return player;
    }
}
