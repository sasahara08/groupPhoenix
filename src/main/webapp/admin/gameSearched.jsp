<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="ja">

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <link rel="stylesheet" href="javascript:void(0)">
        </head>

        <body>

            <!-- ヘッダーを挿入 -->
            <jsp:include page="../inc/adminHeader.jsp" />

            <!-- 試合一覧 -->
            <h3>試合一覧</h3>

            <c:if test="${not empty games}">
                <div class="gameList">
                    <div class="ListHeader">
                        <span> 試合ID </span> <span> 試合日 </span> <span> 時間 </span> <span> チーム(ホーム) </span> <span>
                            チーム(アウェイ)
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
            </c:if>

            <c:if test="${empty games}">
                <p>試合データがありません。</p>
            </c:if>

            <!-- フッターを挿入 -->
            <jsp:include page="../inc/adminFooter.jsp" />

        </body>

        </html>