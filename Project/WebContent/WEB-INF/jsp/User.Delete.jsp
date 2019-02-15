<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="AllUsers_style.css">
<title>delete</title>
</head>
<body>
	<%
		request.getAttribute("userDelete");
	%>
	<div class="section">
		<span class="head">ユーザ名さん</span><span class="logout">ログアウト</span>
	</div>
	<h1 class="newregistraion">ユーザ削除確認</h1>

	<p>ログインID:${userDelete.login_id}</p>

	<p>を本当に削除してよろしいでしょうか</p>

	<p>
		<a href="AllUsersServlet">キャンセル</a>
	</p>

	<form class="form-signin" action="UserDeleteServlet" method="post">
		<span id="reauth-email" class="reauth-email"></span>
		<input type="submit" value="OK">
        <input type="hidden" name=id value="${userDelete.id}">
	</form>
</body>
</html>

