<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome ji welcome!!</h1>

<%
out.println("<h2>" + request.getAttribute("myobj") + "</h2>");
%>
</body>
</html>