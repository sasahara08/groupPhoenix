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
				<form
					action="${pageContext.request.contextPath}/UpdateMemberServlet"
					method="POST">
					<table border="1">
						<tr>
							<th>名前</th>
							<td><input type="text" name="name"
								value="${sessionScope.userName}" required /></td>
						</tr>
						<tr>
							<th>かな</th>
							<td><input type="text" name="kana"
								value="${sessionScope.userKana}" /></td>
						</tr>
						<tr>
							<th>生年月日</th>
							<!-- 生年月日は変更できないようにdisabledを追加 -->
							<td><input type="date" name="birthday"
								value="${sessionScope.userBirthday}" disabled /></td>
						</tr>
						<tr>
							<th>郵便番号</th>
							<td><input type="text" name="postCode"
								value="${sessionScope.userPostCode}" /></td>
						</tr>
						<tr>
							<th>住所</th>
							<td><input type="text" name="address"
								value="${sessionScope.userAddress}" /></td>
						</tr>
						<tr>
							<th>電話番号</th>
							<td><input type="tel" name="phone"
								value="${sessionScope.userPhone}" /></td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td><input type="email" name="email"
								value="${sessionScope.userEmail}" required /></td>
						</tr>
						<tr>
							<th>性別</th>
							<!-- 性別も変更できないようにdisabledを追加 -->
							<td><input type="radio" name="gender" value="男性"
								${sessionScope.userGender == '男性' ? 'checked' : ''} disabled />
								男性 <input type="radio" name="gender" value="女性"
								${sessionScope.userGender == '女性' ? 'checked' : ''} disabled />
								女性</td>
						</tr>
						<tr>
							<th>登録日</th>
							<!-- 登録日は変更できないようにdisabledを追加 -->
							<td><input type="date" name="createdAt"
								value="${sessionScope.userCreatedAt}" disabled /></td>
						</tr>
						<tr>
							<th>最終ログイン日</th>
							<td><input type="date" name="lastLoginAt"
								value="${sessionScope.userLastLoginAt}" disabled /></td>
						</tr>
						<tr>
							<th>クレジットカード番号</th>
							<td><input type="text" name="creditCardNumber"
								value="${sessionScope.userCreditCardNumber}" /></td>
						</tr>
						<tr>
							<th>クレジットカード有効期限</th>
							<td><input type="text" name="creditCardExpiryDate"
								value="${sessionScope.userCreditCardExpiryDate}" /></td>
						</tr>
						<tr>
							<th>クレジットカードセキュリティコード</th>
							<td><input type="text" name="creditCardSecurityCode"
								value="${sessionScope.userCreditCardSecurityCode}" /></td>
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