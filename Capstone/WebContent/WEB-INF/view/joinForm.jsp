<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>가입</title>
<link href="css/background_sub.css?ver=2" rel="stylesheet" type="text/css" >
<link href="css/joinForm.css?ver=2" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrapper">
<form action="join.do" method="post" style="padding-top:0px;">
<div class="form-panel two active" style="height:50%; weight:550px; ">
    <div class="form-header">
      <h1>Register Account</h1>
    </div>
    <div class="form-content">
      <form>
	      <p id="GROUPNUM">
				<label for="groupnumber">Job</label><br>
				<select name="groupnumber" style="width:100px;height:35px;">
	  		  	<option value=0 selected>직업선택</option>
	 		   	<option value=1>교수</option>
	 		   	<option value=2>학생</option>
				</select>
		</p>
        <div class="form-group">
        	<label for="id">ID</label><br>
			<input type="text" name="id" value="${param.id}" required="required">
			<c:if test="${errors.id}">ID를 입력하세요.</c:if>
			<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
        </div>
        <div class="form-group">
			<label for="name">Name</label><br>
			<input type="text" name="name" value="${param.name}"  required="required">
			<c:if test="${errors.name}">이름을 입력하세요.</c:if>
        </div>
        <div class="form-group">
			<label for="password">Password</label><br>
			<input type="password" name="password"  required="required">
			<c:if test="${errors.password}">암호를 입력하세요.</c:if>
        </div>
		<div class="form-group">
			<label for="confirmPassword">ConfirmPassword</label><br>
			<input type="password" name="confirmPassword"  required="required">
			<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
			<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
        </div>
        <div class="form-group">
        	<label for="phonenumber">Phone Number</label><br>
			<input type="text" name="phonenumber"  required="required">
			<c:if test="${errors.phonenumber}">핸드폰 번호를 입력하세요.</c:if>
        </div>
        <div class="form-group">
			<label for="email">Email</label><br>
			<input type="text" name="email"  required="required">
			<c:if test="${errors.email}">이메일을 입력하세요.</c:if>
        </div>
        <div class="form-group">
          <button type="submit">Register</button>
        </div>
      </form>
    </div>
  </div>
</form>
</div>
</body>
</html>

<!-- 

<p id="sign_title">Sign Up</p>
<p id="id">

	<label for="id">ID</label><br>
	<input type="text" name="id" value="${param.id}" required="required">
	<c:if test="${errors.id}">ID를 입력하세요.</c:if>
	<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
</p>

<p id="NAME">
	<label for="name">Name</label><br>
	<input type="text" name="name" value="${param.name}"  required="required">
	<c:if test="${errors.name}">이름을 입력하세요.</c:if>
</p>
<p id="PASSWORD">
	<label for="password">Password</label><br>
	<input type="password" name="password"  required="required">
	<c:if test="${errors.password}">암호를 입력하세요.</c:if>
</p>
<p id="CONFIRM">
	<label for="confirmPassword">ConfirmPassword</label><br>
	<input type="password" name="confirmPassword">
	<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
	<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
</p>
<p id="GROUPNUM">
	<label for="groupnumber">Job</label><br>
	<select name="groupnumber">
    	<option value=0 selected>직업선택</option>
    	<option value=1>교수</option>
    	<option value=2>학생</option>
	</select>
</p>

<p id="PHONENUM">
	<label for="phonenumber">Phone Number</label><br>
	<input type="text" name="phonenumber"  required="required">
	<c:if test="${errors.phonenumber}">핸드폰 번호를 입력하세요.</c:if>
</p>
<p id="EMAIL">
	<label for="email">Email</label><br>
	<input type="text" name="email"  required="required">
	<c:if test="${errors.email}">이메일을 입력하세요.</c:if>
</p>
<input type="submit" value="Sign up">

</form>
-->
