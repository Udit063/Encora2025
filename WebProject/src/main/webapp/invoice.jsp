<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	<h1>Items you had purchased :</h1>
	<p>
		<%
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = (String) session.getAttribute(name);
			out.println(name + "\t : \t" + value + "<br>");
		}
		%>
	</p>

	<form method="post" action="bill.do">
		<input type="hidden" name="action" value="bill"> <input
			type="submit" value="Generate Bill">
	</form>

</body>
</html>