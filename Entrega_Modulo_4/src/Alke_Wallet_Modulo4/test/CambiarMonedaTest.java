package Alke_Wallet_Modulo4.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Alke_Wallet_Modulo4.CambiarMoneda;

public class CambiarMonedaTest {
    @Test
    public void testConvertirUSDToEUR() {
        CambiarMoneda conversor = new CambiarMoneda();
        double montoConvertido = conversor.convertir(100, "USD", "EUR");
        assertEquals(85, montoConvertido, 0.01);
    }

    @Test
    public void testConvertirEURToUSD() {
        CambiarMoneda conversor = new CambiarMoneda();
        double montoConvertido = conversor.convertir(100, "EUR", "USD");
        assertEquals(118, montoConvertido, 0.01);
    }
    
    @Test
    public void testConvertirError() {
        CambiarMoneda conversor = new CambiarMoneda();
        double montoConvertido = conversor.convertir(100, "CLP", "USD");
        assertEquals(0, montoConvertido, 0);
    }
}

