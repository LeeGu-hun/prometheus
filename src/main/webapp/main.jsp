<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<div id="main" >
		<h1>메인페이지</h1>
		<div id="left" style="background-color: yellow;	 float: left; width:20%; height: 800px; text-align: left;">
			<div id="menu">
				<%@include file="/include/menu.jsp"%>
			</div>
			<div id="search" style="background-color: green">
				<%@include file="/search/search_view.jsp"%>
			</div>
			<div id="result" style="background-color: beige">
				<%@include file="/search/bus_search_result.jsp"%>
			</div>
		</div>
		<div id="right" style="float: left; width: 80%; height: 800px;">
			<%@include file="/include/map.jsp"%>
		</div>
	</div>
</body>
</html>