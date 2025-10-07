<%@page import="com.model.User"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .welcome-container {
            background: #fff;
            padding: 40px 50px;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0,0,0,0.2);
            width: 400px;
            text-align: center;
        }

        .welcome-container h1 {
            color: #333;
            margin-bottom: 10px;
        }

        .welcome-container h2 {
            color: #555;
            margin-bottom: 25px;
        }

        .shop-button {
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

        .shop-button:hover {
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

<div class="welcome-container">
    <h1>Welcome !!</h1>
    <%
        User user = (User) session.getAttribute("user");
        if(user != null){
    %>
        <h2>Mr. <%= user.getUname() %></h2>
    <%
        } else {
    %>
        <h2>Guest</h2>
    <%
        }
    %>

    <form:form action="/items/addItems" method="GET">
        <input type="submit" class="shop-button" value="Add Items">
    </form:form>

    <form:form action="/shop/electronics" method="GET">
        <input type="submit" class="shop-button" value="Electronic Shop">
    </form:form>

    <form:form action="/shop/food" method="GET">
        <input type="submit" class="shop-button" value="Food Shop">
    </form:form>

    <form:form action="/shop/beverages" method="GET">
        <input type="submit" class="shop-button" value="Beverage Shop">
    </form:form>

    <form:form action="/logout" method="POST" modelAttribute="userObj">
        <input type="submit" class="shop-button logout-button" value="Logout">
    </form:form>
</div>

</body>
</html>
