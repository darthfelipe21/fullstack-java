package Alke_Wallet_Modulo4.test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Alke_Wallet_Modulo4.Cliente;
import Alke_Wallet_Modulo4.Cuenta;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentasTestMockito {

	@InjectMocks
	Cuenta cuenta;
	
	@Mock
	Cliente cliente;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	
	}
	
    @Test
    void testDepositar() {
        double monto = 100.0;
        when(cliente.getNombre()).thenReturn("Felipe");
        cuenta.depositar(monto);
        assertEquals(monto, cuenta.getSaldo());
    }

    @Test
    void testRetirarConSaldoSuficiente() {
        double saldoInicial = 200.0;
        double monto = 100.0;
        cuenta.setSaldo(saldoInicial);
        when(cliente.getNombre()).thenReturn("Marta");
        cuenta.retirar(monto);
        assertEquals(saldoInicial - monto, cuenta.getSaldo());
    }

    @Test
    void testRetirarConSaldoInsuficiente() {
        double saldoInicial = 50.0;
        double monto = 100.0;
        cuenta.setSaldo(saldoInicial);
        when(cliente.getNombre()).thenReturn("Juanito");
        cuenta.retirar(monto);
        assertEquals(saldoInicial, cuenta.getSaldo());
    }
		
}
