<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 읽기</title>
<link href="css/background.css?ver=2" rel="stylesheet" type="text/css" >
</head>
<body>
<header class="title">
        <h1>Capstone Design Management System</h1>
</header>

<table border="1" width="100%">
<tr>
	<td>번호</td>
	<td>${articleData.article.fileNo}</td>
</tr>
<tr>
	<td>작성자</td>
	<td>${articleData.article.writer.writerId}</td>
</tr>
<tr>
	<td>제목</td>
	<td><c:out value='${articleData.article.title}' /></td>
</tr>
<tr>
	<td>내용</td>
	<td><c:out value='${articleData.content}'/></td>
</tr>
<tr>
	<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
		<a href="teamlist.do?pageNo=${pageNo}">[목록]</a>
		<c:if test="${authUser.id == articleData.article.writer.writerId}">
		<a href="teamarticlemodify.do?fileNo=${articleData.article.fileNo}">[게시글수정]</a>
		<a href="teamarticledelete.do?fileNo=${articleData.article.fileNo}">[게시글삭제]</a>
		</c:if>
	</td>
</tr>
</table>

</body>
</html>