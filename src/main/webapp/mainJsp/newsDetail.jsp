<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${news.title}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/newsDetail.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
     <!-- ヘッダーを挿入 -->
  <jsp:include page="../inc/header.jsp" />
  
 <div class="sub">
  <h1 class="ticket">${news.title}</h1>
 </div>
 <br>
 <div class="content">
  <p>${news.mainText}</p>
  <p><small>公開日: ${news.startAt}</small></p>
  <p><small>更新日: ${news.updatedAt}</small></p>
 </div>
 <br>
 <div class="back-second">
  <a href="${pageContext.request.contextPath}/news" class="back">戻る</a>
 </div>
 
   <!-- フッターを挿入 -->
   <jsp:include page="../inc/footer.jsp" />
</body>
</html>
