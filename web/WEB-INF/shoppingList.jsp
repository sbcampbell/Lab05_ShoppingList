<%-- 
    Document   : shoppingList
    Created on : Oct 18, 2020, 12:40:28 PM
    Author     : 816590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>        
        <p>
            Hello, ${username}
            <br>
            <a href="shoppinglist?action=logout" name="logout">Logout</a>
        </p>
        <h2>List</h2>

        <form method="post" action="">
            <label for="addItem">Add item:</label>
            <input type="text" name="addItem">
            <input type="submit" value="add">
            <input type="hidden" name="action" value="add">
        </form>

        <form action="" method="post">
            <ul>
                <c:forEach var="item" items="${itemList}">
                    <li><input type="radio" name="item" value="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>

    </body>
</html>
