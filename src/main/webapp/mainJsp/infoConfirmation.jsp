<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問い合わせ確認</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/infoConfirmation.css">
</head>
<body>
    <!-- ヘッダーを挿入 -->
    <jsp:include page="../inc/header.jsp" />
    <h1>問い合わせ確認</h1>
<div class="confirm-content">
    <!--        <p>以下の内容でよろしいですか？</p>-->
    <p><strong>氏名</strong> ${info.name}</p>
    <p><strong>メールアドレス</strong> ${info.email}</p>
    <p><strong>問い合わせ内容</strong></p>
    <textarea class="enclose">${info.inquiryText}</textarea>
</div>
    
    <div class="form-group-button">
    <!-- 修正されたフォーム -->
    
    <form action="info" method="post">
    <input type="hidden" name="name" value="${info.name}">
    <input type="hidden" name="email" value="${info.email}">
    
    <input type="hidden" name="message" value="${info.inquiryText}">
    <input type="hidden" name="action" value="complete"> <!-- 完了処理用のパラメータ -->

    <div class="form-group-button-second">
<!--        <button class="button1" onclick="history.back()">戻る</button>-->
        <a href="<%= request.getContextPath() %>/mainJsp/info.jsp" class="button2">戻る</a>
        <!-- <button type="submit" name="confirm" class="button1">確認</button> -->
        <button type="submit" class="button2">送信</button>
    </div>
</form>
    </div>


    <!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
</body>
</html>
