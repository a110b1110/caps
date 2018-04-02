<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 목록</title>
<link href="css/background.css?ver=2" rel="stylesheet" type="text/css" >
</head>
<body>
<header class="title">
        <h1>Capstone Design Management System</h1>
</header>

<table border="1">
   <tr>
      <td colspan="4"><a href="noticewrite.do">[게시글쓰기]</a></td>
   </tr>
   <tr>
      <td>번호</td>
      <td>제목</td>
      <td>작성자</td>
      <td>조회수</td>
   </tr>
<c:if test="${articlePage.hasNoArticles()}">
   <tr>
      <td colspan="4">게시글이 없습니다.</td>
   </tr>
</c:if>
<c:forEach var="article" items="${articlePage.content}">
   <tr>
      <td>${article.postNo}</td>
      <td>
      <a href="noticeread.do?postNo=${article.postNo}&pageNo=${articlePage.currentPage}">
      <c:out value="${article.title}"/>
      </a>
      </td>
      <td>${article.writer.name}</td>
      <td>${article.readCnt}</td>
   </tr>
</c:forEach>
<c:if test="${articlePage.hasArticles()}">
   <tr>
      <td colspan="4">
         <c:if test="${articlePage.startPage > 5}">
         <a href="noticelist.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
         </c:if>
         <c:forEach var="pNo" 
                  begin="${articlePage.startPage}" 
                  end="${articlePage.endPage}">
         <a href="noticelist.do?pageNo=${pNo}">[${pNo}]</a>
         </c:forEach>
         <c:if test="${articlePage.endPage < articlePage.totalPages}">
         <a href="noticelist.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
         </c:if>
      </td>
   </tr>
</c:if>
</table>
</body>
</html>