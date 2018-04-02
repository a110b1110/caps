<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
<link href="css/background.css?ver=2" rel="stylesheet" type="text/css" >
</head>
<body>
<header class="title">
        <h1>Capstone Design Management System</h1>
</header>
<form action="modify.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="${modReq.articleNumber}">
<p>
	번호:<br/>${modReq.articleNumber}
</p>
<p>
	제목:<br/><input type="text" name="title" value="${modReq.title}">
	<c:if test="${errors.title}">제목을 입력하세요.</c:if>
</p>
<p>
	내용:<br/>
	<textarea name="content" rows="5" cols="30">${modReq.content}</textarea>
	파일:	<input name="file" type = "file"/>${modReq.file}<br/>
</p>
<input type="submit" value="글 수정">
</form>
</body>
</html>