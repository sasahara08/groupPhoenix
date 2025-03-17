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
	<h1>会員情報確認</h1>

    <p><strong>氏名：</strong>${param.name}</p>
    <p><strong>ふりがな：</strong>${param.kana}</p>
    <p><strong>生年月日：</strong>${param.birthday}</p>
    <p><strong>性別：</strong>${param.gender}</p>
    <p><strong>郵便番号：</strong>${param.postcode}</p>
    <p><strong>住所：</strong>${param.address}</p>
    <p><strong>電話番号：</strong>${param.phone}</p>
    <p><strong>メールアドレス：</strong>${param.email}</p>
    <p><strong>パスワード：</strong>セキュリティのため非表示</p>
    <p><strong>クレジットカード使用期限：</strong>${param.expiry}</p>
    <p><strong>クレジットカード番号：</strong>${param.creditcard}</p>
    <p><strong>セキュリティコード：</strong>${param.securitycode}</p>

    <form action="memberEditor.jsp" method="get">
        <button type="submit">戻る</button>
    </form>
    <form action="saveMemberInfo.jsp" method="post">
        <button type="submit">保存</button>
    </form>
</body>
</html>
