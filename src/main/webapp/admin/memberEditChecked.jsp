<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報編集内容チェック</title>
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
		<!-- 編集内容チェックエリア -->
		<div class="container">
		<h3>会員情報編集&nbsp;内容確認</h3>
		<h4>編集後</h4>
		<br>
			<div class="label">会員ID：</div>
			<div class="data">${editUser.userId}</div>
			
			<div class="label">名前：</div>
			<div class="data">${editUser.name}</div>
			
			<div class="label">ふりがな：</div>
			<div class="data">${editUser.kana}</div>
			
			<div class="label">生年月日：</div>
			<div class="data">${editUser.birthday}</div>
			
			<div class="label">郵便番号：</div>
			<div class="data">${editUser.postCode}</div>
			
			<div class="label">住所：</div>
			<div class="data">${editUser.address}</div>
			
			<div class="label">電話番号：</div>
			<div class="data">${editUser.phone}</div>
			
			<div class="label">メールアドレス：</div>
			<div class="data">${editUser.email}</div>
			
			<!--<p>性別: ${editUser.gender}</p>-->
			
			<div class="label">パスワード：</div>
			<div class="data">${editUser.pass}</div>
		

			<div class="btn">
				<!-- データ送信用のフォーム -->
				<form action="${pageContext.request.contextPath}/AdminMember" method="post">
					<input type="hidden" name="userId" value="${editUser.userId}">
					<input type="hidden" name="name"
						value="${editUser.name}"> 
						<input type="hidden" name="kana" value="${editUser.kana}"> 
						<input type="hidden" name="birthday" value="${editUser.birthday}"> 
						<input type="hidden" name="postcode" value="${editUser.postCode}"> <input type="hidden" name="address" value="${editUser.address}"> 
						<input type="hidden" name="phone" value="${editUser.phone}"> 
						<input type="hidden" name="email" value="${editUser.email}">
					<!--<input type="hidden" name="gender" value="${editUser.gender}">-->
						<input type="hidden" name="pass" value="${editUser.pass}">
					<button type="submit" name="sendKind" value="userEditConfirm">確定</button>
				</form>
				&nbsp;
				<form action="${pageContext.request.contextPath}/AdminMember" method="get" style="display: inline;">
					<button type="submit" name="sendKind" value="userEdit">修正</button>
						<input type="hidden" name="userId" value="${editUser.userId}">
				</form>
			</div>
		</div>
			
	</main>
	
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />

</body>
</html>