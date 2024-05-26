<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrega Modulo 5</title>
</head>
<body>
	    <h2>Bienvenido a AlkeWallet</h2>
    <%
        String correo_electronico = (String) session.getAttribute("correo_electronico");
        String contrasena = (String) session.getAttribute("contrasena");
        if (correo_electronico == null || contrasena == null) {
            response.sendRedirect("index.jsp");
        }
    %>
    <p>Hola, <%= correo_electronico %>!</p>
    <a href="DepositoRetiroServlet?action=verSaldo">Ver Saldo</a>
    <a href="DepositoRetiroServlet?action=depositar">Depositar</a>
    <a href="DepositoRetiroServlet?action=retirar">Retirar</a>
    <a href="CambioMonedaServlet">Cambiar Moneda</a>
</body>
</html>