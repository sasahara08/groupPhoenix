 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>リセールチケット購入完了</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
</head>
 <body>
 	<form ticket="${pageContext.request.contextPath}/ResaleTicketList.java" method="post" onsubmit="saveData()">
 	<div class = enclose2>
 	<h5>チケットの購入が完了しました</h5><br/>
 	<button type="button2" name="resaleticket" value="memberTop">TOP</button>
 	</div>
 	</form>
 </body>
 </html>