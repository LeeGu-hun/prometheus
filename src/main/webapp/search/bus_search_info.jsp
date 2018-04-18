<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
	a:link {color: black; text-decoration: none;}
	a:visited {	color: blue;	text-decoration: none;}
	a:hover {	color: red;	text-decoration: underline;}
	
	::-webkit-scrollbar-track{-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); border-radius: 10px; background-color: #F5F5F5;}
	::-webkit-scrollbar{width: 12px; background-color: #F5F5F5;}
	::-webkit-scrollbar-thumb{border-radius: 10px; -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);background-color: #D62929;}

	.busNumDiv{width: 100%; height: 150px; overflow: auto;}
</style>
<body>
	<div class="busNumDiv" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<c:forEach var="b" items="${BusNumInfo }" varStatus="i">
				<tr>
					<td><a href="#" class="buslinenum"
						onclick="searchInfo('${b.lineId }');">${b.buslinenum} </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<span id="loadMapGps"></span>
	<div id="searchNumResult"></div>
</body>
</html>