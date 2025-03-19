<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTLコアタグの指定 -->

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>選手紹介</title>
<!-- CSSファイルの動的なパス指定 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/player.css" />
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
						<p>${players.name}</p>
						<p>${players.kana}</p>
						<a href="${pageContext.request.contextPath}/PlayerDetailServlet?id=${players.playerId}"> <img
							src="${pageContext.request.contextPath}/${players.image}" alt="${players.name}のサムネイル" />
						</a>
						<p>${players.position}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- TOPページボタン -->
	<div class="top-page-button">
		<a class="button1" href="${pageContext.request.contextPath}/memberTop.jsp">TOPページ</a>
	</div>
</body>
</html>
