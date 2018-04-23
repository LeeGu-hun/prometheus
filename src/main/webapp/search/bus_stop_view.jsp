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
	a:visited {	color: blue;	text-decoration: none;}
	a:hover {	color: red;	text-decoration: underline;font-weight: bold;}

	.stopType1 {
	    float: left;
	    background: no-repeat 0 -750px url(http://t1.daumcdn.net/localimg/localimages/07/2013/map/ico_bus_2.png);
	    width: 23px;
	    height: 20px;
	    margin-left: 3px;
	    margin-right: 5px;
	    background-position: 0 -795px;
	}
	.stopType2 {
	    float: left;
	    background: no-repeat 0 -750px url(http://t1.daumcdn.net/localimg/localimages/07/2013/map/ico_bus_2.png);
	    width: 23px;
	    height: 20px;
	    margin-left: 3px;
	    margin-right: 5px;
	    background-position: 0 -895px;
	}
	#busStopNameTable{width: 95%; margin:5px; padding: 5px 0 5px 0; }
	#busStopNameTable tr{height: 27px;}
	.busStopNames{border: 1px solid black; height: 20px;}
	#pageDiv{width: 95%; margin:20px 5px 5px 5px; padding: 5px 0 5px 0; }
	
	.pageTable{margin: 0; padding: 0;}
	.pageBtn {
	width: 30px;
	height: 30px;
	background-color:#ffffff;
	border:2px solid #5494fe;
	display:inline-block;
	cursor:pointer;
	color:#666666;
	font-family:Arial;
	font-size:13px;
	font-weight:bold;
	text-decoration:none;
	text-shadow:0px 0px 15px #ffffff;
	}
	.prev {
		font-size:15px;
		-moz-border-radius:12px;
		-webkit-border-radius:12px;
		border-radius: 40px 0 0 40px;
	}
	
	.next{	
		font-size:15px;
		-moz-border-radius:12px;
		-webkit-border-radius:12px;
		border-radius:0 40px 40px 0;
	}
	.pageBtn:hover {
		border:2px solid black;
		background-color:#5494fe;
		color: white;
	}
	.pageActive {
		position:relative;
		background-color:#5494fe;
		color: white;
		border:2px solid black;
	}
</style>
<body>
	<div id="bStopbody">
		<table id="busStopNameTable">
			<c:forEach var="b" items="${map.bstop }" varStatus="i">
				<tr>
					<td><input type="hidden" id="bstopId" value="${b.bstopId }" />
						<input type="hidden" id="bstopId" value="${b.bstopGpsX }" /> <input
						type="hidden" id="bstopId" value="${b.bstopGpsY }" /></td>
					<td class="busStopNames">
						<c:choose>
							<c:when test="${b.bstopType == '일반'}">
								<span class="stopType1"></span>
							</c:when>					
							<c:when test="${b.bstopType == '마을'}">
								<span class="stopType2"></span>
							</c:when>					
							<c:otherwise>
								<span> [ b.bstopType ] </span>
							</c:otherwise>
						</c:choose>
						<a href="#" class="busStopName" onclick="searchBusStopInfo('${b.bstopId }','${b.bstopGpsX }','${b.bstopGpsY }','${b.bstopName }');">${b.bstopName } </a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="pageDiv" align="center">
		<table id="pageTable">
			<tr>
				<c:choose>
					<c:when test="${map.currentPage <= 1}">
						<td></td>
					</c:when>					
					<c:otherwise>
						<td>
							<form class="searchform cf" action="searchbStop" method="get">
 								<input type="hidden" name="busStop"id="busStop" value="${map.station}">
 								<input type="hidden" name="page"id="page" value="${map.currentPage - 1 }">
 									<button type="submit" class="pageBtn prev">◀</button>
							</form>
						</td>
					</c:otherwise>
					</c:choose>
				<c:forEach var="i" begin="${map.startPage}" end="${map.endPage}" step="1">
					<td class="pageTable">
						<form class="searchform cf" action="searchbStop" method="get">
							<c:choose>
								<c:when test="${i == map.currentPage}">
									<input type="hidden" name="busStop"id="busStop" value="${map.station}">
 									<input type="hidden" name="page"id="page" value="${i}">
 									<button type="submit" class="pageBtn pageActive">${i}</button>
								</c:when>					
								<c:otherwise>
									<input type="hidden" name="busStop"id="busStop" value="${map.station}">
 									<input type="hidden" name="page"id="page" value="${i}">
 									<button type="submit" class="pageBtn">${i}</button>
								</c:otherwise>
							</c:choose> 							
						</form>
					</td>
				</c:forEach>
				<c:choose>
					<c:when test="${map.endPage < map.totalPage}">
						<td>
							<form class="searchform cf" action="searchbStop" method="get">
								<input type="hidden" name="busStop"id="busStop" value="${map.station}">
 								<input type="hidden" name="page"id="page" value="${map.currentPage + 1 }">
								<button type="submit" class="pageBtn next">▶</button>
							</form>						
						</td>
					</c:when>					
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</div>
	<div id="searchbStopResult"></div>
</body>
</html>