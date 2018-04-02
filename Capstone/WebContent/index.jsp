<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Capstone Design Management System</title>
   <link href="css/background.css?ver=2" rel="stylesheet" type="text/css" >
   <meta charset="UTF-8" />
</head>
<body>
<%--
<c:if test="${! empty authUser}">
   ${authUser.name}님, 안녕하세요.
   <a href="logout.do">[로그아웃하기]</a>
   <a href="changePwd.do">[암호변경하기]</a>
</c:if>
<c:if test="${empty authUser}">
   <a href="join.do">[회원가입하기]</a>
   <a href="login.do">[로그인하기]</a>
</c:if>
--%>
<div class= "img">
<div class="introback">
		<br>
		<br>
		<div class="intro">
        <h1>C D M S</h1>
        <h6>Capstone Design Management System</h6>
        <br>
    <h3>남서울대 컴퓨터학과 학부생들의 졸업작품을 관리하기 위한 웹 페이지 입니다.</h3>
    </div>
</div>
</div>
<div id="main_box">
<u:isLogin>
<div id="wrapper">
   <div id="logined">
   <p id="success"> ${authUser.name}님, 안녕하세요.   </p>
   <a id="button" href="changePwd.do" >Change Password</a>
   <a id="button" href="logout.do">Logout</a><br>
   <a id="button" href="CreateTeam.do">Create Team</a>
   <a id="button" href="teamlist.do">Team Board</a>
   <a id="button" href="noticelist.do">Notice</a>
   </div>
</div>
</u:isLogin>
<u:notLogin>
<div id="wrapper">
<div id="login">
   <a id="subbutton" href="javascript:void(window.open('login.do','login','width=600,height=535.08'))">Login</a>
   <a id="subbutton" href="javascript:void(window.open('join.do','Sign up','width=600,height=800'))">Sign Up</a>
</div>
</div>
</u:notLogin>
</div>
<br/>
<footer id="main">
  <a href=#>Developed by HONG KI WAN, JO EUN HEE, KIM SANG GU</a> | <a href=#>Assisted by NSU</a>
</footer>
</body>
</html>
