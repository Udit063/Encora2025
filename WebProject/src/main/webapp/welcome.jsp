<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Weclome to the Shopping mall!!!</h1>

	<form action="logout.do" method="post">
		<input type="hidden" name="action" value="logout"> <input type="submit"
			value="Logout">
	</form>

	<form action="shopping.do" method="post">
		<input type="hidden"
			name="action" value="next">
			<input type="submit" value="Next">
	</form>

</body>
</html>