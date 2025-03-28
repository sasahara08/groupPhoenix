<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Game"%>
<%@ page import="dto.Resale"%>
<%@ page import="dao.ResaleDAO"%>
 <html>
 <head>
 <title>チケット表示</title>
 <link rel="stylesheet" href="javascript:void(0)">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
 <body>
<jsp:include page="../inc/memberHeader.jsp" />
 	<h1>チケット</h1>
 	<div class = enclose1>
 	<img src="images/QRAdmission.png" alt="images/QRAdmission.png" width="300px"/>
 	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
 	<h1>
		${tickethomeTeamName}vs${ticket. awayTeamName}<br/>
	</h1>
	<h5>
		日時: ${ticket.gameDate} ${ticket.startTime}<br/>
		場所: ${ticket.stadiumName}<br/>
		座席: ${ticket.seatType} ${ticket.seatNumber}<br/>
		枚数: 枚<br/>
	</h5>
	</form>
	</div>	
	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
	 <input type="hidden" name="resale" value="ticket"/>
	<button type="button1" class="link-button">戻る</button>
	</form>
<jsp:include page="../inc/footer.jsp" />
 </body>
 </html>