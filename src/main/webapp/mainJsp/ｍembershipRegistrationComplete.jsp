<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新規会員登録 完了</title>
    <link rel="stylesheet" href="javascript:void(0)"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <h1>新規会員登録 完了</h1>
    <div class="button-wrapper">
        <form action="memberTop.jsp" method="get">
            <button type="submit">TOP</button>
        </form>
    </div>

    <%
        // 会員情報の登録処理を呼び出す
        String name = request.getParameter("name");
        String kana = request.getParameter("kana");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String postcode = request.getParameter("postcode");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String creditcard = request.getParameter("creditcard");
        String expiry = request.getParameter("expiry");
        String securitycode = request.getParameter("securitycode");

        MembershipRegistrationCompleteDAO dao = new MembershipRegistrationCompleteDAO();
        boolean isRegistered = dao.registerUser(name, kana, birthday, gender, postcode, address, phone, email, password, creditcard, expiry, securitycode);

        if (isRegistered) {
            out.println("<p>会員登録が完了しました。</p>");
        } else {
            out.println("<p>会員登録に失敗しました。</p>");
        }
    %>
</body>
</html>
