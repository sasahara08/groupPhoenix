<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 
</head>
<body>
	<script>
        // フォームをクリアする関数
        function clearForm() {
            document.getElementById("memberForm").reset();
        }
    </script>
</head>
<body>
	<h1>会員情報編集</h1>
    
    <form id="memberForm" action="memberEditorConfirmation.jsp" method="post">
        <p>
            <label for="name">氏名：</label>
            <input type="text" id="name" name="name" value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>" >
        </p>
        <p>
            <label for="kana">ふりがな：</label>
            <input type="text" id="kana" name="kana" value="<%= request.getParameter("kana") != null ? request.getParameter("kana") : "" %>" >
        </p>
        <p>
            <label for="birthday">生年月日：</label>
            <input type="date" id="birthday" name="birthday" value="<%= request.getParameter("birthday") != null ? request.getParameter("birthday") : "" %>" >
        </p>
        <p>
            <label>性別：</label><br>
            <input type="radio" id="male" name="gender" value="male" <%= request.getParameter("gender") != null && request.getParameter("gender").equals("male") ? "checked" : "" %> >
            <label for="male">男性</label>
            <input type="radio" id="female" name="gender" value="female" <%= request.getParameter("gender") != null && request.getParameter("gender").equals("female") ? "checked" : "" %> >
            <label for="female">女性</label>
            <input type="radio" id="other" name="gender" value="other" <%= request.getParameter("gender") != null && request.getParameter("gender").equals("other") ? "checked" : "" %> >
            <label for="other">その他</label>
        </p>
        <p>
            <label for="postcode">郵便番号 (ハイフンなし7桁)：</label>
            <input type="text" id="postcode" name="postcode" value="<%= request.getParameter("postcode") != null ? request.getParameter("postcode") : "" %>" pattern="\d{7}" >
        </p>
        <p>
            <label for="address">住所：</label>
            <input type="text" id="address" name="address" value="<%= request.getParameter("address") != null ? request.getParameter("address") : "" %>" >
        </p>
        <p>
            <label for="phone">電話番号：</label>
            <input type="tel" id="phone" name="phone" value="<%= request.getParameter("phone") != null ? request.getParameter("phone") : "" %>" pattern="\d{10,11}" >
        </p>
        <p>
            <label for="email">メールアドレス：</label>
            <input type="email" id="email" name="email" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>" >
        </p>
        <p>
            <label for="password">パスワード：</label>
            <input type="password" id="password" name="password" value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>" >
        </p>
        <p>
            <label for="expiry">クレジットカード使用期限 (MM/YY)：</label>
            <input type="text" id="expiry" name="expiry" value="<%= request.getParameter("expiry") != null ? request.getParameter("expiry") : "" %>" pattern="\d{2}/\d{2}">
        </p>
        <p>
            <label for="creditcard">クレジットカード番号：</label>
            <input type="text" id="creditcard" name="creditcard" value="<%= request.getParameter("creditcard") != null ? request.getParameter("creditcard") : "" %>" pattern="\d{16}">
        </p>
        <p>
            <label for="securitycode">セキュリティコード:</label>
            <input type="text" id="securitycode" name="securitycode" value="<%= request.getParameter("securitycode") != null ? request.getParameter("securitycode") : "" %>" pattern="\d{3,4}">
        </p>
        <button type="button" onclick="clearForm()">クリア</button>
        <button type="submit">確認</button>
</body>
</html>
