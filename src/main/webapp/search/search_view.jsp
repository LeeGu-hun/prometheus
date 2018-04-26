<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<c:choose>
		<c:when test="${cmd == '/busNumSearch'}">
			<%@ include file="./bus_num_search.jsp"%>
		</c:when>
		<c:when test="${cmd == '/busStopSearch'}">
			<%@ include file="./bus_stop_search.jsp"%>
		</c:when>
		<c:when test="${cmd == '/searchbStop'}">
			<%@ include file="./bus_stop_search.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="./bus_num_search.jsp"%>
		</c:otherwise>
	</c:choose>
</body>
</html>