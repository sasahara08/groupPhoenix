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
		<!-- 検索結果一覧エリア -->
		<div class="deletecheckarea">
			<h3>削除会員情報の内容確認</h3>

			<p>名前: ${sessionScope.newUser.name}</p>
			<p>ふりがな: ${sessionScope.newUser.kana}</p>
			<p>生年月日: ${sessionScope.newUser.birthday}</p>
			<p>郵便番号: ${sessionScope.newUser.postCode}</p>
			<p>住所: ${sessionScope.newUser.address}</p>
			<p>電話番号: ${sessionScope.newUser.phone}</p>
			<p>メールアドレス: ${sessionScope.newUser.email}</p>
			<!--				<p>性別: ${sessionScope.newUser.gender}</p>-->
			<!--				<p>パスワード: ${sessionScope.newUser.pass}</p>-->


			<!-- 削除ボタン -->
			<form action="AdminMember" method="post" style="display: inline;">
				<button type="submit" name="sendKind" value="userDelete">削除</button>
				<input type="hidden" name="userId" value="${user.userId}">
			</form>
			<!-- 戻るボタン -->
			<form action="AdminMember" method="get" style="display: inline;">
				<button type="submit" name="sendKind" value="userSearchTop">戻る</button>
				<input type="hidden" name="userId" value="${user.userId}">
			</form>
	</main>
	<!-- フッターを挿入 -->


</body>
</html>