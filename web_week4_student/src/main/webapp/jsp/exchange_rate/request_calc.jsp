<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환율계산기</title>
</head>
<body>
	<h1>환율계산기</h1>
	<form action="calc.jsp" method="post">
		원화 : <input type="text" name="cash"/>
		<select name="menu">
			<option value="0">--선택--</option>
			<option value="1">달러</option>
			<option value="2">유로</option>
		</select>
		<input type="submit" value="입력"/>
	</form>
</body>
</html>