<%@ page import="com.model.Items" %>
<%@ page import="com.model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invoice</title>
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

    h1, h3 {
        text-align: center;
        color: #333;
    }

    p {
        text-align: center;
        font-size: 18px;
        color: #555;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
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
        display: block;
        width: 200px;
        margin: 20px auto;
        padding: 12px;
        font-size: 16px;
        font-weight: bold;
        color: #fff;
        background-color: #4CAF50;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        text-decoration: none;
        text-align: center;
    }

    .button:hover {
        background-color: #45a049;
    }

    .total {
        text-align: center;
        font-size: 20px;
        font-weight: bold;
        margin-top: 20px;
    }

</style>
</head>
<body>

<div class="container">
    <h1>Invoice</h1>

    <% 
        com.model.Bill bill = (com.model.Bill) request.getAttribute("billObj");
        User user = (User) session.getAttribute("user");
        List<Items> selectedItems = (List<Items>) session.getAttribute("selected");
    %>

    <h3>Bill ID: <%= bill.getId() %></h3>
    <% if(user != null) { %>
        <p>Customer: <%= user.getUname() %></p>
    <% } %>

    <h3>Items:</h3>
    <table>
        <tr>
            <th>Item Name</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <% 
            if(selectedItems != null) {
                for(Items item : selectedItems) {
        %>
        <tr>
            <td><%= item.getItemName() %></td>
            <td><%= item.getCategory() %></td>
            <td><%= item.getQuantity() %></td>
            <td><%= item.getPrice() %></td>
        </tr>
        <% 
                }
            } 
        %>
    </table>

    <% 
        int total = 0;
        if(selectedItems != null) {
            for(Items item : selectedItems) {
                total += item.getPrice() * item.getQuantity();
            }
        }
    %>
    <div class="total">Total Amount: <%= total %></div>

    <form action="/home" method="GET">
        <input type="submit" class="button" value="Shop More">
    </form>
</div>

</body>
</html>
