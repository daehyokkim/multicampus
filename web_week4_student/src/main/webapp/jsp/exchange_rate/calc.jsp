<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		double cash = Integer.parseInt(request.getParameter("cash"));
		String menu = request.getParameter("menu");
		double er =1200;
		if(menu.equals("1")){
			out.print("변환결과<br>");
			out.print(cash/er+"<br>");
		}
		else if(menu.equals("2")){
			er = 1300;
			out.print("변환결과<br>");
			out.print(cash/er+"<br>");
		}
		else{
			out.print("무엇으로 변환 하시게요>>??? 뒤로가세요~!");
		}
	%>
	<a href="request_calc.jsp">환율 계산기</a>
</body>
</html>