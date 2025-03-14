<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>確認画面</title>
    <link rel="stylesheet" href="javascript:void(0)"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <style>
        .button-wrapper {
            display: flex;
            justify-content: space-between;
            width: 300px; /* ボタンの間隔を調整するために適宜変更してください */
            margin: 0 auto;
        }
        .button-wrapper form {
            margin: 0; /* フォーム間の余白を削除 */
        }
    </style>
</head>
<body>
    <jsp:include page="/inc/header.jsp" />
    <h1>新規会員登録 確認</h1>
    <div class="enclose1">
        <p>氏名: ${param.name}</p>
        <p>ふりがな: ${param.kana}</p>
        <p>生年月日: ${param.birthday}</p>
        <p>性別: ${param.gender}</p>
        <p>郵便番号: ${param.postcode}</p>
        <p>住所: ${param.address}</p>
        <p>電話番号: ${param.phone}</p>
        <p>メールアドレス: ${param.email}</p>
        <p>パスワード: ${param.password}</p>
        <p>クレジットカード使用期限: ${param.expiry}</p>
        <p>クレジットカード番号: ${param.creditcard}</p>
        <p>セキュリティコード: ${param.securitycode}</p>
        <div class="button-wrapper">
            <form action="newMemberRegistration.jsp" method="post">
                <input type="hidden" name="name" value="${param.name}">
                <input type="hidden" name="kana" value="${param.kana}">
                <input type="hidden" name="birthday" value="${param.birthday}">
                <input type="hidden" name="gender" value="${param.gender}">
                <input type="hidden" name="postcode" value="${param.postcode}">
                <input type="hidden" name="address" value="${param.address}">
                <input type="hidden" name="phone" value="${param.phone}">
                <input type="hidden" name="email" value="${param.email}">
                <input type="hidden" name="password" value="${param.password}">
                <input type="hidden" name="expiry" value="${param.expiry}">
                <input type="hidden" name="creditcard" value="${param.creditcard}">
                <input type="hidden" name="securitycode" value="${param.securitycode}">
                <button type="submit">戻る</button>
            </form>
            <form action="membershipRegistrationComplete.jsp" method="post">
                <input type="hidden" name="name" value="${param.name}">
                <input type="hidden" name="kana" value="${param.kana}">
                <input type="hidden" name="birthday" value="${param.birthday}">
                <input type="hidden" name="gender" value="${param.gender}">
                <input type="hidden" name="postcode" value="${param.postcode}">
                <input type="hidden" name="address" value="${param.address}">
                <input type="hidden" name="phone" value="${param.phone}">
                <input type="hidden" name="email" value="${param.email}">
                <input type="hidden" name="password" value="${param.password}">
                <input type="hidden" name="expiry" value="${param.expiry}">
                <input type="hidden" name="creditcard" value="${param.creditcard}">
                <input type="hidden" name="securitycode" value="${param.securitycode}">
                <button type="submit">登録</button>
            </form>
        </div>
    </div>
    <jsp:include page="/inc/footer.jsp" />
</body>
</html>
