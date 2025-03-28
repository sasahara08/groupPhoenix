<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="ja">

        <head>
            <meta charset="UTF-8">
            <title>管理者画面-売上詳細</title>

            <style>

                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-bottom: 20px;
                }

                th,
                td,
                tr {
                    border: 1px solid #ddd;
                    padding: 8px;
                    text-align: center;
                    height: 50px;
                }

                th {
                    background-color: #f2f2f2;
                }

                canvas {
                    max-width: 100%;
                    height: auto;
                }
            </style>
        </head>

        <body>

            <jsp:include page="../inc/adminHeader.jsp" />

            <h3>売上一覧：月別</h3>


            <form action="/groupPhoenix/AdminSales" method="get">
                <select name="selectYear">
                    <c:forEach var="year" items="${years}">
                        <option value=${year}>${year}</option>
                    </c:forEach>
                </select> <input type="hidden" name="salePage" value="saleMonth">
                <button type="submit">更新</button>
            </form>

            <table>
                <tr>
                    <th>月</th>
                    <th>売上高 (円)</th>
                    <th>外野席 (枚)</th>
                    <th>内野席（南側） (枚)</th>
                    <th>内野席（北側） (枚)</th>
                    <th>バックネット側指定席 (枚)</th>
                </tr>

                <c:forEach var="sale" items="${sales}">
                    <tr>
                        <td>${sale.saleManth}</td>
                        <td>${sale.salesValue}</td>
                        <td><span>${sale.outSeat} /</span> <span>${sale.totalOutSeat}</span><br>
                            <span>完売率
                                : ${sale.outSeatSellOutRate} %</span></td>
                        <td><span>${sale.nInSeat} /</span> <span>${sale.totalNInSeat}</span><br>
                            <span>完売率
                                : ${sale.outSeatSellNInSeat} %</span></td>
                        <td><span>${sale.sInSeat} /</span> <span>${sale.totalSInSeat}</span><br>
                            <span>完売率
                                : ${sale.outSeatSellSInSeat} %</span></td>
                        <td><span>${sale.backnetSeat} /</span>
                            <span>${sale.totalBacknetSeat}</span><br>
                            <span>完売率 : ${sale.outSeatSellBacknetSeat} %</span>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <canvas id="monthlySalesChart" width="400" height="200"></canvas>
            <canvas id="monthlySellOutRateChart" width="400" height="200"></canvas>

            <jsp:include page="../inc/adminFooter.jsp" />

            <script>
                console.log(${ json });
            </script>

            <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
            <script>
                // saleDataをJavaScriptの変数に代入
                var saleData = JSON.parse('${json}');
                console.log(saleData);

                // 月ごとの売上データを取得
                var months = saleData.map(function (item) {
                    return item.saleMonth + '月'; // saleMonth が月を表すキーであることを確認
                });

                // 売上高を百万円単位に変換
                var sales = saleData.map(function (item) {
                    return (item.salesValue / 1000000).toFixed(2); // 百万円に変換し、小数点以下2桁で表示
                });

                // 各館、各倍率ごとの完売率データを取得
                var outSeatSellOutRates = saleData.map(function (item) {
                    return item.outSeatSellOutRate;
                });
                var nInSeatSellOutRates = saleData.map(function (item) {
                    return item.outSeatSellNInSeat;
                });
                var sInSeatSellOutRates = saleData.map(function (item) {
                    return item.outSeatSellSInSeat;
                });
                var backnetSeatSellOutRates = saleData.map(function (item) {
                    return item.outSeatSellBacknetSeat;
                });

                // Chart.jsで売上高のグラフを描画
                var ctxSales = document.getElementById('monthlySalesChart').getContext('2d');
                var chartSales = new Chart(ctxSales, {
                    type: 'bar',
                    data: {
                        labels: months, // 横軸に月を設定
                        datasets: [{
                            label: '売上一覧 (百万)', // データのラベル
                            data: sales, // 百万円単位のデータを設定
                            backgroundColor: 'rgba(54, 162, 235, 0.4)', // 背景色 (透明度0.4)
                            borderColor: 'rgba(54, 162, 235, 1)', // 枠線の色
                            borderWidth: 1 // 枠線の太さ
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true, // y軸を0から開始
                                ticks: {
                                    // y軸のラベルの単位も調整
                                    callback: function (value) {
                                        return value + '百万'; // 単位を 'M' (百万) に
                                    }
                                }
                            }
                        }
                    }
                });

                // Chart.jsで各館、各倍率ごとの完売率グラフを描画
                var ctxSellOutRate = document.getElementById('monthlySellOutRateChart').getContext('2d');
                var chartSellOutRate = new Chart(ctxSellOutRate, {
                    type: 'bar',
                    data: {
                        labels: months, // 横軸に月を設定
                        datasets: [{
                            label: '外野席 (%)', // データのラベル
                            data: outSeatSellOutRates, // 外野席の完売率データを設定
                            backgroundColor: 'rgba(255, 99, 132, 0.4)', // 背景色 (透明度0.4)
                            borderColor: 'rgba(255, 99, 132, 1)', // 枠線の色
                            borderWidth: 1 // 枠線の太さ
                        }, {
                            label: '内野席（南側） (%)', // データのラベル
                            data: nInSeatSellOutRates, // 内野席（南側）の完売率データを設定
                            backgroundColor: 'rgba(54, 162, 235, 0.4)', // 背景色 (透明度0.4)
                            borderColor: 'rgba(54, 162, 235, 1)', // 枠線の色
                            borderWidth: 1 // 枠線の太さ
                        }, {
                            label: '内野席（北側） (%)', // データのラベル
                            data: sInSeatSellOutRates, // 内野席（北側）の完売率データを設定
                            backgroundColor: 'rgba(255, 206, 86, 0.4)', // 背景色 (透明度0.4)
                            borderColor: 'rgba(255, 206, 86, 1)', // 枠線の色
                            borderWidth: 1 // 枠線の太さ
                        }, {
                            label: 'バックネット側指定席 (%)', // データのラベル
                            data: backnetSeatSellOutRates, // バックネット側指定席の完売率データを設定
                            backgroundColor: 'rgba(75, 192, 192, 0.4)', // 背景色 (透明度0.4)
                            borderColor: 'rgba(75, 192, 192, 1)', // 枠線の色
                            borderWidth: 1 // 枠線の太さ
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true, // y軸を0から開始
                                ticks: {
                                    // y軸のラベルの単位も調整
                                    callback: function (value) {
                                        return value + '%'; // 単位を '%' に
                                    }
                                }
                            }
                        }
                    }
                });
            </script>
        </body>

        </html>