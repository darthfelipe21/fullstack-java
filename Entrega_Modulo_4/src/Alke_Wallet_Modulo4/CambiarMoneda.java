package Alke_Wallet_Modulo4;

public class CambiarMoneda {
    // Metodo que maneja las tasas de cambio de USD y EUR.
    public double convertir(double monto, String monedaOrigen, String monedaDestino) {
        if (monedaOrigen.equals("USD") && monedaDestino.equals("EUR")) {
            return monto * 0.85; // Conversión de dólares a euros
        } else if (monedaOrigen.equals("EUR") && monedaDestino.equals("USD")) {
            return monto * 1.18; // Conversión de euros a dólares
        } else {
            System.out.println("No se pudo realizar la conversión. Monedas no compatibles.");
            return 0;
        }
    }
}
