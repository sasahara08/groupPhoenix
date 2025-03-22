<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 1:チケット情報一覧 -->
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>チケット情報一覧</title>
    <link rel="stylesheet" href="../css/adminheader.css" />
    <link rel="stylesheet" href="../css/adminfooter.css" />
    <link rel="stylesheet" href="../css/admin-ticket.css" />
  </head>
  <body>
  
<!--     ヘッダー  -->
	<header>
		<h1><a href="#" class="logo">Phoenix管理画面</a></h1>
<!--		未ログイン時は「ログイン」、ログイン時は「ログアウト」-->
		<button type="logout" class="logout-button">ログアウト</button>
	</header>
    <!-- タイトル -->
    <main>
    <div class="title">
    <h1>管理画面</h1>
    <p class="sub">3.チケット情報管理</p>
  </div>
    <!-- チケット検索 -->
     <div class="main">
    <h3>【チケット検索】</h3>
    <!-- ★フォームタグ -->
    <form method="post" action="/adminTicket">
    <table>
      <tr>
        <th>購入ステータス</th><td>
          <input type="search" name="purchase-status" list="purchase-status-data" />
          <datalist id="purchase-status-data">
            <option value="未購入"></option>
    
            <option value="購入"></option>
    
            <option value="リセール出品"></option>
          </datalist>
        </td>
      </tr>
    </table>
    <!-- 購入者情報 -->
    <h4>〇購入者情報</h4>
    <table>
      <tr>
        <th>チケットID</th><td><input type="number" placeholder="チケットID" name="ticket-id"></td>
    </tr>
        <th>チケット購入日</th><td><input type="date" name="ticket-purchase-date"></td>
    </tr>
        <th>会員ID</th><td><input type="number" placeholder="会員ID" name="member-id"></td>
    </tr>
        <th>名前</th><td><input type="text" placeholder="山田 太郎" name="name"></td>
    </tr>
        <th>ふりがな</th><td><input type="text" placeholder="やまだ たろう" name="kana"></td>
      </tr>
    </table>
    <!-- リセール購入者情報 -->
    <h4>〇リセール購入者情報</h4>
    <table>
        <tr>
          <th>チケットID</th><td><input type="number" placeholder="チケットID" name="resale-ticket-id"></td>
      </tr>
          <th>チケット購入日</th><td><input type="date" name="resale-ticket-purchase-date"></td>
      </tr>
          <th>会員ID</th><td><input type="number" placeholder="会員ID" name="resale-member-id"></td>
      </tr>
          <th>名前</th><td><input type="text" placeholder="山田 太郎" name="resale-name"></td>
      </tr>
          <th>ふりがな</th><td><input type="text" placeholder="やまだ たろう" name="resale-kana"></td>
        </tr>
      </table>
    <!-- 試合情報 -->
    <h4>〇試合情報</h4>
    <table>
        <tr>
          <th>試合ID</th><td><input type="number" placeholder="チケットID" name="game-id"></td>
      </tr>
      <tr>
          <th>試合日</th><td><input type="date" name="game-date"></td>
      </tr>
      <tr>
          <th>チーム(ホーム)</th><td>
            <input type="search" name="team-home" list="team-home-data" />
            <datalist id="team-home-data">
              <option value="☆"></option>
      
              <option value="☆"></option>
      
              <option value="☆"></option>
            </datalist></td>
      </tr>
      <tr>
          <th>チーム(アウェイ)</th><td>
            <input type="search" name="team-away" list="team-away-data" />
            <datalist id="team-away-data">
              <option value="☆"></option>
      
              <option value="☆"></option>
      
              <option value="☆"></option>
            </datalist>
          </td>
      </tr>
      <tr>
          <th>開催場所</th><td>
            <input type="search" name="place" list="place-data" />
            <datalist id="place-data">
              <option value="☆"></option>
      
              <option value="☆"></option>
      
              <option value="☆"></option>
            </datalist></td>
        </tr>
        <tr>
            <th>試合ステータス</th><td>
              <input type="search" name="game-status" list="game-status-data" />
              <datalist id="game-status-data">
                <option value="今後開催"></option>
        
                <option value="終了"></option>
        
                <option value="すべて"></option>
              </datalist></td>
          </tr>
      </table>
          <!-- 検索・リセットボタン -->
           <div>
            <input type="submit" value="検索">
            <input type="reset" value="リセット">
           </div>
    </form>
  </div>
  </main>
<!--      フッター -->
	<footer class="footer">
		<p>© 2025 Phoenix Inc. All Rights Reserved.</p>
	</footer>
  </body>
</html>
