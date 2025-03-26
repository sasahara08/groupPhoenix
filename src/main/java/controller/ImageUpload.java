package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DBManager;

public class ImageUpload {
    public static void main(String[] args) {
        // 画像ファイルのパス（プロジェクト内のsrc/main/webapp/imagesフォルダ）
        String[] imageFiles = {
            "src/main/webapp/images/1_tanaka.png", "src/main/webapp/images/2_yamada.png", "src/main/webapp/images/3_suzuki.png",
            "src/main/webapp/images/4_satou.png", "src/main/webapp/images/5_takahashi.png", "src/main/webapp/images/6_watanabe.png",
            "src/main/webapp/images/7_kobayashi.png", "src/main/webapp/images/8_nakamura.png", "src/main/webapp/images/9_kato.png",
            "src/main/webapp/images/10_ito.png", "src/main/webapp/images/11_ishikawa.png", "src/main/webapp/images/12_shimizu.png",
            "src/main/webapp/images/13_motsumoto.png", "src/main/webapp/images/14_ishii.png", "src/main/webapp/images/15_ueda.png",
            "src/main/webapp/images/16_mike.png"
        };

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // DBManagerからコネクションを取得
            conn = DBManager.getConnection();

            // SQLクエリの準備（1つのSQLクエリを使いまわす）
            String sql = "INSERT INTO player_images (image_name, image_data) VALUES (?, ?)";

            // 画像ファイルをループしてアップロード
            for (String imageFile : imageFiles) {
                File file = new File(imageFile);
                if (!file.exists()) {
                    System.out.println("ファイルが見つかりません: " + imageFile);
                    continue;
                }

                // 画像ファイルをInputStreamとして開く
                FileInputStream fis = new FileInputStream(file);

                // PreparedStatementを作成
                pstmt = conn.prepareStatement(sql);

                // 画像の名前をセット
                pstmt.setString(1, file.getName());

                // 画像のバイナリデータをセット
                pstmt.setBinaryStream(2, fis, (int) file.length());  // (int) file.length() は長さを指定

                // SQLを実行
                pstmt.executeUpdate();

                // ストリームを閉じる
                fis.close();

                System.out.println("画像 " + file.getName() + " をアップロードしました。");
            }
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // リソースを確実に閉じる
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
