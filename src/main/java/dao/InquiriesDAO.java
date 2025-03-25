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

//     問い合わせをデータベースに保存するメソッド
//    public void saveInquiry(InquiriesBean inquiry) throws SQLException {
//        String sql = "INSERT INTO inquiries (user_id, created_at, inquiry_text) VALUES (?, ?, ?)";
//
////        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//        		try (Connection conn = DriverManager.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//             pstmt.setInt(1, inquiry.getName()); // 名前
//             pstmt.setObject(2, inquiry.getEmail()); // メール
////            pstmt.setInt(1, inquiry.getUserId()); // ユーザーID
////            pstmt.setObject(2, inquiry.getCreatedAt()); // 作成日時
//            pstmt.setString(3, inquiry.getInquiryText()); // 問い合わせ内容
//            pstmt.executeUpdate();
//        }
//    }
//	修正分
	
	public void saveInquiry(InquiriesBean inquiry) throws SQLException {
	    String sql = "INSERT INTO inquiries (name, email, message) VALUES (?, ?, ?)";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, inquiry.getName()); // 名前
	        pstmt.setString(2, inquiry.getEmail()); // メール
	        pstmt.setString(3, inquiry.getInquiryText()); // メッセージ

	        pstmt.executeUpdate();
	    }
	}
	
	
	public List<InquiriesBean> getInquiries() throws SQLException {
	    List<InquiriesBean> inquiriesList = new ArrayList<>();
//	    String sql = "SELECT inquiry_id, user_id, created_at, inquiry_text, response_text, response_at FROM inquiries";
	    String sql = "SELECT * FROM inquiries ORDER BY created_at DESC";
	    try (
				Connection conn = DBManager.getConnection(); // DB接続を取得
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//            ResultSet rs = pstmt.executeQuery() // SQLを実行して結果を取得
				ResultSet resultSet = pstmt.executeQuery() // SQLを実行して結果を取得
		) {

//次回ここから
	    	while (resultSet.next()) {
	    	    InquiriesBean inquiry = new InquiriesBean();
	    	    inquiry.setInquiryId(resultSet.getInt("inquiry_id"));
	    	    inquiry.setUserId(resultSet.getInt("user_id"));
	    	    inquiry.setInquiryText(resultSet.getString("inquiry_text"));
	    	    inquiry.setResponseText(resultSet.getString("response_text"));
	    	    
	    	    inquiry.setName(resultSet.getString("name"));
	    	    inquiry.setEmail(resultSet.getString("email"));
	    	    
	    	    
	    	    if (resultSet.getTimestamp("response_at") != null) {
	    	        inquiry.setResponseAt(resultSet.getTimestamp("response_at").toLocalDateTime());
	    	    }
	    	    inquiriesList.add(inquiry);
	    	}

	    }
	    return inquiriesList;
	}

}

