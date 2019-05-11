package com.intraway.fizzbuzz.handler;

import com.intraway.fizzbuzz.entities.ListaNumero;
import com.intraway.fizzbuzz.utils.Counter;
import com.intraway.fizzbuzz.utils.FBUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzHandlerImpl implements FizzBuzzHandler {

    private final String FIZZ = "Fizz";
    private final String BUZZ = "Buzz";
    private final String MESSAGE_MULTIPLOS_TRES_CINCO = "se encontraron multiplos de 3 y de 5";
    private final String MESSAGE_MULTIPLOS_TRES = "se encontraron multiplos de 3";
    private final String MESSAGE_NO_MULTIPLOS = "no se encontraron multiplos";

    @Resource(name = "counter")
    Counter counter;



    public ListaNumero getListaNumero(int minNum, int maxNum) {

        Boolean multiploTresEncontrado = Boolean.FALSE;
        Boolean multiploCincoEncontrado = Boolean.FALSE;
        List<String> list = new ArrayList<>();

        for (int i = minNum; i < maxNum + 1; i++) {
            int restoTres = i % 3;
            int restoCinco = i % 5;
            if (restoTres == 0 && restoCinco == 0) {
                multiploTresEncontrado = Boolean.TRUE;
                multiploCincoEncontrado = Boolean.TRUE;
                list.add(FIZZ + BUZZ);
            } else if (restoTres == 0) {
                multiploTresEncontrado = Boolean.TRUE;
                list.add(FIZZ);
            } else if (restoCinco == 0) {
                multiploCincoEncontrado = Boolean.TRUE;
                list.add(BUZZ);
            } else {
                list.add(Integer.toString(i));
            }
        }

        String description = "";
        if (multiploTresEncontrado && multiploCincoEncontrado) {
            description = MESSAGE_MULTIPLOS_TRES_CINCO;
        } else if (multiploTresEncontrado) {
            description = MESSAGE_MULTIPLOS_TRES;
        } else {
            description = MESSAGE_NO_MULTIPLOS;
        }

        counter.incrementCounter();
        ListaNumero listaNumero = new ListaNumero(FBUtils.getTimeStamp(), String.format("%03d", counter.getCounter()),
                description, String.join(",", list));


        return listaNumero;
    }
}
