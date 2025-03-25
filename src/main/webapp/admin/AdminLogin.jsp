<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="ja">

        <head>
            <meta charset="UTF-8">
            <title>管理者画面-ログイン画面</title>
            <link rel="stylesheet" href="javascript:void(0)">
        </head>

        <body>
            <!-- ヘッダーを挿入 -->
            <jsp:include page="../inc/adminHeader.jsp" />

            <div class="main">

                <h3>管理者ログイン</h3>

                <c:if test="${not empty errorMessage}">
                    <div style="color: tomato;">${errorMessage}</div>
                </c:if>

                <form action="${pageContext.request.contextPath}/AdminLogin" method="post">
                    <input type="text" name="username" placeholder="管理者名">
                    <input type="password" name="password" placeholder="パスワード">
                    <input type="submit" value="ログイン">
                </form>

            </div>

            <!-- フッターを挿入 -->
            <jsp:include page="../inc/adminFooter.jsp" />
        </body>

        </html>