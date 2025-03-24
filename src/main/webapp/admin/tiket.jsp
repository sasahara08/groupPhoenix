<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!-- 1:チケット情報一覧 -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>チケット情報一覧</title>
<link rel="stylesheet" href="../css/adminheader.css" />
<link rel="stylesheet" href="../css/adminfooter.css" />
<link rel="stylesheet" href="../css/admin-ticket.css" />
</head>
<body>

	<!--     ヘッダー  -->
	<header>
		<h1>
			<a href="#" class="logo">Phoenix管理画面</a>
		</h1>
		<!--		未ログイン時は「ログイン」、ログイン時は「ログアウト」-->
		<button type="logout" class="logout-button">ログアウト</button>
	</header>
	<!-- タイトル -->
	<main>
		<div class="title">
			<h1>管理画面</h1>
			<p class="sub">3.チケット情報管理</p>
		</div>
		<!-- チケット検索 -->
		<div class="main">
			<h3>チケット検索</h3>
			<!-- ★フォームタグ -->
			<form action="${pageContext.request.contextPath}/AdminTicket" method="post">
				<table>
					<tr>
						<th>購入ステータス</th>
						<td><input type="radio" id="status01" name="purchaseStatus" value="1"> <label for="status01">未購入</label>
							<input type="radio" id="status02" name="purchaseStatus" value="2"> <label for="status02">購入済</label> <input
							type="radio" id="status03" name="purchaseStatus" value="3"> <label for="status03">リセール販売</label> <input
							type="radio" id="status04" name="purchaseStatus" value="4"> <label for="status04">リセール購入済</label></td>
					</tr>
				</table>
				<!-- 購入者情報 -->
				<h4>〇購入者情報</h4>
				<table>
					<tr>
						<th>チケットID</th>
						<td><input type="text" placeholder="1" name="ticketId"></td>
					</tr>
					<th>チケット購入日</th>
					<td><input type="date" name="ticketPurchaseDate"></td>
					</tr>
					<th>会員ID</th>
					<td><input type="text" placeholder="1" name="userId"></td>
					</tr>
					<th>名前</th>
					<td><input type="text" placeholder="山田太郎" name="name"></td>
					</tr>
					<th>ふりがな</th>
					<td><input type="text" placeholder="やまだたろう" name="kana"></td>
					</tr>
				</table>
				<!-- リセール購入者情報 -->
				<h4>〇リセール購入者情報</h4>
				<table>
					<tr>
						<th>チケットID</th>
						<td><input type="text" placeholder="1" name="resaleTicketId"></td>
					</tr>
					<th>チケット購入日</th>
					<td><input type="date" name="resaleTicketPurchaseDate"></td>
					</tr>
					<th>会員ID</th>
					<td><input type="text" placeholder="1" name="resaleUserId"></td>
					</tr>
					<th>名前</th>
					<td><input type="text" placeholder="山田太郎" name="resaleName"></td>
					</tr>
					<th>ふりがな</th>
					<td><input type="text" placeholder="やまだたろう" name="resaleKana"></td>
					</tr>
				</table>
				<!-- 試合情報 -->
				<h4>〇試合情報</h4>
				<table>
					<tr>
						<th>試合ID</th>
						<td><input type="text" placeholder="1" name="gameId"></td>
					</tr>
					<tr>
						<th>試合日</th>
						<td><input type="date" name="gameDate"></td>
					</tr>
					<tr>
						<th>チーム(ホーム)</th>
						<td><select name="homeTeam" id="homeTeam">
								<option value="" selected>選択してください</option>
								<c:forEach var="team" items="${teams}">
									<option value="${team.teamName}" name="homeTeam">${team.teamName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th>チーム(アウェイ)</th>
						<td><select name="awayTeam" id="awayTeam">
								<option value="" selected>選択してください</option>
								<c:forEach var="team" items="${teams}">
									<option value="${team.teamName}" name="awayTeam">${team.teamName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th>開催場所</th>
						<td><select name="stadium" id="stadium">
								<c:forEach var="stadium" items="${stadiums}">
									<option value="${stadium.stadiumsName}">${stadium.stadiumsName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th>試合ステータス</th>
						<td><input type="radio" id="gamestatus01" name="GameStatus" value="beforeGame"> <label
							for="gamestatus01">今後開催</label> <input type="radio" id="gamestatus02" name="GameStatus" value="finishedGame">
							<label for="gamestatus02">終了</label> <input type="radio" id="gamestatus03" name="GameStatus" value="all">
							<label for="gamestatus03">すべて</label></td>
					</tr>

				</table>
				<!-- 検索・リセットボタン -->
				<div>
					<button type="submit" name="sendKind" value="ticketSearch">検索</button>
					<button type="reset" name="sendKind" value="ticketTop">リセット</button>
				</div>
			</form>
		</div>
	</main>
	<!--      フッター -->
	<footer class="footer">
		<p>© 2025 Phoenix Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>
