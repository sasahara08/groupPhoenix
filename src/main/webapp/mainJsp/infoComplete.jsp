<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>送信完了</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}//css/infoComplete.css">
   </head>
<body>
    <!-- ヘッダーを挿入 -->
    <jsp:include page="../inc/header.jsp" />

<!--    <h1>問い合わせが完了しました</h1>-->
<!--    <div class="complete-content">-->
<!--        <p>お問い合わせいただき、ありがとうございます。</p>-->
<!--        <p>内容を確認次第、担当者よりご連絡いたします。</p>-->
<!--        <p>引き続きよろしくお願いいたします。</p>-->
<!--    </div>-->


<div class="complete-content">
    <h2 class="contact_us">問い合わせが完了しました</h2>
    <ul>
        <c:forEach var="inquiry" items="${inquiriesList}">
            <li>
                <strong>ID:</strong> ${inquiry.inquiryId} <br>
                <strong>ユーザーID:</strong> ${inquiry.userId} <br>
                <strong>作成日時:</strong> ${inquiry.createdAt} <br>
                <strong>問い合わせ内容:</strong> ${inquiry.inquiryText} <br>
                <strong>回答:</strong> ${inquiry.responseText} <br>
                <strong>回答日時:</strong> ${inquiry.responseAt} <br>
            </li>
        </c:forEach>
    </ul>
</div>

    <div class="back-to-top">
<!--        <a href="${pageContext.request.contextPath}/mainJsp/index.jsp" class="back-button">TOPへ戻る</a>-->
        <a href="${pageContext.request.contextPath}/mainJsp/index.jsp" class="button1">TOP</a>
    </div>

    <!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
</body>
</html>
