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
            <form class="gameSearch" action="/groupPhoenix/game" method="post">
                <h3>試合検索</h3>
                <div class="searchForm">

                    <div class="formItem">
                        <span>試合ID</span> <input type="text" name="gameId">
                    </div>

                    <div class="formItem">
                        <span>試合日</span> <input type="date" name="gameDay">
                    </div>

                    <div class="formItem">
                        <span>チーム(ホーム)</span> <select name="homeTeam" id="homeTeam">
                        <option value="" selected>選択してください</option>
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.teamName}" name="homeTeam">${team.teamName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="formItem">
                        <span>チーム(アウェイ)</span> <select name="awayTeam" id="awayTeam">
                        <option value="" selected>選択してください</option>
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.teamName}" name="awayTeam">${team.teamName}</option>
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

                    <div class="formItem">
                        <span>試合ステータス</span> <label for="all">すべて</label> <input type="radio" id="all" name="status"
                            value="all"> <label for="beforeGame">今後開催</label> <input type="radio" name="status"
                            value="all"> <label for="afterGame">終了</label>
                        <input type="radio" name="status" value="all"> <input type="hidden" name="gamePage"
                            value="search">
                    </div>

                </div>

                <div class="searchBtn">
                    <input type="reset" value="reset"> <input type="submit" name="search" value="検索">
                </div>

            </form>

            <!-- ここから試合追加フォーム -->
            <h3>試合追加</h3>
            <form class="gameAdd" action="/groupPhoenix/game" method="get">
                <div class="addForm">

                    <div class="formItem">
                        <span>試合日</span> <input type="date" name="gameDay" required>
                    </div>

                    <div class="formItem">
                        <span>試合時間</span> <input type="time" name="gameTime" required>
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

                            <span> ${game.gameId} </span>

                            <span> ${game.gameDate} </span>

                            <span> ${game.startTime} </span>

                            <span> ${game.homeTeamName} </span>

                            <span> ${game.awayTeamName} </span>

                            <span> ${game.stadium} </span>
                            
                            <c:if test="${game.gameDeleteAt != null}">
                            <span style="color:tomato;">試合情報は削除されています</span>
                            </c:if>

                            <div>
                                <form action="/groupPhoenix/game" method="get">
                                    <input type="hidden" name="editGameId" value="${game.gameId}">
                                    <input type="hidden" name="editGameDate" value="${game.gameDate}">
                                    <input type="hidden" name="editGameTime" value="${game.startTime}">
                                    <input type="hidden" name="editHomeTeam" value="${game.homeTeamName}">
                                    <input type="hidden" name="editAwayTeam" value="${game.awayTeamName}">
                                    <input type="hidden" name="editStadiumName" value="${game.stadium}">

                                    <input type="hidden" name="gamePage" value="edit">
                                    <input type="submit" value="編集" name="edit">
                                </form>

                                <form action="/groupPhoenix/game" method="get">
                                    <input type="hidden" name="gameId" value="${game.gameId}">
                                    <input type="hidden" name="gameDate" value="${game.gameDate}">
                                    <input type="hidden" name="gameTime" value="${game.startTime}">
                                    <input type="hidden" name="homeTeam" value="${game.homeTeamName}">
                                    <input type="hidden" name="awayTeam" value="${game.awayTeamName}">
                                    <input type="hidden" name="stadiumName" value="${game.stadium}">

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