<%@page import="mc.sn.bookconnect.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mc.sn.bookconnect.BookTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database Connect</title>
</head>
<body>
<% 
   BookTest bt = new BookTest();
   ArrayList<BookDTO> list = bt.getBookList();
   for(BookDTO dto : list){
      out.print("<h1>"+dto.getTitle()+"</h1>");
   }

%>
</body>
</html>