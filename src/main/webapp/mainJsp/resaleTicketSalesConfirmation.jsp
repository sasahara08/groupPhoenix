 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
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
 	<c:forEach var="ticket" items="${ticket.ticketId}">
 	<div class = enclose1>
 	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
 	<h1>
		${game.homeTeam}vs${game.awayTeam}<br/>
	</h1>	
	<h5>
		日時:${game.gameDate} ${game.gameTime}<br/>
		場所:${game.stadiumPlace}<br/>
		座席:${seats.seattype} ${tickets.seatnumber}<br/>
		枚数:${orderdetail.quantity}枚<br/>
	</h5>
	</div>
	<button type="button2" name="ticket" value="ticket">戻る</button>
	<button type="button1" name="ticket" value="resaleTicketSalesComplete">出品する</button>
	</c:forEach>
	</form>
<jsp:include page="../inc/footer.jsp" />
 </body>
 </html>