<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>管理者画面-試合削除確認</title>
        <script src="<%= request.getContextPath() %>/js/adminGameAfterEdit.js"></script>
    </head>

    <body>
        <div class="beforeEditGame">
            <h4>削除する試合情報の確認</h4>
            <div class="contentsForm">
                <div class="contentsItem"><span id="displayId"></span></div>
                <div class="contentsItem"><span id="displayDate"></span></div>
                <div class="contentsItem"><span id="displayTime"></span></div>
                <div class="contentsItem"><span id="displayHomeTeam"></span></div>
                <div class="contentsItem"><span id="displayAwayTeam"></span></div>
                <div class="contentsItem"><span id="displayStadiumName"></span></div>
            </div>
        </div>

        <form class="editComplete" action="/groupPhoenix/game" method="post">
            <input type="hidden" name="gameId" value="">

            <input type="hidden" name="gamePage" value="deleteComplete">

            <input type="submit" value="削除" name="deleteComplete">
            <input type="button" value="戻る" onclick="history.back()">
        </form>
    </body>

    </html>