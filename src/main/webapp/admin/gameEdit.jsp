<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>管理者画面-試合情報編集</title>
        <script src="<%=request.getContextPath()%>/js/adminGameEdit.js"></script>
        <link rel="stylesheet" href="javascript:void(0)">
    </head>

    <body>
        <h3>試合情報_編集</h3>

        <form class="gameAdd" action="/groupPhoenix/game" method="get">
            <div class="addForm">

                <div class="formItem">
                    <span>試合Id</span>
                    <span id="displayId"></span>
                    <input type="text" id="hiddenId" name="gameId" value="">
                </div>

                <div class="formItem">
                    <span>試合日</span>
                    <input type="date" id="gameDay" name="gameDay" value="">
                </div>

                <div class="formItem">
                    <span>試合開始時間</span>
                    <input type="time" id="gameTime" name="gameTime" value="">
                </div>

                <div class="formItem">
                        <span>チーム(ホーム)</span> <select name="homeTeam" id="homeTeam" required>
                        <option value="" selected>選択してください</option>
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.teamName}">${team.teamName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="formItem">
                        <span>チーム(アウェイ)</span> <select name="awayTeam" id="awayTeam" required>
                        <option value="" selected>選択してください</option>
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.teamName}">${team.teamName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="formItem">
                        <span>開催場所</span> <select name="stadium" id="stadium" required>
                            <c:forEach var="stadium" items="${stadiums}">
                                <option value="${stadium.stadiumsName}">${stadium.stadiumsName}</option>
                            </c:forEach>
                        </select>
                    </div>

            </div>

            <div class="addBtn">
                <input type="button" value="戻る" onclick="history.back()">
                <input type="submit" value="確認" name="edit">
                <input type="hidden" name="gamePage" value="editCheck">
            </div>

        </form>
    </body>

    </html>