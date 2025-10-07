<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Register here!!</h1>
<form action="register.do" method="post">
		<input type="hidden" name="action" value="register"> Username: <input
			type="text" name="uname"> Password: <input type="password"
			name="upass">
			<input type="submit" value="register">
	</form>
</body>
</html>