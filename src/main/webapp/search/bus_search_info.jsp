<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div style="width: 100%; height: 150px; overflow: auto">
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