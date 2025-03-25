<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者画面-会員情報検索結果</title>
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
		<!-- 検索結果一覧エリア -->
		<div class="searchresultsarea">
			<h3>会員検索結果一覧</h3>
			<c:if test="${not empty users}">
				<table border="1">
					<thead>
						<tr>
							<th>会員ID</th>
							<th>名前</th>
							<th>ふりがな</th>
							<th>生年月日</th>
							<th>郵便番号</th>
							<th>住所</th>
							<th>電話番号</th>
							<th>メールアドレス</th>
							<!--							<th>性別 (1.男性 2.女性 3.その他)</th>-->
							<th>操作</th>
						</tr>
					</thead>

					<tbody>
						<!-- 検索結果を表示 -->
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.userId}</td>
								<td>${user.name}</td>
								<td>${user.kana}</td>
								<td>${user.birthday}</td>
								<td>${user.postCode}</td>
								<td>${user.address}</td>
								<td>${user.phone}</td>
								<td>${user.email}</td>
								<!--								<td>${user.gender}</td>-->
								<td>
									<!-- 編集ボタン -->
									<form action="${pageContext.request.contextPath}/AdminMember" method="get" style="display: inline;">
										<button type="submit" name="sendKind" value="userEdit">編集</button>
										<input type="hidden" name="userId" value="${user.userId}">
									</form> <!-- 削除ボタン -->
									<form action="${pageContext.request.contextPath}/AdminMember" method="get" style="display: inline;">
										<button type="submit" name="sendKind" value="userDeleteCheck">削除</button>
										<input type="hidden" name="userId" value="${user.userId}">
									</form>
								</td>
							</tr>
						</c:forEach>

					</tbody>

				</table>
			</c:if>

			<!-- 検索結果が空の場合のメッセージ -->
			<c:if test="${empty users}">
				<p>検索結果がありません。</p>
			</c:if>
		</div>
	</main>
	<!-- フッターを挿入 -->


</body>
</html>
