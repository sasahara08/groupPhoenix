<%@ page contentType="text/html;charset=UTF-8" language="java"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.List"%>  
<%@ page import="dto.Game"%>  
<%@ page import="dto.Resaleticket"%>  
<%@ page import="dao.ResaleticketDAO"%>  
<html>  
<head>  
<meta charset="UTF-8">  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title>リセールチケット一覧</title>  
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />  
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />  
</head>  
<body>  
	<jsp:include page="../inc/memberHeader.jsp" />  
	  
	<h1>リセールチケット一覧</h1>  
	<c:forEach var="ticket" items="${tickets}">  
		<form action="${pageContext.request.contextPath}/ResaleTicketList" method="post" onsubmit="return saveData()">  
			<input type="hidden" name="ticketId" value="${ticket.ticketId}" />   
			<input type="hidden" name="resaleticket" value="buyResaleTicketConfirmation" />  
			<button type="submit" class="link-button">リセール</button>  
			<h5>  
				${ticket.homeTeamName} vs ${ticket.awayTeamName}<br />  
				日時: ${ticket.gameDate} ${ticket.startTime}<br />  
				場所: ${ticket.stadiumName}<br /> 座席: ${ticket.seatType}<br />  
			</h5>  
		</form>  
	</c:forEach>  

	<br />  
	<form action="${pageContext.request.contextPath}/GameListServlet" method="get">  
		<button type="submit" class="link-button">戻る</button>  
	</form>  
	  
	<jsp:include page="/inc/footer.jsp" />  
</body>  
</html>  