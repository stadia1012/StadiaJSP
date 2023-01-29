<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// Controller와 view가 분리된 MVC model 1
	// newLecture 님의 강의에 "값을 입력하세요." 메시지를 추가함
	int num = 0;
	String result;
	
	String num_ = request.getParameter("n");
	if(num_ != null && !num_.equals("")) {
		num = Integer.parseInt(num_);
		result = (num%2 != 0)?"odd":"even";
	} else {
		result = "Please enter a value.";
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
		Result : <%=result%>
	</div>
</body>
</html>