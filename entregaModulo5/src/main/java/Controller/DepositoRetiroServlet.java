package Controller;

import Alke_Wallet_Modulo5.Cliente;
import Servicio.Controlador;
import ConfigDB.ConexionDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DepositoRetiroServlet")
public class DepositoRetiroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String correo_electronico = (String) session.getAttribute("correo_electronico");
        String contrasena = (String) session.getAttribute("contrasena");

        if (correo_electronico == null || contrasena == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String action = request.getParameter("action");

        // Obtener el cliente desde la base de datos
        Cliente cliente = obtenerClienteDesdeBD(correo_electronico, contrasena);

        if (cliente == null) {
            // Si no se encuentra el cliente, redirigir al index
            response.sendRedirect("index.jsp");
            return;
        }

        Controlador controlador = new Controlador(cliente);

        switch (action) {
            case "verSaldo":
                double saldo = controlador.verSaldo();
                request.setAttribute("saldo", saldo);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            case "depositar":
                // Lógica para depositar
                break;
            case "retirar":
                // Lógica para retirar
                break;
            default:
                response.sendRedirect("home.jsp");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // Método para obtener el cliente desde la base de datos
    private Cliente obtenerClienteDesdeBD(String correo_electronico, String contrasena) {
        Cliente cliente = null;

        try (Connection connection = ConexionDB.conexion();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE correo_electronico = ? AND contrasena = ?")) {

            statement.setString(1, correo_electronico);
            statement.setString(2, contrasena);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Obtener los datos del cliente desde la base de datos
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String saldo = resultSet.getString("saldo");
                    
                    // Crear una instancia de Cliente con los datos obtenidos
                    cliente = new Cliente(nombre, apellido, correo_electronico, contrasena);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el cliente desde la base de datos: " + e.getMessage());
        }

        return cliente;
    }
}

