<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>管理者画面-試合情報編集</title>
<script src="<%=request.getContextPath()%>/js/adminGameEdit.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admingame.css" />
</head>

<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />

	<!-- 会員情報編集エリア -->
	<div class="addForm">
		<h3>試合情報&nbsp;編集</h3>
		<br>
		<form class="gameAdd" action="/groupPhoenix/game" method="get">

			<div class="formItem">
				<label>試合ID</label> <span id="displayId"></span> <input type="hidden" id="hiddenId" name="gameId" value="">
			</div>

			<div class="formItem">
				<label>試合日</label> <input type="date" id="gameDay" name="gameDay" value="">
			</div>

			<div class="formItem">
				<label>試合開始時間</label> <input type="time" id="gameTime" name="gameTime" value="">
			</div>

			<div class="formItem">
				<label>チーム(ホーム)</label> <select name="homeTeam" id="homeTeam" required>
					<option value="" selected>選択してください</option>
					<c:forEach var="team" items="${teams}">
						<option value="${team.teamName}">${team.teamName}</option>
					</c:forEach>
				</select>
			</div>

			<div class="formItem">
				<label>チーム(アウェイ)</label> <select name="awayTeam" id="awayTeam" required>
					<option value="" selected>選択してください</option>
					<c:forEach var="team" items="${teams}">
						<option value="${team.teamName}">${team.teamName}</option>
					</c:forEach>
				</select>
			</div>

			<div class="formItem">
				<label>開催場所</label> <select name="stadium" id="stadium" required>
					<c:forEach var="stadium" items="${stadiums}">
						<option value="${stadium.stadiumsName}">${stadium.stadiumsName}</option>
					</c:forEach>
				</select>
			</div>


			<div class="addBtn">
				<input type="button" value="戻る" onclick="history.back()"> &nbsp; <input type="submit" value="確認" name="edit">

				<input type="hidden" name="gamePage" value="editCheck">
			</div>
	</div>

	</form>

	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />

</body>
</html>