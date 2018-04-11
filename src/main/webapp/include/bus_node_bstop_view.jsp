<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<table>
		<c:forEach var="bi" items="${BusStopInfo }">
			<tr>
				<td>[${bi.bustype}] ${bi.lineNo }번버스 </td>
			</tr>	
			<tr>
				<td>[첫번째 차량]${bi.station1 }정거장 전 / ${bi.min1 }분 후 도착</td>
			</tr>
			<tr>
				<td>[두번째 차량]${bi.station2 }정거장 전 / ${bi.min2 }분 후 도착</td>
			</tr>
			
		</c:forEach>

	</table>
</body>
</html>