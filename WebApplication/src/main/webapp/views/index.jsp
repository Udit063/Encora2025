<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Expired</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
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
        margin-top: 20px;
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

    form {
        margin: 0;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Your session has expired!</h1>

    <form:form action="/register" method="GET" modelAttribute="userObj">
        <input type="submit" class="button" value="Login Again">
    </form:form>
</div>

</body>
</html>
