 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>マイチケット一覧</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
 <body>
 <jsp:include page="../inc/memberHeader.jsp" />
 	<h1>マイチケット</h1>
 	<div class = enclose1>
 	<c:forEach var="ticket" items="${ticket.ticketId}">
 	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
 	<h1>${team.team_name}vs${game.awayTeam}</h1>
 	<h5>
		日時:${game.gameDate} ${game.gameTime}<br/>
		場所:${game.stadiumPlace}<br/>
		座席:${seats.seattype} ${tickets.seatnumber}<br/>
		枚数:${orderdetail.quantity}枚<br/>
	</h5>	
	<br/>
	<button type="button1" name="ticket" value="resaleTicketSalesConfirmation">リセール出品</button>
 	<button type="button1" name="ticket" value="ticketDisplay">QRコード</button>
 	</form>
 	</c:forEach>
	</div> 
<jsp:include page="/inc/footer.jsp" />
 </body>
 </html>