 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>ログインページ</title>
 <link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 </head>
 <jsp:include page="../inc/header.jsp" />
 <body>
 
 	<h1>ログイン</h1>
 	<div class = enclose1>
<<<<<<< HEAD
<!-- 	<form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return validateForm();">-->
<form login="${pageContext.request.contextPath}/NonMemberLogin.java" method="post" onsubmit="return validateForm();"> 	<p>
=======
 	<form action="${pageContext.request.contextPath}/NonMemberLogin" method="post" onsubmit="return validateForm();">
<!--<form action="login" method="post" onsubmit="return validateForm();"> 	<p>-->
>>>>>>> branch 'main' of https://github.com/sasahara08/groupPhoenix.git
 		<label for="email">メールアドレス</label>
        <input type="email" id="email" name="email" required>
 	</p>
 	<p>
 		<label for="password">パスワード</label>
        <input type="password" id="password" name="password" required></p>
 	
 	<button type="submit" name="login" value="login">ログイン</button>
 	</form>
	</div> 

 </body>
 <jsp:include page="../inc/footer.jsp" />
 </html>