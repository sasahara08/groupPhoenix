<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Game"%>
<%@ page import="dto.Resale"%>
<%@ page import="dao.ResaleDAO"%>
 <html>
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>リセールチケット出品確認</title>
 <link rel="stylesheet" href="javascript:void(0)">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<jsp:include page="../inc/memberHeader.jsp" />
 <body>
 	<h1>リセールチケット</h1>
 	<h5>
 		表示されているチケットを出品してもよろしいでしょうか？<br/>
 		出品後はチケットは使用不可になります。
 	</h5>
 	<div class = enclose1>
 	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
 	<h1>
		${ticket.homeTeamName}vs${ticket.awayTeamName}<br/>
	</h1>	
	<h5>
		日時: ${ticket.gameDate} ${ticket.startTime}<br/>
		場所: ${ticket.stadiumName}<br/>
		座席: ${ticket.seatType} ${ticket.seatNumber}<br/>
		枚数: 枚<br/>
		価格: ${ticket.seatPrice} 円
	</h5>
	</form>
	</div>
	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
	 <input type="hidden" name="resale" value="ticket"/>
	<button type="button1" class="link-button">戻る</button>
	</form>
	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
	<input type="hidden" name="ticketId" value="${ticket.ticketId}"/>
    <input type="hidden" name="resale" value="resaleTicketSalesComplete"/>
	<button type="button1" class="link-button">出品する</button>
	</form>
<jsp:include page="../inc/footer.jsp" />
 </body>
 </html>