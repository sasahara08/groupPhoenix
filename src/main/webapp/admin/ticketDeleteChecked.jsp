<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 3:チケット情報_編集 -->
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>チケット情報_編集</title>
    <link rel="stylesheet" href="../css/adminheader.css" />
    <link rel="stylesheet" href="../css/adminfooter.css" />
    <link rel="stylesheet" href="../css/admin-ticketDeleteChecked.css" />
  </head>
    <body>
    <!-- ページタイトル -->
    <h1>管理画面</h1>
    <p>3.チケット情報管理</p>

    <!-- タイトル -->
    <h2>チケット情報_編集</h2>
    <!-- 中身 -->
    <main>
        <form action="../admin/ticketDeleteComplete.jsp" method="post"></form>
      <table>
        <!-- 購入ステータス -->
        <tr>
          <th>購入ステータス</th>
          <td>
            <input type="search" name="purchase-status" list="purchase-status-data" />
            <datalist id="purchase-status-data">
              <option value="未購入"></option>
      
              <option value="購入"></option>
      
              <option value="リセール出品"></option>
            </datalist></td>
            <td>変更前 ※★（ここに変更前の値を代入）</td>
        </tr>
      </table>

      <!-- 購入者情報 -->
      <h3>購入者情報</h3>
      <table>
        <tr>
          <th>チケットID</th>
          <td>10</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>チケット購入日</th>
          <td><input type="date" name="★"></td>
          <td>変更前 ※★（ここに変更前の値を代入）</td>
        </tr>
        <tr>
          <th>会員ID</th>
          <td><input type="number" name="★" value="123"></td>
        </tr>
        <tr>
          <th>名前</th>
          <td>田中太郎</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>ふりがな</th>
          <td>たなかたろう</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
      </table>

      <!-- リセール購入者情報 -->
      <h3>リセール購入者情報</h3>
      <table>
        <tr>
          <th>チケットID</th>
          <td>20</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>チケット購入日</th>
          <td><input type="date" name="★"></td>
          <td>変更前 ※★（ここに変更前の値を代入）</td>
        </tr>
        <tr>
          <th>会員ID</th>
          <td><input type="number" name="★" value="456"></td>
        </tr>
        <tr>
          <th>名前</th>
          <td>鈴木園子</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>ふりがな</th>
          <td>すずきそのこ</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
      </table>

      <!-- 試合情報 -->
      <h3>試合情報</h3>
      <table>
        <tr>
          <th>試合ID</th>
          <td>1</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>試合日</th>
          <td>2025/4/1</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>開始時間</th>
          <td>18:00</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>チーム(ホーム)</th>
          <td>フェニックス</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>チーム(アウェイ)</th>
          <td>ロッチ</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
        <tr>
          <th>開催場所</th>
          <td>PayPayスタジアム</td><!--変更不可-->
          <td>変更不可</td>
        </tr>
      </table>
      <br />
      <!-- 確認・リセット -->
       <div>
      <input type="submit" value="確認" />
      <input type="reset" value="リセット" />
    </div>
      </form>
      <!-- 戻る -->
      <button onclick="location.href='..admin/ticketSearch.jsp'">戻る</button>
    </main>
  </body>
</html>