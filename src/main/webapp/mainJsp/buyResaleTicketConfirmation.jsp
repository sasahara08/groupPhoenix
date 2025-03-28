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
 <link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 <script>
        function addTicketOrder(ticketId, userId) {
            const requestData = {
                ticket_id: ticketId,
                user_id: userId
            };

            fetch('AddTicketOrderServlet', { // Servletに送信
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requestData)
            }).then(response => {
                if (response.ok) {
                    alert('行が追加されました');
                    location.reload(); // 必要に応じてページを更新
                } else {
                    alert('エラーが発生しました');
                }
            });
        }
    </script>
 
 </head>
 <body>
 <jsp:include page="../inc/memberHeader.jsp" />
 	<form ticket="${pageContext.request.contextPath}/ResaleTicketList.java" method="post" onsubmit="saveData()">
 	<div class = enclose1>
 	<h1>
		試合:  ${ticket.homeTeamName} vs ${ticket.awayTeamName}<br/>
	</h1>	
	<h5>
		日時: ${ticket.gameDate}<br/>
		開幕: ${ticket.startTime}<br/>
		場所: ${ticket.stadiumName}<br/>
		座席: ${ticket.seatType}<br/>
		金額: ${ticket.seatPrice}<br/>
	</h5>
	</div>
	</form>
	<form action="${pageContext.request.contextPath}/ResaleTicketList" method="post" onsubmit="saveData()">
        
    <input type="text" id="ticket_id" placeholder="Ticket ID">
 <input type="hidden" name="resaleticket" value="buyResaleTicketComplete" />
       購入する</button>
    </form>

    <!-- キャンセルボタン -->
    <form action="${pageContext.request.contextPath}/ResaleTicketList" method="post" onsubmit="saveData()">
        <input type="hidden" name="resaleticket" value="buyResaleTicketList" />
        <button type="submit" class="link-button">キャンセル</button>
    </form>


 <jsp:include page="/inc/footer.jsp" />
 </body>
 </html>