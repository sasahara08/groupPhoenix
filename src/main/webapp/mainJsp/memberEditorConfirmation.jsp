<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>会員情報確認</title>
</head>
<body>
    <h2>会員情報確認</h2>
    <form action="${pageContext.request.contextPath}/UpdateMemberServlet" method="POST">
        <table>
            <tr>
                <td>名前:</td>
                <td>${param.name}</td>
            </tr>
            <tr>
                <td>かな:</td>
                <td>${param.kana}</td>
            </tr>
            <tr>
                <td>生年月日:</td>
                <td>${param.birthday}</td>
            </tr>
            <tr>
                <td>郵便番号:</td>
                <td>${param.postCode}</td>
            </tr>
            <tr>
                <td>住所:</td>
                <td>${param.address}</td>
            </tr>
            <tr>
                <td>電話番号:</td>
                <td>${param.phone}</td>
            </tr>
            <tr>
                <td>性別:</td>
                <td>${param.gender}</td>
            </tr>
            <tr>
                <td>クレジットカード番号:</td>
                <td>${param.creditCardNumber}</td>
            </tr>
            <tr>
                <td>クレジットカード有効期限:</td>
                <td>${param.creditCardExpiryDate}</td>
            </tr>
            <tr>
                <td>クレジットカードセキュリティコード:</td>
                <td>${param.creditCardSecurityCode}</td>
            </tr>
        </table>

        <button type="submit" name="action" value="confirm">確定</button>
        <button type="submit" name="action" value="back">戻る</button>
    </form>
</body>
</html>
