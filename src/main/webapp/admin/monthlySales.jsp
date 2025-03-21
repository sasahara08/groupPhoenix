<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>管理者画面-売上詳細</title>
<link rel="stylesheet" href="javascript:void(0)">
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

	<!--上段は年のリスト、年の表示と下段を実装-->
	<!--DAOとサーブレットは実装済み-->

	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />
</body>
</html>