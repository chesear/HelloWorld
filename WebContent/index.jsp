<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="com.wikiTest.WikiTest" %>
<title>Home</title>
</head>
<body>
	<h1>Merry Christmas!</h1>
	<a href="./map.jsp">See the world!</a>
	<p><%= WikiTest.getTestString() %></p>
	<hr />
	<p><%= WikiTest.getWikiString() %></p>
</body>
</html>