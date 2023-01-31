<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> <!-- list 사용을 위한 import -->
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stadia's Home</title>
</head>
<body>
	<div>
	<!-- EL이 얼마나 간편한지 보여주는 예제 -->
		<span>---- EL ----</span><br><br>
		
		int : ${number}<br><br>
		
		ArrayList[0] : ${arrayList[0]}<br>
		ArrayList[1] : ${arrayList[1]}<br>
		ArrayList[2] : ${arrayList[2]}<br><br>
		
		array[0] : ${array[0]}<br><br>
		
		HashMap.name : ${map1.name}<br>
		HashMap.email : ${map1.email}<br><br>
		
<!-- ----------------------------------------------------------- -->
		<!-- EL이 아닌 Java Block 이용 시 -->
		<span>---- 표현식 태그 ----</span><br><br>
		
		int : <%=request.getAttribute("number")%><br><br>
		
		ArrayList[0] : <%=((List<?>)request.getAttribute("arrayList")).get(0)%><br>
		<!-- object를 반환하므로 List 형변환 필요 -->
		ArrayList[1] : <%=((List<?>)request.getAttribute("arrayList")).get(1)%><br>
		ArrayList[2] : <%=((List<?>)request.getAttribute("arrayList")).get(2)%><br><br>
		<!-- array는 난해해서 생략 -->
		
		HashMap.name : <%=((Map<String, Object>)request.getAttribute("map1")).get("name")%><br>
		HashMap.name : <%=((Map<String, Object>)request.getAttribute("map1")).get("email")%>
	</div>
</body>
</html>