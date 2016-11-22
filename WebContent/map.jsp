<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="com.maps.IframeBuilder" %>
<title>Hello world!</title>
</head>
<body>
<h1>Hello world!</h1>
<p> <%= IframeBuilder.sayHi() %> </p>
<p> <%= IframeBuilder.buildIFrame() %> </p>
<!-- <iframe width="600" height="450" 
	  src="https://www.google.com/maps/embed/v1/place?q=Harrods,Brompton%20Rd,%20UK
      &zoom=5
      &key=AIzaSyBJ7LMpz_qI7C0on4EM46tH1kvjGWB2vnc">
  </iframe> -->
</body>
</html>