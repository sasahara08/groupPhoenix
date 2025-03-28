<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSTLコアタグの指定 -->

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>選手詳細</title>
    <!-- CSSファイルの動的なパス指定 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/playerDetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>

<body>
    <!-- ヘッダーを挿入 -->
	<%@ include file="/inc/header.jsp" %>

   
    <div class="container">
        <!-- 中央上に表示するタイトル -->
        <h1 class="player-title">選手詳細</h1>
        <div class="player-detail">
            <!-- 左側: 選手サムネイル -->
            <div class="player-thumbnail">
                <img src="${pageContext.request.contextPath}/images/${player.image}" alt="${player.name}のサムネイル" />
            </div>
            <!-- 右側: 選手詳細情報 -->
            <div class="player-info">
                <p><strong>選手名:</strong>  ${player.name}</p>
                <p><strong>フリガナ:</strong>  ${player.kana}</p>
                <p><strong>生年月日:</strong>  ${player.birthday}</p>
                <p><strong>年齢:</strong>  ${player.age}歳</p>
                <p><strong>身長:</strong>  ${player.height}cm</p>
                <p><strong>体重:</strong>  ${player.weight}kg</p>
                <p><strong>出身地:</strong>  ${player.birthPlace}</p>
                <p><strong>ポジション:</strong>  ${player.position}</p>
                <p><strong>選手コメント:</strong>  ${player.comment}</p>
                <p><strong>入団日:</strong>  ${player.joinedAt}</p>
                <p><strong>在籍状況:</strong>  ${player.playerStatus}</p>
            </div>
        </div>
    </div>
	<!-- 戻るボタン -->
	<div class="back">
		<a href="${pageContext.request.contextPath}/PlayerServlet?action=list" class="button1">　戻る　</a>
	</div>
			   <!-- フッターを挿入 -->
   <jsp:include page="../inc/footer.jsp" />
</body>
</html>

