<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報編集完了</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminMember.css" />
<link rel="stylesheet" href="javascript:void(0)">
</head>
<body>
	<!-- ヘッダーを挿入 -->

	<!-- ページタイトル -->
	<div class="title">
		<h2>
			管理画面<span class="subtitle">1.会員情報</span>
		</h2>
	</div>
	<main>
		<!-- 会員情報登録完了エリア -->
		<div class="container">
			<h3>会員情報&nbsp;内容編集完了</h3>
			
			<div class="btn">
			<form action="${pageContext.request.contextPath}/AdminMember" method="get">
				<input type="submit" value="会員情報TOPに戻る">
			</form>
			</div>
		</div>
	</main>
	<!-- フッターを挿入 -->


</body>
</html>