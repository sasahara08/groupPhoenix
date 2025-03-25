<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>確認画面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <style>
        .button-wrapper {
            display: flex;
            justify-content: space-between;
            width: 300px;
            margin: 0 auto;
        }
        .button-wrapper form {
            margin: 0;
        }
    </style>
</head>
<body>
    <jsp:include page="/inc/header.jsp" />
    <h1>新規会員登録 確認</h1>
    
    <p><strong>氏名:</strong> <%= request.getParameter("name") %></p>
    <p><strong>ふりがな:</strong> <%= request.getParameter("kana") %></p>
    <p><strong>生年月日:</strong> <%= request.getParameter("birthday") %></p>
    <p><strong>性別:</strong> <%= request.getParameter("gender") %></p>
    <p><strong>郵便番号:</strong> <%= request.getParameter("postcode") %></p>
    <p><strong>住所:</strong> <%= request.getParameter("address") %></p>
    <p><strong>電話番号:</strong> <%= request.getParameter("phone") %></p>
    <p><strong>メールアドレス:</strong> <%= request.getParameter("email") %></p>
    <p><strong>クレジットカード番号:</strong> <%= request.getParameter("creditcard") %></p>
    <p><strong>使用期限:</strong> <%= request.getParameter("expiry") %></p>
    <p><strong>セキュリティコード:</strong> <%= request.getParameter("securitycode") %></p>

    <form action="${pageContext.request.contextPath}/mainJsp/newUserComplete.jsp" method="post">
        <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
        <input type="hidden" name="kana" value="<%= request.getParameter("kana") %>">
        <input type="hidden" name="birthday" value="<%= request.getParameter("birthday") %>">
        <input type="hidden" name="gender" value="<%= request.getParameter("gender") %>">
        <input type="hidden" name="postcode" value="<%= request.getParameter("postcode") %>">
        <input type="hidden" name="address" value="<%= request.getParameter("address") %>">
        <input type="hidden" name="phone" value="<%= request.getParameter("phone") %>">
        <input type="hidden" name="email" value="<%= request.getParameter("email") %>">
        <input type="hidden" name="password" value="<%= request.getParameter("password") %>">
        <input type="hidden" name="expiry" value="<%= request.getParameter("expiry") %>">
        <input type="hidden" name="creditcard" value="<%= request.getParameter("creditcard") %>">
        <input type="hidden" name="securitycode" value="<%= request.getParameter("securitycode") %>">
        
        <button type="submit">登録</button>
    </form>
    
    <jsp:include page="/inc/footer.jsp" />
</body>
</html>
