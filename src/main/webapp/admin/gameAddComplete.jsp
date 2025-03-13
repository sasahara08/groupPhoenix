<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="javascript:void(0)">
    </head>

	    <body>
	        <!-- ヘッダーを挿入 -->
	        <jsp:include page="../inc/adminHeader.jsp" />
	
	        <div class="main">
	
	            <h3>試合登録完了</h3>
	            <form action="/adminTop" method="get">
	                <input type="submit" value="試合情報TOPに戻る">
	            </form>
	
	        </div>
	
	        <!-- フッターを挿入 -->
	        <jsp:include page="../inc/adminFooter.jsp" />
	    </body>

    </html>