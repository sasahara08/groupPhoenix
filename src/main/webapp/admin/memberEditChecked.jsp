<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報編集内容チェック</title>
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
		<!-- 編集内容チェックエリア -->
		<div class="searchresultsarea">
			<h3>会員情報編集_内容確認</h3>
			<div class="afterEditUser">
				<h4>編集後</h4>
				<p>会員ID: ${editUser.userId}</p>
				<p>名前: ${editUser.name}</p>
				<p>ふりがな: ${editUser.kana}</p>
				<p>生年月日: ${editUser.birthday}</p>
				<p>郵便番号: ${editUser.postCode}</p>
				<p>住所: ${editUser.address}</p>
				<p>電話番号: ${editUser.phone}</p>
				<p>メールアドレス: ${editUser.email}</p>
				<!--				<p>性別: ${editUser.gender}</p>-->
				<p>パスワード: ${editUser.pass}</p>
			</div>

			<div class="buttonArea">
				<!-- データ送信用のフォーム -->
				<form action="${pageContext.request.contextPath}/AdminMember" method="post">
					<input type="hidden" name="userId" value="${editUser.userId}"> <input type="hidden" name="name"
						value="${editUser.name}"> <input type="hidden" name="kana" value="${editUser.kana}"> <input
						type="hidden" name="birthday" value="${editUser.birthday}"> <input type="hidden" name="postcode"
						value="${editUser.postCode}"> <input type="hidden" name="address" value="${editUser.address}"> <input
						type="hidden" name="phone" value="${editUser.phone}"> <input type="hidden" name="email"
						value="${editUser.email}">
					<!--			<input type="hidden" name="gender" value="${editUser.gender}">-->
					<input type="hidden" name="pass" value="${editUser.pass}">
					<button type="submit" name="sendKind" value="userEditConfirm">確定</button>
				</form>
				<form action="${pageContext.request.contextPath}/AdminMember" method="get" style="display: inline;">
					<button type="submit" name="sendKind" value="userEdit">修正</button>
					<input type="hidden" name="userId" value="${editUser.userId}">
				</form>
			</div>
	</main>
	<!-- フッターを挿入 -->


</body>
</html>
