<%@ page contentType="text/html; charset=utf-8"%>
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
게시글을 수정했습니다.
<br>
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/teamlist.do">[게시글목록보기]</a>
<a href="${ctxPath}/teamread.do?fileNo=${modReq.fileNo}">[게시글내용보기]</a>
</body>
</html>