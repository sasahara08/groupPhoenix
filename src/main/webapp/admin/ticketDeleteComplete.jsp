<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!-- 2:検索結果 -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>検索結果画面</title>
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
			<h3>チケット_リセールチケット削除完了</h3>
		</div>
		<p>
		<form action="${pageContext.request.contextPath}/AdminTicket" method="get">
			<input type="submit" value="チケット情報TOPに戻る">
		</form>
		</p>
	</main>
	<!--      フッター -->
	<footer class="footer">
		<p>© 2025 Phoenix Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>
