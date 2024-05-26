<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrega Modulo 5</title>
</head>
<body>
 <h2>AlkeWallet - Login</h2>
    <form action="LoginServlet" method="post">
        <label for="username">Nombre de Usuario:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="userId">ID de Usuario:</label>
        <input type="number" id="userId" name="userId" required>
        <br>
        <input type="submit" value="Login">
    </form>
    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Nombre de usuario o ID incorrectos.</p>
    <% } %>
</body>
</html>