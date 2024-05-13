package Alke_Wallet_Modulo4;

public class Main {

	public static void main(String[] args) {
        // Crear cliente
        Cliente cliente = new Cliente("Felipe", "Martinez", "25085524-9", "Estaesmiclave_123");
        
        // Crear cuenta para el cliente con un saldo inicial de $1000
        Cuenta cuenta = new Cuenta(cliente, 1000);
        
        // Realización de algunas operaciones
        cuenta.depositar(500);
        cuenta.retirar(2000);
        
        // Crear una instancia de CambiarMoneda
        CambiarMoneda conversor = new CambiarMoneda();
        
        // Realizar una conversión de moneda
        double montoConvertido = conversor.convertir(100, "USD", "EUR");
        System.out.println("100 USD equivale a " + montoConvertido + " EUR");

	}

}
