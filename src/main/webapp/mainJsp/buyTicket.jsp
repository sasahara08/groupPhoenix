<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Game"%>
<%@ page import="dto.Ticket"%>
<%@ page import="dao.TicketDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>チケット購入 選択</title>
<link rel="stylesheet" href="game.css" />
<link rel="stylesheet" href="html5reset-1.6.1.css" />
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<main>
		<h1>座席と枚数を選択する</h1>
		
                    <div class="tickets">
						<p>試合日: ${ticket.gameDate}</p>
						<p>開始時間: ${ticket.startTime}<</p>
						<p>対戦チーム: ${ticket.homeTeamName} vs ${ticket.awayTeamName}</p>
						<p>試合場所: ${ticket.stadiumName}</p>
					</div>

<form ticket="${pageContext.request.contextPath}/GameListServlet" method="post" onsubmit="saveData()">
		<div class="box2">
			<label class="selectbox-3">
				<p>
					 <label for="quantity">枚数を選択する </label>
					 <select id="quantity" name="quantity">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</p>
			</label>
		</div>

		<div class="box2">
			<label class="selectbox-3">
				<p>
						<label for="seatid">座席を選択する  </label>
						<select id="seatid" name="seatid">
						<option value="1">外野応援席</option>
						<option value="2">内野指定席</option>
						<option value="3">バックネット側指定席</option>
					</select>
				</p>
			</label>
		</div>
		<div class="button99">
		
                       <button type="button2" name="ticket" value="game">戻る</button>
					
                        <input type="hidden" name="ticket" value="buyTicketConfirm"/>	
                        <input type="hidden" name="gameId" value="${game.gameId}" />
                       <button type="button1" class="link-button">確認する</button>
        </form>
		</div>
	</main>
</body>
</html>
