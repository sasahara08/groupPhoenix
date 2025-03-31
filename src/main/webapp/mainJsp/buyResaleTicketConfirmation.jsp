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
<title>リセールチケット購入詳細</title>  
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />  
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />  
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/buyResaleTicketConfirmation.css" />  
</head>  
<body>  
	<jsp:include page="../inc/memberHeader.jsp" />  
	  
	<div class="enclose1">  
		<h1>  
			試合: ${ticket.homeTeamName} vs ${ticket.awayTeamName}<br />  
		</h1>  
		<h5>  
			日時: ${ticket.gameDate}<br /> 開幕: ${ticket.startTime}<br /> 場所: ${ticket.stadiumName}<br />   
			座席: ${ticket.seatType}<br /> 金額: ${ticket.seatPrice}<br />  
		</h5>  
	</div>  
	  <div class="button99">
	<!-- 購入フォーム -->  
	<form action="${pageContext.request.contextPath}/ResaleTicketList" method="post" onsubmit="return saveData()">  
		<input type="hidden" name="ticketId" value="${ticket.ticketId}" />   
		<input type="hidden" name="resaleticket" value="buyResaleTicketComplete" />  
		<button type="submit" class="button3">購入する</button>  
	</form>  

	<!-- キャンセルボタン -->  
	<form action="${pageContext.request.contextPath}/ResaleTicketList" method="post" onsubmit="return saveData()">  
		<input type="hidden" name="resaleticket" value="buyResaleTicketList" />  
		<button type="submit" class="button3">キャンセル</button>  
	</form>  
	</div>
	<jsp:include page="/inc/footer.jsp" />  
</body>  
</html>  