 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>ログインページ</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
 <body>
  <jsp:include page="/inc/header.jsp" />
 	<div class="login-container">
        <h1>ログイン</h1>
        
        <% if(request.getAttribute("errorMsg") != null) { %>
            <p class="error-message"><%= request.getAttribute("errorMsg") %></p>
        <% } %>
        
        <form action="${pageContext.request.contextPath}/member" method="post">
            <div class="form-group">
                <label for="email">メールアドレス:</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="pass">パスワード:</label>
                <input type="password" id="pass" name="pass" required>
            </div>
            
            <button type="submit" class="button">ログイン</button>
        </form>
    </div>
<jsp:include page="/inc/footer.jsp" />
 </body>
 </html>