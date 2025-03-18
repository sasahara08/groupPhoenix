<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/news.css">
</head>
<body>
<!--  ヘッダーを挿入 -->
<jsp:include page="../inc/header.jsp" />

 <div class="sub">
  <h1>ＮＥＷＳ</h1>
  </div>
  <br>
<!--  <ul class="news">-->
<!--      <li class="news-content">24/11/27&nbsp; <a href="${pageContext.request.contextPath}/newsDetail.jsp?id=1">チケット購入におけるクレジットカード決済項目追加のお知らせ</a></li>-->
<!--      <li class="news-content">24/11/26&nbsp; <a href="${pageContext.request.contextPath}/newsDetail.jsp?id=2">システムメンテナンス時間延長のお知らせ</a></li>-->
<!--      <li class="news-content">24/11/23&nbsp; <a href="${pageContext.request.contextPath}/newsDetail.jsp?id=3">【2025年公式戦 特別割引チケット】販売情報</a></li>-->
<!--      <li class="news-content">24/10/28&nbsp; <a href="${pageContext.request.contextPath}/newsDetail.jsp?id=4">【11/17】選手トークショー開催！</a></li>-->
<!--  </ul>-->

<!--<ul class="news">-->
<!--    <li class="news-content">-->
<!--        24/11/27&nbsp;-->
<!--        <form action="${pageContext.request.contextPath}/NewsDetail" method="post" style="display:inline;">-->
<!--            <input type="hidden" name="id" value="1" />-->
<!--            <button type="submit" class="link-button">チケット購入におけるクレジットカード決済項目追加のお知らせ</button>-->
<!--        </form>-->
<!--    </li>-->
<!--    <li class="news-content">-->
<!--        24/11/26&nbsp;-->
<!--        <form action="${pageContext.request.contextPath}/NewsDetail" method="post" style="display:inline;">-->
<!--            <input type="hidden" name="id" value="2" />-->
<!--            <button type="submit" class="link-button">システムメンテナンス時間延長のお知らせ</button>-->
<!--        </form>-->
<!--    </li>-->
<!--        <li class="news-content">-->
<!--        24/11/26&nbsp;-->
<!--        <form action="${pageContext.request.contextPath}/NewsDetail" method="post" style="display:inline;">-->
<!--            <input type="hidden" name="id" value="3" />-->
<!--            <button type="submit" class="link-button">時間延長のお知らせ</button>-->
<!--        </form>-->
<!--    </li>-->
<!--        <li class="news-content">-->
<!--        24/11/26&nbsp;-->
<!--        <form action="${pageContext.request.contextPath}/NewsDetail" method="post" style="display:inline;">-->
<!--            <input type="hidden" name="id" value="4" /> -->
<!--            <button type="submit" class="link-button">システムメンテナンス</button>-->
<!--        </form>-->
<!--    </li>-->
<!--</ul>-->

<!--<ul class="news">-->
<!--    <li class="news-content">-->
<!--        24/11/27&nbsp;-->
<!--        <form action="${pageContext.request.contextPath}/NewsDetail" method="post" style="display:inline;">-->
<!--            <input type="hidden" name="id" value="${news.newsId}" />-->
<!--            <button type="submit" class="link-button">${news.title}</button>-->
<!--        </form>-->
<!--    </li>-->
<!--    <li class="news-content">-->
<!--        公開日&nbsp;-->
<!--        <span>${news.startAt}</span>-->
<!--    </li>-->
<!--</ul>-->

<ul class="news">
    <c:forEach var="news" items="${newsList}">
        <li class="news-content">
            <form action="${pageContext.request.contextPath}/news" method="post" style="display:inline;">
                <input type="hidden" name="id" value="${news.newsId}" />
                <button type="submit" class="link-button">${news.title}</button>
            </form>
        </li>
        <li class="news-content">
            公開日: <span>${news.startAt}</span>
        </li>
    </c:forEach>
</ul>



  <br>
  <div class="back-one">
   <a href="${pageContext.request.contextPath}/newsDetail.jsp" class="back">TOP</a>
  </div>
<!--   フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
</body>
</html>

