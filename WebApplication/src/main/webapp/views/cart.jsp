<%@page import="java.util.List"%>
<%@page import="com.model.Items"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 80%;
        margin: 40px auto;
        background: #fff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0,0,0,0.2);
    }

    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 30px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 30px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 12px 15px;
        text-align: center;
    }

    th {
        background-color: #4CAF50;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    .button {
        display: inline-block;
        padding: 12px 25px;
        margin: 5px;
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

    .center {
        text-align: center;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Your Cart</h1>

    <%
        List<Items> selected = (List<Items>) session.getAttribute("selected");
        if (selected != null && !selected.isEmpty()) {
    %>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Quantity Available</th>
            <th>Price</th>
            <th>Category</th>
        </tr>
        <%
            for (Items item : selected) {
        %>
        <tr>
            <td><%= item.getItemId() %></td>
            <td><%= item.getItemName() %></td>
            <td><%= item.getQuantity() %></td>
            <td><%= item.getPrice() %></td>
            <td><%= item.getCategory() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <p class="center">No items in cart</p>
    <%
        }
    %>

    <div class="center">
        <form:form action="/shop/invoice" method="POST" modelAttribute="billObj" style="display:inline-block;">
            <input type="submit" class="button" value="Generate Bill">
        </form:form>

        <form action="/welcome" method="GET" style="display:inline-block;">
            <input type="submit" class="button" value="Go to Dashboard">
        </form>
    </div>
</div>

</body>
</html>
