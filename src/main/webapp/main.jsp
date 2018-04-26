<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 페이지</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" media="all" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"
	type="text/javascript"></script>

<script>
	function searchInfo(buslineId, infoSize) {
		var allData = {
				"buslineId" : buslineId,
				"infoSize" : infoSize
			};
		
		$.ajax({
			url : "/prometheus/searchBInfo",
			method : "GET",
			data : allData,/* + "&linenum=" + linenum */
			success : function(response) {
				$('#searchNumResult').html(response);
			}
		});
	}
	
	function blineGps(busNodeId) {

		$.ajax({
			url : "/prometheus/searchBGps",
			method : "GET",
			data : "busNodeId=" + busNodeId,/* + "&linenum=" + linenum */
			success : function(msg) {
				$('#loadMapGps').html(msg);
			}
		});
	}
	function searchBusStopInfo(bStopId,bstopGpsX,bstopGpsY,bstopName) {
		var allData = {
				"bStopId" : bStopId,
				"bstopGpsX" : bstopGpsX,
				"bstopGpsY" : bstopGpsY,
				"bstopName" : bstopName
			};
		
		
		$.ajax({
			url : "/prometheus/searchbStopInfo",
			method : "GET",
			data : allData,/* + "&linenum=" + linenum */
			success : function(msg) {
				$('#searchbStopResult').html(msg);
			}
		});
	}
	
