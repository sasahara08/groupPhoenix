<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報削除チェック</title>
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
		<!-- 削除内容確認エリア -->
		<div class="deletecheckarea">
			<h3>削除会員情報の内容確認</h3>
			<p>会員ID: ${deleteUser.userId}</p>
			<p>名前: ${deleteUser.name}</p>
			<p>ふりがな: ${deleteUser.kana}</p>
			<p>生年月日: ${deleteUser.birthday}</p>
			<p>郵便番号: ${deleteUser.postCode}</p>
			<p>住所: ${deleteUser.address}</p>
			<p>電話番号: ${deleteUser.phone}</p>
			<p>メールアドレス: ${deleteUser.email}</p>


			<!-- 削除ボタン -->
			<form action="${pageContext.request.contextPath}/AdminMember" method="post" style="display: inline;">
				<button type="submit" name="sendKind" value="userDelete">削除</button>
				<input type="hidden" name="userId" value="${deleteUser.userId}">
			</form>
			<!-- 戻るボタン -->
			<form action="${pageContext.request.contextPath}/AdminMember" method="post" style="display: inline;">
				<button type="submit" name="sendKind" value="userSearch">戻る</button>
			</form>
	</main>
	<!-- フッターを挿入 -->


</body>
</html>
