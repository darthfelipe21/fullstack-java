package ConfigDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String BBDD = "jdbc:mysql://localhost/project_module3";
    private static final String USER = "root";
    private static final String PASS = "dajsdkasjdkaas22e";
    private static Connection conex = null;

    public static Connection conexion() {
        try {
            if (conex == null || conex.isClosed()) {
                Class.forName(DRIVER);
                conex = DriverManager.getConnection(BBDD, USER, PASS);
            }
        } catch (Exception e) {
            System.out.println("Error al conectarse a la DB" + e.getMessage());
        }
        return conex;
    }

    public static void cerrarConexion(Connection conex) {
        try {
            if (conex != null && !conex.isClosed()) {
                conex.close();
            }
        } catch (SQLException sql) {
            System.out.println("Error al cerrar conexion" + sql.getMessage());
        }
    }

    public static ResultSet realizarConsulta(String consulta, String... params) {
        ResultSet rs = null;
        try {
            conex = conexion();
            PreparedStatement stmt = conex.prepareStatement(consulta);
            for (int i = 0; i < params.length; i++) {
                stmt.setString(i + 1, params[i]);
            }
            rs = stmt.executeQuery();
        } catch (SQLException sql) {
            System.out.println("Error al realizar la consulta" + sql.getMessage());
        }
        return rs;
    }

    public static int actualizarDB(String consulta, String... params) {
        int resultado = 0;
        try {
            conex = conexion();
            PreparedStatement stmt = conex.prepareStatement(consulta);
            for (int i = 0; i < params.length; i++) {
                stmt.setString(i + 1, params[i]);
            }
            resultado = stmt.executeUpdate();
        } catch (SQLException sql) {
            System.out.println("Error en actualización" + sql.getMessage());
        }
        return resultado;
    }
}



