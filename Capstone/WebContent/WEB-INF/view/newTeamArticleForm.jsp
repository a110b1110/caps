<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>팀 게시글쓰기</title>
<link href="css/background.css?ver=2" rel="stylesheet" type="text/css" >
</head>
<body>
<header class="title">
        <h1>Capstone Design Management System</h1>
</header>
<form action="teamwrite.do" method="post" enctype="multipart/form-data">
<p>
	제목:<br/><input type="text" name="title" value="${param.title}">
	<c:if test="${errors.title}">제목을 입력하세요.</c:if>
</p>
<p>
	파일:<br/>
	<%--!!이부분을 파일업로드로 수정해야함. 자바스크립스 이용!! --%>
	<label for="filetype">문서타입</label><br>
	<select name="filetype">
    	<option value="0">종류</option>
    	<option value=a>제안서</option>
    	<option value=b>회의록</option>
    	<option value=c>설계서</option>
    	<option value=d>발표자료</option>
	</select>
	<input name="file" type = "file"/>${param.file}<br/>
</p>
<input type="submit" value="새 글 등록">
</form>
</body>
</html>