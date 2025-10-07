<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the Fruits shop!!</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" name="action" value="shopping"> <input
			type="hidden" value="shop1" name="shopid"> Apple : <input
			type="checkbox" name="c1" value="Apple"> Mango : <input
			type="checkbox" name="c2" value="Mango"> Banana : <input
			type="checkbox" name="c3" value="Banana"> <input type="submit"
			value="Next">
	</form>
</body>
</html>