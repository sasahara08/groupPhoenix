<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>試合一覧</title>
<link rel="stylesheet" href="../css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/game.css" />
</head>
<body>

	<c:choose>
		<c:when test="${empty games}">
			<p>試合情報が見つかりませんでした。</p>
		</c:when>
		<c:otherwise>
			<div class="game-list">
				<c:forEach var="game" items="${games}">
					<div class="game">
						<h2>試合ID: ${game.ticketId}</h2>
						<p>試合日: ${game.gameDate}</p>
						<p>開始時間: ${game.startTime}</p>
						<p>対戦チーム: ${game.awayTeam}</p>
						<p>試合場所: ${game.stadiumName}</p>
					</div>
				</c:forEach>
				<button type="button" onclick="location.href='buyTicket.html'">購入</button>
			</div>
		</c:otherwise>
	</c:choose>


	</div>


</body>
</html>