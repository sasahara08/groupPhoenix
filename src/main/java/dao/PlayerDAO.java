package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import dto.PlayersBean;

public class PlayerDAO {
    // データベース接続情報
    private static final String URL = "jdbc:mysql://localhost:3306/your_database?serverTimezone=Asia/Tokyo";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // コンストラクタでJDBCドライバをロード
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBCドライバをロード
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBCドライバのロードに失敗しました", e);
        }
    }

    // プレイヤー情報を取得するメソッド
    public PlayersBean getPlayer(int playerId) throws SQLException {
        PlayersBean player = null;
        String sql = "SELECT p.*, s.playerStatus " +
                     "FROM players p " +
                     "LEFT JOIN player_statuses s ON p.playerStatusId = s.playerStatusId " +
                     "WHERE p.id = ?";

        // データベース接続とクエリ実行
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playerId); // プレイヤーIDをセット

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { // 結果がある場合
                    player = new PlayersBean();
                    player.setPlayerId(rs.getInt("id"));
                    player.setName(rs.getString("name"));
                    player.setKana(rs.getString("kana"));
                    player.setImage(rs.getString("image"));
                    player.setBirthday(rs.getDate("birthday") != null ? rs.getDate("birthday").toLocalDate() : null);
                    player.setHeight(rs.getInt("height"));
                    player.setWeight(rs.getInt("weight"));
                    player.setBirthPlace(rs.getString("birth_place"));
                    player.setPosition(rs.getString("position"));
                    player.setComment(rs.getString("comment"));
                    player.setJoinedAt(rs.getDate("joinedAt") != null ? rs.getDate("joinedAt").toLocalDate() : null);
                    player.setEndingAt(rs.getDate("endingAt") != null ? rs.getDate("endingAt").toLocalDate() : null);
                    player.setPlayerStatusId(rs.getInt("playerStatusId"));
                    player.setPlayerStatus(rs.getString("playerStatus"));
                    
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
