<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>팀 게시글 등록</title>
<link href="css/background.css?ver=2" rel="stylesheet" type="text/css" >
</head>
<body>
<header class="title">
        <h1>Capstone Design Management System</h1>
</header>

팀 게시글을 등록했습니다.
<br>
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/teamlist.do">[팀게시글목록보기]</a>
<a href="${ctxPath}/teamread.do?no=${newArticleNo}">[팀게시글내용보기]</a>
</body>
</html>