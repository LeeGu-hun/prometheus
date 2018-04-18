<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.grid_1 {
	width: 50%;
	margin: 0;
	padding: 0; 
	float : left;
	display: block;
	float: left;
}

.grid_2 {
	width: 50%;
	margin: 0;
	padding : 0;
	float : left;
	display: block;
	float: left;
}

/* Slide 5 */
#slide5 {
	margin: 0;
	padding: 0;
}

#slide5 p {
	font-size: 18px;
	color: white;
}

.contactype {
	position: relative;
	cursor: pointer;
	font-weight: bold; 
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
	text-align: center;
	background-color: #5e5e5e;
	height: 50px;
	float: left;
	transition: all .3s ease-in;
	color: white;
}

.contactype p {
	width: 100%;
	text-align: center;
	position: absolute;
	bottom: -3.5px;
	left: 0;
	padding: 0 !important;
}

.contactype:hover {
	background-color: #5494fe;
}
</style>


<body>
	<div class="slide" id="slide5" data-slide="5"
		data-stellar-background-ratio="0.5">
		<div class="container clearfix">
			<div class="content grid_1 contactype" id="contact-mapClick"
				onclick="location.href='./busNumSearch'">
				<p>번호검색</p>
			</div>
			<div class="content grid_2 contactype" id="contact-carClick"
				onclick="location.href='./busStopSearch'">
				<p>정류소 검색</p>
			</div>
		</div>
	</div>
</body>
</html>