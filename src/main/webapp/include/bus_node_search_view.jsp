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

	.linTable {width: 100%;	height: 320px;	overflow: auto;}
	.crowdedImg {max-height: 30px; width: auto;	margin-left: 15px;}
</style>
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
		</c:forEach>
	</table>
	<div class="linTable">
		<table>
			<c:forEach var="bl" items="${BusLine }">
				<tr>
					<!--searchBusStopInfo('${b.bstopId }','${b.bstopGpsX }','${b.bstopGpsY }','${b.bstopName }  -->
					<td>${bl.bstopIdx }</td>
					<td><a href="#" onclick="blineGps('${bl.nodeId }')">${bl.bstopnm }</a></td>
					<td>${bl.carNo }</td>
					<c:choose>
						<c:when test="${bl.carNo != null}">
							<c:choose>
								<c:when test="${bl.crowded <= 20}">
									<td><img class="crowdedImg"
										src="https://blogfiles.pstatic.net/MjAxODA0MTZfOTcg/MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png">
									</td>
								</c:when>
								<c:when test="${bl.crowded < 35}">
									<td><img class="crowdedImg"
										src="https://blogfiles.pstatic.net/MjAxODA0MTZfNDEg/MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png">
									</td>
								</c:when>
								<c:otherwise>
									<td><img class="crowdedImg"
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