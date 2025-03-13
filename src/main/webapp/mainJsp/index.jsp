<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>非会員TOPページ</title>
    <link rel="stylesheet" href="../css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="../css/style.css" />
    <link rel="stylesheet" href="../css/non-memberTop.css" />
  </head>
  <body>
     <!-- ヘッダーを挿入 -->
  <jsp:include page="../inc/header.jsp" />

    <!-- メインコンテンツ -->
    <main>
      <ul class="col3">
        <li>1</li>
      </ul>
      <div class="main-picture">
        <img src="../images/PhoenixChicketLogoBig.png" alt="TOP画面ロゴ" class="main-logo" />
      </div>
      <p class="sales-message">最安でチケットが買えるウェブサイト</p>
    </main>

  <!-- フッターを挿入 -->
  <jsp:include page="../inc/footer.jsp" />
  </body>
</html>
