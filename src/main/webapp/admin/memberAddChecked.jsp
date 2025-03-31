<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報追加チェック</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminMember.css" />
</head>
<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />

	<!-- ページタイトル -->
	<div class="title">
		<h2>
			管理画面<span class="subtitle">1.会員情報</span>
		</h2>
	</div>
	<main>
		<!-- 検索結果一覧エリア -->
		<div class="container">
		<h3>追加会員情報の内容確認</h3>
		<br>
			<div class="label">名前：</div>
			<div class="data">${user.name}</div>
			
			<div class="label">ふりがな：</div>
			<div class="data">${user.kana}</div>
			
			<div class="label">生年月日：</div>
			<div class="data">${user.birthday}</div>
			
			<div class="label">郵便番号：</div>
			<div class="data">${user.postCode}</div>
			
			<div class="label">住所：</div>
			<div class="data">${user.address}</div>
			
			<div class="label">電話番号：</div>
			<div class="data">${user.phone}</div>
			
			<div class="label">メールアドレス：</div>
			<div class="data">${user.email}</div>
			
			<!--<p>性別: ${user.gender}</p>-->
			
			<div class="label">パスワード：</div>
			<div class="data">${user.pass}</div>


			<!-- データ送信用のフォーム -->
			<div class="btn">
			<form action="${pageContext.request.contextPath}/AdminMember" method="post">
				<input type="hidden" name="name" value="${user.name}"> 
				<input type="hidden" name="kana" value="${user.kana}">
				<input type="hidden" name="birthday" value="${user.birthday}"> 
				<input type="hidden" name="postcode" value="${user.postCode}"> 
				<input type="hidden" name="address" value="${user.address}"> 
				<input type="hidden" name="phone" value="${user.phone}"> 
				<input type="hidden" name="email" value="${user.email}">
				<!--<input type="hidden" name="gender" value="${user.gender}">-->
				<input type="hidden" name="pass" value="${user.pass}">
				<button type="submit" name="sendKind" value="userAddConfirm">確定</button>
			</form>
			&nbsp;
			<form action="${pageContext.request.contextPath}/AdminMember" method="get">
				<button type="submit" name="sendKind" value="userSearch">戻る</button>
			</form>
			</div>
			<!--			<form action="${pageContext.request.contextPath}/AdminMember" method="get">-->
			<!--				<input type="submit" value="会員情報TOPに戻る">-->
			<!--			</form>-->
			
		</div>
	</main>
	
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />

</body>
</html>
		