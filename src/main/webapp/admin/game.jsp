<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib prefix="c" uri="jakarta.tags.core" %>
		<!DOCTYPE html>
		<html lang="ja">

		<head>
			<meta charset="UTF-8">
			<title>管理者画面-試合情報一覧</title>
			<link rel="stylesheet" href="javascript:void(0)">
		</head>

		<body>

			<!-- ヘッダーを挿入 -->
			<jsp:include page="../inc/adminHeader.jsp" />

			<!-- 試合検索フォーム -->
			<form class="gameSearch" action="/game" method="post">
				<h3>試合検索</h3>
				<div class="searchForm">

					<div class="formItem">
						<span>試合ID</span> <input type="text" name="gameId">
					</div>

					<div class="formItem">
						<span>試合日</span> <input type="text" name="gameDay">
					</div>

					<div class="formItem">
						<span>チーム(ホーム)</span> <select name="homeTeam" id="homeTeam">
							<c:forEach var="team" items="${teams}">
								<option value="${team.team_name}" name="homeTeam">${team.teamName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="formItem">
						<span>チーム(アウェイ)</span> <select name="awayTeam" id="awayTeam">
							<c:forEach var="team" items="${teams}">
								<option value="${team.team_name}" name="awayTeam">${team.teamName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="formItem">
						<span>開催場所</span> <select name="stadium" id="stadium">
							<c:forEach var="stadium" items="${stadiums}">
								<option value="${stadium.stadiums_name}">${stadium.stadiumsName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="formItem">
						<span>試合ステータス</span> <label for="all">すべて</label> <input type="radio" id="all" name="status"
							value="all"> <label for="beforeGame">今後開催</label> <input type="radio" name="status"
							value="all"> <label for="afterGame">終了</label>
						<input type="radio" name="status" value="all"> <input type="hidden" name="gamePage"
							value="search">
					</div>

				</div>

				<div class="searchBtn">
					<input type="reset" value="reset"> <input type="submit" name="search" value="編集">
				</div>

			</form>

			<!-- ここから試合追加フォーム -->
			<h3>試合追加</h3>
			<form class="gameAdd" action="/game" method="get">
				<div class="addForm">

					<div class="formItem">
						<span>試合日</span> <input type="date" name="gameDay">
					</div>

					<div class="formItem">
						<span>試合時間</span> <input type="time" name="gameTime">
					</div>

					<div class="formItem">
						<span>チーム(ホーム)</span> <select name="homeTeam" id="homeTeam">
							<c:forEach var="team" items="${teams}">
								<option value="${team.teamName}">${team.teamName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="formItem">
						<span>チーム(アウェイ)</span> <select name="awayTeam" id="awayTeam">
							<c:forEach var="team" items="${teams}">
								<option value="${team.teamName}">${team.teamName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="formItem">
						<span>開催場所</span> <select name="stadium" id="stadium">
							<c:forEach var="stadium" items="${stadiums}">
								<option value="${stadium.stadiumsName}">${stadium.stadiumsName}</option>
							</c:forEach>
						</select>
					</div>

				</div>

				<div class="addBtn">
					<input type="reset" value="reset"> <input type="submit" value="追加" name="add">
				</div>

				<input type="hidden" name="gamePage" value="addCheck">

			</form>


			<!-- 試合一覧 -->
			<h3>試合一覧</h3>

			<div class="gameList">
				<div class="ListHeader">
					<span> 試合ID </span> <span> 試合日 </span> <span> 時間 </span> <span> チーム(ホーム) </span> <span> チーム(アウェイ)
					</span> <span>
						場所 </span> <span> 操作 </span>
				</div>

				<div class="Listmain">
					<c:forEach var="game" items="${games}">
						<div class="gameList">

							<span> ${game.game_id} </span>

							<span> ${game.game_date} </span>

							<span> ${game.start_time} </span>

							<span> ${game.homeTeam.team_name} </span>

							<span> ${game.awayTeam.team_name} </span>

							<span> ${game.stadium.stadium_name} </span>

							<div>
								<form action="/game" method="get">
									<input type="hidden" name="editGameId" value="${game.game_id}">
									<input type="hidden" name="editGameDate" value="${game.game_date}">
									<input type="hidden" name="editGameTime" value="${game.start_time}">
									<input type="hidden" name="editHomeTeam" value="${game.homeTeam.team_name}">
									<input type="hidden" name="editAwayTeam" value="${game.awayTeam.team_name}">
									<input type="hidden" name="editStadiumName" value="${game.stadium.stadium_name}">

									<input type="hidden" name="gamePage" value="edit">
									<input type="submit" value="編集" name="edit">
								</form>

								<form action="/game" method="get">
									<input type="hidden" name="gameId" value="${game.game_id}">
									<input type="hidden" name="gameDate" value="${game.game_date}">
									<input type="hidden" name="gameTime" value="${game.start_time}">
									<input type="hidden" name="homeTeam" value="${game.homeTeam.team_name}">
									<input type="hidden" name="awayTeam" value="${game.awayTeam.team_name}">
									<input type="hidden" name="stadiumName" value="${game.stadium.stadium_name}">

									<input type="hidden" name="gamePage" value="delete">
									<input type="submit" value="削除" name="delete">
								</form>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>

			<!-- フッターを挿入 -->
			<jsp:include page="../inc/adminFooter.jsp" />

		</body>

		</html>