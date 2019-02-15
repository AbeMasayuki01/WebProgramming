<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="AllUsers_style.css">
<title>update</title>
</head>
<body>
<div class="section">
<span class="head">${userInfo.name}さん</span><a href="UserLogoutServlet">ログアウト</a>
</div>

    <h1 class="update">ユーザ情報更新</h1>

<form action="UserUpdateServlet" method=POST>
<input type="hidden" name="id" value="${userUpdate.id}">


    <p>NAME:${userUpdate.name}</p>
    <p>ログインID:${userUpdate.login_id}</p>

    <p>パスワード</p>
    <input type="password" name="password">

    <P>パスワード確認</P>
    <input type="password" name="password">

    <p>ユーザ名</p>
    <input type="text" name="name" value="${userUpdate.name}">

    <p>生年月日</p>
    <input type="text" name="birth_Date" value="${userUpdate.birth_Date}">

    <p>
        <input type="submit" value="更新">
    </p>
</form>

    <a href="AllUsersServlet">戻る</a>


</body>
</html>

