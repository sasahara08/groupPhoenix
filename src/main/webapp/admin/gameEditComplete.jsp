<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>管理者画面-試合情報編集完了</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admingame.css" />     
</head>

<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />
    
	<div class="container">
	<h3>試合情報_内容編集完了</h3>
	
		<div class="btn">
		<form action="/groupPhoenix/AdminTop" method="get">
		<input type="submit" value="試合情報TOPに戻る">
		</form>
		</div>
	</div>
    
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />
	
</body>
</html>