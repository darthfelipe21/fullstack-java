package Alke_Wallet_Modulo5;

/* Creación de la interface para conectar con cuenta los depositos y los retiros, esto por motivos de
 * claridad, mantenibilidad y flexibilidad del código
 */
public interface DepositoRetiro {
    void depositar(double monto);
    void retirar(double monto);
}
