<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  ----------------------------------------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stadia's Home</title>
</head>
<body>
	<div>
		<form action="/oddOrEven2">
			<input type="text" name="n" />
			<input type="submit" value="submit" />
		</form>
		Result : <%=request.getAttribute("result")%>
		<!-- "result"로 보냈으니 "result"로 받기 -->
	</div>
</body>
</html>