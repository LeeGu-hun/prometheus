<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="b" items="${busCrowded }" varStatus="i">
	<span></span><P> 차량번호 : ${b.carNo } // 혼잡도 : ${b.crowded }</P>		
	</c:forEach>
</body>
</html>