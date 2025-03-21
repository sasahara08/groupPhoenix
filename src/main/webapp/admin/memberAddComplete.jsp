<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報追加完了</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminmember.css" />
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
		<div class="addcompletearea">
			<h3>会員情報登録完了</h3>
			<p>
			<form action="${pageContext.request.contextPath}/AdminMember" method="post">
				<button type="submit" name="sendKind" value="userReset">会員情報TOPに戻る</button>
			</form>
			</p>
	</main>
	<!-- フッターを挿入 -->


</body>
</html>