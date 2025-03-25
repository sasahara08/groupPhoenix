<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報追加チェック</title>
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
		<div class="searchresultsarea">
			<h3>追加会員情報の内容確認</h3>

			<p>名前: ${user.name}</p>
			<p>ふりがな: ${user.kana}</p>
			<p>生年月日: ${user.birthday}</p>
			<p>郵便番号: ${user.postCode}</p>
			<p>住所: ${user.address}</p>
			<p>電話番号: ${user.phone}</p>
			<p>メールアドレス: ${user.email}</p>
			<!--				<p>性別: ${user.gender}</p>-->
			<p>パスワード: ${user.pass}</p>

			<!-- データ送信用のフォーム -->
			<form action="${pageContext.request.contextPath}/AdminMember" method="post">
				<input type="hidden" name="name" value="${user.name}"> <input type="hidden" name="kana" value="${user.kana}">
				<input type="hidden" name="birthday" value="${user.birthday}"> <input type="hidden" name="postcode"
					value="${user.postCode}"> <input type="hidden" name="address" value="${user.address}"> <input
					type="hidden" name="phone" value="${user.phone}"> <input type="hidden" name="email" value="${user.email}">
				<!--					<input type="hidden" name="gender" value="${user.gender}">-->
				<input type="hidden" name="pass" value="${user.pass}">
				<button type="submit" name="sendKind" value="userAddConfirm">確定</button>
			</form>
			<form action="${pageContext.request.contextPath}/AdminMember" method="get">
				<input type="submit" value="戻る">
			</form>
			<!--			<form action="${pageContext.request.contextPath}/AdminMember" method="get">-->
			<!--				<input type="submit" value="会員情報TOPに戻る">-->
			<!--			</form>-->
	</main>
	<!-- フッターを挿入 -->


</body>
</html>
