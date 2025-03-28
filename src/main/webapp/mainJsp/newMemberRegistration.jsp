
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新規会員登録画面</title>
<link rel="stylesheet" href="javascript:void(0)">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css"
	media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newMemberRegistration.css" />
</head>
<body>
	<jsp:include page="/inc/header.jsp" />
	<main>
		<h1>新規会員登録 入力</h1>

		<div class=enclose1>
			<table>
				<!-- 	<form action="${pageContext.request.contextPath}/nonMemberNewRegistration.jsp" method="post" onsubmit="return validateForm();">-->
				<form action="confirmationMemberRegistrationDetails.jsp"
					method="post" onsubmit="return validateForm();">
					<tr>
						<th><label for="name">氏名：</label></th>
						<td><input type="text" id="name" name="name" required></td>
					</tr>
				<tr>
					<th><label for="kana">ふりがな：</label></th>
					<td><input type="text" id="kana" name="kana" required></td>
				</tr>
				<tr>
					<th><label for="birthday">生年月日：</label></th>
					<td><input type="date" id="birthday" name="birthday" required></td>
				</tr>
				<tr>
					<th><label>性別：</label></th>
					<td><input type="radio" id="male" name="gender" value="male"
						required> <label for="male">男性</label> <input type="radio"
						id="female" name="gender" value="female" required> <label
						for="female">女性</label> <input type="radio" id="other"
						name="gender" value="other" required> <label for="other">その他</label></td>
				</tr>
				<tr>
					<th><label for="postcode">郵便番号 (ハイフンなし7桁)：</label></th>
					<td><input type="text" id="postcode" name="postcode"
						pattern="\d{7}" required></td>
				</tr>
				<tr>
					<th><label for="address">住所：</label></th>
					<td><input type="text" id="address" name="address" required></td>
				</tr>
				<tr>
					<th><label for="phone">電話番号：</label></th>
					<td><input type="tel" id="phone" name="phone"
						pattern="\d{10,11}" required></td>
				</tr>
				<tr>
					<th><label for="email">メールアドレス：</label></th>
					<td><input type="email" id="email" name="email" required></td>
				</tr>
				<tr>
					<th><label for="password">パスワード：</label></th>
					<td><input type="password" id="password" name="password"
						required></td>
				</tr>
				<tr>
					<th><label for="creditcard">クレジットカード番号：</label></th>
					<td><input type="text" id="creditcard" name="creditcard"
						pattern="\d{16}"></td>
				</tr>
				<tr>
					<th><label for="expiry">クレジットカード使用期限 (MM/YY)：</label></th>
					<td><input type="text" id="expiry" name="expiry"
						pattern="\d{2}/\d{2}"></td>
				</tr>

				<tr>
					<th><label for="securitycode">セキュリティコード:</label></th>
					<td><input type="text" id="securitycode" name="securitycode"
						pattern="\d{3,4}"></td>
				</tr>
			</table>
			<button type="button" onclick="clearForm()" class="button2">クリア</button>
			<button type="submit" class="button2">確認</button>
			</form>
		</div>
	</main>
	<jsp:include page="/inc/footer.jsp" />
	<script>
		function clearForm() {
			document.getElementById("memberForm").reset();
		}

		// validateForm 関数はそのまま
		function validateForm() {
			const name = document.getElementById("name").value;
			const kana = document.getElementById("kana").value;
			const birthday = document.getElementById("birthday").value;
			const postcode = document.getElementById("postcode").value;
			const phone = document.getElementById("phone").value;
			const email = document.getElementById("email").value;

			if (!name || !kana || !birthday || !postcode || !phone || !email) {
				alert("すべての必須項目を入力してください。");
				return false;
			}

			const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
			if (!emailRegex.test(email)) {
				alert("正しいメールアドレスを入力してください。");
				return false;
			}

			return true;
		}
	</script>
</body>
</html>