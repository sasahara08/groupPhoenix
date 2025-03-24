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
    <!--     ヘッダー  -->
	<header>
		<h1><a href="#" class="logo">Phoenix管理画面</a></h1>
<!--		未ログイン時は「ログイン」、ログイン時は「ログアウト」-->
		<button type="logout" class="logout-button">ログアウト</button>
	</header>
	<br>
    <!-- ページタイトル -->
    <div class="title">
    <h1>管理画面</h1>
    <p class="sub">3.チケット情報管理</p>
	</div>
    <!-- タイトル -->
    <h2>チケット情報_編集</h2>
    <!-- 中身 -->
    <main class="main">
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
            <td class="none">変更前 ※★（ここに変更前の値を代入）</td>
        </tr>
      </table>

      <!-- 購入者情報 -->
      <h3>購入者情報</h3>
      <table>
        <tr>
          <th>チケットID</th>
          <td class="glay">10</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>チケット購入日</th>
          <td><input type="date" name="★"></td>
          <td class="none">変更前 ※★（ここに変更前の値を代入）</td>
        </tr>
        <tr>
          <th>会員ID</th>
          <td><input type="number" name="★" value="123"></td>
        </tr>
        <tr>
          <th>名前</th>
          <td class="glay">田中太郎</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>ふりがな</th>
          <td class="glay">たなかたろう</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
      </table>

      <!-- リセール購入者情報 -->
      <h3>リセール購入者情報</h3>
      <table>
        <tr>
          <th>チケットID</th>
          <td class="glay">20</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>チケット購入日</th>
          <td><input type="date" name="★"></td>
          <td class="none">変更前 ※★（ここに変更前の値を代入）</td>
        </tr>
        <tr>
          <th>会員ID</th>
          <td><input type="number" name="★" value="456"></td>
        </tr>
        <tr>
          <th>名前</th>
          <td class="glay">鈴木園子</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>ふりがな</th>
          <td class="glay">すずきそのこ</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
      </table>

      <!-- 試合情報 -->
      <h3>試合情報</h3>
      <div class="left">
      <table>
        <tr>
          <th>試合ID</th>
          <td class="glay">1</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>試合日</th>
          <td class="glay">2025/4/1</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>開始時間</th>
          <td class="glay">18:00</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>チーム(ホーム)</th>
          <td class="glay">フェニックス</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>チーム(アウェイ)</th>
          <td class="glay">ロッチ</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
        <tr>
          <th>開催場所</th>
          <td class="glay">PayPayスタジアム</td><!--変更不可-->
          <td class="none">変更不可</td>
        </tr>
      </table>
      </div>
      <br />
      <!-- 確認・リセット -->
       <div>
      <input type="submit" value="確認" />
      <input type="reset" value="リセット" />
    </div>
      </form>
      <br>
      <!-- 戻る -->
      <button onclick="location.href='..admin/ticketSearch.jsp'">戻る</button>
    </main>
    <br>
    <!--      フッター -->
	<footer class="footer">
		<p>© 2025 Phoenix Inc. All Rights Reserved.</p>
	</footer>
  </body>
</html>