import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberEditorDAO {

    // ユーザーIDに基づいてユーザー情報を取得
    public User getUserById(int userId) {
        User user = null;
        String sql = "SELECT * FROM users WHERE user_id = ?";  // user_idを使用して検索
        
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);  // user_idをセット
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setKana(rs.getString("kana"));
                user.setBirthday(rs.getDate("birthday"));
                user.setGender(rs.getString("gender"));
                user.setPostcode(rs.getString("postcode"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCreditcard(rs.getString("creditcard"));
                user.setExpiry(rs.getString("expiry"));
                user.setSecuritycode(rs.getString("securitycode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }

    // ユーザー情報を更新
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET name = ?, kana = ?, birthday = ?, gender = ?, postcode = ?, address = ?, phone = ?, email = ?, password = ?, creditcard = ?, expiry = ?, securitycode = ? WHERE user_id = ?";
        
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getKana());
            stmt.setDate(3, Date.valueOf(user.getBirthday().toString()));
            stmt.setString(4, user.getGender());
            stmt.setString(5, user.getPostcode());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getPhone());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getPassword());
            stmt.setString(10, user.getCreditcard());
            stmt.setString(11, user.getExpiry());
            stmt.setString(12, user.getSecuritycode());
            stmt.setInt(13, user.getUserId());  // 更新する対象のuser_idをセット
            
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 新規ユーザーをデータベースに挿入
    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (name, kana, birthday, gender, postcode, address, phone, email, password, creditcard, expiry, securitycode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getKana());
            stmt.setDate(3, Date.valueOf(user.getBirthday().toString()));
            stmt.setString(4, user.getGender());
            stmt.setString(5, user.getPostcode());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getPhone());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getPassword());
            stmt.setString(10, user.getCreditcard());
            stmt.setString(11, user.getExpiry());
            stmt.setString(12, user.getSecuritycode());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
