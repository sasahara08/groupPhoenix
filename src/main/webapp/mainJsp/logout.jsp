<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>ログアウト</title>
<link rel="stylesheet" href="../css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/logout.css">

</head>

<body>
	<!-- ヘッダーを挿入 -->
	 <jsp:include page="../inc/memberHeader.jsp" />
	 
		<div class="completion-container">
    	    <h1>ログアウトしますか？</h1>
        	<a href="index.jsp" class="button1">ログアウトする</a>
    	</div>
   		
</body>
</html>