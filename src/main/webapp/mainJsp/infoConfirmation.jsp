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
        <p>以下の内容でよろしいですか？</p>
        <p><strong>氏名:</strong> ${name}</p>
        <p><strong>メールアドレス:</strong> ${email}</p>
        <p><strong>問い合わせ内容:</strong> ${message}</p>
    </div>
    
    <div class="form-group-button">
    <!-- 修正されたフォーム -->
    <form action="Info" method="post">
        <input type="hidden" name="name" value="${name}">
        <input type="hidden" name="email" value="${email}">
        <input type="hidden" name="message" value="${message}">
        <input type="hidden" name="action" value="complete"> <!-- 完了処理用のパラメータ -->
        <button type="submit">送信</button>
    </form>
    <button class="back-button" onclick="history.back()">戻る</button>
</div>
    
    
<!--    <div class="form-group-button">-->
<!--        <form action="SubmitContactServlet" method="post">-->
<!--            <input type="hidden" name="name" value="${name}">-->
<!--            <input type="hidden" name="email" value="${email}">-->
<!--            <input type="hidden" name="message" value="${message}">-->
<!--            <button type="submit">送信</button>-->
<!--        </form>-->
<!--        <button class="back-button" onclick="history.back()">戻る</button>-->
<!--    </div>-->
    <!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
</body>
</html>
