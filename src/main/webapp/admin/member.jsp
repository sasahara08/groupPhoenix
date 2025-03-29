<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報TOP</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminMemberList.css" />
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
		<!-- 会員検索ボックスエリア -->
		<div class="searchForm">
			<h3>【会員検索】</h3>
			<form action="${pageContext.request.contextPath}/AdminMember" method="post">
				<div class="formItem">
					<label>会員ID</label><input type="text" name="userid">
				</div>
				
				<div class="formItem">
					<label>名前</label><input type="text" name="name">
				</div>
				
				<div class="formItem">
					<label>ふりがな</label><input type="text" name="kana">
				</div>
				
				<div class="formItem">
					<label>電話番号</label><input type="text" name="phone">
				</div>
				
				<div class="formItem">
					<label>メールアドレス</label><input type="text" name="email">
				</div>
				
				<div class="searchBtn">
					<button type="submit" name="sendKind" value="userSearch">検索</button>
					&nbsp;
					<button type="reset" name="sendKind" value="userReset">リセット</button>
				</div>
			</form>
		</div>
		<!-- 会員追加ボックスエリア -->
		<div class="addForm">
			<h3>【会員追加】</h3>
			<p>※すべて入力必須</p>
			<form action="${pageContext.request.contextPath}/AdminMember" method="post">
				<div class="formItem">
					<label>名前</label><input type="text" name="name" placeholder="田中太郎" required>
				</div>
				<div class="formItem">
					<label>ふりがな</label><input type="text" name="kana" placeholder="たなかたろう" required>
				</div>
				<div class="formItem">
					<label>生年月日</label><input type="date" name="birthday" required>
				</div>
				<div class="formItem">
					<label>郵便番号</label><input type="text" name="postcode" pattern="\d{3}-?\d{4}" placeholder="1234567 ※ハイフンなし" required>
				</div>
				<div class="formItem">
					<label>住所</label><input type="text" name="address" placeholder="福岡県福岡市中央区長浜１丁目4番13号 SF福岡ビル6階" required>
				</div>
				<div class="formItem">
					<label>電話番号</label><input type="text" name="phone" placeholder="09012345678 ※ハイフンなし" required>
				</div>
				<div class="formItem">
					<label>メールアドレス</label><input type="email" name="email" placeholder="pmark@sozosha.ac.jp" required>
				</div>
<!--				<div class="gender">-->
<!--					<label>性別</label>-->
<!--					<input type="radio" name="gender" value="male" id="gender_male"> <label for="gender_male">男</label>-->
<!--					<input type="radio" name="gender" value="female" id="gender_female"> <label for="gender_female">女</label>-->
<!--					<input type="radio" name="gender" value="other" id="gender_other"> <label for="gender_female">その他</label>-->
<!--				</div>-->
				<div class="formItem">
					<label>パスワード</label><input type="password" name="pass" required>
				</div>
				<div class="addBtn">
					<button type="submit" name="sendKind" value="userAddCheck">追加</button>
					&nbsp;
					<button type="reset" name="sendKind" value="userReset">リセット</button>
				</div>
			</form>
		</div>
	</main>
	<!-- フッターを挿入 -->


</body>
</html>