<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>選手紹介</title>
    <link rel="stylesheet" href="player.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>選手紹介</h1>            
        </div>
        <div class="players-grid">
            <!-- 選手データ -->
            <div class="player-card">
				<div class="player-info">
					<p> ヤマダ タロウ</p>
					     <a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
					        <img src="player1.jpg" alt="player1のサムネイル">
						</a>
                    <p>キャッチャー</p>
                </div>
            </div>
            <div class="player-card">
				<div class="player-info">
					<p>サトウ ハナコ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
					        <img src="player2.jpg" alt="player2のサムネイル">
						</a>
					<p>ファースト</p>
                </div>
            </div>
			<div class="player-card">
				<div class="player-info">
					<p>タナカ ジロウ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
								    	<img src="player3.jpg" alt="player3のサムネイル">
						</a>
					<p>セカンド</p>
			    </div>
			</div>
			<div class="player-card">
				<div class="player-info">
					<p>ワタナベ サブロウ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player4.jpg" alt="player4のサムネイル">
						</a>
					<p>サード</p>
			    </div>
			</div>
			<div class="player-card">
				<div class="player-info">
					<p>マイケル アベ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player3.jpg" alt="player5のサムネイル">
						</a>
			        <p>ショート</p>
			    </div>
			</div>
			<div class="player-card">
				<div class="player-info">
					<p>トニー ラマ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player1.jpg" alt="player6のサムネイル">
						</a>
			        <p>ライト</p>
			    </div>
			</div>
			<div class="player-card">				
				<div class="player-info">
					<p> フリーザ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player4.jpg" alt="player7のサムネイル">
						</a>
					<p>センター</p>
			    </div>
			</div>
			<div class="player-card">
				<div class="player-info">
					<p>ピッコロ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player3.jpg" alt="player8のサムネイル">
						</a>
			        <p>レフト</p>
			    </div>
			</div>
			<div class="player-card">
				<div class="player-info">
					<p> ヤムチャ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player3.jpg" alt="player9のサムネイル">
						</a>
			        <p>ピッチャー</p>
			    </div>
			</div>
			<div class="player-card">
				<div class="player-info">
					<p>テンシンハン</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player4.jpg" alt="player10のサムネイル">
						</a>
			        <p>レフト</p>
			    </div>
			</div>
			<div class="player-card">
				<div class="player-info">
					<p>カカロット</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player2.jpg" alt="player11のサムネイル">
						</a>
			        <p>センター</p>
			    </div>
			</div>
			<div class="player-card">
				<div class="player-info">
					<p>チャオズ</p>
						<a href="playerDetail.jsp"> <!-- 個別選手ページへのリンク -->
							<img src="player3.jpg" alt="player12のサムネイル">
						</a>
			        <p>ファースト</p>
			    </div>
			</div>						
			
            <!-- 以下、架空選手のデータを繰り返し -->
        </div>
    </div>
	<!-- TOPページボタン -->
	<div class="top-page-button">
	    <a href="memberTop.jsp">TOPページ</a>
	</div>

</body>
</html>
