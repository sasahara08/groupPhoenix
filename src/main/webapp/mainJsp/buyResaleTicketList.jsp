 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>リセールチケット一覧</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
 <jsp:include page="../inc/memberHeader.jsp" />
 <body>
 	<form ticket="${pageContext.request.contextPath}/ResaleTicketList.java" method="post" onsubmit="saveData()">
 	<h1>リセールチケット一覧</h1>
 	<button type="button3" name="resaleticket" value="buyResaleTicketConfirmation">
 	<h5>
		試合<br/>
		日時<br/>
		場所<br/>
		座席<br/>
	</h5>	
	</button>
	<br/>
	<button type="button2" name="resaleticket" value="game">戻る</button>
	</form>
 <jsp:include page="/inc/footer.jsp" />
 </body>
 </html>