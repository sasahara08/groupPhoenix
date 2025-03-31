<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>管理者画面-売上詳細</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
</head>
<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />

	<h3>売上一覧：月別</h3>

	<form action="/AdminSales" method="get">
		<select name="selectYear">
			<c:forEach var="year" items="${years}">
				<option value="year">${year}</option>
			</c:forEach>
		</select>
		<button type="submit">更新</button>
	</form>

	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />
</body>
</html>