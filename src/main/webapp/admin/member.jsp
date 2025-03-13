<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Phoenix管理画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminmember.css" />
<link rel="stylesheet" href="javascript:void(0)">
</head>
<body>
	<div class="title">
		<h2>
			管理画面<span class="subtitle">1.会員情報</span>
		</h2>
	</div>

	<main>
		<div class="searcharea">
			<h3>【会員検索】</h3>
			<form action="${pageContext.request.contextPath}/AdminMember" method="post">
				<p>
					<label>会員ID</label><input type="text" name="userid">
				</p>
				<p>
					<label>名前</label><input type="text" name="name">
				</p>
				<p>
					<label>ふりがな</label><input type="text" name="kana">
				</p>
				<p>
					<label>電話番号</label><input type="text" name="phone">
				</p>
				<p>
					<label>メールアドレス</label><input type="text" name="email">
				</p>
				<p>
					<button type="reset" value="reset">リセット</button>
					<button type="submit" name="sendKind" value="userSearch">検索</button>
				</p>
			</form>
		</div>
	</main>

</body>
</html>