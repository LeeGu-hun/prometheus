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
	
	.bustype1 {
	    float: left;
	    background: no-repeat 0 -750px url(http://t1.daumcdn.net/localimg/localimages/07/2013/map/ico_bus_2.png);
	    width: 23px;
	    height: 20px;
	    margin-left: 3px;
	    margin-right: 5px;
	    background-position: 0 -795px;
	}
	
	.bustype2 {
	    float: left;
	    background: no-repeat 0 -750px url(http://t1.daumcdn.net/localimg/localimages/07/2013/map/ico_bus_2.png);
	    width: 23px;
	    height: 20px;
	    margin-left: 3px;
	    margin-right: 5px;
	    background-position: 0 -895px;
	}
	
	.bustype3 {
	    float: left;
	    background: no-repeat 0 -750px url(http://t1.daumcdn.net/localimg/localimages/07/2013/map/ico_bus_2.png);
	    width: 23px;
	    height: 20px;
	    margin-left: 3px;
	    margin-right: 5px;
	    background-position: 0 -995px;
	}
	.bustype4 {
	    float: left;
	    background: no-repeat 0 -750px url(http://t1.daumcdn.net/localimg/localimages/07/2013/map/ico_bus_2.png);
	    width: 23px;
	    height: 20px;
	    margin-left: 3px;
	    margin-right: 5px;
	    background-position: 0 -945px;
	}
	.bustype5 {
	    float: left;
	    background: no-repeat 0 -750px url(http://t1.daumcdn.net/localimg/localimages/07/2013/map/ico_bus_2.png);
	    width: 23px;
	    height: 20px;
	    margin-left: 3px;
	    margin-right: 5px;
	    background-position: 0 -870px;
	}
	
	#imgsize{
	    float: right;
	    height: 35px;
	    width: auto;
	    margin: 5px;
	}
	.busNumTable{width: 95%; margin:10px 5px 5px 5px; padding:0 5px 5px 0; border: 1px solid #5e5e5e; border-radius: 5px; }
	.busTd{margin: 0; padding: 0; }
	#busNumDiv{width: 100%; max-height:268px; overflow: auto;}
	.busInfo{padding-left:30px; font-size: 12px; color: #5e5e5e; font-weight: bold;}
	#busNumMainDIv{width: 100%; height: 100%;}
</style>
<body>
<div id="busNumMainDIv">
	<div id="busNumDiv" >
		<c:forEach var="b" items="${map.BusNumInfo }" varStatus="i">
			<table class="busNumTable">
				<tr>
					<td class="busNumTd">
					<c:choose>
							<c:when test="${b.busType == '일반버스'}">
								<span class="bustype1"></span>
							</c:when>					
							<c:when test="${b.busType == '마을버스'}">
								<span class="bustype2"></span>
							</c:when>					
							<c:when test="${b.busType == '급행버스'}">
								<span class="bustype3"></span>
							</c:when>
							<c:when test="${b.busType == '심야버스(급행)'}">
								<span class="bustype4"></span>
								<span class="bustype3"></span>
							</c:when>
							<c:when test="${b.busType == '심야버스(일반)'}">
								<span class="bustype4"></span>
								<span class="bustype1"></span>
							</c:when>					
							<c:otherwise>
								<span class="bustype5"></span>
							</c:otherwise>
					</c:choose>
						<a href="#" class="buslinenum"onclick="searchInfo('${b.lineId }','${map.infoSize}');">${b.busLineNum}</a>
					</td>
					<td align="right" rowspan="2"><a href="#" class="buslinenum"onclick="searchInfo('${b.lineId }', '${map.infoSize}');"><img id="imgsize" src="https://cdn0.iconfinder.com/data/icons/geo-points/154/bus-512.png"></a></td>
				</tr>
				<c:choose>
					<c:when test="${b.startPoint == '0'}">
					</c:when>
					<c:otherwise>
						<tr>
							<td class="busInfo">
							${b.startPoint}
							<img src="http://t1.daumcdn.net/localimg/localimages/07/2011/icon/ico_twoarrow2.gif"/>
							${b.endPoint}
							</td>						
						</tr>
						<tr>
							<td class="busInfo">첫차 : ${b.firstTime } 막차 : ${b.endTime }</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</c:forEach>
	</div>
	<span id="loadMapGps"></span>
	<div id="searchNumResult"></div>
</div>
</body>
</html>