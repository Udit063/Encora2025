<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Items</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .form-container {
        background: #fff;
        padding: 40px 50px;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0,0,0,0.2);
        width: 400px;
    }

    .form-container h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
    }

    label {
        display: block;
        font-weight: bold;
        margin-top: 15px;
        margin-bottom: 5px;
    }

    input[type="text"], input[type="number"], select {
        width: 100%;
        padding: 10px 12px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 12px;
        margin-top: 20px;
        background-color: #4CAF50;
        border: none;
        border-radius: 6px;
        color: white;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    form {
        margin: 0;
    }
</style>
</head>
<body>

<div class="form-container">
    <h2>Add New Item</h2>
    <form:form action="/items/addItems" method="post" modelAttribute="itemsObj">

        <label for="itemName">Name</label>
        <form:input path="itemName" id="itemName" />

        <label for="category">Category</label>
        <form:select path="category" id="category">
            <form:option value="Electronics" label="Electronics" />
            <form:option value="Food" label="Food" />
            <form:option value="Beverages" label="Beverage" />
        </form:select>

        <label for="price">Price</label>
        <form:input path="price" id="price" value="100" />

        <label for="quantity">Quantity</label>
        <form:input path="quantity" id="quantity" value="100" />

        <input type="submit" value="Add" />
    </form:form>
    
     <form action="/welcome" method="GET" style="display:inline-block;">
            <input type="submit" class="button" value="Go to Dashboard">
     </form>
</div>

</body>
</html>
