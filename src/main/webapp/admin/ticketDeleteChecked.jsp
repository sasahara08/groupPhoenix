<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!-- 2:検索結果 -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>検索結果画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-ticket-search.css" />
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
			<h3>チケット_リセールチケット削除確認</h3>
		</div>
		<!-- 削除データの表示 -->
		<table>
			<!-- タイトル -->
			<tr class="blue">
				<th>試合ID</th>
				<th>試合日</th>
				<th>開始時間</th>
				<th>チーム(ホーム)</th>
				<th>チーム(アウェイ)</th>
				<th>場所</th>
			</tr>
			<!-- 1行目 -->
			<tr>
				<td>${deleteResaleTicket.gameId}</td>
				<td>${deleteResaleTicket.gameDate}</td>
				<td>${deleteResaleTicket.startTime}</td>
				<td>${deleteResaleTicket.homeTeamName}</td>
				<td>${deleteResaleTicket.awayTeamName}</td>
				<td>${deleteResaleTicket.stadium}</td>
			</tr>
			<!-- 2行目 -->
			<tr class="orange">
				<th>チケットID</th>
				<th>チケット購入日</th>
				<th>会員ID</th>
				<th>名前</th>
				<th>ふりがな</th>
				<th>チケットステータス</th>
			</tr>
			<!-- 3行目 -->
			<tr>
				<td>${deleteResaleTicket.ticketId}</td>
				<td>${deleteResaleTicket.createAt}</td>
				<td>${deleteResaleTicket.userId}</td>
				<td>${deleteResaleTicket.name}</td>
				<td>${deleteResaleTicket.kana}</td>
				<td>${deleteResaleTicket.ticketStatus}</td>
			</tr>
		</table>

		<!-- 削除ボタン -->
		<form action="${pageContext.request.contextPath}/AdminTicket" method="post" style="display: inline;">
			<button type="submit" name="sendKind" value="resaleTicketDelete">削除</button>
			<input type="hidden" name="ticketId" value="${deleteResaleTicket.ticketId}">
			<input type="hidden" name="orderDetailId" value="${deleteResaleTicket.orderDetailId}">
		</form>
		<!-- 戻るボタン -->
		<form action="${pageContext.request.contextPath}/AdminTicket" method="get" style="display: inline;">
			<button type="submit">戻る</button>
			
		</form>
	</main>
	<!--      フッター -->
	<footer class="footer">
		<p>© 2025 Phoenix Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>
