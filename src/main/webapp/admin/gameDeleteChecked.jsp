<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>管理者画面-試合削除確認</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admingame.css" /> 
    </head>

<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />
            
	<div class="container">
		<h4>削除する試合情報の確認</h4>
		<div class="contentsForm">
			<div class="label"><span id="displayId"></span></div>
			<div class="label"><span id="displayDate"></span></div>
			<div class="label"><span id="displayTime"></span></div>
			<div class="label"><span id="displayHomeTeam"></span></div>
			<div class="label"><span id="displayAwayTeam"></span></div>
			<div class="label"><span id="displayStadiumName"></span></div>
		</div>
        
		
		<div class="btn">
        	<form class="editComplete" action="/groupPhoenix/game" method="post">
            	<input type="hidden" id="hiddenId"" name="gameId" value="">
            	<input type="hidden" name="gamePage" value="deleteComplete">

            	<input type="submit" value="削除" name="deleteComplete">
            	&nbsp;
            	<input type="button" value="戻る" onclick="history.back()">
        	</form>
        </div>
	</div>
	
	<script src="<%= request.getContextPath() %>/js/adminGameDelete.js"></script>
	
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />
            
	</body>
</html>