<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="AllUsers_style.css">
<title>newregistration</title>
</head>
<body>
<div class="section">

<span class="head">ユーザ名さん</span><span class="logout">ログアウト</span>

</div>
<form action = "NewRegistrationServlet" method="post">
    <h1 class="newregistration">ユーザ新規登録</h1>

    <p>ログインID</p>
    <input type="text" name="loginId">

    <p>パスワード</p>
    <input type="password" name="password">

    <P>パスワード確認</P>
    <input type="password" name="password">

    <p>ユーザ名</p>
    <input type="text" name="username">

    <p>生年月日</p>
    <input type="text" name="dateofbirth">

    <p>
        <button type="submit">登録</button>
    </p>
</form>

   <a href="AllUsersServlet">戻る</a>


</body>
</html>

