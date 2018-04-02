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
  <div class="form-panel one" style="height: 498px; weight: 500px">
    <div class="form-header">
      <h1>Account Login</h1>
    </div>
<form action="login.do" method="post">
<c:if test="${errors.idOrPwNotMatch}">
아이디와 암호가 일치하지 않습니다.
</c:if>
<div id="wrapper">
<p>
 	<label for="groupnumber">Job</label><br>
	<select name="groupnumber" style="width:100px;height:35px;" >
    	<option value="">직업선택</option>
    	<option value=1>교수</option>
    	<option value=2>학생</option>
	</select>
</p>

<div class="form-group">
    <label for="username">Username</label>
	<input type="text" name="id" value="${param.id}" required="required">
	<c:if test="${errors.id}">ID를 입력하세요.</c:if>
</div>
<div class="form-group">
	<label for="Password">Password</label><br>
	<input type="password" name="password" required="required">
	<c:if test="${errors.password}">암호를 입력하세요.</c:if>
</div>
<!-- 아이디 기억
<label class="form-remember">
            <input type="checkbox">Remember Me
          </label>
           -->
<div class="form-group">
                  <button type="submit" value="Login">Log In
        </button>
        </div>

</div>
</form>
</div>
</body>
</html>