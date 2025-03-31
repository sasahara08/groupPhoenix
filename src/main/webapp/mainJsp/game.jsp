<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Game"%>
<%@ page import="dto.Ticket"%>
<%@ page import="dao.TicketDAO"%>
<html>
<head>
<title>試合リスト</title>
</head>
<link rel="stylesheet" href="javascript:void(0)">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<jsp:include page="../inc/memberHeader.jsp" />

<body>
	<h1>試合リスト</h1>
		<form action="${pageContext.request.contextPath}/ResaleTicketList" method="get">
			<button class="button2" type="submit">リセールチケット</button>
		</form>

	<div class="ticket-list">
		<c:forEach var="ticket" items="${tickets}">
			<div class="tickets">
				<h2>対戦チーム: ${ticket.homeTeamName} vs ${ticket.awayTeamName}</h2>
				<p>試合日: ${ticket.gameDate}</p>
				<p>開始時間: ${ticket.startTime}</p>
				<p>試合場所: ${ticket.stadiumName}</p>
				<form ticket="${pageContext.request.contextPath}/GameListServlet" method="post" onsubmit="saveData()">
					<input type="hidden" name="gameId" value="${ticket.gameId}" /> 
					<input type="hidden" name="ticket" value="buyTicket" />
					<button type="button1" class="link-button">チケット購入</button>
				</form>
			</div>
		</c:forEach>
		<div>
			<form action="${pageContext.request.contextPath}/MemberTopServlet" method="get">
				<button class="button2" type="submit">戻る</button>
			</form>
		</div>
	<jsp:include page="/inc/footer.jsp" />
</body>
</html>
