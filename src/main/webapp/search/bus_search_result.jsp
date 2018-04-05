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
	<h1>버스 조회 결과</h1>
	<c:choose>
		<c:when test="${cmd == '/busNumSearch'}">
			<h2> 개발중 </h2>
		</c:when>
		<c:when test="${cmd == '/search'}">
			<c:if test="${map.bstopCount > 0}">
			<div id="body">
				<table>
					<c:forEach var="b"  items="${map.bstop }" varStatus="i">
					<tr>
						<td>
							<input type="hidden" id="bstopId" value="${b.bstopId }"/>
							<input type="hidden" id="bstopId" value="${b.bstopGpsX }"/>
							<input type="hidden" id="bstopId" value="${b.bstopGpsY }"/>
						</td>
						<td>
							<label>[${b.bstopType }]</label>
							<label>정류소명 : ${b.bstopName }  </label>
						</td>
					</tr>					
					</c:forEach>
				</table>
			</div>
		</c:if>
		<c:if test="${map.bstopCount <= 0}">
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