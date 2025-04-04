<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="ja">

        <head>
            <meta charset="UTF-8">
            <title>管理者画面-売上一覧</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminheader.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminfooter.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admingame.css" />
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminSale.css" />
        </head>

        <body>

            <!-- ヘッダーを挿入 -->
            <jsp:include page="../inc/adminHeader.jsp" />

            <main>

                <div class="saleForMonthBtn">
                    <form action="/groupPhoenix/AdminSales" method="get">
                        <input type="hidden" name="salePage" value="saleMonth">
                        <input type="submit" value="月別売上">
                    </form>
                </div>

                <h3>試合別売上一覧</h3>

                <div class="selesList">
                    <table>
                        <tr>
                            <th>対象試合</th>
<!--                            <th>開催日時</th>-->
                            <th>売上高 (円)</th>
                            <th>外野席 (枚)</th>
                            <th>北側内野席(枚)</th>
                            <th>南側内野席(枚)</th>
                            <th>バックネット側席(枚)</th>
                        </tr>

                        <c:forEach var="sale" items="${sales}">
                            <tr>
                                <td>${sale.gameName}</td>
<!--                                <td>${sale.gameDate}</td>-->
                                <td>${sale.salesValue}</td>
                                <td>${sale.outSeat}</td>
                                <td>${sale.nInSeat}</td>
                                <td>${sale.sInSeat}</td>
                                <td>${sale.backnetSeat}</td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
            </main>

            <!-- フッターを挿入 -->
            <jsp:include page="../inc/adminFooter.jsp" />
        </body>

        </html>

