<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the Grocery Shop!!</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" value="shopping" name="action">
		<input type="hidden" value="shop3" name="shopid">
		Rice: <input type="checkbox" name="c7" value="Rice">
		Flour: <input type="checkbox" name="c8" value="Flour">
		Wheat: <input type="checkbox" name="c9" value="Wheat">
		<input type="submit" value="Generate Bill">
	</form>
</body>
</html>