<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Vegetables shop!!</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" name="action" value="shopping">
		<input type="hidden" name="shopid" value="shop2">
		Potato: <input type="checkbox" name="c4" value="Potato">
		Garlic: <input type="checkbox" name="c5" value="Garlic">
		Capsicum: <input type="checkbox" name="c6" value="Capsicum">
		<input type="submit" value="Next">

	</form>
</body>
</html>