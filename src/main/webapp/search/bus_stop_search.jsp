<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정류소 검색</title>
</head>
<style>

#header{ margin-top: 0; padding: 0; }
#busStop{width: 70%; height: 30px; margin: 5px 10px 0 5px; padding: 0; border-right:0px; border-top:0px; boder-left:0px; border-bottom: 2px solid #5494fe; }
@import url(https://fonts.googleapis.com/css?family=BenchNine:700);
.snip1535 {
  background-color: #5494fe;
  border: none;
  color: #fff;
  margin-top: 10px;
  cursor: pointer;
  display: inline-block;
  font-family: 'BenchNine', Arial, sans-serif;
  outline: none;
  padding: 7px 10px 7px;
  position: relative;
  text-transform: uppercase;
}
.snip1535:before,
.snip1535:after {
  border-color: transparent;
  -webkit-transition: all 0.25s;
  transition: all 0.25s;
  border-style: solid;
  border-width: 0;
  content: "";
  height: 25px;
  position: absolute;
  width: 25px;
}
.snip1535:before {
  border-color: #5494fe;
  border-right-width: 2px;
  border-top-width: 2px;
  right: -5px;
  top: -5px;
}
.snip1535:after {
  border-bottom-width: 2px;
  border-color: #5494fe;
  border-left-width: 2px;
  bottom: -5px;
  left: -5px;
}
.snip1535:hover,
.snip1535.hover {
  background-color: #5494fe;
}
.snip1535:hover:before,
.snip1535.hover:before,
.snip1535:hover:after,
.snip1535.hover:after {
  height: 100%;
  width: 100%;
}
</style>
<body>
	<div id="searchResult">
		<form class="searchform cf" action="searchbStop" method="get">
 			<div id="header">
				<input type="text" name="busStop"id="busStop" placeholder="What are you looking for BusStop?">
 				<input type="hidden" name="page"id="page" value="1">
 				<button type="submit" class="snip1535">Search</button>
			</div>
		</form>
	</div>
</body>
</html>