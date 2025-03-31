<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>管理者画面-試合追加確認</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admingame.css" />
    </head>

    <body>
    <!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/adminHeader.jsp" />
    
	<!-- 追加試合 内容確認 -->
		<div class="addForm">
        <h3>追加試合情報の内容確認</h3>
        <form class="gameAdd" action="/groupPhoenix/game" method="post">
            
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

            <div class="addBtn">
                <input type="hidden" id="hiddenStatus" name="gamePage" value="addComplete">
                <input type="button" value="戻る" onclick="history.back()">
                &nbsp;
                <input type="submit" value="追加" name="add">
            </div>

        </form>
        </div>

    <script src="<%= request.getContextPath() %>/js/adminGameAddCheck.js"></script>
    
    <!-- フッターを挿入 -->
	<jsp:include page="../inc/adminFooter.jsp" />
    
    </body>
    </html>