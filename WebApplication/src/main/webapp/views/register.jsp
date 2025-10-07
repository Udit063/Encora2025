<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .register-container {
            background: #fff;
            padding: 35px 45px; /* slightly larger padding than login */
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            width: 370px;
            border: 2px solid #4CAF50; /* subtle green border to differentiate */
        }

        .register-container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
            letter-spacing: 1px; /* subtle styling difference */
        }

        .register-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .register-container input[type="text"],
        .register-container input[type="password"] {
            width: 100%;
            padding: 11px 12px; /* slightly taller inputs */
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .register-container input[type="submit"] {
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

        .register-container input[type="submit"]:hover {
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

<div class="register-container">
    <h2>Create an Account</h2>
    <form:form action="/login" method="POST" modelAttribute="userObj">
        <label for="uname">Username</label>
        <form:input path="uname" id="uname" placeholder="Enter your username"/>
        <form:errors path="uname" cssClass="error" />

        <label for="upass">Password</label>
        <form:password path="upass" id="upass" placeholder="Enter a secure password"/>
        <form:errors path="upass" cssClass="error" />

        <input type="submit" value="Register">
    </form:form>
    
     <form action="/login"  method="GET">
        <input type="submit" class="button" value="Login">
    </form>
</div>

</body>
</html>