</script>
</head>
<style>
	body{margin: 0; padding: 0;}

	#left,#right{border-top: 3px solid black; border-bottom: 3px solid black;}
	#left{background-color:white; float: left; width: 20%; height: 750px; text-align: left;}
	#right{float: left; width: 79.7%; height: 750px; border-left: 2px solid black; }
	#map{width: 100%; height: 750px; }
	#road{
	  width: 99.7%;
	  height: 80px;
	  background-color:gray;
	  margin:0;
	  clear:both;
	  border-radius:2px;
	}
	
	.bus {
	    display: inline-block;
	    width: 90px;
	    height: 45px;
	    clear:both;
	    margin:20px 0px 0px 10px;
	 	border-radius:17px 10px 2px 2px;  
	    position :relative;
	  animation: mymove 7s infinite normal ease-in-out;
	  -webkit-animation: mymove 7s infinite normal ease-in-out;
	}
	
	
	/* 
	@-webkit-keyframes mymove {
	    0%   { left: 300px; background-color:  green;}
	    25%  { left: 700px; background-color:  green;}
	    50%  {left: 1100px; background-color: orange;}
	    100% {left: 1500px; background-color: red;}
	}
	
	@keyframes mymove {
	    0%   { left: 300px; background-color:  green;}
	    25%  { left: 700px; background-color:  green;}
	    50%  {left: 1100px; background-color: orange;}
	    100% {left: 1500px; background-color: red;}
	}
	 */ 
	
	@-webkit-keyframes mymove {
	    0%   { left: -300px;background-color: red;}
	    50%  {left: 700px; background-color: red;}
	    100% {left: 1500px;background-color: red;}
	}
	
	@keyframes mymove {
	    0%   { left: -300px;background-color: red;}
	    50%  {left: 700px; background-color: red;}
	    100% {left: 1500px;background-color: red;}
	}
	
	
	
	#whell1{
	  position:absolute;
	  display: inline-block;
	  width:14px;
	  height:14px;
	  background-color:black;
	  border-radius:80px;
	  margin:37px 65px;
	  background-position: center center;
	  }
	
	
	#whell2{
	  position:absolute;
	  display: inline-block;
	  width:14px;
	  height:14px;
	  background-color:black;
	  border-radius:80px;
	  margin:37px 10px;
	  background-position: center center;
	  }
	
	#whell3{
	  position:absolute;
	  display: inline-block;
	  width:8px;
	  height:8px;
	  background-color:transparent;
	  border:1.5px dotted white;
	  border-radius:80px;
	  margin:39px 67.1px;
	  background-position: center center;
	  }
	
	
	#whell4{
	  position:absolute;
	  display: inline-block;
	  width:8px;
	  height:8px;
	  background-color:transparent;
	  border:1.5px dotted white;
	  border-radius:80px;
	  margin:39px 11.9px;
	  background-position: center center;
	  }
	
	
	#win1{
	  position:absolute;
	  display: inline-block;
	  width:12px;
	  height:12px;
	  background-color:white;
	  border-radius:4px 0 0 0;
	  margin:5px 20px 0px 8px;
	  background-position: center center;
	  }
	#win2{
	  position:absolute;
	  display: inline-block;
	  width:18px;
	  height:12px;
	  background-color:white;
	  border-radius:3px 3px 0px 0px; 
	  margin:5px 33px 0px 24px;
	  background-position: center center;
	  }
	
	#win3{
	  position:absolute;
	  display: inline-block;
	  width:18px;
	  height:12px;
	  background-color:white;
	  border-radius:3px 3px 0px 0px; 
	  margin:5px 54px 0 48px;
	  background-position: center center;
	  }
	
	#win4{
	  position:absolute;
	  display: inline-block;
	  width:12px;
	  height:12px;
	  background-color:white;
	  border-radius:0 4px 0 0;
	  margin:5px 54px 0 72px;
	  background-position: center center;
	  }
	
	#line{
	    position:relative;
	    width: 1200px;
	     top:40px;
	    height: 1px;
	    clear:both;
	    margin-left: auto;
	    margin-right:auto;
	 	border:1px dashed white;
	}
	
	#fuel{
	  position:absolute;
	  display: inline-block;
	  width:5px;
	  height:1.5px;
	  background-color:#1D1F20;
	  border-radius:0px;
	  margin:42px -5px;
	  background-position: center center;
	  transform:rotate(-18deg);  
	}
	
	#light{
	  z-index:1;
	  position:absolute;
	  display: inline-block;
	  width:4px;
	  height:7.8px;
	  background-color:black;
	  border-radius:80px;
	  margin:27px 90px;
	  border-radius: 0 90px 90px 0;
	  background:#f93100;
	 
	}
	
	#up1{
	  position:absolute;
	  display: inline-block;
	  width:50px;
	  height:2px;
	  background-color:white;
	  border-radius:4px 4px 0 0;
	  margin:-5px 0px 0px 19px;
	  background-position: center center;
	  }
	
	#up2{
		position:absolute;
		display: inline-block;
		width:2px;
		height:5px;
		background-color:white;
		margin:-5px 0px 0px 26px;
		background-position: center center;
	  }
	
	#up3{
		position:absolute;
		display: inline-block;
		width:2px;
		height:5px;
		background-color:white;
		margin:-5px 0px 0px 60px;
		background-position: center center;
	}
	
	#foggy{
		width:4px;
		height:7.8px;
		border-right:200px solid #f7f771;
		border-top:20px solid transparent;
		border-left:20px solid transparent;
		border-bottom:20px solid transparent;
		border-radius:100px;
		margin:90px 60px;
		position:absolute;
		margin:7px 68px;
	  }

	::-webkit-scrollbar-track{-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); border-radius: 10px; background-color: #F5F5F5;}
	::-webkit-scrollbar{width: 12px; background-color: #F5F5F5;}
	::-webkit-scrollbar-thumb{border-radius: 10px; -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);background-color: #5283f4;}
	
	
</style>
<body>
	<div id="main">
		<h1>Team Prometheus</h1>
		<div id="left">
			<div id="menu">
				<%@include file="/include/menu.jsp"%>
			</div>
			<div id="search">
				<%@include file="/search/search_view.jsp"%>
			</div>
			<div id="result">
				<%@include file="/search/bus_search_result.jsp"%>
			</div>
		</div>
		<div id="right" class="inline-svg">
			<div id="map"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=66a85d4816bb221219a1d74fd28e15d3">
			</script>
		</div>	
<script>
		// 지도를 표시할 div 
		
		if(${cmd == '/searchbStop'}){
				var mapContainer = document.getElementById('map'), 
				mapOption = {
					// 지도의 중심좌표
					center : new daum.maps.LatLng('${map.bstop.get(0).bstopGpsY}', '${map.bstop.get(0).bstopGpsX}'), 
					// 지도의 확대 레벨
					level : 3 
				};
		}else{
			var mapContainer = document.getElementById('map'), 
			mapOption = {
				// 지도의 중심좌표 X=,Y=
				center : new daum.maps.LatLng('35.15332040526', '129.059362360916'), 
				// 지도의 확대 레벨
				level : 3 
			};
			
		}
		
		// 지도 생성
		var map = new daum.maps.Map(mapContainer, mapOption); 
		var markers = [];

		var mapTypeControl = new daum.maps.MapTypeControl();
		// 지도에 컨트롤을 추가
		// daum.maps.ControlPosition은 컨트롤이 표시될 위치를 정의 TOPRIGHT= 오른쪽 위
		map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);

		// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
		var zoomControl = new daum.maps.ZoomControl();
		map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);

		
		function overlay(conOverLay, GpsX,GpsY,bname){
			 for (var i = 0; i < markers.length; i++) {
			        markers[i].setMap(null);
			    }      
			// 이동할 위도 경도 위치 생성함
			var moveLatLon = new daum.maps.LatLng(GpsY, GpsX);
	
			//부드럽게 지도 중심 이동(너무 멀땐 안됨)
			map.panTo(moveLatLon);
			
			// 마커 위도 경도 위치 생성
			var markerPosition = new daum.maps.LatLng(GpsY, GpsX); 

			// 마커 생성
			var marker = new daum.maps.Marker({
			    position: markerPosition
			});

			var content = conOverLay;
			
			// 마커 위에 커스텀오버레이를 표시합니다
			// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
			var overlay = new daum.maps.CustomOverlay({
			    content: content,
			    map: map,
			    position: marker.getPosition()       
			});
			
			// 마커 삽입
			marker.setMap(map);
		    overlay.setMap(map);

		    // 생성된 마커를 배열에 추가합니다
		    markers.push(marker);
		    markers.push(overlay);			
				
		}
		
		// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
		function closeOverlay() {
			 for (var i = 0; i < markers.length; i++) {
			        markers[i].setMap(null);
			    }        
		}
		
		function panTo(GpsX,GpsY,bname) {
			 for (var i = 0; i < markers.length; i++) {
			        markers[i].setMap(null);
			    }      
			// 이동할 위도 경도 위치 생성함
			var moveLatLon = new daum.maps.LatLng(GpsY, GpsX);
	
			//부드럽게 지도 중심 이동(너무 멀땐 안됨)
			map.panTo(moveLatLon);
			
			// 마커 위도 경도 위치 생성
			var markerPosition = new daum.maps.LatLng(GpsY, GpsX); 

			// 마커 생성
			var marker = new daum.maps.Marker({
			    position: markerPosition
			});

			// 마커 삽입
			marker.setMap(map);
			
			// 생성된 마커를 배열에 추가합니다
		    markers.push(marker);
			
			// 대가리 표시 내용으로 HTML 문자열이나 document element가 가능
			var iwContent = '<div style="padding:5px;">'+bname+'</div>'; 
			
			// 인포윈도우 생성
			var infowindow = new daum.maps.InfoWindow({
			    content : iwContent
			});

			// 마커 마우스오버 이벤트 등록
			daum.maps.event.addListener(marker, 'mouseover', function() {
			  // 마커에 마우스 가져대면 글자 뜸
			    infowindow.open(map, marker);
			});

			// 마커 마우스아웃 이벤트 등록
			daum.maps.event.addListener(marker, 'mouseout', function() {
			    // 마커에 마우스 떼면 글자없앰
			    infowindow.close();
			});
		}
		
</script>
	<div id = 'road'>
     <div id = 'line'></div>
       <div id = 'tree'></div>   
       <div class = 'bus'>
         <div id = 'up1'></div>
         <div id = 'up2'></div>
         <div id = 'up3'></div>
         <div id = 'win1'></div>
         <div id = 'win2'></div>
         <div id = 'win3'></div>
         <div id = 'win4'></div>
         <div id = 'whell1'></div>
         <div id = 'whell2'></div>
         <div id = 'whell3'></div>
         <div id = 'whell4'></div>
         <div id = 'fuel'></div>
         <div id ='light'></div>
         <div id ='foggy'></div>
   	 </div>
  </div>
</div>
</body>
</html>