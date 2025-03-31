<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>チケット購入 確認</title>
<link rel="stylesheet" href="javascript:void(0)">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<jsp:include page="../inc/memberHeader.jsp" />
<body>
	<main>
		<h1>チケット購入内容 確認</h1>
		<div class="box2">
			<p>試合日時：${ticket.gameDate}</p>
			<p>試合場所：${ticket.stadiumName}</p>
			<p>座席：${seat.seatType}</p>
			<p>価格：${seat.seatPrice}</p>
		</div>

		<div class="button99">
			<form ticket="${pageContext.request.contextPath}/GameListServlet" method="post" onsubmit="saveData()">
				<button type="submit" name="ticket" value="game">キャンセル</button>
			</form>
			<form ticket="${pageContext.request.contextPath}/GameListServlet" method="post" onsubmit="saveData()">
				<input type="hidden" name="gameId" value="${ticket.gameId}" />
				<input type="hidden" name="seatId" value="${seat.seatId}" />
				 <input type="hidden" name="ticket" value="buyTicketComplete" />
				<button type="submit" class="link-button">購入</button>
			</form>
		</div>
	</main>
	<jsp:include page="/inc/footer.jsp" />
</body>
</html>
