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
					<!-- ログイン -->
					<li>
						<button onclick="location.href='login.jsp'">ログイン</button>
					</li>
					<!-- 新規登録 -->
					<li>
						<button onclick="location.href='newMemberRegistration.jsp'">新規登録</button>
					</li>
				</div>
			</ul>
		</nav>
	</div>
</header>