<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>選手詳細</title>
<link rel="stylesheet" href="../css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="../css/playerDetail.css">
<link rel="stylesheet" href="../css/style.css" />
</head>

<body>
    <!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/header.jsp" />
    
    <div class="container">
        <div class="player-detail">
            <!-- 左側: 選手サムネイル -->
            <div class="player-thumbnail">
                <img src="${player.image}" alt="選手サムネイル">
            </div>
            <!-- 右側: 選手詳細情報 -->
            <div class="player-info">
                <h2>選手詳細</h2>
				<p><strong>選手名:</strong> ${player.name}</p>
                <p><strong>フリガナ:</strong> ${player.kana}</p>
                <p><strong>生年月日:</strong> ${player.birthday}</p>
                <p><strong>身長:</strong> ${player.height}cm</p>
                <p><strong>体重:</strong> ${player.weight}kg</p>
                <p><strong>出身地:</strong> ${player.birth_place}</p>
                <p><strong>ポジション:</strong> ${player.position}</p>
                <p><strong>選手コメント:</strong> ${player.comment}</p>
                <p><strong>入団日:</strong> ${player.Date}</p>
                <p><strong>在籍状況:</strong> ${player.status_id}</p>
            </div>
        </div>
    </div>
    <!-- 戻るボタン -->
    <div class="back-button">
        <a href="player.jsp">戻る</a>
    </div>
    
    <!-- フッターを挿入 -->
	<jsp:include page="../inc/footer.jsp" />
    
</body>
</html>
