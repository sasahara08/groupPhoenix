<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!-- 1:チケット情報一覧 -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>チケット情報一覧</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-ticket.css" />
</head>
<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />
	
	<!-- タイトル -->
	<div class="title">
		<h2>
			管理画面<span class="subtitle">3.チケット情報管理</span>
		</h2>
	</div>
	
	<!-- チケット検索 -->
		<h3><u>チケット検索</u></h3>
		
		<div class="container">
		<h4>〇購入者情報</h4>
		<br>
			<!-- ★フォームタグ -->
			<form action="${pageContext.request.contextPath}/AdminTicket" method="post">

				<!-- 購入者情報 -->
				<table class="table_design08">
					<tr>
						<th>購入ステータス</th>
						<td><input type="radio" id="status02" name="purchaseStatus" value="2" checked> <label for="status02">購入済</label></td>
						<td><input type="radio" id="status03" name="purchaseStatus" value="3"> <label for="status03">リセール出品中</label></td>
						<td><input type="radio" id="status04" name="purchaseStatus" value="4"> <label for="status04">リセール購入済</label></td>
					</tr>
				</table>
				<br>
				<table class="table_design08">
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
				<div>
					<button type="submit" name="sendKind" value="ticketSearch">検索</button>
					<button type="reset" name="sendKind" value="ticketTop">リセット</button>
				</div>
			</form>
		</div>
			
			<!-- リセール購入者情報 -->
<!--			<form action="${pageContext.request.contextPath}/AdminTicket" method="post">-->
<!--				<h4>〇リセール購入者情報</h4>-->
<!--				<table>-->
<!--					<tr>-->
<!--						<th>購入ステータス</th>-->
<!--						<td><input type="radio" id="status04" name="resalePurchaseStatus" value="4" checked> <label-->
<!--							for="status04">リセール購入済</label></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--				<table>-->
<!--					<tr>-->
<!--						<th>チケットID</th>-->
<!--						<td><input type="text" placeholder="1" name="resaleTicketId"></td>-->
<!--					</tr>-->
<!--					<th>チケット購入日</th>-->
<!--					<td><input type="date" name="resaleTicketPurchaseDate"></td>-->
<!--					</tr>-->
<!--					<th>会員ID</th>-->
<!--					<td><input type="text" placeholder="1" name="resaleUserId"></td>-->
<!--					</tr>-->
<!--					<th>名前</th>-->
<!--					<td><input type="text" placeholder="山田太郎" name="resaleName"></td>-->
<!--					</tr>-->
<!--					<th>ふりがな</th>-->
<!--					<td><input type="text" placeholder="やまだたろう" name="resaleKana"></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--				<div>-->
<!--					<button type="submit" name="sendKind" value="resaleTicketSearch">検索</button>-->
<!--					<button type="reset" name="sendKind" value="ticketTop">リセット</button>-->
<!--				</div>-->
				<!-- 試合情報 -->
				
		<div class="container">		
			<h4>〇試合情報</h4>
				<br>
				<table class="table_design08">
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
					<!--					<tr>-->
					<!--						<th>試合ステータス</th>-->
					<!--						<td><input type="radio" id="gamestatus01" name="GameStatus" value="beforeGame"> <label-->
					<!--							for="gamestatus01">今後開催</label> <input type="radio" id="gamestatus02" name="GameStatus" value="finishedGame">-->
					<!--							<label for="gamestatus02">終了</label> <input type="radio" id="gamestatus03" name="GameStatus" value="all">-->
					<!--							<label for="gamestatus03">すべて</label></td>-->
					<!--					</tr>-->

				</table>
				<!-- 検索・リセットボタン -->
				<div class="btn">
					<button type="submit" name="sendKind" value="ticketSearch">検索</button>
					&nbsp;
					<button type="reset" name="sendKind" value="ticketTop">リセット</button>
				</div>
			</form>
		</div>
	
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />
</body>
</html>
