<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.GameTicket" %>
<html>
<head>
<title>試合リスト</title>
</head>
<body>
	<h1>試合リスト</h1>

	<c:choose>
		<c:when test="${empty games}">
			<p>試合情報が見つかりませんでした。</p>
		</c:when>
		<c:otherwise>
			<c:forEach var="game" items="${games}">
				<div class="game">
					<h2>試合ID: ${game.ticketId}</h2>
					<p>試合日: ${game.gameDate}</p>
					<p>開始時間: ${game.startTime}</p>
					<p>対戦チーム: ${game.awayTeam}</p>
					<p>試合場所: ${game.stadiumName}</p>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>


</body>
</html>