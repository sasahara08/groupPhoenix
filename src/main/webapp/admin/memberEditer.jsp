<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報編集</title>
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
		<!-- 会員情報編集エリア -->
		<div class="editarea">
			<h3>会員情報編集</h3>
			<form action="${pageContext.request.contextPath}/AdminMember" method="post">
				<div>
					<label>会員ID</label><input type="text" name="userId" value="${editUser.userId}" readonly>
				</div>
				<div>
					<label>名前</label><input type="text" name="name" value="${editUser.name}">
				</div>
				<div>
					<label>ふりがな</label><input type="text" name="kana" value="${editUser.kana}">
				</div>
				<div>
					<label>生年月日</label><input type="date" name="birthday" value="${editUser.birthday}">
				</div>
				<div>
					<label>郵便番号</label><input type="text" name="postcode" pattern="\d{3}-?\d{4}" value="${editUser.postCode}">
				</div>
				<div>
					<label>住所</label><input type="text" name="address" value="${editUser.address}">
				</div>
				<div>
					<label>電話番号</label><input type="text" name="phone" value="${editUser.phone}">
				</div>
				<div>
					<label>メールアドレス</label><input type="email" name="email" value="${editUser.email}">
				</div>
				<!--				<div class="gender">-->
				<!--					<label>性別</label> <input type="radio" name="gender" value="male" id="gender_male"-->
				<!--						<c:if test="${user.gender == 'male'}">checked</c:if>> <label for="gender_male">男</label> <input-->
				<!--						type="radio" name="gender" value="female" id="gender_female"-->
				<!--						<c:if test="${user.gender == 'female'}">checked</c:if>> <label for="gender_female">女</label> <input-->
				<!--						type="radio" name="gender" value="other" id="gender_other" <c:if test="${user.gender == 'other'}">checked</c:if>>-->
				<!--					<label for="gender_female">その他</label>-->
				<!--				</div>-->
				<div>
					<label>パスワード</label><input type="password" name="pass" value="${editUser.pass}">
				</div>
				<div class="buttonarea">
					<button type="submit" name="sendKind" value="userEditCheck">確認</button>
			</form>
			<!-- 戻るボタン -->
			<form action="${pageContext.request.contextPath}/AdminMember" method="post" style="display: inline;">
				<button type="submit" name="sendKind" value="userSearch">戻る</button>

			</form>
		</div>

		</div>
	</main>
	<!-- フッターを挿入 -->


</body>
</html>
