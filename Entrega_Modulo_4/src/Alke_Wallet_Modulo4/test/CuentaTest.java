package Alke_Wallet_Modulo4.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Alke_Wallet_Modulo4.Cliente;
import Alke_Wallet_Modulo4.Cuenta;

public class CuentaTest {
    @Test
    public void testDepositar() {
        Cliente cliente = new Cliente("Pedro", "Pe", "123456", "clave123");
        Cuenta cuenta = new Cuenta(cliente, 1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirar() {
        Cliente cliente = new Cliente("Pedro", "Pe", "123456", "clave123");
        Cuenta cuenta = new Cuenta(cliente, 1000);
        cuenta.retirar(200);
        assertEquals(800, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirarConSaldoInsuficiente() {
        Cliente cliente = new Cliente("Pedro", "Pe", "123456", "clave123");
        Cuenta cuenta = new Cuenta(cliente, 1000);
        cuenta.retirar(2000);
        assertEquals(1000, cuenta.getSaldo(), 0.01);
    }
    
    @Test
    public void testGettersAndSettersCuenta() {
        Cliente cliente = new Cliente("Pedro", "Pe", "123456", "clave123");
        Cuenta cuenta = new Cuenta();
        
        cuenta.setCliente(cliente);
        cuenta.setSaldo(1000);
        
        assertEquals(cliente, cuenta.getCliente());
        assertEquals(1000, cuenta.getSaldo(), 0.01);
    }
}

