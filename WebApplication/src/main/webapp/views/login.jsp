<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            width: 350px;
        }

        .login-container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        .login-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px 12px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .login-container input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            color: white;
            font-weight: bold;
            margin-bottom:10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-container input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error {
            color: red;
            font-size: 0.9em;
            margin-top: -10px;
            margin-bottom: 10px;
        }

    </style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form:form action="/welcome" method="POST" modelAttribute="userObj">
        <label for="uname">Username</label>
        <form:input path="uname" id="uname" />
        <form:errors path="uname" cssClass="error" />

        <label for="upass">Password</label>
        <form:password path="upass" id="upass" />
        <form:errors path="upass" cssClass="error" />

        <input type="submit" value="Login">
    </form:form>
    
     <form action="/register"  method="GET">
        <input type="submit" class="button" value="Register">
    </form>
</div>

</body>
</html>
