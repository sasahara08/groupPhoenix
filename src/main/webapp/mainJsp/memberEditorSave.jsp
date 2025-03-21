<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="dao.MemberEditorDAO"%>
<%@ page import="dto.User"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>保存処理</title>
<link rel="stylesheet" href="javascript:void(0)"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
 <%
        // 送信されたフォームデータを取得
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

        // Userオブジェクトにデータをセット
        User user = new User();
        user.setName(name);
        user.setKana(kana);
        user.setBirthday(birthday);
        user.setGender(gender);
        user.setPostcode(postcode);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreditcard(creditcard);
        user.setExpiry(expiry);
        user.setSecuritycode(securitycode);

        // MemberEditorDAOを使ってデータベースに保存
        MemberEditorDAO dao = new MemberEditorDAO();
        boolean isSuccess = dao.updateUser(user); // updateUserメソッドでデータを更新

        // 更新が成功したらcomplete.jspに遷移
        if (isSuccess) {
            response.sendRedirect("memberEditorComplete.jsp");
        } else {
            out.println("保存処理に失敗しました。");
        }
    %>
</body>
</html>
