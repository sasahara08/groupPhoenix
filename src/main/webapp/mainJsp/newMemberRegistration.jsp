 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>新規会員登録画面</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
 <body>
  <jsp:include page="/inc/header.jsp" />
 	<h1>新規会員登録 入力</h1>
 	<div class = enclose1>
<!-- 	<form action="${pageContext.request.contextPath}/nonMemberNewRegistration.jsp" method="post" onsubmit="return validateForm();">-->
<form action="confirmationMemberRegistrationDetails.jsp" method="post" onsubmit="return validateForm();"> 	
	<p>
 		<label for="name">氏名：</label>
        <input type="text" id="name" name="name" required>
 	</p>
	<p>
 		<label for="kana">ふりがな：</label>
        <input type="text" id="kana" name="kana" required>
 	</p>
	<p>
 		<label for="birthday">生年月日：</label>
        <input type="date" id="birthday" name="birthday" required>
 	</p>
	<p>
 		<label>性別：</label><br>
        <input type="radio" id="male" name="gender" value="male" required>
        <label for="male">男性</label>
        <input type="radio" id="female" name="gender" value="female" required>
        <label for="female">女性</label>
        <input type="radio" id="other" name="gender" value="female" required>
        <label for="other">その他</label>
 	</p>
 	<p>
 	<label for="postcode">郵便番号 (ハイフンなし7桁)：</label><br>
        <input type="text" id="postcode" name="postcode" pattern="\d{7}" required>
 	</p>
 	<p>
 	<label for="address">住所：</label><br>
        <input type="text" id="address" name="address" required>
 	</p>
 	<p>
 	<label for="phone">電話番号：</label><br>
        <input type="tel" id="phone" name="phone" pattern="\d{10,11}" required>
 	</p>
	<p>
 		<label for="email">メールアドレス：</label>
        <input type="email" id="email" name="email" required>
 	</p>
 	<p>
 		<label for="password">パスワード：</label>
        <input type="password" id="password" name="password" required>
    </p>
	<p>
	<label for="expiry">クレジットカード使用期限 (MM/YY)：</label>
        <input type="text" id="expiry" name="expiry" pattern="\d{2}/\d{2}">
    </p>
    <p>
    <label for="creditcard">クレジットカード番号：</label>
        <input type="text" id="creditcard" name="creditcard" pattern="\d{16}">
    </p>
	<p>
        <label for="securitycode">セキュリティコード:</label>
        <input type="text" id="securitycode" name="securitycode" pattern="\d{3,4}">
	</p>
 	<button type="button1" onclick="clearForm()">クリア</button>
    <button type="submit">確認</button>
 	</form>
	</div> 
<jsp:include page="/inc/footer.jsp" />
<script>
    function clearForm() {
      document.getElementById("name").value = "";
      document.getElementById("kana").value = "";
      document.getElementById("birthday").value = "";
      document.getElementById("male").checked = false;
      document.getElementById("female").checked = false;
      document.getElementById("other").checked = false;
      document.getElementById("postcode").value = "";
      document.getElementById("address").value = "";
      document.getElementById("phone").value = "";
      document.getElementById("email").value = "";
      document.getElementById("password").value = "";
      document.getElementById("expiry").value = "";
      document.getElementById("creditcard").value = "";
      document.getElementById("securitycode").value = "";
    }
  </script>
 </body>
 </html>