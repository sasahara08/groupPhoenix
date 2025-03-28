<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員情報変更</title>
<link rel="stylesheet" href="javascript:void(0)">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css"
	media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/memberEditor.css" />

</head>
<body>
	<jsp:include page="/inc/memberHeader.jsp" />
	<main>
		<div class="enclose1">
			<h1>会員情報変更 入力画面</h1>
			<table>
				<form action="memberEditorConfirmation.jsp" method="post">
					<!-- hiddenフィールドでuser_idを送信 -->
					<input type="hidden" name="user_id" value="${user.userId}">

					<tr>
						<th><label for="name">氏名：</label></th>
						<td><input type="text" id="name" name="name"
							value="${user.name}" ></td>
					</tr>
					<tr>
						<th><label for="kana">ふりがな：</label></th>
						<td><input type="text" id="kana" name="kana"
							value="${user.kana}"></td>
					</tr>
					<tr>
						<th><label for="postcode">郵便番号 (ハイフンなし7桁)：</label></th>
						<td><input type="text" id="postcode" name="postcode"
							value="${user.post_code}"></td>
					</tr>
					<tr>
						<th><label for="address">住所：</label></th>
						<td><input type="text" id="address" name="address"
							value="${user.address}"></td>
					</tr>
					<tr>
						<th><label for="phone">電話番号：</label>
						</th>
						<td><input type="tel" id="phone" name="phone"
							value="${user.phone}"></td>
					</tr>
					<tr>
						<th><label for="email">メールアドレス：</label></th>
						<td><input type="email" id="email" name="email"
							value="${user.email}"></td>
					</tr>
					<tr>
						<th><label for="password">パスワード：</label></th>
						<td><input type="password" id="password" name="password"
							value="${user.pass}"></td>
					</tr>
					<tr>
						<th><label for="creditcard">クレジットカード番号：</label></th>
						<td><input type="text" id="creditcard" name="creditcard"
							value="${user.creditcard}"></td>
					</tr>
					<tr>
						<th><label for="expiry">クレジットカード使用期限：</label></th>
						<td><input type="text" id="expiry" name="expiry"
							value="${user.expiry}"></td>
					</tr>
					<tr>
						<th><label for="securitycode">セキュリティコード：</label></th>
						<td><input type="text" id="securitycode" name="securitycode"
							value="${user.securitycode}"></td>
					</tr>
			</table>
			<div class="under-button">
			<!-- 確認ボタン -->
			<button type="submit" class="button2">確認</button>
			</form>
			<!-- 戻るボタン -->
			<form action="myPage.jsp" method="get">
				<button type="submit" class="button2">戻る</button>
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="/inc/footer.jsp" />
</html>
