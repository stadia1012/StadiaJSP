<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// Controller와 view가 분리된 MVC model 1
	int num = 0;
	String num_ = request.getParameter("n");
	if(num_ != null && !num_.equals("")) {
		num = Integer.parseInt(num_);
	}
	
	String result;
	if(num%2 != 0) {
		result = "홀수입니다.";
	} else {
		result = "짝수입니다.";
	}
%>
<!--  ----------------------------------------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stadia's Home</title>
</head>
<body>
	<div>
		<form action="oddOrEven.jsp">
			<input type="text" name="n" />
			<input type="submit" value="submit" />
		</form>
		결과 : <%=result%>
	</div>
</body>
</html>