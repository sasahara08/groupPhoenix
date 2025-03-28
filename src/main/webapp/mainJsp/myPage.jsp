<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>マイページ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css" />
</head>
<body>
	<jsp:include page="/inc/memberHeader.jsp" />

	<%
	// セッション情報を取得
	String userName = (String) session.getAttribute("userName");
	Integer userId = (Integer) session.getAttribute("userId");

	// セッションが無効の場合、ログインページへリダイレクト
	if (userName == null || userId == null) {
		response.sendRedirect("login.jsp");
		return; // 処理を終了
	}
	%>

	<div class="container">
		<br>
		<h1>メンバーページ</h1>

		<div class="welcome-message">
			<p>
				ユーザー名:
				<%=userName%></p>
			<p>
				ユーザーID:
				<%=userId%></p>
		</div>

		<div class="wrapper">
			<!-- 会員情報変更ボタン -->
			<form action="${pageContext.request.contextPath}/MemberEditorServlet" method="get">
				<button class="button3" type="submit">会員情報変更</button>
			</form>

			<!-- マイチケットボタン -->
			<form action="${pageContext.request.contextPath}/TicketList" method="get">
				<button class="button3" type="submit">マイチケット</button>
			</form>
		</div>
		<br>

		<!-- TOPボタン -->
		<form action="${pageContext.request.contextPath}/MemberTopServlet" method="get">
			<button class="button2" type="submit">TOP</button>
		</form>
		<br> <br>
	</div>

	<jsp:include page="/inc/footer.jsp" />
</body>
</html>
