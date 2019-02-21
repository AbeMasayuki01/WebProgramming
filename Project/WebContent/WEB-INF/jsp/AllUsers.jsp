<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="AllUsers_style.css">
<title>allusers</title>
</head>
<body>
<div class="section">
<span class="head">${userInfo.name}さん</span><a href="UserLogoutServlet">ログアウト</a>
</div>
	<h1 class="allusers">ユーザ一覧</h1>

	<p>
		<a href="NewRegistrationServlet">新規登録</a>
	</p>

	<p>ログインID</p>
	<input type="text" name="loginID">

	<p>ユーザ名</p>
	<input type="text" name="username">

	<p>生年月日</p>
	<input type="text" value="" placeholder="年/月/日">
	<p>
		〜 <p>
	<input type="text" value="" placeholder="年/月/日"><p>
		<input type="submit" value="検索">
	</p>
	<table border="1">
		<tr>
			<th>ログインID</th>
			<th>ユーザ名</th>
			<th>生年月日</th>
			<th></th>
		</tr>
		<tbody>
		<!-- リクエストスコープのuserlistをuserとして扱う。userlistの中はuserbeansのフィールドが入っている。
		＜user.longi_id＞はuserList（user）の中身であるbeansのlogin_idをEL式で表している。 -->
                 <c:forEach var="user" items="${userList}" >
                   <tr>
                     <td>${user.login_id}</td>
                     <td>${user.name}</td>
                     <td>${user.birth_Date}</td>
                     <!-- TODO 未実装；ログインボタンの表示制御を行う -->
                     <td>
                     <c:if test="${userInfo.login_id=='admin'}">
                       <a href="UserDetailsServlet?id=${user.id}">詳細</a>
                       <a href="UserUpdateServlet?id=${user.id}">更新</a>
                       <a href ="UserDeleteServlet?id=${user.id}">削除</a>
                       </c:if>

                        <c:if test="${userInfo.login_id!='admin'}">
                       <a href="UserDetailsServlet?id=${user.id}">詳細</a>
                       </c:if>

                       <c:if test="${userInfo.login_id==user.login_id}">
                       <a href="UserDetailsServlet?id=${user.id}">詳細</a>
                       <a href="UserUpdateServlet?id=${user.id}">更新</a>
                       </c:if>

                     </td>
                   </tr>
                 </c:forEach>
               </tbody>
	</table>
</body>
</html>

