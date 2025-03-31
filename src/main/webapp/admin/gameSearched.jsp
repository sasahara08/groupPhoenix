<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>試合一覧</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admingame.css" /> 
</head>

<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />

	<!-- 試合一覧 -->
	<div class="gameList">
	<h3>試合一覧</h3>
	               
		<table class="table_design08">
			<thead>
			<c:if test="${not empty games}">
				<tr>
					<th>試合ID</th>
                	<th>試合日</th>
					<th>時間</th>
					<th>チーム(ホーム)</th>
					<th>チーム(アウェイ)</th>
					<th>場所</th>
					<th>操作</th>
				</tr>
			</thead>
					
			<tbody>
			<c:forEach var="game" items="${games}">
				<tr>
					<td data-label="試合ID">${game.gameId}</td>
					<td data-label="試合日">${game.gameDate}</td>
					<td data-label="時間">${game.startTime}</td>
					<td data-label="チーム(ホーム)">${game.homeTeamName}</td>
					<td data-label="チーム(アウェイ)">${game.awayTeamName}</td>
					<td data-label="場所">${game.stadium}</td>
					
					<td>				                            
					<c:if test="${game.gameDeleteAt != null}">
					<td colspan="7" class="deleted-message">試合情報は削除されています</td>
					</c:if>
					</td>
					
                    <td>            
					<form action="/groupPhoenix/game" method="get">
						<input type="hidden" name="editGameId" value="${game.gameId}">
						<input type="hidden" name="editGameDate" value="${game.gameDate}">
						<input type="hidden" name="editGameTime" value="${game.startTime}">
						<input type="hidden" name="editHomeTeam" value="${game.homeTeamName}">
						<input type="hidden" name="editAwayTeam" value="${game.awayTeamName}">
						<input type="hidden" name="editStadiumName" value="${game.stadium}">

						<input type="hidden" name="gamePage" value="edit">
 						<input type="submit" value="編集" name="edit">
					</form>
					&nbsp;

					<form action="/groupPhoenix/game" method="get">
						<input type="hidden" name="gameId" value="${game.gameId}">
						<input type="hidden" name="gameDate" value="${game.gameDate}">
						<input type="hidden" name="gameTime" value="${game.startTime}">
						<input type="hidden" name="homeTeam" value="${game.homeTeamName}">
						<input type="hidden" name="awayTeam" value="${game.awayTeamName}">
						<input type="hidden" name="stadiumName" value="${game.stadium}">

						<input type="hidden" name="gamePage" value="delete">
						<input type="submit" value="削除" name="delete">
					</form>     
			</c:forEach>      
			</c:if>

 			<c:if test="${empty games}">
				<p>試合データがありません。</p>
			</c:if>
            </tbody>
		</table>
	</div>
            
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />

</body>
</html>