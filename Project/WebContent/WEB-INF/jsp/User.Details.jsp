<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="AllUsers_style.css">
<title>details</title>
</head>
<body>
	<div class="section">
		<%
			request.getAttribute("userDetail");
		%>
		<span class="head">${userDetail.name}さん</span><a href="UserLogoutServlet">ログアウト</a>
	</div>
	<h1 class="details">ユーザ情報詳細参照</h1>

	<p>${userDetail.login_id}</p>

	<p>${userDetail.name}</p>

	<p>生年月日 ${userDetail.birth_Date}</p>

	<p>登録日時</p>
	<p>${userDetail.create_Date}</p>

	<p>更新日時</p>
	<p>${userDetail.update_Date}</p>


	   <a href="AllUsersServlet">戻る</a>


</body>
</html>

