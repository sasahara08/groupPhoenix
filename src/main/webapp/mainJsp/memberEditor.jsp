<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>会員情報変更
</title>
<link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 
</head>
<body>
	 <h1>会員情報変更 入力画面
</h1>
    
    <form action="memberEditorConfirmation.jsp" method="post">
        <!-- hiddenフィールドでuser_idを送信 -->
        <input type="hidden" name="user_id" value="${user.userId}">

        <p>
            <label for="name">氏名：</label>
            <input type="text" id="name" name="name" value="${user.name}" required>
        </p>
        <p>
            <label for="kana">ふりがな：</label>
            <input type="text" id="kana" name="kana" value="${user.kana}" required>
        </p>
        <p>
            <label for="birthday">生年月日：</label>
            <input type="date" id="birthday" name="birthday" value="${user.birthday}" required>
        </p>
        <p>
            <label>性別：</label><br>
            <input type="radio" id="male" name="gender" value="male" <c:if test="${user.gender == 'male'}">checked</c:if> required>
            <label for="male">男性</label>
            <input type="radio" id="female" name="gender" value="female" <c:if test="${user.gender == 'female'}">checked</c:if> required>
            <label for="female">女性</label>
            <input type="radio" id="other" name="gender" value="other" <c:if test="${user.gender == 'other'}">checked</c:if> required>
            <label for="other">その他</label>
        </p>
        <p>
            <label for="postcode">郵便番号 (ハイフンなし7桁)：</label>
            <input type="text" id="postcode" name="postcode" value="${user.postcode}">
        </p>
        <p>
            <label for="address">住所：</label>
            <input type="text" id="address" name="address" value="${user.address}">
        </p>
        <p>
            <label for="phone">電話番号：</label>
            <input type="tel" id="phone" name="phone" value="${user.phone}">
        </p>
        <p>
            <label for="email">メールアドレス：</label>
            <input type="email" id="email" name="email" value="${user.email}">
        </p>
        <p>
            <label for="password">パスワード：</label>
            <input type="password" id="password" name="password" value="${user.password}">
        </p>
        <p>
            <label for="creditcard">クレジットカード番号：</label>
            <input type="text" id="creditcard" name="creditcard" value="${user.creditcard}">
        </p>
        <p>
            <label for="expiry">クレジットカード使用期限：</label>
            <input type="text" id="expiry" name="expiry" value="${user.expiry}">
        </p>
        <p>
            <label for="securitycode">セキュリティコード：</label>
            <input type="text" id="securitycode" name="securitycode" value="${user.securitycode}">
        </p>

        <!-- 確認ボタン -->
        <button type="submit">確認</button>
    </form>

    <!-- 戻るボタン -->
    <form action="myPage.jsp" method="get">
        <button type="submit">戻る</button>
    </form>
    <jsp:include page="/inc/footer.jsp" />
</html>
