<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stadia's Home</title>
</head>
<%
// 저장소의 우선순위 :
// page > request > session > application

// page 내에서 쓸 수 있는 page 내장 객체
pageContext.setAttribute("number", 1234);
%>
<body>
	<div>
		int : ${number}<br><br>  <!-- 1234 -->
		
		sessionScope.int : ${requestScope.number}<br><br> <!-- 1012 -->
		<!-- request로 범위 한정 -->
		
		<!-- 4대 저장소 외에도 EL을 통해 불러올 수 있는 다양한 내장 객체 존재 -->
		header.host : ${header.host}<br>
		header.Accept-Language : ${header["Accept-Language"]}<br><br>
		<!-- 변수명명 규칙에 위배될 때 이렇게 사용 -->
		
		param.n : ${param.n} <!-- ?n=숫자 로 전달 --> <br><br>
		
		<br>
		-------------------------------<br>
		+ EL로 pageContext 사용 시,<br>
		EL에서 메소드는 이용불가하지만 get메소드는 가능. 단, "get"생략.<br><br>
		
		예를들어,<br>
		&#36;{pageContext.getRequest().getMethod()} 가 아니라,<br>
		&#36;{pageContext.request.method} 처럼 사용<br>
		
	</div>
</body>
</html>