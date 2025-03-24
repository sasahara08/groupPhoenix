<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 2:検索結果 -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>検索結果画面</title>
<link rel="stylesheet" href="../css/adminheader.css" />
<link rel="stylesheet" href="../css/adminfooter.css" />
<link rel="stylesheet" href="../css/admin-ticket-search.css" />
</head>
<body>
	<!--     ヘッダー  -->
	<header>
		<h1>
			<a href="#" class="logo">Phoenix管理画面</a>
		</h1>
		<!--		未ログイン時は「ログイン」、ログイン時は「ログアウト」-->
		<button type="logout" class="logout-button">ログアウト</button>
	</header>
	<!-- ページタイトル -->
			<div class="main-title">
			<h1>管理画面</h1>
			<p class="sub">3.チケット情報管理</p>
		</div>
	<main>
			<!-- タイトル -->
			<div class="title">
			<br>
				<h3>検索結果</h3>
				<p>検索結果を表示する</p>
			</div>
			<!-- 検索結果の表示 -->
			<table>
				<!-- タイトル -->
				<tr class="blue">
					<th>試合ID</th>
					<th>試合日</th>
					<th>時間</th>
					<th>チーム(ホーム)</th>
					<th>チーム(アウェイ)</th>
					<th>場所</th>
					<th>その他</th>
					<th>操作</th>
				</tr>
				<!-- 1行目 -->
				<tr>
					<td>1</td>
					<td>##</td>
					<td>##</td>
					<td>フェニックス</td>
					<td>ロッチ</td>
					<td>paypayドーム</td>
					<td></td>
					<td rowspan="5" class="green"><a class="green-button" href="../admin/ticketDeleteChecked.jsp">編集</a></td>
				</tr>
				<!-- 2行目 -->
				<tr class="orange">
					<th>通常</th>
					<th>チケットID</th>
					<th>チケット購入日</th>
					<th>会員ID</th>
					<th>名前</th>
					<th>ふりがな</th>
					<th>チケットステータス</th>
				</tr>
				<!-- 3行目 -->
				<tr>
					<td>★</td>
					<td>10</td>
					<td>##</td>
					<td>123</td>
					<td>田中太郎</td>
					<td>たなかたろう</td>
					<td>リセール出品</td>
				</tr>
				<!-- 4行目 -->
				<tr class="pink">
					<th>リセール</th>
					<th>チケットID</th>
					<th>チケット購入日</th>
					<th>会員ID</th>
					<th>名前</th>
					<th>ふりがな</th>
					<th></th>
				</tr>
				<!-- 5行目 -->
				<tr>
					<td>★</td>
					<td>20</td>
					<td>##</td>
					<td>456</td>
					<td>鈴木園子</td>
					<td>すずきそのこ</td>
					<td></td>
				</tr>
			</table>
			<br>
	</main>
	<!--      フッター -->
	<footer class="footer">
		<p>© 2025 Phoenix Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>

<!-- forEachを使用してリストのデータを全て表示
    <c:forEach var="ticket" items="${ticketList}">
        <tr>
            <td>${ticket.id}</td>
            <td>${ticket.name}</td>
            <td>${ticket.gameDate}</td>
            <td>${ticket.status}</td>
        </tr>
    </c:forEach> -->
