<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Daum 지도 시작하기</title>
</head>
<body>
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
		}
		else{
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
		

		function panTo() {
			// 이동할 위도 경도 위치 생성함
			var moveLatLon = new daum.maps.LatLng('${BUSTgpsY.get(0)}', '${BUSTgpsX.get(0)}');
	
			//부드럽게 지도 중심 이동(너무 멀땐 안됨)
			map.panTo(moveLatLon);
			
			// 마커 위도 경도 위치 생성
			var markerPosition = new daum.maps.LatLng('${BUSTgpsY.get(0)}', '${BUSTgpsX.get(0)}'); 

			// 마커 생성
			var marker = new daum.maps.Marker({
			    position: markerPosition
			});

			// 마커 삽입
			marker.setMap(map);
			
			// 대가리 표시 내용으로 HTML 문자열이나 document element가 가능
			var iwContent = '<div style="padding:5px;">${BUSTTname.get(0)}</div>'; 
			
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
	
</body>
</html>