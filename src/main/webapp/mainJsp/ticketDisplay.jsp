 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>チケット表示</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
</head>
 <body>
 	<h1>チケット</h1>
 	<div class = enclose1>
 	<img src="images/QRAdmission.png" alt="images/QRAdmission.png" width="300px"/>
 	<h1>
		試合<br/>
	</h1>
	<h5>
		日時<br/>
		場所<br/>
		座席<br/>
	</h5>
	</div>	
	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
	<button type="button2" name="ticket" value="ticket">戻る</button>
	</form>
 </body>
 </html>