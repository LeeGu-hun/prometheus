<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div id="bStopbody">
		<table>
			<c:forEach var="b" items="${map.bstop }" varStatus="i">
				<tr>
					<td><input type="hidden" id="bstopId" value="${b.bstopId }" />
						<input type="hidden" id="bstopId" value="${b.bstopGpsX }" /> <input
						type="hidden" id="bstopId" value="${b.bstopGpsY }" /></td>
					<td><a href="#" class="busStopName"
						onclick="searchBusStopInfo('${b.bstopId }','${b.bstopGpsX }','${b.bstopGpsY }','${b.bstopName }');">[${b.bstopType }]
							${b.bstopName } </a>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="searchbStopResult"></div>
</body>
</html>