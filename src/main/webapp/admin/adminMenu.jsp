<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8" />
    <title>管理者画面-Top</title>
    <link rel="stylesheet" href="javascript:void(0)" />
    <link rel="stylesheet" href="../css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="../css/adminheader.css" />
    <link rel="stylesheet" href="../css/adminfooter.css" />
    <link rel="stylesheet" href="../css/adminmenu.css" />
  </head>
  <body>
    <!-- ヘッダーを挿入 -->
    <header>
      <h1><a href="#" class="logo">Phoenix管理画面</a></h1>
      <!--		未ログイン時は「ログイン」、ログイン時は「ログアウト」-->
      <button type="logout" class="logout-button">ログアウト</button>
    </header>

    <div class="adminMenu">
      <h3>管理画面<br />TOP</h3>
      
      <a href="#" class="button25">1.会員情報管理</a>
      <a href="#" class="button25">2.試合情報管理</a>
      <a href="#" class="button25">3.チケット情報管理</a>
      <a href="#" class="button25">4.売上管理</a>
      <a href="#" class="button25">5.フード/グッズ管理</a>
      <a href="#" class="button25">6.選手情報管理</a>
      <a href="#" class="button25">7.NEWS情報管理</a>
      <a href="#" class="button25">8.問い合わせ管理</a>
      <a href="#" class="button25">9.管理情報</a>
    </div>

    <!-- フッターを挿入 -->
    <footer class="footer">
      <p>© 2025 Phoenix Inc. All Rights Reserved.</p>
    </footer>
  </body>
</html>
