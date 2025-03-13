 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>リセールチケット販売確認</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
</head>
 <body>
 	<h1>リセールチケット出品</h1>
 	<h5>表示されているチケットを出品しますか？</h5>
 	<div class = enclose1>
 	<form ticket="${pageContext.request.contextPath}/TicketList.java" method="post" onsubmit="saveData()">
 	<h1>
		試合<br/>
	</h1>	
	<h5>
		日時<br/>
		場所<br/>
		座席<br/>
	</h5>
	</div>
	<button type="button2" name="ticket" value="ticket">戻る</button>
	<button type="button1" name="ticket" value="resaleTicketSalesComplete">出品する</button>
	</form>
 </body>
 </html>