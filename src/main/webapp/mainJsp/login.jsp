<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ログインページ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
    <jsp:include page="/inc/header.jsp" />
    <br>
    <main>
    <div class="login-container">
        <h1>ログイン</h1>

        <% if(request.getAttribute("errorMsg") != null) { %>
            <p class="error-message"><%= request.getAttribute("errorMsg") %></p>
        <% } %>

		<div class="form">
        <form action="${pageContext.request.contextPath}/MemberTopServlet" method="get">
            <table>
            <tr>
                <th><label for="email">メールアドレス:</label></th>
                <td><input type="email" id="email" name="email" required></td>
                </tr>
			<br>
            <tr>
                <th><label for="pass">パスワード:</label></th>
                <td><input type="password" id="pass" name="password" required></td>  <!-- 修正: name属性を"password"に統一 -->
                </tr>
            </table>
            </div>
			<br>
            <button type="submit" class="button2">ログイン</button>
        </form>
        <br>
    </div>
    </main>
    <jsp:include page="/inc/footer.jsp" />
</body>
</html>
