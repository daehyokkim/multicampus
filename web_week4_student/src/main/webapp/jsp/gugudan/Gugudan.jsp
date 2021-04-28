<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%="Welcom Java Server Pager" %></h1>
	<h1><%
		String name = "Java Web";
		//out이라는 객체가 브아우저와 연결 되어있어 변수값 출력시 사용하는 개체
		out.print(name);
	%></h1>
	<a href="request_gugu.jsp">뒤로가기</a><br>
	
	<!-- 스크립트릿 -->
	<%
		//request는 내장객체라고 한고 getParameter통해 데이터를 꺼낼수 있다.파라미터값은 key값을 나타낸다.
		String temp = request.getParameter("dan");
		int dan = Integer.parseInt(temp);
		
		for(int i =1;i<10;i++){
				//out깩체는 순수하게 데이터를 브라우저로 보내는 역할을 함 response객체를 생성해서 개발자가 
				out.print(dan+" * "+i+" = "+dan*i+"<br>");
			}
	%>	
</body>
</html>