<!-- 鐘ケ江 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>会員TOPページ</title>
<link rel="stylesheet" href="../css/html5reset-1.6.1.css" media="all" />
<!-- slider.js -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/non-memberTop.css" />
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
				<img class="right-image-logo" src="../images/PhoenixTicketLogoBig.png" alt="画像" />
				<p class="right-image-text">最安値でチケットを買えるサイト</p>
				<!-- スライドショー画像 -->
				<div class="slide-container">
					<div class="slide-wrapper">
						<img class="slide" src="../images/baseball.jpg" alt="画像" /> <img class="slide" src="../images/batting.jpg" alt="画像" />
						<img class="slide" src="../images/nagaoka.jpg" alt="良い街" />
					</div>
					<div class="slide-wrapper">
						<img class="slide" src="../images/baseball.jpg" alt="画像" /> <img class="slide" src="../images/batting.jpg" alt="画像" />
						<img class="slide" src="../images/nagaoka.jpg" alt="良い街" />
					</div>
					<div class="slide-wrapper">
						<img class="slide" src="../images/baseball.jpg" alt="画像" /> <img class="slide" src="../images/batting.jpg" alt="画像" />
						<img class="slide" src="../images/nagaoka.jpg" alt="良い街" />
					</div>
				</div>
				<!-- <img src="/images/baseball.jpg" alt="画像" />
          <img src="/images/batting.jpg" alt="画像" /> -->
				<!-- 回転する画像 -->
				<img class="rotating-image" src="../images/spinning.png" alt="回転する画像" />
			</div>
		</div>
		<!-- サイトの説明文 -->
		<div class="siteInfo">
			<img class="siteInfo-bg" src="../images/baseballStadium.jpg" alt="スタジアム画像" />
			<div class="siteInfo-text">
				<h1 class="siteInfo-title">
					経済的に。<br />どこよりも安く買えるチケット
				</h1>
				<br /> <br />
				<br /> <br />
				<p>格安サイトを利用することで、通常よりもはるかに低価格でチケットを購入できるため、旅行やイベントにかかる費用を大幅に節約できるだけでなく、
				その浮いたお金を他の楽しみや食事、観光などに充てることができ、より充実した時間を過ごせる可能性が広がります。</p>
				<br /> <br /> <br />
				<p>多くのサイトでは定期的に期間限定のセールや特別な割引クーポンが提供されているため、通常価格よりさらに安くチケットを手に入れるチャンスが多く、
				特に早期予約や直前割引などを活用すれば、驚くほどお得な価格で希望するチケットを確保できることがあります。</p>
				<br /> <br /> <br />
				<p>座席の比較や口コミの確認が簡単にできるため、利用者の評価やリアルな体験談を参考にしながら、自分の希望や予算に最も適した選択肢をじっくりと検討できるだけでなく、
				サイトによっては座席の詳細な位置情報や施設の雰囲気まで事前に把握することができ、より納得のいく購入が可能になります。</p>
				<br /> <br /> <br />
				<p>インターネットを通じて簡単にチケットを購入できるため、わざわざ店舗に足を運んで長時間待たされる心配がなく、スマートフォンやパソコンさえあれば、
				通勤中や自宅でくつろぎながらでも手軽に予約が完了し、時間と手間を大幅に削減できるという大きな利点があります。</p>
				<br /> <br /> <br />
				<div class="siteInfo-button">
				<a class="button2" href="../mainJsp/ticket.jsp">チケットを購入する</a>
				</div>
			</div>
		</div>
		<!-- なんかフワっとする画像（フワちゃん） -->
		<div class="huwa-container">
			<img src="../images/featured_image.jpg" alt="" loading="lazy" class="box" />
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
					<img src="../images/baseball.jpg" />
				</div>
				<div class="swiper-slide">
					<img src="../images/baseball.jpg" />
				</div>
				<div class="swiper-slide">
					<img src="../images/baseball.jpg" />
				</div>
				<div class="swiper-slide">
					<img src="../images/baseball.jpg" />
				</div>
			</div>
			<div class="swiper-pagination"></div>
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>

		<!-- ②試合情報③チケット購入　横並び -->
		<div class="game-and-buyTicket">

			<!-- ③チケット購入 -->
			<div class="buy-ticket">
				<h4 class="ticket">buy ticket</h4>
				<a class="ticket-button" href="../mainJsp/ticket.jsp">チケット購入</a>
			</div>
		</div>
		<!-- ④ニュース -->
		<h4>news</h4>
		<div class="news">
			<hr />
			<div class="news-number">
				<p>2025.03.01</p>
				<a class="news-number-button" href="★">初めてのおつかい（ゼリー編）</a>
			</div>
			<hr />
			<div class="news-number">
				<p>2025.02.28</p>
				<a class="news-number-button" href="★">青い空と白い雲</a>
			</div>
			<hr />
			<div class="news-number">
				<p>2025.02.26</p>
				<a class="news-number-button" href="★">絵の具の使い方について</a>
			</div>
			<hr />
			<div class="news-number">
				<p>2025.02.26</p>
				<a class="news-number-button" href="★">岩室</a>
			</div>
			<hr />
			<div class="news-all">
				<p>news all</p>
				<a class="news-all-button" href="../mainJsp/news.jsp">></a>
			</div>
		</div>
		<!-- フード・グッズ -->
		<!-- ⑤選手紹介 -->
		<h4>player</h4>
		<div class="player-inf">
			<div class="image-container">
				<img class="left-img" src="../images/kata.jpg" alt="Left Image" /> <img class="center-img" src="../images/uezawa.jpg"
					alt="Center Image" /> <img class="right-img" src="../images/tsumori.jpg" alt="Right Image" />
			</div>
		</div>
		<a class="button1" href="../mainJsp/player.jsp">選手紹介</a>
		<!-- ⑥場所 -->
		<div class="hero">
			<div class="hero__bg"></div>
		</div>
		<div class="hero-container">
			<div class="slidein slide_right">
				<h5 class="location">location</h5>
				<p class="location-title">長浜PoyPoyドーム</p>
				<br /> <br />
				<p class="location-text">2025年3月19日よりグランドオープン</p>
				<h3 class="location-title-sub">営業時間</h3>
				<p class="location-text">月~日（水曜除く） 11:00~17:00</p>
				<br />
				<h3 class="location-title-sub">店舗所在地</h3>
				<p class="location-text">
					〒810-0072 福岡県福岡市中央区<br /> 長浜1丁目4番13号 SF福岡ビル 6階
				</p>
				<div class="confirm-button">
					<a class="button2" href="https://maps.app.goo.gl/RExydBp71P7HY72X6">確認する</a>
				</div>
			</div>
		</div>
	</main>
	<!-- フッターを挿入 -->
	<jsp:include page="../inc/footer.jsp" />
	<script src="../js/script.js"></script>
</body>
</html>