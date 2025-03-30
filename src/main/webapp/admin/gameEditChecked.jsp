<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>管理者画面-試合編集確認</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admingame.css" />     

</head>

<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />
	
	<!-- 編集内容の確認 -->
	<div class="container">
	<h3>試合情報_編集内容確認</h3>

		
		<h4>編集後</h4>
		
			<div class="label">
			<span>試合ID</span><span id="displayId"></span>
			</div>
		
			<div class="label">
			<span>試合日</span><span id="displayDate"></span>
			</div>
		
			<div class="label">
			<span>試合開始時間</span><span id="displayTime"></span>
			</div>
		
			<div class="label">
			<span>チーム(ホーム)</span><span id="displayHomeTeam"></span>
			</div>
		
			<div class="label">
			<span>チーム(アウェイ)</span><span id="displayAwayTeam"></span>
			</div>
		
			<div class="label">
			<span>開催場所</span><span id="displayStadium"></span>
			</div>
		
		<br>
		<br>
		<br>
		<h4>編集前</h4>
		
			<div class="label">
			<span>${games.gameId}</span>
			</div>
			
			<div class="label">
			<span>${games.gameDate}</span>
			</div>

			<div class="label">
			<span>${games.startTime}</span>
			</div>

			<div class="label">
			<span>${games.homeTeamName}</span>
			</div>

			<div class="label">
			<span>${games.awayTeamName}</span>
			</div>

			<div class="label">
			<span>${games.stadium}</span>
			</div>
		

		<div class="btn">
		<form class="editComplete" action="/groupPhoenix/game" method="post">
			<input type="hidden" id="gameId" name="gameId" value="">
			<input type="hidden" id="gameDay" name="gameDay" value="">
			<input type="hidden" id="gameTime" name="gameTime" value="">
			<input type="hidden" id="homeTeam" name="homeTeam" value="<%= request.getParameter("homeTeam") %>">
			<input type="hidden" id="awayTeam" name="awayTeam" value="<%= request.getParameter("awayTeam") %>">
			<input type="hidden" id="stadium" name="stadium" value="<%= request.getParameter("stadium") %>">
			<input type="hidden" name="gamePage" value="editComplete">
			&nbsp;
			<input type="submit" value="登録" name="editComplete">
			
			<input type="button" value="修正" onclick="history.back()">
		</form>
		</div>
	</div>
        
	<script src="<%= request.getContextPath() %>/js/adminGameAfterEdit.js"></script>

	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />
	
</body>
</html>