<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<table>
		<c:forEach var="bi" items="${BusInfo }">
			<tr>
				<td>버스번호 :${bi.buslinenum }</td>
			</tr>
			<tr>
				<td>버스타입 :${bi.bustype }</td>
			</tr>
			<tr>
				<td>버스회사 :${bi.companyid }</td>
			</tr>
			<tr>
				<td>종점 :${bi.endpoint }</td>
			</tr>
			<tr>
				<td>막차시간 :${bi.endtime }</td>
			</tr>
			<tr>
				<td>첫차시간 :${bi.firsttime }</td>
			</tr>
			<tr>
				<td>노선ID :${bi.lineId }</td>
			</tr>
			</tr>
		</c:forEach>
	</table>
		<div style="width: 100%; height: 200px; overflow: auto">
		<table>
			<c:forEach var="bl" items="${BusLine }">

				<tr>

					<td>${bl.bstopIdx }</td>
					<td><a href="#" onclick="blineGps('${bl.nodeId }')">${bl.bstopnm }</td>
					<td>${bl.carNo }</td>


				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>