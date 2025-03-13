<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問い合わせ</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        display: block;
        margin-bottom: 5px;
    }
    .form-group input, .form-group textarea {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
    }
    .form-group button {
        padding: 10px 20px;
        background-color: #007BFF;
        color: #fff;
        border: none;
        cursor: pointer;
        border-radius: 5px;
    }
    .form-group button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
 <h2>問い合わせ</h2>
 <form action="ContactServlet" method="post">
    <div class="form-group">
        <label for="name">氏名</label>
        <input type="text" id="name" name="name" required>
    </div>
    <div class="form-group">
        <label for="email">メールアドレス</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div class="form-group">
        <label for="confirm-email">メールアドレス（確認用）</label>
        <input type="email" id="confirm-email" name="confirm-email" required>
    </div>
    <div class="form-group">
        <label for="message">お問い合わせ内容</label>
        <textarea id="message" name="message" rows="5" required></textarea>
    </div>
    <div class="form-group">
        <button type="submit">送信</button>
    </div>
 </form>
</body>
</html>
