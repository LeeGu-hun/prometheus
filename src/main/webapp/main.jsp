<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"
	type="text/javascript"></script>

<script>
	function searchInfo(buslineId) {

		$.ajax({
			url : "/prometheus/searchBInfo",
			method : "GET",
			data : "buslineId=" + buslineId,/* + "&linenum=" + linenum */
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
	
	
</script>
</head>
<body>
	<div id="main" >
		<h1>메인페이지</h1>
		<div id="left" style="background-color: yellow;	 float: left; width:20%; height: 800px; text-align: left;">
			<div id="menu">
				<%@include file="/include/menu.jsp"%>
			</div>
			<div id="search" style="background-color: green">
				<%@include file="/search/search_view.jsp"%>
			</div>
			<div id="result" style="background-color: beige">
				<%@include file="/search/bus_search_result.jsp"%>
			</div>
		</div>
		<div id="right" style="float: left; width: 80%; height: 800px;">
			<div id="map" style="width: 100%; height: 800px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=66a85d4816bb221219a1d74fd28e15d3"></script>
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
		

		function panTo(GpsX,GpsY,bname) {
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
		</div>
	</div>
</body>
</html>