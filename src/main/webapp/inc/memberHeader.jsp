<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- ヘッダー -->
<header>
	<div class="header_inline_block">
		<nav>
			<ul>
				<!-- ヘッダー左ロゴ -->
				<li><a href="index.jsp"> <img src="../images/PhoenixChicketLogo.png" alt="ロゴ兼Home">
				</a></li>
				<!-- ヘッダー右側 -->
				<div class="nav">
					<!-- ログアウト -->
					<li>
						<button onclick="location.href='logout.jsp'">ログアウト</button>
					</li>
					<!-- マイページ -->
					<li>
						<button onclick="location.href='myPage.jsp'">マイページ</button>
					</li>
				</div>
			</ul>
		</nav>
	</div>
</header>