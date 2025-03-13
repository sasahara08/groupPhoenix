<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>管理者画面-試合追加確認</title>
        <script src="<%= request.getContextPath() %>/js/adminGameAddCheck.js"></script>
    </head>

    <body>
        <h3>追加試合情報の内容確認</h3>
        <form class="gameAdd" action="/game" method="post">
            <div class="addForm">

                <div class="formItem">
                    <span>試合日</span>
                    <span id="displayDay"></span>
                    <input type="hidden" id="hiddenDay" name="hiddenDay" value="">
                </div>

                <div class="formItem">
                    <span>試合時間</span>
                    <span id="displayTime"></span>
                    <input type="hidden" id="hiddenTime" name="hiddenTime" value="">
                </div>

                <div class="formItem">
                    <span>チーム(ホーム)</span>
                    <span id="displayHomeTeam"></span>
                    <input type="hidden" id="hiddenHomeTeam" name="hiddenHomeTeam" value="">
                </div>

                <div class="formItem">
                    <span>チーム(アウェイ)</span>
                    <span id="displayAwayTeam"></span>
                    <input type="hidden" id="hiddenAwayTeam" name="hiddenAwayTeam" value="">
                </div>

                <div class="formItem">
                    <span>開催場所</span>
                    <span id="displayStadium"></span>
                    <input type="hidden" id="hiddenStadium" name="hiddenStadium" value="">
                </div>

                <div class="formItem">
                    <span>試合ステータス</span>
                    <span id="displayStatus"></span>
                    <input type="hidden" id="hiddenStatus" name="hiddenStatus" value="">
                </div>

            </div>

            <div class="addBtn">
                <input type="button" value="戻る" onclick="history.back()">
                <input type="submit" value="追加" name="add">
            </div>

        </form>


    </body>

    </html>