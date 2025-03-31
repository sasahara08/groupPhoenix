<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!-- 2:検索結果 -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>検索結果画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-ticket-search.css" />
</head>
<body>
	<!--     ヘッダー  -->
	<!-- ヘッダーを挿入 -->
    <jsp:include page="../inc/adminHeader.jsp" />
	<!-- ページタイトル -->
	<div class="main-title">
		<h1>管理画面</h1>
		<p class="sub">3.チケット情報管理</p>
	</div>
	<main>
		<!-- タイトル -->
		<div class="title">
			<br>
			<h3>チケット_検索結果</h3>
		</div>
		<!-- 検索結果の表示 -->
		<c:if test="${not empty ticketLists}">
			<c:forEach var="ticketList" items="${ticketLists}">
				<table>
					<!-- タイトル -->
					<tr class="blue">
						<th>試合ID</th>
						<th>試合日</th>
						<th>開始時間</th>
						<th>チーム(ホーム)</th>
						<th>チーム(アウェイ)</th>
						<th>場所</th>
						<th>操作</th>
					</tr>

					<!-- 1行目 -->
					<tr>
						<td>${ticketList.gameId}</td>
						<td>${ticketList.gameDate}</td>
						<td>${ticketList.startTime}</td>
						<td>${ticketList.homeTeamName}</td>
						<td>${ticketList.awayTeamName}</td>
						<td>${ticketList.stadium}</td>
						<td rowspan="3" class="green">
							<!-- 購入済またはリセール販売の場合 --> <c:if test="${ticketList.ticketStatus == '購入済' || ticketList.ticketStatus == 'リセール販売'}">&nbsp;-&nbsp;
    </c:if> <c:if test="${ticketList.ticketStatus == 'リセール購入済'}">
								<form action="${pageContext.request.contextPath}/AdminTicket" method="get" style="display: inline;">
									<button type="submit" name="sendKind" value="resaleTicketDeleteCheck">削除</button>
									<input type="hidden" name="ticketId" value="${ticketList.ticketId}"> <input type="hidden"
										name="orderDetailId" value="${ticketList.orderDetailId}">
								</form>
							</c:if>
						</td>
					</tr>
					<!-- 2行目 -->
					<tr class="orange">
						<th>チケットID</th>
						<th>チケット購入日</th>
						<th>会員ID</th>
						<th>名前</th>
						<th>ふりがな</th>
						<th>チケットステータス</th>
					</tr>
					<!-- 3行目 -->
					<tr>
						<td>${ticketList.ticketId}</td>
						<td>${ticketList.createAt}</td>
						<td>${ticketList.userId}</td>
						<td>${ticketList.name}</td>
						<td>${ticketList.kana}</td>
						<td>${ticketList.ticketStatus}</td>
					</tr>
				</table>
			</c:forEach>
		</c:if>
		<c:if test="${empty ticketLists}">
			<p>チケットデータがありません。</p>
		</c:if>
		<br>

		<!-- 戻るボタン -->
		<form action="${pageContext.request.contextPath}/AdminTicket" method="get" style="display: inline;">
			<button type="submit">戻る</button>
	</main>
	<!--      フッター -->
	<footer class="footer">
		<p>© 2025 Phoenix Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>
