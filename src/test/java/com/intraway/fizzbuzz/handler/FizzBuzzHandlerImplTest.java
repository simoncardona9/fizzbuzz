package com.intraway.fizzbuzz.handler;


import com.intraway.fizzbuzz.entities.ListaNumero;
import com.intraway.fizzbuzz.utils.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class FizzBuzzHandlerImplTest {

    private final String MESSAGE_MULTIPLOS_TRES_CINCO = "se encontraron multiplos de 3 y de 5";
    private final String MESSAGE_MULTIPLOS_TRES = "se encontraron multiplos de 3";
    private final String MESSAGE_NO_MULTIPLOS = "no se encontraron multiplos";

    private FizzBuzzHandler fizzBuzzHandler;

    @BeforeEach
    public void init() {
        fizzBuzzHandler = new FizzBuzzHandlerImpl();
        Counter counter = new Counter(0);
        ReflectionTestUtils.setField(fizzBuzzHandler, "counter", counter);
    }

    @Test
    public void testGetListaNumeroMultiplosTresCinco() {
        ListaNumero listaNumero = fizzBuzzHandler.getListaNumero(1, 10);
        String description = listaNumero.getDescription();
        Assertions.assertEquals(MESSAGE_MULTIPLOS_TRES_CINCO, description);
    }

    @Test
    public void testGetListaNumeroMultiploTres() {
        ListaNumero listaNumero = fizzBuzzHandler.getListaNumero(1, 4);
        String description = listaNumero.getDescription();
        Assertions.assertEquals(MESSAGE_MULTIPLOS_TRES, description);
    }

    @Test
    public void testGetListaNumeroSinMultiplos() {
        ListaNumero listaNumero = fizzBuzzHandler.getListaNumero(1, 2);
        String description = listaNumero.getDescription();
        Assertions.assertEquals(MESSAGE_NO_MULTIPLOS, description);
    }
}
