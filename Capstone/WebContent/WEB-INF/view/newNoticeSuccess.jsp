<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 등록</title>
<link href="css/background.css?ver=2" rel="stylesheet" type="text/css" >
</head>
<body>
<header class="title">
        <h1>Capstone Design Management System</h1>
</header>

공지사항을 등록했습니다.
<br>
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/noticelist.do">[공지사항목록보기]</a>


<%--아랫부분은 필요없음!! --%>
<a href="${ctxPath}/noticeread.do?no=${newArticleNo}">[공지사항내용보기]</a>
</body>
</html>