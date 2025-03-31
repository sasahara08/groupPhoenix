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
<title>リセールチケット購入完了</title>
<link rel="stylesheet" href="javascript:void(0)">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/buyResaleTicketComplete.css" />
</head>
<body>
	<jsp:include page="../inc/memberHeader.jsp" />
	<main>
	<div class=enclose2>
		<h5>チケットの購入が完了しました</h5>
		<br />
		<form action="${pageContext.request.contextPath}/MemberTopServlet" method="get">
				<button class="button3" type="submit">TOP</button>
			</form>
	</div>
	</main>
	<jsp:include page="/inc/footer.jsp" />
</body>
</html>