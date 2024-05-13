package Alke_Wallet_Modulo4.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Alke_Wallet_Modulo4.Cliente;

public class ClienteTest {
    @Test
    public void testConstructor() {
        Cliente cliente = new Cliente("Pedro", "Pe", "123456", "clave123");
        assertEquals("Pedro", cliente.getNombre());
        assertEquals("Pe", cliente.getApellido());
        assertEquals("123456", cliente.getRut());
        assertEquals("clave123", cliente.getContrasena());
    }
    
    @Test
    public void testGettersAndSettersCliente() {
        Cliente cliente = new Cliente();
        
        cliente.setNombre("Pedro");
        cliente.setApellido("Pe");
        cliente.setRut("123456");
        cliente.setContrasena("clave123");
        
        assertEquals("Pedro", cliente.getNombre());
        assertEquals("Pe", cliente.getApellido());
        assertEquals("123456", cliente.getRut());
        assertEquals("clave123", cliente.getContrasena());
        
    }
}
