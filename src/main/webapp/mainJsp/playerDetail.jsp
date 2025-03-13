<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>選手詳細</title>
    <link rel="stylesheet" href="playerDetail.css">
</head>
<body>
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
                <p><strong>フリガナ:</strong> ${player.furigana}</p>
                <p><strong>生年月日:</strong> ${player.birthDate}</p>
                <p><strong>年齢:</strong> ${player.age}歳</p>
                <p><strong>身長:</strong> ${player.height}cm</p>
                <p><strong>体重:</strong> ${player.weight}kg</p>
                <p><strong>出身地:</strong> ${player.hometown}</p>
                <p><strong>ポジション:</strong> ${player.position}</p>
                <p><strong>選手コメント:</strong> ${player.comment}</p>
                <p><strong>入団日:</strong> ${player.joinDate}</p>
                <p><strong>在籍状況:</strong> ${player.status}</p>
            </div>
        </div>
    </div>
    <!-- 戻るボタン -->
    <div class="back-button">
        <a href="player.jsp">戻る</a>
    </div>
</body>
</html>
