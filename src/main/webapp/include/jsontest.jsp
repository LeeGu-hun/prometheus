<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="refresh" content="1;url=#">
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#data{
	width: 340px;
	height: 80px;
	font-size: 24px;
	border: 1px solid skyblue;
	border-radius: 1em;
	margin-bottom: 1px;
	text-align: center;
}
#jsontitle{
	width: 100%;
	height: 100px;
	text-align: center;
}
#datapostion{
	position: absolute;
	top:150px;
	left:790px;
}
</style>
</head>
<body>
<div id="jsontitle"><h1>현재 버스 상황</h1></div>
	<div id = "datapostion">
		<c:forEach var="b" items="${busCrowded }" varStatus="i">
			<div id="data"><P> 차량번호 : ${b.carNo } // 혼잡도 : ${b.crowded }</P></div>		
		</c:forEach>
	</div>
</body>
</html>