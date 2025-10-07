<%@page import="com.model.Items"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 85%;
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

    input[type="submit"] {
        display: inline-block;
        width: 180px;
        margin: 10px 10px 0 0;
        padding: 12px;
        font-size: 16px;
        font-weight: bold;
        color: #fff;
        background-color: #4CAF50;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        text-align: center;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .dashboard-button {
        background-color: #2196F3;
    }

    .dashboard-button:hover {
        background-color: #0b7dda;
    }

    form {
        margin: 0;
    }
</style>
</head>
<body>

<div class="container">
    <h1><%= request.getAttribute("categoryName") %> Shop</h1>

    <form:form action="/shop/cart" method="POST" modelAttribute="shopObj">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Select</th>
            </tr>

            <%
                List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");
                if (itemsList != null && !itemsList.isEmpty()) {
                    for (Items item : itemsList) {
            %>
            <tr>
                <td><%= item.getItemId() %></td>
                <td><%= item.getItemName() %></td>
                <td><%= item.getQuantity() %></td>
                <td><%= item.getPrice() %></td>
                <td><form:checkbox path="selectedItemIds" value="<%= item.getItemId() %>" /></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No items found!!</td>
            </tr>
            <%
                }
            %>
        </table>

        <input type="submit" value="Add to Cart">
    </form:form>

    <form action="/welcome" method="GET">
        <input type="submit" class="dashboard-button" value="Go to Dashboard">
    </form>
</div>

</body>
</html>
