<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>버스 번호 검색</h1>
	<div id="searchResult">
		<form action="searchbnum" method="get">
			<div id="header">
				<table>
					<tr>
						<td><label> <input type="text" name="busNum"
								id="busNum" />
						</label> <input type="submit" value="검색" /></td>
					</tr>
					
				</table>
			</div>
		</form>
	</div>
</body>
</html>