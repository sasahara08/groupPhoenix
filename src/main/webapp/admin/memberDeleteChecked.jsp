<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報削除チェック</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
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
		<!-- 削除内容確認エリア -->
		<div class="container">
		<h3>削除会員情報の内容確認</h3>
		<br>
			<div class="label">会員ID：</div>
			<div class="data">${deleteUser.userId}</div>
			
			<div class="label">名前：</div>
			<div class="data">${deleteUser.name}</div>
			
			<div class="label">ふりがな：</div>
			<div class="data">${deleteUser.kana}</div>
			
			<div class="label">生年月日：</div>
			<div class="data">${deleteUser.birthday}</div>
			
			<div class="label">郵便番号：</div>
			<div class="data">${deleteUser.postCode}</div>
			
			<div class="label">住所：</div>
			<div class="data">${deleteUser.address}</div>
			
			<div class="label">電話番号：</div>
			<div class="data">${deleteUser.phone}</div>
			
			<div class="label">メールアドレス：</div>
			<div class="data">${deleteUser.email}</div>


			<!-- 削除ボタン -->
			<div class="btn">
			<form action="${pageContext.request.contextPath}/AdminMember" method="post" style="display: inline;">
				<button type="submit" name="sendKind" value="userDelete">削除</button>
				<input type="hidden" name="userId" value="${deleteUser.userId}">
			</form>
			&nbsp;
			<!-- 戻るボタン -->
			<form action="${pageContext.request.contextPath}/AdminMember" method="post" style="display: inline;">
				<button type="submit" name="sendKind" value="userSearch">戻る</button>
			</form>
			</div>
		</div>
	</main>
	
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />

</body>
</html>