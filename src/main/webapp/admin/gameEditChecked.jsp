<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>管理者画面-試合編集確認</title>
        <script src="<%= request.getContextPath() %>/js/adminGameAfterEdit.js"></script>
    </head>

    <body>
        <h3>試合情報_編集内容確認</h3>

        <div class="afterEditGame">
            <h4>編集後</h4>
            <div class="contentsForm">
                <div class="contentsItem"><span>試合ID</span><span id="displayId"></span></div>
                <div class="contentsItem"><span>試合日</span><span id="displayDate"></span></div>
                <div class="contentsItem"><span>試合開始時間</span><span id="displayTime"></span></div>
                <div class="contentsItem"><span>チーム(ホーム)</span><span id="displayHomeTeam"></span></div>
                <div class="contentsItem"><span>チーム(アウェイ)</span><span id="displayAwayTeam"></span></div>
                <div class="contentsItem"><span>開催場所</span><span id="displayStadium"></span></div>
            </div>
        </div>

        <div class="beforeEditGame">
            <h4>編集前</h4>
            <div class="contentsForm">
                <div class="contentsItem"><span>${games.game_id}</span></div>
                <div class="contentsItem"><span>${games.game_date}</span></div>
                <div class="contentsItem"><span>${games.start_time}</span></div>
                <div class="contentsItem"><span>${games.homeTeam.team_name}</span></div>
                <div class="contentsItem"><span>${games.awayTeam.team_name}</span></div>
                <div class="contentsItem"><span>${games.stadiums.stadiums_name}</span></div>
            </div>
        </div>

        <form class="editComplete" action="/groupPhoenix/game" method="post">
            <input type="hidden" id="gameId" name="gameId" value="">
            <input type="hidden" id="gameDay" name="gameDay" value="">
            <input type="hidden" id="gameTime" name="gameTime" value="">
            <input type="hidden" id="homeTeam" name="homeTeam" value=${games.home_team_id}>
            <input type="hidden" id="awayTeam" name="awayTeam" value=${games.away_team_id}>
            <input type="hidden" id="stadium" name="stadium" value=${games.stadium_id}>

            <input type="hidden" name="gamePage" value="editComplete">

            <input type="submit" value="登録" name="editComplete">
            <input type="button" value="修正" onclick="history.back()">
        </form>
    </body>

    </html>