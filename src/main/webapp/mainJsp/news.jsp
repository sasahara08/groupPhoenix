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
  
<!--<ul class="news">-->
<!--    <c:forEach var="news" items="${newsList}">-->
<!--        <li class="news-content">-->
<!--            <form action="${pageContext.request.contextPath}/mainJsp/news" method="post" style="display:inline;">-->
<!--                <input type="hidden" name="id" value="${news.newsId}" />-->
<!--                <button type="submit" class="link-button">${news.title}</button>-->
<!--            </form>-->
<!--        </li>-->
<!--        <li class="news-content">-->
<!--            公開日: <span>${news.startAt}</span>-->
<!--        </li>-->
<!--    </c:forEach>-->
<!--</ul>-->
<!--下記追加分(更新日)-->
<ul class="news">
    <c:forEach var="news" items="${newsList}">
        <li class="news-content">
            公開日: <span>${news.startAt}</span>
            <form action="${pageContext.request.contextPath}/mainJsp/news" method="post" style="display:inline;">
                <input type="hidden" name="id" value="${news.newsId}" />
                <button type="submit" class="link-button">${news.title}</button>
            </form>
        </li>
    </c:forEach>
</ul>

  <br>
 <div class="back-one">
  <% if (session.getAttribute("user") != null) { %>
    <a href="<%= request.getContextPath() %>/mainJsp/memberTop.jsp" class="button1">TOP</a>
  <% } else { %>
    <a href="<%= request.getContextPath() %>/mainJsp/index.jsp" class="button1">TOP</a>
  <% } %>
</div> 

<!--  <div class="back-one">-->
<!--   <a href="${pageContext.request.contextPath}/mainJsp/news.jsp" class="back">TOP</a>-->
<!--  </div>-->
<!--   フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
</body>
</html>

