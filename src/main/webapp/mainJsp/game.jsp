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
<body>
    <h1>試合リスト</h1>
    <form ticket="${pageContext.request.contextPath}/GameListServlet" method="post" onsubmit="saveData()">
	<button type="button1" name="ticket" value="buyResaleTicketList">リセールチケット</button>
	</form>

            <div class="ticket-list">
                <c:forEach var="ticket" items="${tickets}">
                    <div class="tickets">
                          <h2>対戦チーム: ${ticket.homeTeamName} vs ${ticket.awayTeamName}</h2>
                        <p>試合日: ${ticket.gameDate}</p>
                        <p>開始時間: ${ticket.startTime}</p>
                        <p>試合場所: ${ticket.stadiumName}</p>
                        <form ticket="${pageContext.request.contextPath}/Test" method="post" onsubmit="saveData()">
                        <input type="hidden" name="gameId" value="${ticket.gameId}"/>
                        <input type="hidden" name="ticket" value="buyTicket"/>
                       <button type="button1" class="link-button">チケット購入</button>
                       </form>
                    </div>
                </c:forEach>
            </div>
            <form ticket="${pageContext.request.contextPath}/GameListServlet" method="post" onsubmit="saveData()">
           <div>
   		 <button type="button2" name="ticket" value="top">戻る</button>
   		 </div>
    </form>
</body>
</html>
