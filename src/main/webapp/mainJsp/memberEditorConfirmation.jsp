<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員情報変更確認</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <h1>会員情報変更確認画面</h1>

    <p><strong>氏名:</strong> ${param.name}</p>
    <p><strong>ふりがな:</strong> ${param.kana}</p>
    <p><strong>生年月日:</strong> ${param.birthday}</p>
    <p><strong>性別:</strong> ${param.gender}</p>
    <p><strong>郵便番号:</strong> ${param.postcode}</p>
    <p><strong>住所:</strong> ${param.address}</p>
    <p><strong>電話番号:</strong> ${param.phone}</p>
    <p><strong>メールアドレス:</strong> ${param.email}</p>
    <p><strong>パスワード:</strong> ${param.password}</p>
    <p><strong>クレジットカード番号:</strong> ${param.creditcard}</p>
    <p><strong>クレジットカード使用期限:</strong> ${param.expiry}</p>
    <p><strong>セキュリティコード:</strong> ${param.securitycode}</p>

    <form action="memberEditorSave.jsp" method="post">
        <input type="hidden" name="name" value="${param.name}">
        <input type="hidden" name="kana" value="${param.kana}">
        <input type="hidden" name="birthday" value="${param.birthday}">
        <input type="hidden" name="gender" value="${param.gender}">
        <input type="hidden" name="postcode" value="${param.postcode}">
        <input type="hidden" name="address" value="${param.address}">
        <input type="hidden" name="phone" value="${param.phone}">
        <input type="hidden" name="email" value="${param.email}">
        <input type="hidden" name="password" value="${param.password}">
        <input type="hidden" name="creditcard" value="${param.creditcard}">
        <input type="hidden" name="expiry" value="${param.expiry}">
        <input type="hidden" name="securitycode" value="${param.securitycode}">

        <button type="submit">保存</button>
    </form>

    <form action="memberEditor.jsp" method="get">
        <button type="submit">戻る</button>
    </form>
</body>
</html>
