<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Already Logged In</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .container {
        background: #fff;
        padding: 40px 50px;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0,0,0,0.2);
        width: 400px;
        text-align: center;
    }

    h1 {
        color: #333;
        margin-bottom: 25px;
    }

    .button {
        display: block;
        width: 100%;
        padding: 12px;
        margin: 10px 0;
        font-size: 16px;
        font-weight: bold;
        color: #fff;
        background-color: #4CAF50;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        text-decoration: none;
    }

    .button:hover {
        background-color: #45a049;
    }

    .logout-button {
        background-color: #f44336;
    }

    .logout-button:hover {
        background-color: #da190b;
    }

    form {
        margin: 0;
    }
</style>
</head>
<body>

<div class="container">
    <h1>User is already logged in!!</h1>

    <form action="/welcome" method="GET">
        <input type="submit" class="button" value="Go to Dashboard">
    </form>

    <form:form action="/already" method="POST" modelAttribute="userObj">
        <input type="submit" class="button logout-button" value="Logout">
    </form:form>
</div>

</body>
</html>
