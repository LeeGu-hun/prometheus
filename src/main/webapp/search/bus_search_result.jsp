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
		<c:when test="${cmd == '/searchbnum'}">
			<%@include file="/search/bus_search_info.jsp"%>
		</c:when>

		<c:when test="${cmd == '/searchbStop'}">
			<c:if test="${map.bstop.get(0).bstopId != null}">
			<%@include file="/search/bus_stop_view.jsp"%>	
			</c:if>
			<c:if test="${map.bstop.get(0).bstopId == null}">
				<table>
					<tr>
						<td><font size=2>찾을수 없는 정류소입니다.</font></td>
					</tr>
				</table>
			</c:if>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>

</body>
</html>