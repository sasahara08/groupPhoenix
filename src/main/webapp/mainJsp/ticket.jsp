 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>チケット一覧</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
 <body>
  <jsp:include page="/inc/header.jsp" />
 	<h1>マイチケット</h1>
 	<div class = enclose1>
 	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
 	<h1>試合チーム</h1>
 	<h5>
		日時<br/>
		場所<br/>
		座席<br/>
	</h5>	
	<br/>
	<button type="button1" name="ticket" value="resaleTicketSalesConfirmation">リセールする</button>
 	<button type="button1" name="ticket" value="ticketDisplay">詳細</button>
 	</form>
	</div> 
<jsp:include page="/inc/footer.jsp" />
 </body>
 </html>