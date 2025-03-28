<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>チケット購入 確認</title>
<link rel="stylesheet" href="game.css" />
<link rel="stylesheet" href="html5reset-1.6.1.css" />
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<main>
		<h1>チケット購入内容 確認</h1>
		<div class="box2">
			<p>試合日時：${game.gameDate}</p>
			<p>試合場所：${game.stadiumName}</p>
			<p>座席：${seatId.seatType}</p>
			<p>枚数：${quantity}</p>
			<p>価格：${quantity*seatId.seatPrice}</p>
		</div>

		<div class="button99">
		<form ticket="${pageContext.request.contextPath}/GameListServlet" method="post" onsubmit="saveData()">
                       <button type="button2" name="ticket" value="game">キャンセル</button>
                       </form>
                       <form ticket="${pageContext.request.contextPath}/GameListServlet" method="post" onsubmit="saveData()">
                       <input type="hidden" name="ticketId" value="${ticket.ticketId}" />
                        <input type="hidden" name="ticket" value="buyTicketComplete"/>
                       <button type="button1" class="link-button">購入</button>
         </form>
		</div>
	</main>
</body>
</html>
