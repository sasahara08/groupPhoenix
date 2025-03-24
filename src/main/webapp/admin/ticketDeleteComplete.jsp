<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 4:チケット情報管理 -->
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>試合情報_編集内容確認</title>
    <link rel="stylesheet" href="../css/adminheader.css" />
    <link rel="stylesheet" href="../css/adminfooter.css" />
    <link rel="stylesheet" href="../css/admin-ticketDeleteComplete.css" />
  </head>
  <body>
    <!-- ページタイトル -->
    <h1>管理画面</h1>
    <p>3.チケット情報管理</p>

    <!-- タイトル -->
    <h2>チケット情報_編集内容確認</h2>
    <!-- 中身 -->
    <main>
        <form action="★TOP" method="post"></form>
        <div class="wrapper">
        <!-- 編集後 -->
        <div class="left">
      <table>
        <!-- 購入ステータス -->
         <tr>
            <th></th><th>【編集後】</th>
         </tr>
        <tr>
          <th>購入ステータス</th>
          <td>★リセール出品</td>
        </tr>
      </table>

      <!-- 購入者情報 -->
      <h3>〇購入者情報</h3>
      <table>
        <tr class="glay">
          <th>チケットID</th>
          <td>10</td>
        </tr>
        <tr>
          <th>チケット購入日</th>
          <td>★</td>
        </tr>
        <tr>
          <th>会員ID</th>
          <td>★</td>
        </tr>
        <tr class="glay">
          <th>名前</th>
          <td>★</td>
        </tr>
        <tr class="glay">
          <th>ふりがな</th>
          <td>★</td>
        </tr>
      </table>

      <!-- リセール購入者情報 -->
      <h3>〇リセール購入者情報</h3>
      <table>
        <tr class="glay">
          <th>チケットID</th>
          <td></td>
        </tr>
        <tr>
          <th>チケット購入日</th>
          <td></td>
        </tr>
        <tr>
          <th>会員ID</th>
          <td></td>
        </tr>
        <tr class="glay">
          <th>名前</th>
          <td></td>
        </tr>
        <tr class="glay">
          <th>ふりがな</th>
          <td></td>
        </tr>
      </table>

      <!-- 試合情報 -->
      <h3>〇試合情報</h3>
      <table>
        <tr class="glay">
          <th>試合ID</th>
          <td>1</td>
        </tr>
        <tr class="glay">
          <th>試合日</th>
          <td>2025/4/1</td>
        </tr>
        <tr class="glay">
          <th>開始時間</th>
          <td>18:00</td>
        </tr>
        <tr class="glay">
          <th>チーム(ホーム)</th>
          <td>フェニックス</td>
        </tr>
        <tr class="glay">
          <th>チーム(アウェイ)</th>
          <td>ロッチ</td>
        </tr>
        <tr class="glay">
          <th>開催場所</th>
          <td>PayPayスタジアム</td>
        </tr>
      </table>
      <br />
    </div>

    <!-- 編集前 -->
             <div class="right">
                <table>
                  <!-- 購入ステータス -->
                   <tr>
                      <th></th><th>【編集前】</th>
                    </tr>
                    <tr>
                      <th>購入ステータス</th>
                      <td>★リセール出品</td>
                    </tr>
                  </table>
            
                  <!-- 購入者情報 -->
                  <h3>〇購入者情報</h3>
                  <table>
                    <tr class="glay">
                      <th>チケットID</th>
                      <td>10</td>
                    </tr>
                    <tr>
                      <th>チケット購入日</th>
                      <td>★</td>
                    </tr>
                    <tr>
                      <th>会員ID</th>
                      <td>★</td>
                    </tr>
                    <tr class="glay">
                      <th>名前</th>
                      <td>★</td>
                    </tr>
                    <tr class="glay">
                      <th>ふりがな</th>
                      <td>★</td>
                    </tr>
                  </table>
            
                  <!-- リセール購入者情報 -->
                  <h3>〇リセール購入者情報</h3>
                  <table>
                    <tr class="glay">
                      <th>チケットID</th>
                      <td></td>
                    </tr>
                    <tr>
                      <th>チケット購入日</th>
                      <td></td>
                    </tr>
                    <tr>
                      <th>会員ID</th>
                      <td></td>
                    </tr>
                    <tr class="glay">
                      <th>名前</th>
                      <td></td>
                    </tr>
                    <tr class="glay">
                      <th>ふりがな</th>
                      <td></td>
                    </tr>
                  </table>
            
                  <!-- 試合情報 -->
                  <h3>〇試合情報</h3>
                  <table>
                    <tr class="glay">
                      <th>試合ID</th>
                      <td>1</td>
                    </tr>
                    <tr class="glay">
                      <th>試合日</th>
                      <td>2025/4/1</td>
                    </tr>
                    <tr class="glay">
                      <th>開始時間</th>
                      <td>18:00</td>
                    </tr>
                    <tr class="glay">
                      <th>チーム(ホーム)</th>
                      <td>フェニックス</td>
                    </tr>
                    <tr class="glay">
                      <th>チーム(アウェイ)</th>
                      <td>ロッチ</td>
                    </tr>
                    <tr class="glay">
                      <th>開催場所</th>
                      <td>PayPayスタジアム</td>
                    </tr>
                  </table>
                  <br />
                </div>
            </div>
      <!-- 確認・リセット -->
       <div>
      <input type="submit" value="登録" />
      <button onclick="location.href='..admin/ticketDeleteChecked.jsp'">修正</button>
    </div>
      </form>
    </main>
  </body>
</html>
  