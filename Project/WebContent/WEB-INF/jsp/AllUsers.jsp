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
<span class="head">ユーザ名さん</span><span class="logout">ログアウト</span>
</div>
	<h1 class="allusers">ユーザ一覧</h1>

	<p>
		<input type="submit" value="新規登録">
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
		<tr>
			<td>id001</td>
            <td>添田大地</td>
            <td>1991年4月1日</td>
			<td><button>詳細</button><button>更新</button><button>削除</button></td>
		</tr>
		<tr>
			<td>id002</td>
            <td>石田陽平</td>
            <td>1991年4月2日</td>
			<td><button class="blue">詳細</button><button>更新</button><button>削除</button></td>
		</tr>
		<tr>
			<td>id003</td>
			<td>田中直毅</td>
			<td>1991年4月3日</td>
			<td><button>詳細</button><button>更新</button><button>削除</button></td>
		</tr>
	</table>


</body>
</html>

