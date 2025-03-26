<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問い合わせ</title>
<!--<link rel="stylesheet" href="../css/html5reset-1.6.1.css" media="all" />-->
<!--<link rel="stylesheet" href="../css/style.css" />-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/info.css">
</head>
<body>
     <!-- ヘッダーを挿入 -->
  <jsp:include page="../inc/header.jsp" />
 <h1>問い合わせ</h1>
<!-- <form action="ContactServlet" method="post">-->
<!--<form action="${pageContext.request.contextPath}/controller/Info" method="post">-->
<form action="${pageContext.request.contextPath}/mainJsp/info" method="post">
    <div class="form-group">
        <label for="name">氏名</label>
        <input type="text" id="name" name="name" required>
    </div>
    <div class="form-group">
        <label for="email">メールアドレス</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div class="form-group">
        <label for="confirm-email">メールアドレス（確認）</label>
        <input type="email" id="confirm-email" name="confirm-email" required>
    </div>
    <div class="form-group reverse-label-textarea">
        <label for="message">問い合わせ内容</label>
        <textarea id="message" name="message" rows="5" required></textarea>
    </div>
<!--    <div class="form-group-button">-->
<!--        <button type="submit" name="confirm">確認</button>  -->
<!--        <button class="back-button" type="button" onclick="resetForm()">クリア</button>-->
<!--    </div>-->
    
    <div class="form-group-button">
        <button type="submit" name="confirm" class="button1">確認</button>  
        <button type="button" class="button1 back-button" onclick="resetForm()">クリア</button>
    </div>
 </form>
    <!-- フッターを挿入 -->
   <jsp:include page="../inc/footer.jsp" />
   <script>
   
 function resetForm() {
    document.querySelector('form').reset();
 }
</script>
</body>
</html>
