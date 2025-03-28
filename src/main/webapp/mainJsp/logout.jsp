<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>ログアウト</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/logout.css">
</head>
<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/memberHeader.jsp" />

	<div class="completion-container">
		<h1>ログアウトしますか？</h1>
		<!-- ログアウト用のサーブレットに遷移するリンク -->
		<a href="<%=request.getContextPath()%>/LogoutServlet" class="button1"> ログアウトする </a>
	</div>
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
