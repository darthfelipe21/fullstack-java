package Controller;

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

import ConfigDB.ConexionDB;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo_electronico = request.getParameter("correo_electronico");
        String contrasena = request.getParameter("contrasena");

        try (Connection connection = ConexionDB.conexion();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE correo_electronico = ? AND contrasena = ?")) {

            statement.setString(1, correo_electronico);
            statement.setString(2, contrasena);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Usuario válido, realizar redireccionamiento
                    response.sendRedirect("home.jsp");
                } else {
                    // Usuario inválido, redireccionar a la página de inicio de sesión con un mensaje de error
                    response.sendRedirect("login.jsp?error=true");
                }
            }
        } catch (SQLException e) {
            // Manejar excepciones
            e.printStackTrace();
        }
    }
}


