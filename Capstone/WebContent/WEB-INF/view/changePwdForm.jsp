<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>암호 변경</title>
<link href="css/background_sub.css?ver=2" rel="stylesheet" type="text/css" >
<link href="css/ChangePwdForm.css?ver=2" rel="stylesheet" type="text/css" >
</head>
<body>
<header class="title">
        <h1>Capstone Design Management System</h1>
</header>

<div id="wrapper">
<form action="changePwd.do" method="post">
<p id="Change_pw">Change Password</p>
<p>
	<label for="curPwd">Current Password</label><br>
	<br/><input type="password" name="curPwd">
	<c:if test="${errors.curPwd}">현재 암호를 입력하세요.</c:if>
	<c:if test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다.</c:if>
</p>
<p>
	<label for="newPwd">New Password</label><br>
	<br/><input type="password" name="newPwd">
	<c:if test="${errors.newPwd}">새 암호를 입력하세요.</c:if>
</p>
<input type="submit" value="Change Password">
</form>
</div>

</body>
</html>