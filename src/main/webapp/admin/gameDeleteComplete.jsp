<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>管理者画面-試合情報削除完了</title>
        <link rel="stylesheet" href="javascript:void(0)">
    </head>

        <body>
            <!-- ヘッダーを挿入 -->
            <jsp:include page="../inc/adminHeader.jsp" />
    
            <div class="main">
    
                <h3>試合情報の削除完了</h3>
                <form action="/groupPhoenix/adminTop" method="get">
                    <input type="submit" value="試合情報TOPに戻る">
                </form>
    
            </div>
    
            <!-- フッターを挿入 -->
            <jsp:include page="../inc/adminFooter.jsp" />
        </body>

    </html>