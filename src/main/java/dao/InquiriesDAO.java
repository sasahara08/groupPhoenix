//package dao;
//
//public class InquiriesDAO {
//
//}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.InquiriesBean;

public class InquiriesDAO {

//    // データベース接続情報を直接記述
//    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name"; // データベース名を指定
//    private static final String USER = "your_username"; // MySQLユーザー名
//    private static final String PASSWORD = "your_password"; // MySQLパスワード

    // 問い合わせをデータベースに保存するメソッド
//    public void saveInquiry(InquiriesBean inquiry) throws SQLException {
//        String sql = "INSERT INTO inquiries (user_id, created_at, inquiry_text) VALUES (?, ?, ?)";
//
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, inquiry.getUserId()); // ユーザーID
//            pstmt.setObject(2, inquiry.getCreatedAt()); // 作成日時
//            pstmt.setString(3, inquiry.getInquiryText()); // 問い合わせ内容
//            pstmt.executeUpdate();
//        }
//    }
	public List<InquiriesBean> getInquiries() throws SQLException {
	    List<InquiriesBean> inquiriesList = new ArrayList<>();
	    String sql = "SELECT inquiry_id, user_id, created_at, inquiry_text, response_text, response_at FROM inquiries";
	    
	    try (
				Connection conn = DBManager.getConnection(); // DB接続を取得
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//            ResultSet rs = pstmt.executeQuery() // SQLを実行して結果を取得
				ResultSet resultSet = pstmt.executeQuery() // SQLを実行して結果を取得
		) {

//次回ここから

//	        while (rs.next()) {
//	            inquiriesList.add(new InquiriesBean(
//	                rs.getInt("inquiry_id"),
//	                rs.getInt("user_id"),
//	                rs.getTimestamp("created_at").toLocalDateTime(),
//	                rs.getString("inquiry_text"),
//	                rs.getString("response_text"),
//	                rs.getTimestamp("response_at") != null ? rs.getTimestamp("response_at").toLocalDateTime() : null
//	            ));
//	        }
	    }
	    return inquiriesList;
	}

}

