<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stadia's Home</title>
</head>
<body>
	<div>
		int : ${number}<br><br>
		
		ArrayList[0] : ${arrayList[0]}<br>
		ArrayList[1] : ${arrayList[1]}<br>
		ArrayList[2] : ${arrayList[2]}<br><br>
		
		HashMap.name : ${map1.name}<br>
		HashMap.email : ${map1.email}<br>
		
<!-- ----------------------------------------------------------- -->
		<!-- EL이 아닌 Java Block 이용 시 -->
		
		int : <%=request.getAttribute("result")%><br><br>
		
		ArrayList[0] : <%=(List)request.getAttribute("arrayList")%><br>
		ArrayList[1] : <%=request.getAttribute("arrayList")%><br>
		ArrayList[2] : ${arrayList[2]}<br><br>
		
		HashMap.name : ${map1.name}<br>
		HashMap.email : ${map1.email}<br>
	</div>
</body>
</html>