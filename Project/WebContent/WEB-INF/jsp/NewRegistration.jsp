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
<div class="container">

    <c:if test="${errMsg != null}" >
        <div class="red">
          ${errMsg}
        </div>
    </c:if>
</div><!-- /container -->
<div class="section">

<span class="head">${userInfo.name}さん</span><a href="UserLogoutServlet">ログアウト</a>

</div>
<form action = "NewRegistrationServlet" method="post">
    <h1 class="newregistration">ユーザ新規登録</h1>

    <p>ログインID</p>
    <input type="text" name="loginId" value="${loginId}">

    <p>パスワード</p>
    <input type="password" name="password">

    <P>パスワード確認</P>
    <input type="password" name="re_password">

    <p>ユーザ名</p>
    <input type="text" name="username" value="${username}">

    <p>生年月日</p>
    <input type="text" name="dateofbirth" value="${dateofbirth}">

    <p>
        <button type="submit">登録</button>
    </p>
</form>

   <a href="AllUsersServlet">戻る</a>


</body>
</html>

