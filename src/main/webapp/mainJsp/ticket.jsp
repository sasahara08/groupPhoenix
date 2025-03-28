<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Game"%>
<%@ page import="dto.Resale"%>
<%@ page import="dao.ResaleDAO"%>
 <html>
 <head>
 <title>マイチケット一覧</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
 <body>
 <jsp:include page="/inc/memberHeader.jsp" />
 	<h1>マイチケット</h1>
 	
 	<c:forEach var="ticket" items="${tickets}">
 	<div class = enclose1>
 	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
 	<h1> ${ticket.homeTeamName} vs ${ticket.awayTeamName} </h1>
 	<h5>
		日時: ${ticket.gameDate} ${ticket.startTime} <br/>
		場所: ${ticket.stadiumName} <br/>
		座席: ${ticket.seatType} ${ticket.seatNumber} <br/>
		枚数: ${ticket.seatPrice} 枚<br/>
		価格: ${ticket.seatPrice}円
	</h5>
	</form>
	<br/>
	 <form action="${pageContext.request.contextPath}/TicketList" method="post">
            <!-- ticketIdが正しく設定されていることを確認 -->
            <input type="hidden" name="ticketId" value="${ticket.ticketId}" />
            <input type="hidden" name="resale" value="resaleTicketSalesConfirmation" />
            <button type="submit" class="link-button">リセール</button>
        </form>

     <form action="${pageContext.request.contextPath}/TicketList" method="post">
            <!-- ticketIdが正しく設定されていることを確認 -->
            <input type="hidden" name="ticketId" value="${ticket.ticketId}" />
            <input type="hidden" name="resale" value="ticketDisplay" />
            <button type="submit" class="link-button">QRコード</button>
        </form>

 	</div>
 	</c:forEach>
 	
		
 <jsp:include page="/inc/footer.jsp" />
 </body>
 </html>