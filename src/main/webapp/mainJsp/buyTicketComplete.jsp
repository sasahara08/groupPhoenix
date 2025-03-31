<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>チケット購入完了</title>
<link rel="stylesheet" href="javascript:void(0)">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/buyTicketComplete.css" />
</head>
<jsp:include page="../inc/memberHeader.jsp" />
<body>
	<main>
		<h1>チケット購入内容 確認</h1>
		<div class="box2">チケットの購入が完了しました</div>

		<form action="${pageContext.request.contextPath}/MemberTopServlet" method="get">
				<button class="button2" type="submit">TOP</button>
			</form>
	</main>
	<jsp:include page="/inc/footer.jsp" />
</body>
</html>
