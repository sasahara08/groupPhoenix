<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>管理者画面-Top</title>
<link rel="stylesheet" href="javascript:void(0)" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminmenu.css" />
</head>
<body>
	<!-- ヘッダーを挿入 -->
            <jsp:include page="../inc/adminHeader.jsp" />
            
            
	<div class="adminMenu">
		<br>
		<br>
		<h3>
			管理画面&nbsp;TOP
		</h3>

		<a href="${pageContext.request.contextPath}/AdminMember" class="button25">1.会員情報管理</a> <a
			href="${pageContext.request.contextPath}/game" class="button25">2.試合情報管理</a> <a href="${pageContext.request.contextPath}/AdminTicket" class="button25">3.チケット情報管理</a>
		<a href="${pageContext.request.contextPath}/AdminSales" class="button25">4.売上管理</a> <a href="#" class="button25">5.フード/グッズ管理</a>
		<a href="#" class="button25">6.選手情報管理</a> <a href="#" class="button25">7.NEWS情報管理</a> <a href="#" class="button25">8.問い合わせ管理</a>
		<a href="#" class="button25">9.管理情報</a>
	</div>

	<!-- フッターを挿入 -->
	<footer class="footer">
		<p>© 2025 Phoenix Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>
