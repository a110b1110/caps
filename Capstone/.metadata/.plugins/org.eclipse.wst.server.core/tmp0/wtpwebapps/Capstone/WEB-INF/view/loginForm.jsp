<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="css/background_sub.css?ver=2" rel="stylesheet" type="text/css" >
<link href="css/LoginForm.css?ver=2" rel="stylesheet" type="text/css" >
</head>
<body>
<header class="title">
        <h1>Capstone Design Management System</h1>
</header>
<form action="login.do" method="post">
<c:if test="${errors.idOrPwNotMatch}">
아이디와 암호가 일치하지 않습니다.
</c:if>
<div id="wrapper">
<p id="login_title">Login</p>
<p>
 	<label for="groupnumber">Job</label><br>
	<select name="groupnumber">
    	<option value="">직업선택</option>
    	<option value=1>교수</option>
    	<option value=2>학생</option>
	</select>
</p>
<p>
	<label for="id">ID</label><br>
	<input type="text" name="id" value="${param.id}">
	<c:if test="${errors.id}">ID를 입력하세요.</c:if>
</p>
<p>
	<label for="Password">Password</label><br>
	<input type="password" name="password">
	<c:if test="${errors.password}">암호를 입력하세요.</c:if>
</p>
<input type="submit" value="Login">
</div>
</form>
</body>
</html>