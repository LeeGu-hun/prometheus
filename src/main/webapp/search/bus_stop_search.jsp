<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>정류소 검색</h1>
	<div id="home">
		<form action="search" method="get">
			<div id="header">
				<table>
					<tr>
						<td><label> <input type="text" name="busStop" id="busStop" />
						</label> <input type="submit" value="검색" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>