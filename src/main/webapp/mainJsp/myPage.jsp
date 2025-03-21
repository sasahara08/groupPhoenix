<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.UserDTO" %>
<%
    // セッションからユーザー情報を取得
    LoginBean loginUser = (LoginBean) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>マイページ</title>
    <link rel="stylesheet" href="javascript:void(0)">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
  </head>
  <body>
    <jsp:include page="/inc/header.jsp" />
    <div class="container">
        <h1>メンバーページ</h1>
        
        <div class="welcome-message">
            <h2>ようこそ、<%= loginUser.getName() %>さん！</h2>
            <p>ユーザーID: <%= loginUser.getUserId() %></p>
        </div>
      
      <!-- 会員情報変更ボタン -->
      <form action="memberEditor.jsp" method="post">
          <button type="submit">会員情報変更</button>
      </form>

      <!-- マイチケットボタン -->
      <form action="ticket.jsp" method="post">
          <button type="submit">マイチケット</button>
      </form>

      <!-- TOPボタン -->
      <form action="member.jsp" method="post">
          <button type="submit">TOP</button>
      </form>
    </div>
    <jsp:include page="/inc/footer.jsp" />
  </body>
</html>
