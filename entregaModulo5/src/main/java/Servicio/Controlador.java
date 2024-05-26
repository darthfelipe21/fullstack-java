package Servicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import ConfigDB.ConexionDB;
import Alke_Wallet_Modulo5.Cliente;

public class Controlador {
    private Cliente cliente;

    public Controlador(Cliente cliente) {
        this.cliente = cliente;
    }

    public double verSaldo() {
        double saldo = 0.0;
        try {
            String consulta = "SELECT saldo FROM usuario WHERE correo_electronico = ?";
            try (ResultSet rs = ConexionDB.realizarConsulta(consulta, cliente.getCorreoElectronico())) {
                if (rs.next()) {
                    saldo = rs.getDouble("saldo");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el saldo: " + e.getMessage());
        }
        return saldo;
    }

    public void realizarDeposito(double monto) {
        try {
            double saldoActual = verSaldo();
            double nuevoSaldo = saldoActual + monto;
            String actualizacion = "UPDATE usuario SET saldo = ? WHERE correo_electronico = ?";
            ConexionDB.actualizarDB(actualizacion, Double.toString(nuevoSaldo), cliente.getCorreoElectronico());
        } catch (Exception e) {
            System.out.println("Error al realizar el depósito: " + e.getMessage());
        }
    }

    public void realizarRetiro(double monto) {
        try {
            double saldoActual = verSaldo();
            double nuevoSaldo = saldoActual - monto;
            if (nuevoSaldo >= 0) {
                String actualizacion = "UPDATE usuario SET saldo = ? WHERE correo_electronico = ?";
                ConexionDB.actualizarDB(actualizacion, Double.toString(nuevoSaldo), cliente.getCorreoElectronico());
            } else {
                System.out.println("Error: Saldo insuficiente");
            }
        } catch (Exception e) {
            System.out.println("Error al realizar el retiro: " + e.getMessage());
        }
    }
}








