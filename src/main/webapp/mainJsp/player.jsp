<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>選手紹介</title>
<link rel="stylesheet" href="../css/html5reset-1.6.1.css" media="all" />
<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/player.css">-->
<link rel="stylesheet" href="../css/style.css" />
<!--  古いcssが読み込まれる場合があるので ?v=20250313　のように後ろに日付等の文字列のクエリを入れると、最新のcssが読み込まれます-->
<link rel="stylesheet" href="../css/player.css">
</head>

<body class="one">
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/header.jsp" />

	<div class="container">
		<div class="header">
			<h1>選手紹介</h1>
		</div>
		<div class="players-grid">
			<!-- 選手データを繰り返し表示 -->
			<c:forEach var="player" items="${players}">
				<div class="player-card">
					<div class="player-info">
						<p>${player.name}</p>
						<p>${player.kana}</p>
						<a href="${player.detailLink}"> <!-- 個別選手ページへのリンク --> <img src="${player.image}" alt="${player.name}のサムネイル">
						</a>
						<p>${player.position}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<!-- TOPページボタン -->
	<div class="top-page-button">
		<a class="button1" href="memberTop.jsp">TOPページ</a>
	</div>

</body>
</html>
