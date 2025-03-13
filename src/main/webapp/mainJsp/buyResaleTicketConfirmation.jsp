 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>リセールチケット購入詳細</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
</head>
 <body>
 	<form ticket="${pageContext.request.contextPath}/ResaleTicketList.java" method="post" onsubmit="saveData()">
 	<div class = enclose1>
 	<h1>
		試合<br/>
	</h1>	
	<h5>
		日時<br/>
		開幕<br/>
		場所<br/>
		座席<br/>
		金額<br/>
		お問い合わせ先   創造社リカレントファルコンズ 0120-345-6789
	</h5>
	</div>	
	<button type="button1"name="resaleticket" value="buyResaleTicketComplete">購入する</button>
	<button type="button2" name="resaleticket" value="buyResaleTicketList">キャンセル</button>
	</form>
 
 </body>
 </html>