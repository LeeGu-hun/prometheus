<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
	a:link {color: blue; text-decoration: none;}
	a:visited {	color: blue; text-decoration: none;}
	a:hover {color: red; text-decoration:underline; font-weight: bold;}
	
	#linTable {width: 100%;	height: 380px; overflow: auto; float: right; margin-top: 10px; }
	#linTable1 {width: 100%;	height: 467px; overflow: auto; float: right; margin-top: 10px; }
	#linTable2 {width: 100%;	height: 553px; overflow: auto; float: right; margin-top: 10px; }
	
	.crowdImg {max-height: 30px; width: auto;	margin-left: 15px;}
	#nodeIdTd{width: 200px;}
	
	#th{
	padding-left: 20px;
	background-color:#ffffff;
	border:2px solid #5494fe;
	border-radius :0 20px 20px 0;
	cursor:pointer;
	color:#666666;
	font-family:Arial;
	font-size:20px;
	font-weight:bold;
	text-decoration:none;
	text-shadow:0px 0px 15px #ffffff;
	}
	
</style>
<body>
	<c:choose>
		<c:when test="${bSize >= 3}">
			<div id="linTable">
		</c:when>
		<c:when test="${bSize == 2}">
			<div id="linTable1">
		</c:when>
		<c:otherwise>
			<div id="linTable2">
		</c:otherwise>
	</c:choose>
		<table>
			<th id="th" colspan="4">${BusLine.get(0).lineNo }번 버스</th>
			<c:forEach var="bl" items="${BusLine }">
				<tr>
					<!--searchBusStopInfo('${b.bstopId }','${b.bstopGpsX }','${b.bstopGpsY }','${b.bstopName }  -->
					<td >${bl.bstopIdx }</td>
					<td id="nodeIdTd"><a href="#" onclick="blineGps('${bl.nodeId }')">${bl.bstopnm }</a></td>
					<td>${bl.carNo }</td>
					<c:choose>
						<c:when test="${bl.carNo != null}">
							<c:choose>
								<c:when test="${bl.crowded <= 20}">
									<td><img class="crowdImg"
										src="https://blogfiles.pstatic.net/MjAxODA0MTZfOTcg/MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png">
									</td>
								</c:when>
								<c:when test="${bl.crowded < 35}">
									<td><img class="crowdImg"
										src="https://blogfiles.pstatic.net/MjAxODA0MTZfNDEg/MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png">
									</td>
								</c:when>
								<c:otherwise>
									<td><img class="crowdImg"
										src="https://blogfiles.pstatic.net/MjAxODA0MTZfMTQg/MDAxNTIzODY5MjU3NDgx.a8kS9vmgZcV8xZQ6LMjBbmzsEytJIEfENusu_i2H4qkg.xVRPaORFC6BEuTdY0su_5DtsQrro_1EOHl2xgKTf7E0g.PNG.aaz77/3.png">
									</td>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>