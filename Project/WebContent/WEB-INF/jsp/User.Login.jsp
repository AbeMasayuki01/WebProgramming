<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="AllUsers_style.css">

<title>login</title>
</head>
<body>
<div class="container">

    <c:if test="${errMsg != null}" >
        <div class="red">
          ${errMsg}
        </div>
    </c:if>

	<form class="form-signin" action="UserLoginServlet" method="post">

		<h2>ログイン画面</h2>

		<p>ログインID</p>
		<input type="text" name="login_id">
		<p>パスワード</p>
		<input type="password" name="password">
		<p>
			<input type="submit" value="ログイン">
		</p>

	</form>
 </div><!-- /container -->

</body>
</html>

