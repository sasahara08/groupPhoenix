<!-- 鐘ケ江 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>会員TOPページ</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css"
	media="all" />
<!-- slider.js -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/non-memberTop.css" />
</head>
<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/memberHeader.jsp" />
	<main>
		<!-- 動く画像のある行 -->
		<div class="container">
			<!-- 左空きスペース -->
			<div class="left-space">
				<p class="catchphrase">チケットを買おう。</p>
			</div>
			<!-- 右2/3スペース -->
			<div class="right-image">
				<!-- スライドショー上画像キャッチフレーズ -->
				<img class="right-image-logo"
					src="${pageContext.request.contextPath}/images/PhoenixTicketLogoBig.png"
					alt="画像" />
				<p class="right-image-text">最安値でチケットを買えるサイト</p>
				<!-- スライドショー画像 -->
				<div class="slide-container">
					<div class="slide-wrapper">
						<img class="slide"
							src="${pageContext.request.contextPath}/images/baseball.jpg"
							alt="画像" /> <img class="slide"
							src="${pageContext.request.contextPath}/images/batting.jpg"
							alt="画像" /> <img class="slide"
							src="${pageContext.request.contextPath}/images/nagaoka.jpg"
							alt="良い街" />
					</div>
					<div class="slide-wrapper">
						<img class="slide"
							src="${pageContext.request.contextPath}/images/baseball.jpg"
							alt="画像" /> <img class="slide"
							src="${pageContext.request.contextPath}/images/batting.jpg"
							alt="画像" /> <img class="slide"
							src="${pageContext.request.contextPath}/images/nagaoka.jpg"
							alt="良い街" />
					</div>
					<div class="slide-wrapper">
						<img class="slide"
							src="${pageContext.request.contextPath}/images/baseball.jpg"
							alt="画像" /> <img class="slide"
							src="${pageContext.request.contextPath}/images/batting.jpg"
							alt="画像" /> <img class="slide"
							src="${pageContext.request.contextPath}/images/nagaoka.jpg"
							alt="良い街" />
					</div>
				</div>
				<!-- <img src="/images/baseball.jpg" alt="画像" />
          <img src="/images/batting.jpg" alt="画像" /> -->
				<!-- 回転する画像 -->
				<img class="rotating-image"
					src="${pageContext.request.contextPath}/images/spinning.png"
					alt="回転する画像" />
			</div>
		</div>
		<!-- サイトの説明文 -->
		<div class="siteInfo">
			<img class="siteInfo-bg"
				src="${pageContext.request.contextPath}/images/baseballStadium.jpg"
				alt="スタジアム画像" />
			<div class="siteInfo-text">
				<h1 class="siteInfo-title">
					経済的に。<br />どこよりも安く買えるチケット
				</h1>
				<br /> <br />
				<p class="big-text">①浮いたお金を他で使える！</p>
				<br /> <br /> <br />
				<p class="big-text">②どこよりも安い！</p>
				<br /> <br /> <br />
				<p class="big-text">③座席の比較や口コミの確認が簡単！</p>
				<br /> <br /> <br />
				<p class="big-text">④足を運ぶ必要なし！</p>
				<br />
				<div class="siteInfo-button">
					<form action="${pageContext.request.contextPath}/GameListServlet" method="get">
						<button class="button2" type="submit">チケットを購入する</button>
					</form>
				</div>
			</div>
		</div>
		<!-- なんかフワっとする画像（フワちゃん） -->
		<div class="huwa-container">
			<img
				src="${pageContext.request.contextPath}/images/featured_image.jpg"
				alt="" loading="lazy" class="box" />
			<!-- 流れる文字 -->
			<div class="loop-wrap">
				<ul class="loop-area">
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
				</ul>
				<ul class="loop-area">
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
				</ul>
				<ul class="loop-area">
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
					<li class="content">&nbsp;BASEBALL.</li>
				</ul>
			</div>
		</div>
		<!-- ①スライダーバナー -->
		<h4>resent contents</h4>
		<div class="swiper sample-slider">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="${pageContext.request.contextPath}/images/bees.jpg" />
				</div>
				<div class="swiper-slide">
					<img src="${pageContext.request.contextPath}/images/dolphins.jpg" />
				</div>
				<div class="swiper-slide">
					<img src="${pageContext.request.contextPath}/images/flowers.jpg" />
				</div>
<!--				<div class="swiper-slide">-->
<!--					<img src="${pageContext.request.contextPath}/images/baseball.jpg" />-->
<!--				</div>-->
			</div>
			<div class="swiper-pagination"></div>
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>

		<!-- ②試合情報③チケット購入　横並び -->
		<div class="game-and-buyTicket">
			<!-- ③チケット購入 -->
			<div class="buy-ticket">
				<h4 class="ticket">game & buy ticket</h4>
				<form action="${pageContext.request.contextPath}/GameListServlet" method="get">
					<button class="ticket-button" type="submit">試合情報&チケット購入</button>
				</form>
			</div>
		</div>
		<!-- ④ニュース -->
		<h4>news</h4>
		<div class="news">
			<hr />
			<!-- ニュースリストが空でない場合 -->
			<c:if test="${not empty newsList}">
				<ul class="news-list">
					<c:forEach var="news" items="${newsList}">
						<!-- 日付の表示 -->
						<li><span class="news-date">${news.startAt}</span>
							<p class="news-title">${news.title}</p></li>
						<hr>
					</c:forEach>
				</ul>
			</c:if>
			<!-- ニュースリストが空の場合 -->
			<c:if test="${empty newsList}">
				<p>ニュースはありません</p>
			</c:if>

			<!-- ニュースを全部見るボタン -->
			<div class="news-all">
				<p>news all</p>
				<form action="${pageContext.request.contextPath}/news" method="get">
					<button class="news-all-button" type="submit">></button>
				</form>
			</div>
		</div>
		<!-- フード・グッズ -->
		<!-- ⑤選手紹介 -->
		<h4>player</h4>
		<div class="player-inf">
			<div class="image-container">
				<img class="left-img"
					src="${pageContext.request.contextPath}/images/kata.jpg"
					alt="Left Image" /> <img class="center-img"
					src="${pageContext.request.contextPath}/images/uezawa.jpg"
					alt="Center Image" /> <img class="right-img"
					src="${pageContext.request.contextPath}/images/tsumori.jpg"
					alt="Right Image" />
			</div>
		</div>
		<form action="${pageContext.request.contextPath}/PlayerServlet" method="get">
			<button class="button1" type="submit">選手紹介</button>
		</form>
		<!-- ⑥場所 -->
		<div class="hero">
			<div class="hero__bg"></div>
		</div>
		<div class="hero-container">
			<div class="slidein slide_right">
				<h5 class="location">location</h5>
				<p class="location-title">長浜PoyPoyドーム</p>
				<p class="location-text">2025年3月19日よりグランドオープン</p>
				<h3 class="location-title-sub">営業時間</h3>
				<p class="location-text">月~日（水曜除く） 11:00~17:00</p>
				<br />
				<h3 class="location-title-sub">店舗所在地</h3>
				<p class="location-text">
					〒810-0072 福岡県福岡市中央区<br /> 長浜1丁目4番13号 SF福岡ビル 6階
				</p>
				<div class="confirm-button">
					<a class="button2" href="https://maps.app.goo.gl/RExydBp71P7HY72X6" target="_blank" rel="noopener noreferrer">確認する</a>
				</div>
			</div>
		</div>
	</main>
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>