<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="ja">

        <head>
            <meta charset="UTF-8">
            <title>管理者画面-試合情報一覧</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admingame.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminSale.css" />

        </head>

        <body>
            <!-- ヘッダーを挿入 -->
            <jsp:include page="../inc/adminHeader.jsp" />


            <!-- 試合検索フォーム -->
            <div class="searchForm">
                <form class="gameSearch" action="/groupPhoenix/game" method="post">
                    <h3>試合検索</h3>

                    <div class="formItem">
                        <label for="gameId">試合ID</label> <input type="text" name="gameId">
                    </div>

                    <div class="formItem">
                        <label for="gameDay">試合日</label> <input type="date" name="gameDay">
                    </div>

                    <div class="formItem">
                        <label for="homeTeam">チーム(ホーム)</label> <select name="homeTeam" id="homeTeam">
                            <option value="" selected>選択してください</option>
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.teamName}" name="homeTeam">${team.teamName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="formItem">
                        <label for="awayTeam">チーム(アウェイ)</label> <select name="awayTeam" id="awayTeam">
                            <option value="" selected>選択してください</option>
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.teamName}" name="awayTeam">${team.teamName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="formItem">
                        <label for="stadium">開催場所</label> <select name="stadium" id="stadium">
                            <c:forEach var="stadium" items="${stadiums}">
                                <option value="${stadium.stadiumsName}">${stadium.stadiumsName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="formItem">
                        <label for="status">試合ステータス</label> すべて <input type="radio" id="all" name="status" value="all">
                        今後開催 <input type="radio" name="status" value="all"> 終了 <input type="radio" name="status"
                            value="all"> <input type="hidden" name="gamePage" value="search">
                    </div>

                    <div class="searchBtn">
                        <input type="reset" value="reset">&nbsp; <input type="submit" name="search" value="検索">
                    </div>
                </form>
            </div>


            <!-- ここから試合追加フォーム -->
            <div class="addForm">
                <form class="gameAdd" action="/groupPhoenix/game" method="get">
                    <h3>試合追加</h3>

                    <div class="formItem">
                        <label for="gameDay">試合日</label> <input type="date" name="gameDay" required>
                    </div>

                    <div class="formItem">
                        <label for="gameTime">試合時間</label> <input type="time" name="gameTime" required>
                    </div>

                    <div class="formItem">
                        <label for="homeTeam">チーム(ホーム)</label> <select name="homeTeam" id="homeTeam" required>
                            <option value="" selected>選択してください</option>
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.teamName}">${team.teamName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="formItem">
                        <label for="awayTeam">チーム(アウェイ)</label> <select name="awayTeam" id="awayTeam" required>
                            <option value="" selected>選択してください</option>
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.teamName}">${team.teamName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="formItem">
                        <label for="awayTeam">開催場所</label> <select name="stadium" id="stadium" required>
                            <c:forEach var="stadium" items="${stadiums}">
                                <option value="${stadium.stadiumsName}">${stadium.stadiumsName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="addBtn">
                        <input type="reset" value="reset">&nbsp; <input type="submit" value="追加" name="add"> <input
                            type="hidden" name="gamePage" value="addCheck">
                    </div>
                </form>
            </div>



            <!-- 試合一覧 -->
            <div class="gameList">
                <h3>試合一覧</h3>
                <div class="ListHeader">
                    <table class="table_design08">
                        <thead>
                            <tr>
                                <th>試合ID</th>
                                <th>試合日</th>
                                <th>時間</th>
                                <th>チーム(ホーム)</th>
                                <th>チーム(アウェイ)</th>
                                <th>場所</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="game" items="${games}">
                                <tr>
                                    <td data-label="試合ID">${game.gameId}</td>
                                    <td data-label="試合日">${game.gameDate}</td>
                                    <td data-label="時間">${game.startTime}</td>
                                    <td data-label="チーム(ホーム)">${game.homeTeamName}</td>
                                    <td data-label="チーム(アウェイ)">${game.awayTeamName}</td>
                                    <td data-label="場所">${game.stadium}</td>

                                    <td>
                                        <div>
                                            <form action="/groupPhoenix/game" method="get" class="inline-form">
                                                <input type="hidden" name="editGameId" value="${game.gameId}"> <input type="hidden" name="editGameDate"
                                                    value="${game.gameDate}"> <input type="hidden" name="editGameTime" value="${game.startTime}"> <input
                                                    type="hidden" name="editHomeTeam" value="${game.homeTeamName}">
                                                <input type="hidden" name="editAwayTeam" value="${game.awayTeamName}">
                                                <input type="hidden" name="editStadiumName" value="${game.stadium}">
                                                <input type="hidden" name="gamePage" value="edit">
                                                <input type="submit" value="編集" name="edit">
                                            </form>
                                    
                                            <form action="/groupPhoenix/game" method="get" class="inline-form">
                                                <input type="hidden" name="gameId" value="${game.gameId}"> <input type="hidden" name="gameDate"
                                                    value="${game.gameDate}"> <input type="hidden" name="gameTime" value="${game.startTime}"> <input
                                                    type="hidden" name="homeTeam" value="${game.homeTeamName}"> <input type="hidden" name="awayTeam"
                                                    value="${game.awayTeamName}">
                                                <input type="hidden" name="stadiumName" value="${game.stadium}">
                                                <input type="hidden" name="gamePage" value="delete"> 
                                                <c:if test="${game.gameDeleteAt != null}">
                                               <input type="button" value="削除" name="delete" style="background-color: gray;">
                                                </c:if>
                                                
                                                <c:if test="${game.gameDeleteAt == null}">
                                                <input type="submit" value="削除" name="delete">
                                                </c:if>
                                            </form>
                                        </div>
                                    </td>
                                </tr>

                                <c:if test="${game.gameDeleteAt != null}">
                                    <tr>
                                        <td colspan="7" class="deleted-message">試合情報は削除されています</td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


            <!-- フッターを挿入 -->
            <footer class="footer">
                <p>© 2025 Phoenix Inc. All Rights Reserved.</p>
            </footer>
        </body>

        </html>